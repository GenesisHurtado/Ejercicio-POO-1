package Vista;
import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class JPBusqueda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JPBusqueda extends JPanel
{
    private JTextField txtLinea, txtMarca;
    private JButton btnBuscarLinea, btnBuscarMarca, btnMasCaro;

    public JPBusqueda(){
        setLayout(new GridLayout(3,2,5,5));
        setBorder(BorderFactory.createTitledBorder("Busquedas"));

        txtLinea = new JTextField();
        txtMarca = new JTextField();
        btnBuscarLinea = new JButton("Buscar por linea");
        btnBuscarMarca = new JButton("Buscar por marca");
        btnMasCaro = new JButton("Buscar vehiculo mas Caro");

        add(txtLinea);
        add(btnBuscarLinea);
        add(txtMarca);
        add(btnBuscarMarca);
        add(new JLabel());
        add(btnMasCaro);
    }

    public JTextField getTxtLinea(){
        return this.txtLinea;
    }

    public JTextField getTxtMarca(){
        return this.txtMarca;
    }

    public JButton getBtnBuscarLinea(){
        return this.btnBuscarLinea;
    }

    public JButton getBtnBuscarMarca(){
        return this.btnBuscarMarca;
    }

    public JButton getBtnMasCaro(){
        return this.btnMasCaro;
    }
    
}