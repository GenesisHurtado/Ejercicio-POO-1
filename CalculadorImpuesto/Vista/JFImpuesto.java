package Vista;
import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class JFImpuesto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JFImpuesto extends JFrame
{
      private JPImagen panelImagen;
    private JPVehiculo panelVehiculo;
    private JPBusqueda panelBusqueda;
    private JPDescuento panelDescuento;
    private JPOpciones panelOpciones;
    private JPResultado panelResultado;

    public JFImpuesto(){
        setTitle("Calculo impuestos");
        setSize(570,840);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        panelImagen = new JPImagen();
        panelVehiculo = new JPVehiculo();
        panelBusqueda = new JPBusqueda();
        panelDescuento = new JPDescuento();
        panelOpciones = new JPOpciones();
        panelResultado = new JPResultado();

        JPanel panelSur = new JPanel(new GridLayout(4,1));
        panelSur.add(panelBusqueda);
        panelSur.add(panelDescuento);
        panelSur.add(panelOpciones);
        panelSur.add(panelResultado);

        add(panelImagen,BorderLayout.NORTH);
        add(panelVehiculo,BorderLayout.CENTER);
        add(panelSur,BorderLayout.SOUTH);
    }

    public JPImagen getPanelImagen(){
        return this.panelImagen;
    }

    public JPVehiculo getPanelVehiculo(){
        return this.panelVehiculo;
    }

    public JPBusqueda getPanelBusqueda(){
        return this.panelBusqueda;
    }

    public JPDescuento getPanelDescuento(){
        return this.panelDescuento;
    }

    public JPOpciones getPanelOpciones(){
        return this.panelOpciones;
    }

    public JPResultado getPanelResultado(){
        return this.panelResultado;
    }
    
}