package Modelo;

public class Estudiante {

    private String nombre;
    private String apellido;
    private int grado;
    private String grupo;

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, int grado, String grupo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.grado = grado;
        this.grupo = grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (Grado " + grado + "-" + grupo + ")";
    }
}
