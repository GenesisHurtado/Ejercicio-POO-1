package Vista;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Write a description of class JPResultado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JPResultado extends JPanel
{
    private JTextArea campoTexto;

    public JPResultado(){
        setLayout(new BorderLayout());
        TitledBorder borde = BorderFactory.createTitledBorder("Resultado");
        borde.setTitleColor(Color.BLUE);
        setBorder(borde);

        campoTexto = new JTextArea();
        campoTexto.setEditable(false);

        add(new JScrollPane(campoTexto),BorderLayout.CENTER);
    }

    public JTextArea getCampoTexto(){
        return this.campoTexto;
    }
}