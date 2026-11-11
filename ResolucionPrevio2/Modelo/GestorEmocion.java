package Modelo;
import java.util.ArrayList;


/**
 * Write a description of class GestorEmocion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GestorEmocion
{

    private ArrayList <Emocion> lista;
    private ArrayList <Recuerdo> recuerdos;
    private ArrayList <Evento> eventos;
    
    
    
    public GestorEmocion(){
        lista = new ArrayList <>();
        recuerdos = new ArrayList <>();
        eventos = new ArrayList <>();
        
    }
    
    
    public boolean agregarEmocion (Emocion e ){
        
        String nombre = e.getNombre();
        
        for (Emocion emocion : lista ){
            if( emocion.getNombre().equals(nombre)){
                return false;
            }
        }
        lista.add(e);
        return true;
    }
    
    public String enListarEmociones (){
        
        String r = " ";
        for(Emocion emocion :lista ){
            r+=emocion.toString();
        }
        return r;
    }
    
    public boolean agregarRecuerdo(Recuerdo e ){
        String nombre = e.getDescripcion();
        
        for ( Recuerdo recuerdo : recuerdos ){
            if (recuerdo.getDescripcion().equals(nombre)){
                return false;
            }
        }
        
        recuerdos.add(e);
        
        
    }
}