package Modelo;

public abstract class Usuario
{
    protected String codigo;
    protected String nombre;

    public Usuario(String codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
    }

    // Plazo maximo de prestamo en dias
    public abstract int getPlazoMaximo();

    public abstract String getTipo();

    public String getCodigo(){
        return codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public String toString(){
        return codigo + " - " + nombre + " (" + getTipo() + ")";
    }
}
