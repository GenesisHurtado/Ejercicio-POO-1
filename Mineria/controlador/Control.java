package controlador;
import modelo.*;
import vista.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Control
{
    private JFGestion viewGestion;
    private GestorRiesgos modelGestorRiesgos;

    private static final Color COLOR_ERROR = new Color(150, 40, 40);
    private static final Color COLOR_OK = new Color(30, 120, 50);

    public Control(GestorRiesgos modelGestorRiesgos, JFGestion viewGestion){
        this.viewGestion = viewGestion;
        this.modelGestorRiesgos = modelGestorRiesgos;

        mostrarLista();
        mensaje("Ingrese los datos del riesgo y presione Agregar", true);

        // Agregar un riesgo
        viewGestion.getBtnAgregar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                agregarRiesgo();
            }
        });

        // Buscar un riesgo por codigo
        viewGestion.getBtnBuscar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buscarRiesgo();
            }
        });

        // Eliminar un riesgo por codigo
        viewGestion.getBtnEliminar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                eliminarRiesgo();
            }
        });

        // Listar todos los riesgos
        viewGestion.getBtnListar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mostrarLista();
                mensaje("Se muestran todos los riesgos registrados", true);
            }
        });

        // Limpiar los campos
        viewGestion.getBtnLimpiar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                limpiarCampos();
                mensaje("Campos limpiados", true);
            }
        });

        // Salir
        viewGestion.getBtnSalir().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }

    private void agregarRiesgo(){
        String codigo = viewGestion.getTxtCodigo().getText().trim();
        String descripcion = viewGestion.getTxtDescripcion().getText().trim();
        String tipo = textoTipo();
        String textoNivel = viewGestion.getTxtNivel().getText().trim();

        if(codigo.isEmpty() || descripcion.isEmpty() || tipo.isEmpty() || textoNivel.isEmpty()){
            mensaje("Complete el código, la descripción, el tipo y el nivel de peligro", false);
            return;
        }

        int nivel;
        try{
            nivel = Integer.parseInt(textoNivel);
        }catch(NumberFormatException ex){
            mensaje("El nivel de peligro debe ser un número entero", false);
            return;
        }
        if(!Riesgo.nivelValido(nivel)){
            mensaje("El nivel de peligro debe estar entre 1 y 5", false);
            return;
        }

        if(!modelGestorRiesgos.agregarRiesgo(new Riesgo(codigo, descripcion, tipo, nivel))){
            mensaje("Ya existe un riesgo con el código " + codigo, false);
            return;
        }

        limpiarCampos();
        mostrarLista();
        mensaje("Riesgo agregado: " + codigo, true);
    }

    private void buscarRiesgo(){
        String codigo = viewGestion.getTxtCodigo().getText().trim();
        if(codigo.isEmpty()){
            mensaje("Escriba el código del riesgo que desea buscar", false);
            return;
        }

        Riesgo r = modelGestorRiesgos.buscarRiesgo(codigo);
        if(r == null){
            mensaje("No se encontró ningún riesgo con el código " + codigo, false);
            return;
        }

        // Muestra el riesgo en el area de texto y carga sus datos en el formulario
        viewGestion.getAreaRiesgos().setText("RESULTADO DE LA BÚSQUEDA\n"
                + "------------------------------------------\n" + detalle(r));
        viewGestion.getAreaRiesgos().setCaretPosition(0);
        viewGestion.getTxtCodigo().setText(r.getCodigo());
        viewGestion.getTxtDescripcion().setText(r.getDescripcion());
        viewGestion.getCmbTipo().setSelectedItem(r.getTipo());
        viewGestion.getTxtNivel().setText("" + r.getNivelPeligro());
        mensaje("Riesgo encontrado: " + r.getCodigo(), true);
    }

    private void eliminarRiesgo(){
        String codigo = viewGestion.getTxtCodigo().getText().trim();
        if(codigo.isEmpty()){
            mensaje("Escriba el código del riesgo que desea eliminar", false);
            return;
        }
        if(modelGestorRiesgos.buscarRiesgo(codigo) == null){
            mensaje("No se encontró ningún riesgo con el código " + codigo, false);
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(viewGestion,
                "¿Desea eliminar el riesgo " + codigo + "?", "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(opcion != JOptionPane.YES_OPTION){
            mensaje("Eliminación cancelada", true);
            return;
        }

        modelGestorRiesgos.eliminarRiesgo(codigo);
        limpiarCampos();
        mostrarLista();
        mensaje("Riesgo eliminado: " + codigo, true);
    }

    // Escribe en el area de texto todos los riesgos registrados
    private void mostrarLista(){
        ArrayList<Riesgo> lista = modelGestorRiesgos.listarRiesgos();
        StringBuilder sb = new StringBuilder();
        sb.append("RIESGOS REGISTRADOS: ").append(lista.size()).append("\n");
        sb.append("------------------------------------------\n");
        if(lista.isEmpty()){
            sb.append("Aún no hay riesgos registrados.\n");
        }
        for(Riesgo r : lista){
            sb.append(detalle(r)).append("\n");
        }
        viewGestion.getAreaRiesgos().setText(sb.toString());
        viewGestion.getAreaRiesgos().setCaretPosition(0);
    }

    private String detalle(Riesgo r){
        return "Código:      " + r.getCodigo() + "\n"
             + "Descripción: " + r.getDescripcion() + "\n"
             + "Tipo:        " + r.getTipo() + "\n"
             + "Nivel:       " + r.getNivelPeligro() + " (" + r.getNombreNivel() + ")\n";
    }

    private String textoTipo(){
        Object tipo = viewGestion.getCmbTipo().getSelectedItem();
        return tipo == null ? "" : tipo.toString().trim();
    }

    private void limpiarCampos(){
        viewGestion.getTxtCodigo().setText("");
        viewGestion.getTxtDescripcion().setText("");
        viewGestion.getCmbTipo().setSelectedIndex(0);
        viewGestion.getTxtNivel().setText("");
        viewGestion.getTxtCodigo().requestFocus();
    }

    // ok = true muestra el mensaje en verde, ok = false en rojo
    private void mensaje(String texto, boolean ok){
        viewGestion.getLblMensaje().setForeground(ok ? COLOR_OK : COLOR_ERROR);
        viewGestion.getLblMensaje().setText(texto);
    }
}
