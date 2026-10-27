package Modelo;

public class Gasto
{
    private double monto;

    public Gasto() {
    }

    public Gasto(double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Monto: $" + monto;
    }
}
