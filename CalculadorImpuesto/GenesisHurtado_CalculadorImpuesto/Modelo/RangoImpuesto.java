package Modelo;

public class RangoImpuesto
{
    private double limiteInferior;
    private double limiteSuperior;
    private double porcentaje;

    public RangoImpuesto(double limiteInferior, double limiteSuperior, double porcentaje){
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        this.porcentaje = porcentaje;
    }

    public boolean incluye(double valor){
        return valor > limiteInferior && valor <= limiteSuperior;
    }

    public double getLimiteInferior(){ return limiteInferior; }
    public double getLimiteSuperior(){ return limiteSuperior; }
    public double getPorcentaje(){ return porcentaje; }

    public void setLimiteInferior(double limiteInferior){ this.limiteInferior = limiteInferior; }
    public void setLimiteSuperior(double limiteSuperior){ this.limiteSuperior = limiteSuperior; }
    public void setPorcentaje(double porcentaje){ this.porcentaje = porcentaje; }
}
