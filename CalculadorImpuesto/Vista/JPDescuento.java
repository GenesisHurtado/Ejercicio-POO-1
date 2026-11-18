package Vista;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Write a description of class JPDescuento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JPDescuento extends JPanel
{
    private JCheckBox chkProntoPago, chkTraslado, chkServicioPublico;

    public JPDescuento(){
        setLayout(new GridLayout(2,2,5,5));
        TitledBorder borde = BorderFactory.createTitledBorder("Descuentos");
        borde.setTitleColor(Color.BLUE);
        setBorder(borde);

        chkProntoPago = new JCheckBox("Pronto pago");
        chkTraslado = new JCheckBox("Traslado de cuenta");
        chkServicioPublico = new JCheckBox("Servicio publico");

        add(chkProntoPago);
        add(chkTraslado);
        add(chkServicioPublico);
        add(new JLabel());
    }

    public JCheckBox getChkProntoPago(){
        return this.chkProntoPago;
    }

    public JCheckBox getChkTraslado(){
        return this.chkTraslado;
    }

    public JCheckBox getChkServicioPublico(){
        return this.chkServicioPublico;
    }
    
}