package Modelo;
import java.util.ArrayList;

public class GestorPedido
{
    private ArrayList<Pedido> pedidos;
    private Pedido pedidoActual;

    public GestorPedido(){
        pedidos = new ArrayList<>();
        pedidoActual = new Pedido(1);
    }

    // GETTERS PARA LA VISTA
    public Pedido getPedidoActual(){
        return pedidoActual;
    }

    public ArrayList<Pedido> getPedidos(){
        return pedidos;
    }

    // PEDIDO ACTUAL

    public boolean agregarProducto(Producto p){
        return pedidoActual.agregarProducto(p);
    }

    public boolean eliminarProducto(String codigo){
        return pedidoActual.eliminarProducto(codigo);
    }

    public double calcularTotal(){
        return pedidoActual.calcularTotal();
    }

    // Guarda el pedido actual con su cliente y abre el siguiente pedido
    public boolean cerrarPedido(Cliente cliente){
        if(pedidoActual.estaVacio()){
            return false;
        }
        pedidoActual.setCliente(cliente);
        pedidos.add(pedidoActual);
        pedidoActual = new Pedido(pedidoActual.getNumero() + 1);
        return true;
    }

    public int contarPedidos(){
        return pedidos.size();
    }
}
