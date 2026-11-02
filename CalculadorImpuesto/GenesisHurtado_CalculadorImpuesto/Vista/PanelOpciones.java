package Vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelOpciones extends JPanel
{
    public JButton btnCalcular;
    public JButton btnOpcion1;
    public JButton btnOpcion2;

    public PanelOpciones(){
        setLayout(new GridLayout(1, 3, 5, 0));
        TitledBorder borde = BorderFactory.createTitledBorder("Opciones");
        borde.setTitleColor(Color.BLUE);
        setBorder(borde);

        btnCalcular = new JButton("Calcular");
        btnOpcion1 = new JButton("Opción 1");
        btnOpcion2 = new JButton("Opción 2");

        add(btnCalcular);
        add(btnOpcion1);
        add(btnOpcion2);
    }
}
