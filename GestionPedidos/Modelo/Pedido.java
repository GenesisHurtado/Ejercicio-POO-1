package Modelo;
import java.util.ArrayList;

public class Pedido
{
    private int numero;
    private Cliente cliente;
    private ArrayList<Producto> productos;

    public Pedido(int numero){
        this.numero = numero;
        this.productos = new ArrayList<>();
    }

    public Producto buscarProducto(String codigo){
        for(Producto p : productos){
            if(p.getCodigo().equalsIgnoreCase(codigo)){
                return p;
            }
        }
        return null;
    }

    // No se repite el mismo codigo dentro de un pedido
    public boolean agregarProducto(Producto p){
        if(buscarProducto(p.getCodigo()) != null){
            return false;
        }
        productos.add(p);
        return true;
    }

    public boolean eliminarProducto(String codigo){
        Producto p = buscarProducto(codigo);
        if(p == null){
            return false;
        }
        productos.remove(p);
        return true;
    }

    public double calcularTotal(){
        double total = 0;
        for(Producto p : productos){
            total += p.getPrecio();
        }
        return total;
    }

    public boolean estaVacio(){
        return productos.isEmpty();
    }

    public int getNumero(){
        return numero;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public ArrayList<Producto> getProductos(){
        return productos;
    }
}
