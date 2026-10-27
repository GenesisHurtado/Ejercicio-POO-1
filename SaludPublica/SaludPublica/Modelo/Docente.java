package Modelo;

public class Docente extends Persona
{
    private String instEducativa;
    private String nivelEducativo;
    private ImplementoTecnologico implemento;
    private Servicio servicio;

    public Docente(TipoDocumento tipoDocumento, String numDocumento, String nombre,
                   String apellido, String direccion, String telefono, int edad,
                   String estadoCivil, int estrato, boolean cabezaHogar,
                   String instEducativa, String nivelEducativo,
                   ImplementoTecnologico implemento, Servicio servicio) {
        super(tipoDocumento, numDocumento, nombre, apellido, direccion, telefono,
              edad, estadoCivil, estrato, cabezaHogar);
        this.instEducativa = instEducativa;
        this.nivelEducativo = nivelEducativo;
        this.implemento = implemento;
        this.servicio = servicio;
        this.bono = new Bono(100000, this);
    }

    @Override
    public double getTotalGastado() {
        double total = 0;
        if (implemento != null) total += implemento.getMonto();
        if (servicio != null) total += servicio.getMonto();
        return total;
    }

    @Override
    public String getTipo() {
        return "Docente";
    }

    public String getInstEducativa() { return instEducativa; }
    public void setInstEducativa(String instEducativa) { this.instEducativa = instEducativa; }

    public String getNivelEducativo() { return nivelEducativo; }
    public void setNivelEducativo(String nivelEducativo) { this.nivelEducativo = nivelEducativo; }

    public ImplementoTecnologico getImplemento() { return implemento; }
    public void setImplemento(ImplementoTecnologico implemento) { this.implemento = implemento; }

    public Servicio getServicio() { return servicio; }
    public void setServicio(Servicio servicio) { this.servicio = servicio; }

    @Override
    public String toString() {
        return super.toString()
             + "\nInstitución educativa: " + instEducativa
             + "\nNivel educativo: " + nivelEducativo
             + "\nImplementos tecnológicos: $" + (implemento != null ? implemento.getMonto() : 0)
             + "\nServicio: $" + (servicio != null ? servicio.getMonto() : 0)
             + "\nTotal gastado: $" + getTotalGastado()
             + "\nBono: $" + bono.getMonto();
    }
}
