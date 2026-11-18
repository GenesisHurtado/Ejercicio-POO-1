import Modelo.*;
import Vista.*;
import Controlador.*;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
     public static void main(String[] args){
        GestorVehiculo gestor = new GestorVehiculo();
        CalculadorImpuesto calculador = new CalculadorImpuesto();
        JFImpuesto vista = new JFImpuesto();
        Control control = new Control(gestor, calculador, vista);
        vista.setVisible(true);
    }
    
}