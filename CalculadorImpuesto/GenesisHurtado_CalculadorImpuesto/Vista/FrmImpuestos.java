package Vista;

import Modelo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class FrmImpuestos extends JFrame implements ActionListener
{
    public PanelImagen panelImagen;
    public PanelVehiculo panelVehiculo;
    public PanelBusqueda panelBusqueda;
    public PanelDescuento panelDescuento;
    public PanelOpciones panelOpciones;

    private JPanel panelSur;
    private GestorVehiculo gestor;
    private CalculadorImpuesto calculador;
    private DecimalFormat formato;

    public FrmImpuestos(){
        setTitle("Cálculo impuestos");
        setSize(570, 740);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        gestor = new GestorVehiculo();
        calculador = new CalculadorImpuesto();
        formato = new DecimalFormat("#,##0", new DecimalFormatSymbols(Locale.forLanguageTag("es-CO")));

        panelImagen = new PanelImagen();
        panelVehiculo = new PanelVehiculo();
        panelBusqueda = new PanelBusqueda();
        panelDescuento = new PanelDescuento();
        panelOpciones = new PanelOpciones();

        panelSur = new JPanel();
        panelSur.setLayout(new BoxLayout(panelSur, BoxLayout.Y_AXIS));
        panelSur.add(panelBusqueda);
        panelSur.add(panelDescuento);
        panelSur.add(panelOpciones);

        add(panelImagen, BorderLayout.NORTH);
        add(panelVehiculo, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        panelVehiculo.btnPrimero.addActionListener(this);
        panelVehiculo.btnAnterior.addActionListener(this);
        panelVehiculo.btnSiguiente.addActionListener(this);
        panelVehiculo.btnUltimo.addActionListener(this);
        panelBusqueda.btnBuscarLinea.addActionListener(this);
        panelBusqueda.btnBuscarMarca.addActionListener(this);
        panelBusqueda.btnMasCaro.addActionListener(this);
        panelOpciones.btnCalcular.addActionListener(this);

        mostrarVehiculo(gestor.getVehiculoActual());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object origen = e.getSource();

        if (origen == panelVehiculo.btnPrimero){
            mostrarVehiculo(gestor.primero());
        } else if (origen == panelVehiculo.btnAnterior){
            mostrarVehiculo(gestor.anterior());
        } else if (origen == panelVehiculo.btnSiguiente){
            mostrarVehiculo(gestor.siguiente());
        } else if (origen == panelVehiculo.btnUltimo){
            mostrarVehiculo(gestor.ultimo());
        } else if (origen == panelBusqueda.btnBuscarLinea){
            buscarPorLinea();
        } else if (origen == panelBusqueda.btnBuscarMarca){
            buscarPorMarca();
        } else if (origen == panelBusqueda.btnMasCaro){
            mostrarVehiculo(gestor.buscarMasCaro());
        } else if (origen == panelOpciones.btnCalcular){
            calcular();
        }
    }

    private void mostrarVehiculo(Vehiculo v){
        if (v == null){
            return;
        }
        panelVehiculo.txtMarca.setText(v.getMarca());
        panelVehiculo.txtLinea.setText(v.getLinea());
        panelVehiculo.txtModelo.setText(String.valueOf(v.getModelo()));
        panelVehiculo.txtValor.setText("$ " + formato.format(v.getPrecio()));
        panelVehiculo.setFoto(v.getImagen());
    }

    private void buscarPorLinea(){
        String linea = panelBusqueda.txtLinea.getText().trim();

        if (linea.isEmpty()){
            mensaje("Escriba la línea a buscar");
            return;
        }

        Vehiculo v = gestor.buscarPorLinea(linea);
        if (v == null){
            mensaje("No se encontró ningún vehículo con esa línea");
        } else {
            mostrarVehiculo(v);
        }
    }

    private void buscarPorMarca(){
        String marca = panelBusqueda.txtMarca.getText().trim();

        if (marca.isEmpty()){
            mensaje("Escriba la marca a buscar");
            return;
        }

        Vehiculo v = gestor.buscarPorMarca(marca);
        if (v == null){
            mensaje("No se encontró ningún vehículo con esa marca");
        } else {
            mostrarVehiculo(v);
        }
    }

    private void calcular(){
        Vehiculo v = gestor.getVehiculoActual();
        if (v == null){
            return;
        }

        double base = calculador.calcularImpuestoBase(v);
        double total = calculador.calcularImpuestoFinal(
            base,
            panelDescuento.chkProntoPago.isSelected(),
            panelDescuento.chkServicioPublico.isSelected(),
            panelDescuento.chkTraslado.isSelected()
        );

        mensaje("Vehículo: " + v.getMarca() + " " + v.getLinea() + " " + v.getModelo()
            + "\nImpuesto sin descuentos: $ " + formato.format(base)
            + "\nTotal a pagar: $ " + formato.format(total));
    }

    private void mensaje(String texto){
        JOptionPane.showMessageDialog(this, texto);
    }
}
