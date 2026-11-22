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

    public Control(GestorCardenal modeloGestor, JFConclave vistaGestor){
        this.vistaGestor = vistaGestor;
        this.modeloGestor = modeloGestor;

        // Se crean los cardenales: 9 electores y 3 no electores (mayores de 80 anios)
        agregar(new Cardenal("Italia",    "1001", "Pietro Parolin",    70, TipoCardenal.OBISPO));
        agregar(new Cardenal("Filipinas", "1002", "Luis Tagle",        68, TipoCardenal.OBISPO));
        agregar(new Cardenal("Hungria",   "1003", "Peter Erdo",        73, TipoCardenal.PRESBITERO));
        agregar(new Cardenal("Ghana",     "1004", "Peter Turkson",     76, TipoCardenal.OBISPO));
        agregar(new Cardenal("Colombia",  "1005", "Cardenal Colombia", 65, TipoCardenal.PRESBITERO));
        agregar(new Cardenal("Brasil",    "1006", "Cardenal Brasil",   60, TipoCardenal.DIACONO));
        agregar(new Cardenal("Espana",    "1007", "Cardenal Espana",   72, TipoCardenal.OBISPO));
        agregar(new Cardenal("Francia",   "1008", "Cardenal Francia",  58, TipoCardenal.PRESBITERO));
        agregar(new Cardenal("Mexico",    "1009", "Cardenal Mexico",   66, TipoCardenal.DIACONO));
        agregar(new Cardenal("Portugal",  "1010", "Cardenal Portugal", 85, TipoCardenal.OBISPO));
        agregar(new Cardenal("Alemania",  "1011", "Cardenal Alemania", 82, TipoCardenal.PRESBITERO));
        agregar(new Cardenal("Polonia",   "1012", "Cardenal Polonia",  90, TipoCardenal.DIACONO));

        // RF 1: listado de electores al iniciar
        vistaGestor.getCampoTexto().setText("Electores: " + modeloGestor.contarElectores() +
            " | No electores: " + modeloGestor.contarNoElectores() +
            "\nVotos para la mayoria (2/3): " + modeloGestor.calcularMayoria() +
            "\n\nListado de electores:\n" + modeloGestor.enlistarElectores() +
            "\n" + modeloGestor.describirRonda() +
            "\nSeleccione un cardenal y presione Votar.");
        vistaGestor.getCampoTexto().setCaretPosition(0);

        // RF 2 y 3: votar y cierre de ronda
        vistaGestor.getBtnVotar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Cardenal votado = (Cardenal) vistaGestor.getCbCardenales().getSelectedItem();
                if(votado == null){
                    vistaGestor.getCampoTexto().setText("Seleccione un cardenal");
                    return;
                }
                if(modeloGestor.votar(votado)){
                    vistaGestor.getCampoTexto().setText("Voto registrado (" +
                        modeloGestor.contarVotos() + " de " +
                        modeloGestor.contarElectores() + ")");
                }
                if(modeloGestor.rondaCerrada()){
                    vistaGestor.getBtnVotar().setEnabled(false);
                    String resultado = modeloGestor.describirRonda() + "\n" + modeloGestor.enlistarResultados();
                    if(modeloGestor.verificarPapa() != null){
                        resultado += "\nHay nuevo papa\n" + modeloGestor.enlistarPapa();
                        vistaGestor.getBtnSiguienteRonda().setEnabled(false);
                    }else{
                        resultado += "\nNo hay papa aun";
                        vistaGestor.getBtnSiguienteRonda().setEnabled(true);
                    }
                    vistaGestor.getCampoTexto().setText(resultado);
                }
            }
        });

        vistaGestor.getBtnMostrarResultados().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                vistaGestor.getCampoTexto().setText(modeloGestor.describirRonda() +
                    "\nVotos registrados: " + modeloGestor.contarVotos() +
                    " de " + modeloGestor.contarElectores() +
                    "\n" + modeloGestor.enlistarResultados());
            }
        });

        vistaGestor.getBtnSiguienteRonda().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(modeloGestor.siguienteRonda()){
                    vistaGestor.getTxtNumRonda().setText("" + modeloGestor.numeroRonda());
                    vistaGestor.getBtnVotar().setEnabled(true);
                    vistaGestor.getBtnSiguienteRonda().setEnabled(false);
                    vistaGestor.getCampoTexto().setText(modeloGestor.describirRonda() +
                        "\nNueva ronda. Seleccione un cardenal y presione Votar.");
                }
            }
        });
    }

    private void agregar(Cardenal c){
        if(modeloGestor.agregarCardenal(c)){
            vistaGestor.getCbCardenales().addItem(c);
        }
    }
}
