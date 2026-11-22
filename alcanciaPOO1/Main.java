import Modelo.*;
import Vista.*;
import Controlador.*;

public class Main
{
    public static void main(String[] args){
        Alcancia modelo = new Alcancia();
        JFAlcancia vista = new JFAlcancia();
        Control control = new Control(modelo, vista);
        vista.setVisible(true);
    }
}
