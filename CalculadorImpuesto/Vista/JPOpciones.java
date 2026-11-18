package Vista;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Write a description of class JPOpciones here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JPOpciones extends JPanel
{
    private JButton btnCalcular, btnOpcion1, btnOpcion2;

    public JPOpciones(){
        setLayout(new GridLayout(1,3,5,0));
        TitledBorder borde = BorderFactory.createTitledBorder("Opciones");
        borde.setTitleColor(Color.BLUE);
        setBorder(borde);

        btnCalcular = new JButton("Calcular");
        btnOpcion1 = new JButton("Opcion 1");
        btnOpcion2 = new JButton("Opcion 2");

        add(btnCalcular);
        add(btnOpcion1);
        add(btnOpcion2);
    }

    public JButton getBtnCalcular(){
        return this.btnCalcular;
    }

    public JButton getBtnOpcion1(){
        return this.btnOpcion1;
    }

    public JButton getBtnOpcion2(){
        return this.btnOpcion2;
    }
}