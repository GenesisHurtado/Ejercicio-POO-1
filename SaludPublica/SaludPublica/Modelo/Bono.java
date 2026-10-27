package Modelo;

public class Bono
{
    private double monto;
    private Persona persona;

    public Bono(double monto, Persona persona) {
        this.monto = monto;
        this.persona = persona;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Bono de $" + monto + "\n" +
               "Titular: " + persona.getNombre() + " " + persona.getApellido();
    }
}
