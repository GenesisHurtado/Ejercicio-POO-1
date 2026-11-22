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
        GestorCardenal modelo = new GestorCardenal();
        JFConclave vista = new JFConclave();
        Control control = new Control(modelo, vista);
        vista.setVisible(true);
    }
}