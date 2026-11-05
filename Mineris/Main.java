import modelo.*;
import vista.*;
import controlador.*;


/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Main {
    public static void main(String[] args) {
        GestorRiesgos modeloGestor = new GestorRiesgos();
        JFGestion vistaGestion = new JFGestion();
        Control control = new Control(modeloGestor, vistaGestion);
        vistaGestion.setVisible(true);
    }
}

