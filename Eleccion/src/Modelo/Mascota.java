package Modelo;

public class Mascota {

    private String id;
    private String nombre;
    private String genero;
    private int edad;
    private String cualidades;
    private TipoAnimal tipo;

    public Mascota() {
    }

    public Mascota(String id, String nombre, String genero, int edad, String cualidades, TipoAnimal tipo) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.cualidades = cualidades;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCualidades() {
        return cualidades;
    }

    public void setCualidades(String cualidades) {
        this.cualidades = cualidades;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " (" + tipo + ", " + genero + ", " + edad + " años) Cualidades: " + cualidades;
    }
}
