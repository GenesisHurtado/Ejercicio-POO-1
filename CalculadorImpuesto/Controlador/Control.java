package Controlador;
import Modelo.*;
import Vista.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Write a description of class Control here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Control
{
    private JFImpuesto vistaImpuestos;
    private GestorVehiculo modeloGestor;
    private CalculadorImpuesto modeloCalculador;
    private DecimalFormat formato;

    public Control(GestorVehiculo modeloGestor, CalculadorImpuesto modeloCalculador, JFImpuesto vistaImpuestos){
        this.modeloGestor = modeloGestor;
        this.modeloCalculador = modeloCalculador;
        this.vistaImpuestos = vistaImpuestos;
        formato = new DecimalFormat("#,##0", new DecimalFormatSymbols(Locale.forLanguageTag("es-CO")));

        mostrarVehiculo(modeloGestor.getVehiculoActual());

        vistaImpuestos.getPanelVehiculo().getBtnPrimero().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mostrarVehiculo(modeloGestor.primero());
            }
        });

        vistaImpuestos.getPanelVehiculo().getBtnAnterior().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mostrarVehiculo(modeloGestor.anterior());
            }
        });

        vistaImpuestos.getPanelVehiculo().getBtnSiguiente().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mostrarVehiculo(modeloGestor.siguiente());
            }
        });

        vistaImpuestos.getPanelVehiculo().getBtnUltimo().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mostrarVehiculo(modeloGestor.ultimo());
            }
        });

        vistaImpuestos.getPanelBusqueda().getBtnBuscarLinea().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String linea = vistaImpuestos.getPanelBusqueda().getTxtLinea().getText().trim();
                if(linea.isEmpty()){
                    vistaImpuestos.getPanelResultado().getCampoTexto().setText("Escriba la linea a buscar");
                    return;
                }
                Vehiculo v = modeloGestor.buscarPorLinea(linea);
                if(v == null){
                    vistaImpuestos.getPanelResultado().getCampoTexto().setText("No se encontro ningun vehiculo con esa linea");
                }else{
                    mostrarVehiculo(v);
                }
            }
        });

        vistaImpuestos.getPanelBusqueda().getBtnBuscarMarca().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String marca = vistaImpuestos.getPanelBusqueda().getTxtMarca().getText().trim();
                if(marca.isEmpty()){
                    vistaImpuestos.getPanelResultado().getCampoTexto().setText("Escriba la marca a buscar");
                    return;
                }
                Vehiculo v = modeloGestor.buscarPorMarca(marca);
                if(v == null){
                    vistaImpuestos.getPanelResultado().getCampoTexto().setText("No se encontro ningun vehiculo con esa marca");
                }else{
                    mostrarVehiculo(v);
                }
            }
        });

        vistaImpuestos.getPanelBusqueda().getBtnMasCaro().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mostrarVehiculo(modeloGestor.buscarMasCaro());
            }
        });

        vistaImpuestos.getPanelOpciones().getBtnCalcular().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Vehiculo v = modeloGestor.getVehiculoActual();
                if(v == null){
                    return;
                }
                boolean prontoPago = vistaImpuestos.getPanelDescuento().getChkProntoPago().isSelected();
                boolean servicioPublico = vistaImpuestos.getPanelDescuento().getChkServicioPublico().isSelected();
                boolean traslado = vistaImpuestos.getPanelDescuento().getChkTraslado().isSelected();

                double base = modeloCalculador.calcularImpuestoBase(v);
                double total = modeloCalculador.calcularImpuestoFinal(base, prontoPago, servicioPublico, traslado);

                vistaImpuestos.getPanelResultado().getCampoTexto().setText(
                    "Vehiculo: " + v.getMarca() + " " + v.getLinea() + " " + v.getModelo() + "\n" +
                    "Impuesto sin descuentos: $ " + formato.format(base) + "\n" +
                    "Total a pagar: $ " + formato.format(total));
            }
        });
    }

    private void mostrarVehiculo(Vehiculo v){
        if(v == null){
            return;
        }
        vistaImpuestos.getPanelResultado().getCampoTexto().setText("");
        vistaImpuestos.getPanelVehiculo().getTxtMarca().setText(v.getMarca());
        vistaImpuestos.getPanelVehiculo().getTxtLinea().setText(v.getLinea());
        vistaImpuestos.getPanelVehiculo().getTxtModelo().setText(String.valueOf(v.getModelo()));
        vistaImpuestos.getPanelVehiculo().getTxtValor().setText("$ " + formato.format(v.getPrecio()));
        vistaImpuestos.getPanelVehiculo().setFoto(v.getImagen());
    }

    
}