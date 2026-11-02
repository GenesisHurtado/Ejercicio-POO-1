package Vista;

import javax.swing.*;
import java.awt.*;

public class PanelBusqueda extends JPanel
{
    public JTextField txtLinea;
    public JTextField txtMarca;
    public JButton btnBuscarLinea;
    public JButton btnBuscarMarca;
    public JButton btnMasCaro;

    public PanelBusqueda(){
        setLayout(new GridLayout(3, 2, 5, 5));
        setBorder(BorderFactory.createTitledBorder("Búsquedas"));

        txtLinea = new JTextField();
        txtMarca = new JTextField();
        btnBuscarLinea = new JButton("Buscar por línea");
        btnBuscarMarca = new JButton("Buscar por marca");
        btnMasCaro = new JButton("Buscar vehículo más Caro");

        add(txtLinea);
        add(btnBuscarLinea);
        add(txtMarca);
        add(btnBuscarMarca);
        add(new JLabel());
        add(btnMasCaro);
    }
}
