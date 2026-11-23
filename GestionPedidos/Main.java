import Modelo.*;
import Vista.*;
import Controlador.*;
import javax.swing.UIManager;

public class Main
{
    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
        }
        GestorPedido modelo = new GestorPedido();
        JFGestionPedido vista = new JFGestionPedido();
        Control control = new Control(modelo, vista);
        vista.setVisible(true);
    }
}
