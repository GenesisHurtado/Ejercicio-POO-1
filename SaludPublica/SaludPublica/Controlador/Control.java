package Controlador;
import Modelo.*;
import Vista.*;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;

public class Control
{
    private JFRegistroPersona vistaGestor;
    private GestorPersona modeloGestor;

    public Control(GestorPersona modeloGestor, JFRegistroPersona vistaGestor){
        this.vistaGestor = vistaGestor;
        this.modeloGestor = modeloGestor;

        limpiar();

        // Habilitar campos y paneles segun el tipo de persona
        vistaGestor.getCbTipoPersona().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                habilitarSegunTipo();
            }
        });

        // Guardar
        vistaGestor.getBtnGuardar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                guardar();
            }
        });

        // Buscar
        vistaGestor.getBtnBuscar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buscar();
            }
        });

        // Limpiar
        vistaGestor.getBtnLimpiar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                limpiar();
            }
        });
    }

    private void habilitarSegunTipo(){
        String tipo = (String) vistaGestor.getCbTipoPersona().getSelectedItem();
        boolean salud = "Salud".equals(tipo);
        boolean docente = "Docente".equals(tipo);
        boolean independiente = "Independiente".equals(tipo);

        vistaGestor.getTxtInstitucion().setEnabled(salud || docente);
        vistaGestor.getTxtEspecialidad().setEnabled(salud);
        vistaGestor.getCbNivel().setEnabled(docente);

        if(!(salud || docente)) vistaGestor.getTxtInstitucion().setText("");
        if(!salud) vistaGestor.getTxtEspecialidad().setText("");
        if(!docente) vistaGestor.getCbNivel().setSelectedIndex(-1);

        habilitarPanel(vistaGestor.getPanelSalud(), salud);
        habilitarPanel(vistaGestor.getPanelDocente(), docente);
        habilitarPanel(vistaGestor.getPanelIndependiente(), independiente);
    }

    private void habilitarPanel(JPanel panel, boolean habilitar){
        panel.setEnabled(habilitar);
        for(Component c : panel.getComponents()){
            c.setEnabled(habilitar);
            if(!habilitar && c instanceof JTextField){
                ((JTextField) c).setText("");
            }
        }
    }

    private void limpiar(){
        vistaGestor.getCbTipoDocumento().setSelectedIndex(-1);
        vistaGestor.getTxtDocumento().setText("");
        vistaGestor.getTxtNombre().setText("");
        vistaGestor.getTxtApellido().setText("");
        vistaGestor.getTxtDireccion().setText("");
        vistaGestor.getTxtTelefono().setText("");
        vistaGestor.getTxtEdad().setText("");
        vistaGestor.getTxtEstrato().setText("");
        vistaGestor.getTxtEstadoCivil().setText("");
        vistaGestor.getChkCabezaHogar().setSelected(false);
        vistaGestor.getCbTipoPersona().setSelectedIndex(-1);
        habilitarSegunTipo();
    }

    private void guardar(){
        try{
            Persona p = construirPersona();
            if(p == null) return;

            if(!modeloGestor.distribucionValida(p)){
                vistaGestor.getCampoTexto().setText("La distribucion ($" + formato(p.getTotalGastado()) +
                    ") supera el bono asignado ($" + formato(p.getBono().getMonto()) + ")");
                return;
            }

            if(modeloGestor.agregarPersona(p)){
                limpiar();
                vistaGestor.getCampoTexto().setText("Guardado: " + p.getTipo() +
                    "\nPersonas registradas: " + modeloGestor.contarPersonas());
            }
        }catch(NumberFormatException ex){
            vistaGestor.getCampoTexto().setText("Edad, estrato y montos deben ser numericos");
        }catch(IllegalArgumentException ex){
            vistaGestor.getCampoTexto().setText(ex.getMessage());
        }
    }

    private Persona construirPersona(){
        String tipo = (String) vistaGestor.getCbTipoPersona().getSelectedItem();
        TipoDocumento td = (TipoDocumento) vistaGestor.getCbTipoDocumento().getSelectedItem();
        String doc = vistaGestor.getTxtDocumento().getText().trim();
        String nombre = vistaGestor.getTxtNombre().getText().trim();
        String apellido = vistaGestor.getTxtApellido().getText().trim();
        String direccion = vistaGestor.getTxtDireccion().getText().trim();
        String telefono = vistaGestor.getTxtTelefono().getText().trim();
        String estadoCivil = vistaGestor.getTxtEstadoCivil().getText().trim();

        if(td == null || tipo == null || doc.isEmpty() || nombre.isEmpty() || apellido.isEmpty()
                || direccion.isEmpty() || telefono.isEmpty() || estadoCivil.isEmpty()){
            vistaGestor.getCampoTexto().setText("Complete todos los datos basicos y seleccione el tipo");
            return null;
        }

        int edad = Integer.parseInt(vistaGestor.getTxtEdad().getText().trim());
        int estrato = Integer.parseInt(vistaGestor.getTxtEstrato().getText().trim());

        if(edad < 0 || edad > 120){
            vistaGestor.getCampoTexto().setText("Edad no valida");
            return null;
        }
        if(estrato < 1 || estrato > 6){
            vistaGestor.getCampoTexto().setText("El estrato debe estar entre 1 y 6");
            return null;
        }
        if(modeloGestor.buscarPersona(doc) != null){
            vistaGestor.getCampoTexto().setText("Ya existe una persona con ese documento");
            return null;
        }

        boolean cabeza = vistaGestor.getChkCabezaHogar().isSelected();

        if(tipo.equals("Salud")){
            String inst = vistaGestor.getTxtInstitucion().getText().trim();
            String esp = vistaGestor.getTxtEspecialidad().getText().trim();
            if(inst.isEmpty() || esp.isEmpty()){
                vistaGestor.getCampoTexto().setText("Ingrese institucion y especialidad");
                return null;
            }
            return new ProfesionalSalud(td, doc, nombre, apellido, direccion, telefono, edad,
                estadoCivil, estrato, cabeza, inst, esp,
                new ElementoBioseguridad(monto(vistaGestor.getTxtElementoBioseguridad())),
                new Medicina(monto(vistaGestor.getTxtMedicinaSalud())));
        }

        if(tipo.equals("Docente")){
            String inst = vistaGestor.getTxtInstitucion().getText().trim();
            String nivel = (String) vistaGestor.getCbNivel().getSelectedItem();
            if(inst.isEmpty() || nivel == null){
                vistaGestor.getCampoTexto().setText("Ingrese institucion y nivel educativo");
                return null;
            }
            return new Docente(td, doc, nombre, apellido, direccion, telefono, edad,
                estadoCivil, estrato, cabeza, inst, nivel,
                new ImplementoTecnologico(monto(vistaGestor.getTxtImplementosTecnologicos())),
                new Servicio(monto(vistaGestor.getTxtInternetEnergia())));
        }

        if(estrato > 2){
            vistaGestor.getCampoTexto().setText("La persona independiente debe ser de estrato 1 o 2");
            return null;
        }
        return new Ciudadano(td, doc, nombre, apellido, direccion, telefono, edad,
            estadoCivil, estrato, cabeza,
            new Medicina(monto(vistaGestor.getTxtMedicinaIndependiente())),
            new CanastaFamiliar(monto(vistaGestor.getTxtCanastaFamiliar())));
    }

    private void buscar(){
        String doc = vistaGestor.getTxtDocumento().getText().trim();
        if(doc.isEmpty()){
            vistaGestor.getCampoTexto().setText("Ingrese el numero de documento a buscar");
            return;
        }

        Persona p = modeloGestor.buscarPersona(doc);
        if(p == null){
            vistaGestor.getCampoTexto().setText("No se encontro ninguna persona con documento " + doc);
            return;
        }

        String tipo = "Independiente";
        if(p instanceof ProfesionalSalud) tipo = "Salud";
        else if(p instanceof Docente) tipo = "Docente";

        vistaGestor.getCbTipoPersona().setSelectedItem(tipo);
        vistaGestor.getCbTipoDocumento().setSelectedItem(p.getTipoDocumento());
        vistaGestor.getTxtDocumento().setText(p.getNumDocumento());
        vistaGestor.getTxtNombre().setText(p.getNombre());
        vistaGestor.getTxtApellido().setText(p.getApellido());
        vistaGestor.getTxtDireccion().setText(p.getDireccion());
        vistaGestor.getTxtTelefono().setText(p.getTelefono());
        vistaGestor.getTxtEdad().setText(String.valueOf(p.getEdad()));
        vistaGestor.getTxtEstrato().setText(String.valueOf(p.getEstrato()));
        vistaGestor.getTxtEstadoCivil().setText(p.getEstadoCivil());
        vistaGestor.getChkCabezaHogar().setSelected(p.getCabezaHogar());

        if(p instanceof ProfesionalSalud){
            ProfesionalSalud ps = (ProfesionalSalud) p;
            vistaGestor.getTxtInstitucion().setText(ps.getInstSalud());
            vistaGestor.getTxtEspecialidad().setText(ps.getEspecialidad());
            vistaGestor.getTxtElementoBioseguridad().setText(formato(ps.getElemento().getMonto()));
            vistaGestor.getTxtMedicinaSalud().setText(formato(ps.getMedicina().getMonto()));
        }else if(p instanceof Docente){
            Docente d = (Docente) p;
            vistaGestor.getTxtInstitucion().setText(d.getInstEducativa());
            vistaGestor.getCbNivel().setSelectedItem(d.getNivelEducativo());
            vistaGestor.getTxtImplementosTecnologicos().setText(formato(d.getImplemento().getMonto()));
            vistaGestor.getTxtInternetEnergia().setText(formato(d.getServicio().getMonto()));
        }else{
            Ciudadano c = (Ciudadano) p;
            vistaGestor.getTxtMedicinaIndependiente().setText(formato(c.getMedicina().getMonto()));
            vistaGestor.getTxtCanastaFamiliar().setText(formato(c.getCanasta().getMonto()));
        }

        vistaGestor.getCampoTexto().setText(p.toString());
        vistaGestor.getCampoTexto().setCaretPosition(0);
    }

    private double monto(JTextField campo){
        String texto = campo.getText().trim();
        if(texto.isEmpty()) return 0;
        double valor = Double.parseDouble(texto);
        if(valor < 0){
            throw new IllegalArgumentException("Los montos no pueden ser negativos");
        }
        return valor;
    }

    private String formato(double valor){
        if(valor == (long) valor) return String.valueOf((long) valor);
        return String.valueOf(valor);
    }
}
