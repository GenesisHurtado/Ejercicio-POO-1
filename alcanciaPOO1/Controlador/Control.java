package Controlador;
import Modelo.*;
import Vista.*;
import java.awt.event.*;

public class Control
{
    private JFAlcancia vistaAlcancia;
    private Alcancia modeloAlcancia;

    public Control(Alcancia modeloAlcancia, JFAlcancia vistaAlcancia){
        this.modeloAlcancia = modeloAlcancia;
        this.vistaAlcancia = vistaAlcancia;

        actualizarInterfaz();

        // Ingresar monedas
        vistaAlcancia.getBtn50().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                agregarMoneda(50);
            }
        });

        vistaAlcancia.getBtn100().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                agregarMoneda(100);
            }
        });

        vistaAlcancia.getBtn200().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                agregarMoneda(200);
            }
        });

        vistaAlcancia.getBtn500().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                agregarMoneda(500);
            }
        });

        vistaAlcancia.getBtn1000().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                agregarMoneda(1000);
            }
        });

        // Vaciar
        vistaAlcancia.getBtnVaciar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                vaciarAlcancia();
            }
        });
    }

    private void agregarMoneda(int valor){
        if(modeloAlcancia.agregarMonedas(valor)){
            vistaAlcancia.getLblImagen().setIcon(vistaAlcancia.getIconoLlenando());
            actualizarInterfaz();
        }
    }

    private void vaciarAlcancia(){
        modeloAlcancia.vaciar();
        vistaAlcancia.getLblImagen().setIcon(vistaAlcancia.getIconoRota());
        actualizarInterfaz();
    }

    private void actualizarInterfaz(){
        vistaAlcancia.getLblSaldo().setText("$" + modeloAlcancia.getSaldo());
        vistaAlcancia.getLbl50().setText("<html><center>$50<br>" + modeloAlcancia.getMonedas50() + "</center></html>");
        vistaAlcancia.getLbl100().setText("<html><center>$100<br>" + modeloAlcancia.getMonedas100() + "</center></html>");
        vistaAlcancia.getLbl200().setText("<html><center>$200<br>" + modeloAlcancia.getMonedas200() + "</center></html>");
        vistaAlcancia.getLbl500().setText("<html><center>$500<br>" + modeloAlcancia.getMonedas500() + "</center></html>");
        vistaAlcancia.getLbl1000().setText("<html><center>$1000<br>" + modeloAlcancia.getMonedas1000() + "</center></html>");
        vistaAlcancia.getLblTotal().setText("Total monedas: " + modeloAlcancia.getTotalMonedas());
    }
}
