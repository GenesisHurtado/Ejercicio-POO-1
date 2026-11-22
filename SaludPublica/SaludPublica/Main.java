import Modelo.*;
import Vista.*;
import Controlador.*;

public class Main
{
    public static void main(String[] args){
        GestorPersona modelo = new GestorPersona();
        JFRegistroPersona vista = new JFRegistroPersona();
        Control control = new Control(modelo, vista);
        vista.setVisible(true);
    }
}
