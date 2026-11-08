package Modelo;
import java.util.ArrayList;


/**
 * Write a description of class GestorCardenal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GestorCardenal
{
     private ArrayList <Cardenal> cardenales;
     private Ronda rondaActual;
     private Cardenal papa ;
    
    
     
     public GestorCardenal() {
    this.cardenales = new ArrayList<>();
    this.rondaActual = new Ronda(1, "Mañana", 1);
    this.papa = null;
   }
   
   
   // RF 1 Electores
   
   public void agregarCardenal(Cardenal cardenal) {
    cardenales.add(cardenal);
  }
  
  public int contarElectores() {
    int contador = 0;
    for (Cardenal c : cardenales) {
        if(c.esElector()){
            contador++;
        }
    }
    return contador;
  }
  
    public ArrayList<Cardenal> listarElectores() {
    ArrayList<Cardenal> electores = new ArrayList<>();
    for (Cardenal c : cardenales) {
        if(c.esElector()){
         electores.add(c);   
        }
    }
    return electores;
  }
  
  // RF  Votar
  
  
} 