package Modelo;

public class ProfesionalSalud extends Persona
{
    private String instSalud;
    private String especialidad;
    private ElementoBioseguridad elemento;
    private Medicina medicina;

    public ProfesionalSalud(TipoDocumento tipoDocumento, String numDocumento, String nombre,
                            String apellido, String direccion, String telefono, int edad,
                            String estadoCivil, int estrato, boolean cabezaHogar,
                            String instSalud, String especialidad,
                            ElementoBioseguridad elemento, Medicina medicina) {
        super(tipoDocumento, numDocumento, nombre, apellido, direccion, telefono,
              edad, estadoCivil, estrato, cabezaHogar);
        this.instSalud = instSalud;
        this.especialidad = especialidad;
        this.elemento = elemento;
        this.medicina = medicina;
        this.bono = new Bono(350000, this);
    }

    @Override
    public double getTotalGastado() {
        double total = 0;
        if (medicina != null) total += medicina.getMonto();
        if (elemento != null) total += elemento.getMonto();
        return total;
    }

    @Override
    public String getTipo() {
        return "Profesional de Salud";
    }

    public String getInstSalud() { return instSalud; }
    public void setInstSalud(String instSalud) { this.instSalud = instSalud; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public ElementoBioseguridad getElemento() { return elemento; }
    public void setElemento(ElementoBioseguridad elemento) { this.elemento = elemento; }

    public Medicina getMedicina() { return medicina; }
    public void setMedicina(Medicina medicina) { this.medicina = medicina; }

    @Override
    public String toString() {
        return super.toString()
             + "\nInstitución de salud: " + instSalud
             + "\nEspecialidad: " + especialidad
             + "\nMedicina: $" + (medicina != null ? medicina.getMonto() : 0)
             + "\nBioseguridad: $" + (elemento != null ? elemento.getMonto() : 0)
             + "\nTotal gastado: $" + getTotalGastado()
             + "\nBono: $" + bono.getMonto();
    }
}
