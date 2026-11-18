package Modelo;
import java.util.ArrayList;


/**
 * Write a description of class CalculadorImpuesto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CalculadorImpuesto
{
     public static final double DESCUENTO_PRONTO_PAGO = 10;
    public static final double DESCUENTO_SERVICIO_PUBLICO = 50000;
    public static final double DESCUENTO_TRASLADO = 5;

    private ArrayList<RangoImpuesto> rangos;

    public CalculadorImpuesto(){
        rangos = new ArrayList<>();
        rangos.add(new RangoImpuesto(0, 30000000, 1.5));
        rangos.add(new RangoImpuesto(30000000, 70000000, 2.0));
        rangos.add(new RangoImpuesto(70000000, 200000000, 2.5));
        rangos.add(new RangoImpuesto(200000000, Double.MAX_VALUE, 4.0));
    }

    public void agregarRango(RangoImpuesto r){
        rangos.add(r);
    }

    public void eliminarRango(int indice){
        if(indice >= 0 && indice < rangos.size()){
            rangos.remove(indice);
        }
    }

    public RangoImpuesto buscarRango(double valor){
        for(RangoImpuesto r: rangos){
            if(r.incluye(valor)){
                return r;
            }
        }
        return null;
    }

    public double calcularImpuestoBase(Vehiculo v){
        RangoImpuesto r = buscarRango(v.getPrecio());
        if(r == null){
            return 0;
        }
        return v.getPrecio() * r.getPorcentaje() / 100;
    }

    public double calcularImpuestoFinal(double impuesto, boolean prontoPago, boolean servicioPublico, boolean traslado){
        double total = impuesto;
        if(prontoPago){
            total = total - (total * DESCUENTO_PRONTO_PAGO / 100);
        }
        if(servicioPublico){
            total = total - DESCUENTO_SERVICIO_PUBLICO;
            if(total < 0){
                total = 0;
            }
        }
        if(traslado){
            total = total - (total * DESCUENTO_TRASLADO / 100);
        }
        return total;
    }

    public ArrayList<RangoImpuesto> getRangos(){
        return this.rangos;
    }
}