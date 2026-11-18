package Modelo;


/**
 * Write a description of class Vehiculo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vehiculo
{
    private String marca;
    private String linea;
    private int modelo;
    private double precio;
    private String imagen;

    public Vehiculo(String marca, String linea, int modelo, double precio, String imagen){
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getLinea(){
        return this.linea;
    }

    public int getModelo(){
        return this.modelo;
    }

    public double getPrecio(){
        return this.precio;
    }

    public String getImagen(){
        return this.imagen;
    }
}