package controlador;
import modelo.*;
import vista.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.event.*;

public class Control
{
    private JFVecindad viewVecindad;
    private Vecindad modelVecindad;

    private static final Color COLOR_ERROR = new Color(150, 40, 40);
    private static final Color COLOR_OK = new Color(30, 120, 50);

    public Control(Vecindad modelVecindad, JFVecindad viewVecindad){
        this.viewVecindad = viewVecindad;
        this.modelVecindad = modelVecindad;

        cargarListas();
        registrar("Bienvenido a la vecindad. Selecciona un personaje y elige una acción.");
        mensaje("Seleccione un personaje de la lista", true);

        // Al seleccionar un personaje se muestran sus datos
        viewVecindad.getListaPersonajes().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if(!e.getValueIsAdjusting()){
                    mostrarDatosPersonaje();
                }
            }
        });

        // Hablar
        viewVecindad.getBtnHablar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                hablar();
            }
        });

        // Mover
        viewVecindad.getBtnMover().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mover();
            }
        });

        // Accion especial del personaje
        viewVecindad.getBtnAccionEspecial().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                accionEspecial();
            }
        });

        // Interactuar con otro personaje
        viewVecindad.getBtnInteractuar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                interactuarConPersonaje();
            }
        });

        // Usar el objeto seleccionado
        viewVecindad.getBtnUsarObjeto().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                usarObjeto();
            }
        });

        // Limpiar el registro
        viewVecindad.getBtnLimpiar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                viewVecindad.getAreaRegistro().setText("");
                mensaje("Registro limpiado", true);
            }
        });

        // Salir
        viewVecindad.getBtnSalir().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        viewVecindad.getListaPersonajes().setSelectedIndex(0);
    }

    private void cargarListas(){
        for(Personaje p : modelVecindad.getPersonajes()){
            viewVecindad.getModeloPersonajes().addElement(p.getNombre());
            viewVecindad.getCmbOtroPersonaje().addItem(p.getNombre());
        }
        for(ObjetoInteractivo o : modelVecindad.getObjetos()){
            viewVecindad.getModeloObjetos().addElement(o.getNombre());
        }
    }

    // Personaje que esta seleccionado en la lista (null si no hay)
    private Personaje personajeSeleccionado(){
        int indice = viewVecindad.getListaPersonajes().getSelectedIndex();
        if(indice < 0){
            mensaje("Seleccione un personaje de la lista", false);
            return null;
        }
        return modelVecindad.getPersonajes().get(indice);
    }

    private void mostrarDatosPersonaje(){
        int indice = viewVecindad.getListaPersonajes().getSelectedIndex();
        if(indice < 0){
            viewVecindad.getTxtNombre().setText("");
            viewVecindad.getTxtEdad().setText("");
            viewVecindad.getTxtPersonalidad().setText("");
            viewVecindad.getTxtRol().setText("");
            return;
        }
        Personaje p = modelVecindad.getPersonajes().get(indice);
        viewVecindad.getTxtNombre().setText(p.getNombre());
        viewVecindad.getTxtEdad().setText("" + p.getEdad());
        viewVecindad.getTxtPersonalidad().setText(p.getPersonalidad());
        viewVecindad.getTxtRol().setText(p.getRol());
        mensaje("Personaje seleccionado: " + p.getNombre(), true);
    }

    private void hablar(){
        Personaje p = personajeSeleccionado();
        if(p == null){
            return;
        }
        String texto = viewVecindad.getTxtMensaje().getText().trim();
        if(texto.isEmpty()){
            mensaje("Escriba lo que quiere que diga " + p.getNombre(), false);
            return;
        }
        registrar(p.hablar(texto));
        viewVecindad.getTxtMensaje().setText("");
        mensaje(p.getNombre() + " habló", true);
    }

    private void mover(){
        Personaje p = personajeSeleccionado();
        if(p == null){
            return;
        }
        String direccion = (String) viewVecindad.getCmbDireccion().getSelectedItem();
        registrar(p.mover(direccion));
        mensaje(p.getNombre() + " se movió", true);
    }

    private void accionEspecial(){
        Personaje p = personajeSeleccionado();
        if(p == null){
            return;
        }
        registrar(p.accionEspecial());
        mensaje("Acción especial de " + p.getNombre(), true);
    }

    private void interactuarConPersonaje(){
        Personaje p = personajeSeleccionado();
        if(p == null){
            return;
        }
        int indiceOtro = viewVecindad.getCmbOtroPersonaje().getSelectedIndex();
        if(indiceOtro < 0){
            mensaje("Elija con qué personaje quiere interactuar", false);
            return;
        }
        Personaje otro = modelVecindad.getPersonajes().get(indiceOtro);
        if(otro == p){
            mensaje("Elija un personaje diferente al seleccionado", false);
            return;
        }
        registrar(p.interactuarCon(otro));
        mensaje(p.getNombre() + " interactuó con " + otro.getNombre(), true);
    }

    private void usarObjeto(){
        Personaje p = personajeSeleccionado();
        if(p == null){
            return;
        }
        int indiceObjeto = viewVecindad.getListaObjetos().getSelectedIndex();
        if(indiceObjeto < 0){
            mensaje("Seleccione un objeto de la lista de objetos", false);
            return;
        }
        ObjetoInteractivo objeto = modelVecindad.getObjetos().get(indiceObjeto);
        registrar(p.interactuar(objeto));
        mensaje(p.getNombre() + " usó: " + objeto.getNombre(), true);
    }

    // Agrega una linea al registro de la vecindad
    private void registrar(String texto){
        viewVecindad.getAreaRegistro().append("• " + texto + "\n");
        viewVecindad.getAreaRegistro().setCaretPosition(viewVecindad.getAreaRegistro().getDocument().getLength());
    }

    // ok = true muestra el mensaje en verde, ok = false en rojo
    private void mensaje(String texto, boolean ok){
        viewVecindad.getLblMensaje().setForeground(ok ? COLOR_OK : COLOR_ERROR);
        viewVecindad.getLblMensaje().setText(texto);
    }
}
