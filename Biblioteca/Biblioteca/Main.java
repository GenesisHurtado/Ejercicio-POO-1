import Modelo.*;
import Vista.*;
import Controlador.*;

public class Main
{
    public static void main(String[] args){
        GestorBiblioteca modelo = new GestorBiblioteca();
        JFBiblioteca vista = new JFBiblioteca();
        Control control = new Control(modelo, vista);
        vista.setVisible(true);
    }
}
