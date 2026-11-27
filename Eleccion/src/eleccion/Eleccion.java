package eleccion;

import Controlador.*;
import Modelo.*;
import Vista.JFEleccion;

public class Eleccion {

    public static void main(String[] args) {
        JFEleccion vista = new JFEleccion();
        Gestor modelo = new Gestor();
        Control control = new Control(vista, modelo);
        vista.setVisible(true);
    }
}
