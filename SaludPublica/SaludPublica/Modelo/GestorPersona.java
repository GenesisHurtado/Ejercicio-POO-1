package Modelo;
import java.util.ArrayList;

public class GestorPersona
{
    private ArrayList<Persona> personas;

    public GestorPersona(){
        personas = new ArrayList<>();
    }

    public ArrayList<Persona> getPersonas(){
        return personas;
    }

    // Guardar: polimorfismo, el ArrayList es de la clase padre
    public boolean agregarPersona(Persona p){
        if(buscarPersona(p.getNumDocumento()) != null){
            return false;
        }
        personas.add(p);
        return true;
    }

    // Buscar por documento
    public Persona buscarPersona(String documento){
        for(Persona p : personas){
            if(p.getNumDocumento().equals(documento)){
                return p;
            }
        }
        return null;
    }

    public int contarPersonas(){
        return personas.size();
    }

    // Validacion de la distribucion del bono segun su clasificacion
    public boolean distribucionValida(Persona p){
        return p.distribucionValida();
    }
}
