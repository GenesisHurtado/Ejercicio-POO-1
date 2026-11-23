package Modelo;

public class Estudiante extends Usuario
{
    public Estudiante(String codigo, String nombre){
        super(codigo, nombre);
    }

    public int getPlazoMaximo(){
        return 15;
    }

    public String getTipo(){
        return "Estudiante";
    }
}
