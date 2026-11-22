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
    private ArrayList<Cardenal> cardenales;
    private Ronda rondaActual;
    private Cardenal papa;

    public GestorCardenal(){
        cardenales = new ArrayList<>();
        rondaActual = new Ronda(1, "Mañana", 1);
        papa = null;
    }

    // GETTERS PARA LA VISTA
    public ArrayList<Cardenal> getCardenales(){
        return cardenales;
    }

    public Ronda getRondaActual(){
        return rondaActual;
    }

    public Cardenal getPapa(){
        return papa;
    }

    // RF 1: Cardenales, electores y no electores

    public boolean agregarCardenal(Cardenal c){
        for(Cardenal cardenal : cardenales){
            if(cardenal.getCedula().equals(c.getCedula())){
                return false;
            }
        }
        cardenales.add(c);
        return true;
    }

   
    public int contarElectores(){
        int contador = 0;
        for(Cardenal c : cardenales){
            if(c.puedeVotar()){
                contador++;
            }
        }
        return contador;
    }

    public int contarNoElectores(){
        return cardenales.size() - contarElectores();
    }

    public String enlistarElectores(){
        String r = "";
        for(Cardenal c : cardenales){
            if(c.puedeVotar()){
                r += "- " + c + ", " + c.getEdad() + " anios\n";
            }
        }
        return r;
    }

    // RF 2: Votar (el combo box y el boton Votar estan en la vista)

    public boolean votar(Cardenal cardenalVotado){
        if(papa != null || rondaCerrada()){
            return false;
        }
        rondaActual.registrarVoto(cardenalVotado);
        return true;
    }

    public int contarVotos(){
        return rondaActual.cantidadVotos();
    }

    // RF 3: Cierre de ronda, mayoria de 2/3 y eleccion del papa

    public boolean rondaCerrada(){
        return rondaActual.rondaCerrada(contarElectores());
    }

    
    public int calcularMayoria(){
        int electores = contarElectores();
        return (2 * electores + 2) / 3;
    }

   
    public Cardenal verificarPapa(){
        if(!rondaCerrada()){
            return null;
        }
        int mayoria = calcularMayoria();
        for(Cardenal c : cardenales){
            if(rondaActual.contarVotos(c.getCedula()) >= mayoria){
                papa = c;
                return papa;
            }
        }
        return null;
    }

    public String enlistarPapa(){
        if(papa == null){
            return "";
        }
        return "Ronda: " + rondaActual.getNumero() + "\n" +
               "Jornada: " + rondaActual.getJornada() + "\n" +
               "Nombre: " + papa.getNombre() + "\n" +
               "Pais: " + papa.getPais() + "\n" +
               "Edad: " + papa.getEdad();
    }


    public String enlistarResultados(){
        String r = "";
        for(Cardenal c : cardenales){
            int votos = rondaActual.contarVotos(c.getCedula());
            if(votos > 0){
                r += c + ": " + votos + " votos\n";
            }
        }
        return r;
    }

    public String describirRonda(){
        return rondaActual.toString();
    }

    public int numeroRonda(){
        return rondaActual.getNumero();
    }

  
    public boolean siguienteRonda(){
        if(papa != null || !rondaCerrada()){
            return false;
        }
        int numero = rondaActual.getNumero() + 1;
        int dia = (numero - 1) / 4 + 1;
        String jornada;
        if((numero - 1) % 4 < 2){
            jornada = "Mañana";
        }else{
            jornada = "Tarde";
        }
        rondaActual = new Ronda(numero, jornada, dia);
        return true;
    }
    
   } 