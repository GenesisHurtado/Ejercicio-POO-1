package modelo;

public class Personaje
{
    protected String nombre;
    protected Integer edad;
    protected String personalidad;
    protected String rol;

    public Personaje(String nombre, Integer edad, String personalidad, String rol){
        this.nombre = nombre;
        this.edad = edad;
        this.personalidad = personalidad;
        this.rol = rol;
    }

    // GETTERS Y SETTERS
    public String getNombre(){ return nombre; }
    public void setNombre(String nombre){ this.nombre = nombre; }

    public Integer getEdad(){ return edad; }
    public void setEdad(Integer edad){ this.edad = edad; }

    public String getPersonalidad(){ return personalidad; }
    public void setPersonalidad(String personalidad){ this.personalidad = personalidad; }

    public String getRol(){ return rol; }
    public void setRol(String rol){ this.rol = rol; }

    // ACCIONES: devuelven el texto de lo que ocurre (la vista se encarga de mostrarlo)
    public String hablar(String mensaje){
        return nombre + ": " + mensaje;
    }

    public String mover(String direccion){
        return nombre + " se mueve hacia " + direccion;
    }

    // Accion caracteristica de cada personaje (las subclases la redefinen)
    public String accionEspecial(){
        return nombre + " observa la vecindad";
    }

    // Interaccion entre personajes (las subclases la redefinen)
    public String interactuarCon(Personaje otro){
        return nombre + " saluda a " + otro.getNombre();
    }

    // Interaccion con un objeto del entorno
    public String interactuar(ObjetoInteractivo objeto){
        return objeto.usar(this);
    }

    public String toString(){
        return nombre;
    }
}
