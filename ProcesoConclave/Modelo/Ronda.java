package Modelo;
import java.util.ArrayList;


/**
 * Write a description of class Ronda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ronda
{
    private int numero;
    private String jornada;
    private int dia;
    private ArrayList<Voto> votos; 
    
    
    public Ronda(){
        
    }
    
    
      public Ronda(int numero, String jornada, int dia) {
        this.numero = numero;
        this.jornada = jornada;
        this.dia = dia;
        this.votos = new ArrayList <>();
        
    }

   
    

//Start GetterSetterExtension Source Code

    /**GET Method Propertie numero*/
    public int getNumero(){
        return this.numero;
    }//end method getNumero

    /**SET Method Propertie numero*/
    public void setNumero(int numero){
        this.numero = numero;
    }//end method setNumero

    /**GET Method Propertie jornada*/
    public String getJornada(){
        return this.jornada;
    }//end method getJornada

    /**SET Method Propertie jornada*/
    public void setJornada(String jornada){
        this.jornada = jornada;
    }//end method setJornada

    /**GET Method Propertie dia*/
    public int getDia(){
        return this.dia;
    }//end method getDia

    /**SET Method Propertie dia*/
    public void setDia(int dia){
        this.dia = dia;
    }//end method setDia

    /**GET Method Propertie votos*/
    public java.util.ArrayList<Modelo.Voto> getVotos(){
        return this.votos;
    }//end method getVotos

    /**SET Method Propertie votos*/
    public void setVotos(java.util.ArrayList<Modelo.Voto> votos){
        this.votos = votos;
    }//end method setVotos

//End GetterSetterExtension Source Code
      
    //METODOS OPERACIONALES
    public void registrarVoto ( Cardenal cardenalVotado){
     
    Voto v = new Voto(cardenalVotado);
    votos.add(v);
    }

    
     public int contarVotos(String cedula){
        int contador = 0;
        for (Voto v : votos) {
            if (v.getCardenalVotado().getCedula().equals(cedula)) {
                contador++;
            }
        }
        return contador;
    }
    
    public boolean rondaCerrada(int cantidadElectores){
      if(votos.size()==cantidadElectores){
          return true;
      }else{
          return false;
      }
     }
    
    
    
  @Override
    public String toString() {
        return "Ronda  Numero : " + numero + "\n"+
               "Jornada :" + jornada + "\n"+
               "Dia: " + dia + "\n"+
               "Votos : " + votos ;
    }


}//End class