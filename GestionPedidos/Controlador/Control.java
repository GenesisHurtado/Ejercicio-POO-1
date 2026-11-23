package Controlador;
import Modelo.*;
import Vista.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Control
{
    private JFGestionPedido vistaGestor;
    private GestorPedido modeloGestor;
    private DecimalFormat formato;

    public Control(GestorPedido modeloGestor, JFGestionPedido vistaGestor){
        this.vistaGestor = vistaGestor;
        this.modeloGestor = modeloGestor;

        // Los valores se muestran con punto de miles: 295.000
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setGroupingSeparator('.');
        simbolos.setDecimalSeparator(',');
        formato = new DecimalFormat("#,##0.##", simbolos);

        mostrarNumeroPedido();
        actualizarTotal();
        mensaje("Ingrese los datos del producto y presione Agregar Producto");

        // Agregar un producto al pedido
        vistaGestor.getBtnAgregarProducto().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                agregarProducto();
            }
        });

        // Eliminar el producto seleccionado en la tabla
        vistaGestor.getBtnEliminarProducto().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                eliminarProducto();
            }
        });

        // Guardar el pedido y empezar uno nuevo
        vistaGestor.getBtnNuevoPedido().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                nuevoPedido();
            }
        });

        // Limpiar los campos de texto
        vistaGestor.getBtnLimpiar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                limpiarCampos();
                mensaje("Campos limpiados");
            }
        });

        // Salir
        vistaGestor.getBtnSalir().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }

    private void agregarProducto(){
        String codigo = vistaGestor.getTxtCodigoProducto().getText().trim();
        String nombre = vistaGestor.getTxtNombreProducto().getText().trim();
        String textoPrecio = vistaGestor.getTxtPrecio().getText().trim();

        if(codigo.isEmpty() || nombre.isEmpty() || textoPrecio.isEmpty()){
            mensaje("Complete el código, el nombre y el precio del producto");
            return;
        }

        double precio;
        try{
            precio = Double.parseDouble(textoPrecio);
        }catch(NumberFormatException ex){
            mensaje("El precio debe ser un número");
            return;
        }
        if(precio <= 0){
            mensaje("El precio debe ser mayor que cero");
            return;
        }

        if(!modeloGestor.agregarProducto(new Producto(codigo, nombre, precio))){
            mensaje("El producto " + codigo + " ya está en el pedido");
            return;
        }

        vistaGestor.getModeloTabla().addRow(new Object[]{codigo, nombre, formato.format(precio)});
        vistaGestor.getTxtCodigoProducto().setText("");
        vistaGestor.getTxtNombreProducto().setText("");
        vistaGestor.getTxtPrecio().setText("");
        actualizarTotal();
        mensaje("Producto agregado: " + nombre);
    }

    private void eliminarProducto(){
        int fila = vistaGestor.getTablaProductos().getSelectedRow();
        if(fila < 0){
            mensaje("Seleccione un producto de la tabla");
            return;
        }
        String codigo = (String) vistaGestor.getModeloTabla().getValueAt(fila, 0);
        modeloGestor.eliminarProducto(codigo);
        vistaGestor.getModeloTabla().removeRow(fila);
        actualizarTotal();
        mensaje("Producto eliminado: " + codigo);
    }

    private void nuevoPedido(){
        if(modeloGestor.getPedidoActual().estaVacio()){
            limpiarCampos();
            mensaje("El pedido actual no tiene productos");
            return;
        }

        String cedula = vistaGestor.getTxtCedula().getText().trim();
        String nombre = vistaGestor.getTxtNombreCliente().getText().trim();
        if(cedula.isEmpty() || nombre.isEmpty()){
            mensaje("Ingrese la cédula y el nombre del cliente para guardar el pedido");
            return;
        }
        if(!cedula.matches("\\d+")){
            mensaje("La cédula debe ser numérica");
            return;
        }

        int numero = modeloGestor.getPedidoActual().getNumero();
        int cantidad = modeloGestor.getPedidoActual().getProductos().size();
        double total = modeloGestor.calcularTotal();

        if(modeloGestor.cerrarPedido(new Cliente(cedula, nombre))){
            vistaGestor.getModeloTabla().setRowCount(0);
            limpiarCampos();
            mostrarNumeroPedido();
            actualizarTotal();
            mensaje("Pedido " + numero + " guardado (" + cantidad + " productos, $ " + formato.format(total) + ")");
        }
    }

    private void limpiarCampos(){
        vistaGestor.getTxtCedula().setText("");
        vistaGestor.getTxtNombreCliente().setText("");
        vistaGestor.getTxtCodigoProducto().setText("");
        vistaGestor.getTxtNombreProducto().setText("");
        vistaGestor.getTxtPrecio().setText("");
    }

    private void mostrarNumeroPedido(){
        vistaGestor.getTxtNumeroPedido().setText("" + modeloGestor.getPedidoActual().getNumero());
    }

    private void actualizarTotal(){
        vistaGestor.getLblTotal().setText("$ " + formato.format(modeloGestor.calcularTotal()));
    }

    private void mensaje(String texto){
        vistaGestor.getLblMensaje().setText(texto);
    }
}
