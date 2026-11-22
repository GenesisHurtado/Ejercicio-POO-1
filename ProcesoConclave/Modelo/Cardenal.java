package Modelo;


/**
 * Write a description of class Cardenal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cardenal
{
     private String pais;
    private String cedula;
    private String nombre;
    private int edad;
    private TipoCardenal tipoCardenal;
    private boolean presente; 
    
    
    public Cardenal(){
        
     }
    
     public Cardenal(String pais, String cedula, String nombre, int edad, TipoCardenal tipoCardenal){
        this.pais = pais;
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.tipoCardenal = tipoCardenal;
        this.presente = true;
    }
   
    //Start GetterSetterExtension Source Code

    /**GET Method Propertie pais*/
    public String getPais(){
        return this.pais;
    }//end method getPais

    /**SET Method Propertie pais*/
    public void setPais(String pais){
        this.pais = pais;
    }//end method setPais

    /**GET Method Propertie cedula*/
    public String getCedula(){
        return this.cedula;
    }//end method getCedula

    /**SET Method Propertie cedula*/
    public void setCedula(String cedula){
        this.cedula = cedula;
    }//end method setCedula

    /**GET Method Propertie nombre*/
    public String getNombre(){
        return this.nombre;
    }//end method getNombre

    /**SET Method Propertie nombre*/
    public void setNombre(String nombre){
        this.nombre = nombre;
    }//end method setNombre

    /**GET Method Propertie edad*/
    public int getEdad(){
        return this.edad;
    }//end method getEdad

    /**SET Method Propertie edad*/
    public void setEdad(int edad){
        this.edad = edad;
    }//end method setEdad

    /**GET Method Propertie tipoCardenal*/
    public TipoCardenal getTipoCardenal(){
        return this.tipoCardenal;
    }//end method getTipoCardenal

    /**SET Method Propertie tipoCardenal*/
    public void setTipoCardenal(TipoCardenal tipoCardenal){
        this.tipoCardenal = tipoCardenal;
    }//end method setTipoCardenal

    /**GET Method Propertie presente*/
    public boolean isPresente(){
        return this.presente;
    }//end method isPresente

    /**SET Method Propertie presente*/
    public void setPresente(boolean presente){
        this.presente = presente;
    }//end method setPresente

   //End GetterSetterExtension Source Code
    // METODOS OPERACIONALES
    
    public boolean esElector(){
        
       if (edad < 80 ){
         return true;  
       }else{
           return false;
       }
       
    }
    
    
   
    public boolean puedeVotar(){
        return esElector() && presente;
    }

    public String enlistar(){
        String r = "Cedula: " + cedula + "\n" +
                   "Nombre: " + nombre + "\n" +
                   "Pais: " + pais + "\n" +
                   "Edad: " + edad + "\n" +
                   "Tipo: " + tipoCardenal + "\n";
        return r;
    }

    @Override
    public String toString() {
        return " Pais: " + pais + " \n" +
               " Cedula: " + cedula + " \n" + 
               " Nombre: " + nombre + " \n" +
               " Edad: " + edad + " \n" +
               "Tipo Cardenal: " + tipoCardenal ;
    }

}//End class