package modelo;
import java.util.ArrayList;

public class GestorRiesgos
{
    private ArrayList<Riesgo> riesgos;

    public GestorRiesgos(){
        riesgos = new ArrayList<>();
    }

    // Agrega el riesgo. Devuelve false si ya existe uno con el mismo codigo
    public boolean agregarRiesgo(Riesgo riesgo){
        if(buscarRiesgo(riesgo.getCodigo()) != null){
            return false;
        }
        riesgos.add(riesgo);
        return true;
    }

    // Devuelve el riesgo con ese codigo o null si no existe
    public Riesgo buscarRiesgo(String codigo){
        for(Riesgo r : riesgos){
            if(r.getCodigo().equalsIgnoreCase(codigo)){
                return r;
            }
        }
        return null;
    }

    // Elimina el riesgo con ese codigo. Devuelve false si no existe
    public boolean eliminarRiesgo(String codigo){
        Riesgo r = buscarRiesgo(codigo);
        if(r == null){
            return false;
        }
        riesgos.remove(r);
        return true;
    }

    // Lista de todos los riesgos registrados
    public ArrayList<Riesgo> listarRiesgos(){
        return new ArrayList<>(riesgos);
    }

    public int contarRiesgos(){
        return riesgos.size();
    }
}
