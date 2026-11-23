package Modelo;

public class Administrativo extends Usuario
{
    public Administrativo(String codigo, String nombre){
        super(codigo, nombre);
    }

    public int getPlazoMaximo(){
        return 3;
    }

    public String getTipo(){
        return "Administrativo";
    }
}
