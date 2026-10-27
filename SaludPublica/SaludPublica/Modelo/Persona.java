package Modelo;

public abstract class Persona
{
    protected TipoDocumento tipoDocumento;
    protected String numDocumento;
    protected String nombre;
    protected String apellido;
    protected String direccion;
    protected String telefono;
    protected int edad;
    protected String estadoCivil;
    protected int estrato;
    protected boolean cabezaHogar;
    protected Bono bono;

    public Persona(TipoDocumento tipoDocumento, String numDocumento, String nombre,
                   String apellido, String direccion, String telefono, int edad,
                   String estadoCivil, int estrato, boolean cabezaHogar) {
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.edad = edad;
        this.estadoCivil = estadoCivil;
        this.estrato = estrato;
        this.cabezaHogar = cabezaHogar;
    }

    public abstract double getTotalGastado();

    public abstract String getTipo();

    public boolean distribucionValida() {
        return getTotalGastado() <= bono.getMonto();
    }

    public TipoDocumento getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(TipoDocumento tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public String getNumDocumento() { return numDocumento; }
    public void setNumDocumento(String numDocumento) { this.numDocumento = numDocumento; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getEstadoCivil() { return estadoCivil; }
    public void setEstadoCivil(String estadoCivil) { this.estadoCivil = estadoCivil; }

    public int getEstrato() { return estrato; }
    public void setEstrato(int estrato) { this.estrato = estrato; }

    public boolean getCabezaHogar() { return cabezaHogar; }
    public void setCabezaHogar(boolean cabezaHogar) { this.cabezaHogar = cabezaHogar; }

    public Bono getBono() { return bono; }
    public void setBono(Bono bono) { this.bono = bono; }

    @Override
    public String toString() {
        return "Clasificación: " + getTipo() + "\n" +
               "Tipo Documento: " + tipoDocumento + "\n" +
               "Número Documento: " + numDocumento + "\n" +
               "Nombre: " + nombre + "\n" +
               "Apellido: " + apellido + "\n" +
               "Dirección: " + direccion + "\n" +
               "Teléfono: " + telefono + "\n" +
               "Edad: " + edad + "\n" +
               "Estado Civil: " + estadoCivil + "\n" +
               "Estrato: " + estrato + "\n" +
               "Cabeza de Hogar: " + (cabezaHogar ? "Sí" : "No");
    }
}
