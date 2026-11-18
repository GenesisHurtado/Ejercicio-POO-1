package Vista;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Write a description of class JPVehiculo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JPVehiculo extends JPanel
{
    private JLabel lblMarca, lblLinea, lblModelo, lblValor, lblFoto;
    private JTextField txtMarca, txtLinea, txtModelo, txtValor;
    private JButton btnPrimero, btnAnterior, btnSiguiente, btnUltimo;

    public JPVehiculo(){
        setLayout(new BorderLayout(5,5));
        TitledBorder borde = BorderFactory.createTitledBorder("Datos del vehiculo");
        borde.setTitleColor(Color.BLUE);
        setBorder(borde);

        lblFoto = new JLabel();
        lblFoto.setHorizontalAlignment(SwingConstants.CENTER);

        lblMarca = new JLabel("Marca");
        lblLinea = new JLabel("Linea");
        lblModelo = new JLabel("Modelo");
        lblValor = new JLabel("Valor");

        txtMarca = new JTextField();
        txtLinea = new JTextField();
        txtModelo = new JTextField();
        txtValor = new JTextField();
        txtMarca.setEditable(false);
        txtLinea.setEditable(false);
        txtModelo.setEditable(false);
        txtValor.setEditable(false);
        txtValor.setBackground(Color.WHITE);
        txtValor.setForeground(Color.BLUE);

        JPanel panelCampos = new JPanel(new GridLayout(4,2,10,10));
        panelCampos.add(lblMarca);
        panelCampos.add(txtMarca);
        panelCampos.add(lblLinea);
        panelCampos.add(txtLinea);
        panelCampos.add(lblModelo);
        panelCampos.add(txtModelo);
        panelCampos.add(lblValor);
        panelCampos.add(txtValor);

        JPanel panelDatos = new JPanel(new GridLayout(1,2,10,0));
        panelDatos.add(lblFoto);
        panelDatos.add(panelCampos);

        btnPrimero = new JButton("<<");
        btnAnterior = new JButton("<");
        btnSiguiente = new JButton(">");
        btnUltimo = new JButton(">>");

        JPanel panelNavegacion = new JPanel(new GridLayout(1,4,5,0));
        panelNavegacion.add(btnPrimero);
        panelNavegacion.add(btnAnterior);
        panelNavegacion.add(btnSiguiente);
        panelNavegacion.add(btnUltimo);

        add(panelDatos,BorderLayout.CENTER);
        add(panelNavegacion,BorderLayout.SOUTH);
    }

    public void setFoto(String ruta){
        ImageIcon icono = new ImageIcon("imagenes/" + ruta);
        Image imagen = icono.getImage().getScaledInstance(250,149,Image.SCALE_SMOOTH);
        lblFoto.setIcon(new ImageIcon(imagen));
    }

    public JTextField getTxtMarca(){
        return this.txtMarca;
    }

    public JTextField getTxtLinea(){
        return this.txtLinea;
    }

    public JTextField getTxtModelo(){
        return this.txtModelo;
    }

    public JTextField getTxtValor(){
        return this.txtValor;
    }

    public JButton getBtnPrimero(){
        return this.btnPrimero;
    }

    public JButton getBtnAnterior(){
        return this.btnAnterior;
    }

    public JButton getBtnSiguiente(){
        return this.btnSiguiente;
    }

    public JButton getBtnUltimo(){
        return this.btnUltimo;
    }

    
}