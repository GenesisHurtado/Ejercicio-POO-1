package Modelo;


/**
 * Write a description of class RangoImpuesto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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

    public double getLimiteInferior(){
        return this.limiteInferior;
    }

    public void setLimiteInferior(double limiteInferior){
        this.limiteInferior = limiteInferior;
    }

    public double getLimiteSuperior(){
        return this.limiteSuperior;
    }

    public void setLimiteSuperior(double limiteSuperior){
        this.limiteSuperior = limiteSuperior;
    }

    public double getPorcentaje(){
        return this.porcentaje;
    }

    public void setPorcentaje(double porcentaje){
        this.porcentaje = porcentaje;
    }
}