package modelo;

public class Riesgo
{
    private String codigo;
    private String descripcion;
    private String tipo;
    private int nivelPeligro;

    public Riesgo(String codigo, String descripcion, String tipo, int nivelPeligro){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        setNivelPeligro(nivelPeligro);
    }

    // El nivel de peligro solo puede ir de 1 a 5
    public static boolean nivelValido(int nivel){
        return nivel >= 1 && nivel <= 5;
    }

    // GETTERS
    public String getCodigo(){
        return codigo;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public String getTipo(){
        return tipo;
    }

    public int getNivelPeligro(){
        return nivelPeligro;
    }

    // SETTERS
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setNivelPeligro(int nivelPeligro){
        if(!nivelValido(nivelPeligro)){
            throw new IllegalArgumentException("El nivel de peligro debe estar entre 1 y 5");
        }
        this.nivelPeligro = nivelPeligro;
    }

    // Nombre del nivel segun el numero
    public String getNombreNivel(){
        switch(nivelPeligro){
            case 1:  return "Muy bajo";
            case 2:  return "Bajo";
            case 3:  return "Medio";
            case 4:  return "Alto";
            default: return "Crítico";
        }
    }

    public String toString(){
        return codigo + " - " + descripcion + " (" + tipo + ", nivel " + nivelPeligro + ")";
    }
}
