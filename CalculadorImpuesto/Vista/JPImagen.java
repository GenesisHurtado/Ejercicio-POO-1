package Vista;
import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class JPImagen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JPImagen extends JPanel
{
    private JLabel lblBanner;

    public JPImagen(){
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        ImageIcon icono = new ImageIcon("imagenes/banner.png");
        Image imagen = icono.getImage().getScaledInstance(540,183,Image.SCALE_SMOOTH);
        lblBanner = new JLabel(new ImageIcon(imagen));
        add(lblBanner);
    }

    public JLabel getLblBanner(){
        return this.lblBanner;
    }
}