package Modelo;

import java.util.ArrayList;

public class GestorVehiculo
{
    private ArrayList<Vehiculo> vehiculos;
    private int posicion;

    public GestorVehiculo(){
        vehiculos = new ArrayList<Vehiculo>();
        posicion = 0;

        vehiculos.add(new Vehiculo("Ford", "Taurus", 2016, 136340000, "ford_taurus.png"));
        vehiculos.add(new Vehiculo("Mazda", "3", 2018, 62500000, "mazda_3.png"));
        vehiculos.add(new Vehiculo("Chevrolet", "Spark", 2017, 28000000, "chevrolet_spark.png"));
        vehiculos.add(new Vehiculo("Renault", "Logan", 2015, 35900000, "renault_logan.png"));
        vehiculos.add(new Vehiculo("Audi", "A4", 2020, 215000000, "audi_a4.png"));
        vehiculos.add(new Vehiculo("Toyota", "Prado", 2019, 189000000, "toyota_prado.png"));
    }

    public void agregarVehiculo(Vehiculo v){
        vehiculos.add(v);
    }

    public Vehiculo getVehiculoActual(){
        if (vehiculos.isEmpty()){
            return null;
        }
        return vehiculos.get(posicion);
    }

    public Vehiculo primero(){
        posicion = 0;
        return getVehiculoActual();
    }

    public Vehiculo anterior(){
        if (posicion > 0){
            posicion--;
        }
        return getVehiculoActual();
    }

    public Vehiculo siguiente(){
        if (posicion < vehiculos.size() - 1){
            posicion++;
        }
        return getVehiculoActual();
    }

    public Vehiculo ultimo(){
        posicion = vehiculos.size() - 1;
        return getVehiculoActual();
    }

    public Vehiculo buscarPorLinea(String linea){
        for (int i = 0; i < vehiculos.size(); i++){
            if (vehiculos.get(i).getLinea().equalsIgnoreCase(linea)){
                posicion = i;
                return vehiculos.get(i);
            }
        }
        return null;
    }

    public Vehiculo buscarPorMarca(String marca){
        for (int i = 0; i < vehiculos.size(); i++){
            if (vehiculos.get(i).getMarca().equalsIgnoreCase(marca)){
                posicion = i;
                return vehiculos.get(i);
            }
        }
        return null;
    }

    public Vehiculo buscarMasCaro(){
        if (vehiculos.isEmpty()){
            return null;
        }
        int mayor = 0;
        for (int i = 1; i < vehiculos.size(); i++){
            if (vehiculos.get(i).getPrecio() > vehiculos.get(mayor).getPrecio()){
                mayor = i;
            }
        }
        posicion = mayor;
        return vehiculos.get(mayor);
    }

    public int cantidadVehiculos(){
        return vehiculos.size();
    }

    public ArrayList<Vehiculo> getVehiculos(){
        return vehiculos;
    }
}
