package Controlador;
import Modelo.*;
import Vista.*;
import java.awt.event.*;

/**
 * Write a description of class Control here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Control
{
     private JFConclave vistaGestor;
    private GestorCardenal modeloGestor;
    private JPVotacion panelVotacion;
    private JPElectores panelElectores;

    public Control(GestorCardenal modeloGestor, JFConclave vistaGestor){
        this.vistaGestor = vistaGestor;
        this.modeloGestor = modeloGestor;
        panelVotacion = new JPVotacion();
        panelElectores = new JPElectores();

     for(Cardenal c : modeloGestor.getCardenales()){
            panelVotacion.getCbCardenales().addItem(c);
        }
        panelVotacion.getCampoTexto().setText("Electores: " + modeloGestor.contarElectores() +
                                              "\nVotos para la mayoria (2/3): " + modeloGestor.calcularMayoria() +
                                              "\n" + modeloGestor.getRondaActual() +
                                              "\nSeleccione un cardenal y presione Votar.");
        vistaGestor.reemplazarPanelCentral(panelVotacion);

        vistaGestor.getBtnVotacion().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                vistaGestor.reemplazarPanelCentral(panelVotacion);
            }
        });

        vistaGestor.getBtnElectores().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                vistaGestor.reemplazarPanelCentral(panelElectores);
            }
        });
        
        // RF 1: listado de electores
        panelElectores.getBtnEnlistar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String lista = modeloGestor.enlistarElectores();
                panelElectores.getCampoTexto().setText("Electores: " + modeloGestor.contarElectores() +
                                                       " | No electores: " + modeloGestor.contarNoElectores() +
                                                       "\n\n" + lista);
            }
        });

        // RF 2 y 3: votar y cierre de ronda
        panelVotacion.getBtnVotar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Cardenal votado = (Cardenal) panelVotacion.getCbCardenales().getSelectedItem();
                if(votado == null){
                    panelVotacion.getCampoTexto().setText("Seleccione un cardenal");
                    return;
                }
                if(modeloGestor.votar(votado)){
                    panelVotacion.getCampoTexto().setText("Voto registrado (" +
                        modeloGestor.getRondaActual().cantidadVotos() + " de " +
                        modeloGestor.contarElectores() + ")");
                }
                if(modeloGestor.rondaCerrada()){
                    panelVotacion.getBtnVotar().setEnabled(false);
                    String texto = modeloGestor.getRondaActual() + "\n" + modeloGestor.enlistarResultados();
                    Cardenal papa = modeloGestor.verificarPapa();
                    if(papa != null){
                        Ronda r = modeloGestor.getRondaActual();
                        texto += "\nHay nuevo papa\n" +
                                 "Ronda: " + r.getNumero() + "\n" +
                                 "Jornada: " + r.getJornada() + "\n" +
                                 "Nombre: " + papa.getNombre() + "\n" +
                                 "Pais: " + papa.getPais() + "\n" +
                                 "Edad: " + papa.getEdad();
                        panelVotacion.getBtnSiguienteRonda().setEnabled(false);
                    }else{
                        texto += "\nNo hay papa aun";
                        panelVotacion.getBtnSiguienteRonda().setEnabled(true);
                    }
                    panelVotacion.getCampoTexto().setText(texto);
                }
            }
        });

        panelVotacion.getBtnMostrarResultados().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panelVotacion.getCampoTexto().setText(modeloGestor.getRondaActual() +
                    "\nVotos registrados: " + modeloGestor.getRondaActual().cantidadVotos() +
                    " de " + modeloGestor.contarElectores() +
                    "\n" + modeloGestor.enlistarResultados());
            }
        });

        panelVotacion.getBtnSiguienteRonda().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(modeloGestor.siguienteRonda()){
                    panelVotacion.getTxtNumRonda().setText("" + modeloGestor.getRondaActual().getNumero());
                    panelVotacion.getBtnVotar().setEnabled(true);
                    panelVotacion.getBtnSiguienteRonda().setEnabled(false);
                    panelVotacion.getCampoTexto().setText(modeloGestor.getRondaActual() +
                        "\nNueva ronda. Seleccione un cardenal y presione Votar.");
                }
            }
        });
    }
}

        
    
