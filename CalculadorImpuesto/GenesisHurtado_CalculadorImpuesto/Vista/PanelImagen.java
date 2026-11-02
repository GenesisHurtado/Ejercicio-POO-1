package Vista;

import javax.swing.*;
import java.awt.*;

public class PanelImagen extends JPanel
{
    private JLabel lblBanner;

    public PanelImagen(){
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        ImageIcon icono = new ImageIcon("Vista/Imagen/banner.png");
        Image imagen = icono.getImage().getScaledInstance(540, 183, Image.SCALE_SMOOTH);
        lblBanner = new JLabel(new ImageIcon(imagen));

        add(lblBanner);
    }
}
