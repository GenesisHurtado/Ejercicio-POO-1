package Modelo;


/**
 * Write a description of class Voto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Voto
{
    private Cardenal cardenalVotado;
    
    public Voto(){
        
    }
    
    public Voto(Cardenal cardenalVotado){
        this.cardenalVotado=cardenalVotado;
    }

//Start GetterSetterExtension Source Code

    /**GET Method Propertie cardenalVotado*/
    public Cardenal getCardenalVotado(){
        return this.cardenalVotado;
    }//end method getCardenalVotado

    /**SET Method Propertie cardenalVotado*/
    public void setCardenalVotado(Cardenal cardenalVotado){
        this.cardenalVotado = cardenalVotado;
    }//end method setCardenalVotado

//End GetterSetterExtension Source Code

   @Override
    public String toString() {
        return " Cardenal votado : " + cardenalVotado ;
            
    }



}//End class