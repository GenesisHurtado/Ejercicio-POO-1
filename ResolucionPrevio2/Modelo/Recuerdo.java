package Modelo;


/**
 * Write a description of class Recuerdo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recuerdo
{
    
    private Emocion emocion ;
    private String descripcion;
    private String fecha;
    private Evento evento;
    
    public Recuerdo (Emocion emocion , String descripcion , String fecha , Evento evento ){
        this.emocion=emocion;
        this.descripcion=descripcion;
        this.fecha=fecha;
        this.evento=evento;
    }
    
    /*public String enListar (){
        String r = "Descripcion : " + descripcion + "\n" +
                   "Fecha : " + fecha + "\n"+
                // "Evento : " +evento.getNombre()+ "\n\n";
                
        return String;
        
    }*/

//Start GetterSetterExtension Source Code

    /**GET Method Propertie emocion*/
    public Emocion getEmocion(){
        return this.emocion;
    }//end method getEmocion

    /**SET Method Propertie emocion*/
    public void setEmocion(Emocion emocion){
        this.emocion = emocion;
    }//end method setEmocion

    /**GET Method Propertie descripcion*/
    public String getDescripcion(){
        return this.descripcion;
    }//end method getDescripcion

    /**SET Method Propertie descripcion*/
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }//end method setDescripcion

    /**GET Method Propertie fecha*/
    public String getFecha(){
        return this.fecha;
    }//end method getFecha

    /**SET Method Propertie fecha*/
    public void setFecha(String fecha){
        this.fecha = fecha;
    }//end method setFecha

    /**GET Method Propertie evento*/
    public Evento getEvento(){
        return this.evento;
    }//end method getEvento

    /**SET Method Propertie evento*/
    public void setEvento(Evento evento){
        this.evento = evento;
    }//end method setEvento

//End GetterSetterExtension Source Code


}//End class