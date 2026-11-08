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
  
    // RF 2: Votar (el combo box y el botón Votar están en la vista)

    public boolean votar(Cardenal cardenalVotado) {
        if (papa != null || rondaCerrada()) {
            return false;
        }
        rondaActual.registrarVoto(cardenalVotado);
        return true;
    }

    // RF 3: Cierre de ronda, mayoría de 2/3 y elección del papa

    public boolean rondaCerrada() {
        return rondaActual.rondaCerrada(contarElectores());
    }

    public int calcularMayoria() {
        int electores = contarElectores();
        return (2 * electores + 2) / 3;
    }

    public Cardenal verificarPapa() {
        if (!rondaCerrada()) {
            return null;
        }
        int mayoria = calcularMayoria();
        for (Cardenal c : cardenales) {
            if (rondaActual.contarVotos(c.getCedula()) >= mayoria) {
                papa = c;
                return papa;
            }
        }
        return null;
    }

    // RF 3: Siguiente ronda (2 rondas en la mañana y 2 en la tarde, 4 por día)

    public boolean siguienteRonda() {
        if (papa != null || !rondaCerrada()) {
            return false;
        }
        int numero = rondaActual.getNumero() + 1;
        int dia = (numero - 1) / 4 + 1;
        String jornada;
        if ((numero - 1) % 4 < 2) {
            jornada = "Mañana";
        } else {
            jornada = "Tarde";
        }
        rondaActual = new Ronda(numero, jornada, dia);
        return true;
    }
   
    // METODOS PARA LA VISTA 
     public ArrayList<Cardenal> getCardenales() {
        return cardenales;
    }

    public Ronda getRondaActual() {
        return rondaActual;
    }

    public Cardenal getPapa() {
        return papa;
    }
  
} 