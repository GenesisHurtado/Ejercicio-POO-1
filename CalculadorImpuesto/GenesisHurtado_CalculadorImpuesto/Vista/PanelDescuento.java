package Vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelDescuento extends JPanel
{
    public JCheckBox chkProntoPago;
    public JCheckBox chkTraslado;
    public JCheckBox chkServicioPublico;

    public PanelDescuento(){
        setLayout(new GridLayout(2, 2, 5, 5));
        TitledBorder borde = BorderFactory.createTitledBorder("Descuentos");
        borde.setTitleColor(Color.BLUE);
        setBorder(borde);

        chkProntoPago = new JCheckBox("Pronto pago");
        chkTraslado = new JCheckBox("Traslado de cuenta");
        chkServicioPublico = new JCheckBox("Servicio público");

        add(chkProntoPago);
        add(chkTraslado);
        add(chkServicioPublico);
        add(new JLabel());
    }
}
