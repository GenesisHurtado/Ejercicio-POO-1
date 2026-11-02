package Vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelVehiculo extends JPanel
{
    private JLabel lblMarca;
    private JLabel lblLinea;
    private JLabel lblModelo;
    private JLabel lblValor;
    private JLabel lblFoto;
    private JPanel panelDatos;
    private JPanel panelCampos;
    private JPanel panelNavegacion;

    public JTextField txtMarca;
    public JTextField txtLinea;
    public JTextField txtModelo;
    public JTextField txtValor;

    public JButton btnPrimero;
    public JButton btnAnterior;
    public JButton btnSiguiente;
    public JButton btnUltimo;

    public PanelVehiculo(){
        setLayout(new BorderLayout(5, 5));
        TitledBorder borde = BorderFactory.createTitledBorder("Datos del vehículo");
        borde.setTitleColor(Color.BLUE);
        setBorder(borde);

        lblFoto = new JLabel();
        lblFoto.setHorizontalAlignment(SwingConstants.CENTER);

        lblMarca = new JLabel("Marca");
        lblLinea = new JLabel("Línea");
        lblModelo = new JLabel("Modelo");
        lblValor = new JLabel("Valor");
        Font negrita = new Font("Arial", Font.BOLD, 12);
        lblMarca.setFont(negrita);
        lblLinea.setFont(negrita);
        lblModelo.setFont(negrita);
        lblValor.setFont(negrita);

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

        panelCampos = new JPanel(new GridLayout(4, 2, 10, 10));
        panelCampos.add(lblMarca);
        panelCampos.add(txtMarca);
        panelCampos.add(lblLinea);
        panelCampos.add(txtLinea);
        panelCampos.add(lblModelo);
        panelCampos.add(txtModelo);
        panelCampos.add(lblValor);
        panelCampos.add(txtValor);

        panelDatos = new JPanel(new GridLayout(1, 2, 10, 0));
        panelDatos.add(lblFoto);
        panelDatos.add(panelCampos);

        btnPrimero = new JButton("<<");
        btnAnterior = new JButton("<");
        btnSiguiente = new JButton(">");
        btnUltimo = new JButton(">>");

        panelNavegacion = new JPanel(new GridLayout(1, 4, 5, 0));
        panelNavegacion.add(btnPrimero);
        panelNavegacion.add(btnAnterior);
        panelNavegacion.add(btnSiguiente);
        panelNavegacion.add(btnUltimo);

        add(panelDatos, BorderLayout.CENTER);
        add(panelNavegacion, BorderLayout.SOUTH);
    }

    public void setFoto(String ruta){
        ImageIcon icono = new ImageIcon("Vista/Imagen/" + ruta);
        Image imagen = icono.getImage().getScaledInstance(250, 149, Image.SCALE_SMOOTH);
        lblFoto.setIcon(new ImageIcon(imagen));
    }
}
