import modelo.*;
import vista.*;
import controlador.*;
import javax.swing.UIManager;

public class Main
{
    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
        }
        GestorRiesgos modelo = new GestorRiesgos();
        JFGestion vista = new JFGestion();
        Control control = new Control(modelo, vista);
        vista.setVisible(true);
    }
}
