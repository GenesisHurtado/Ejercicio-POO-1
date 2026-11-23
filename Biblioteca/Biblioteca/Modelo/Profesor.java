package Modelo;

public class Profesor extends Usuario
{
    public Profesor(String codigo, String nombre){
        super(codigo, nombre);
    }

    public int getPlazoMaximo(){
        return 15;
    }

    public String getTipo(){
        return "Profesor";
    }
}
