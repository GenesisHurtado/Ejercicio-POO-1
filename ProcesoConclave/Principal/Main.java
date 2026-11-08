package Principal;
import Modelo.*;
import Vista.JFGestorCardenales;

/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main{
    
     public static void main(String[] args) {
        GestorCardenal gestor = new GestorCardenal();
        cargarDatosPrueba(gestor);

        new JFGestorCardenales(gestor);
    }

    /** Subconjunto reducido para validar: 9 electores (<80 anios) y 3 no electores. */
    private static void cargarDatosPrueba(GestorCardenal g) {
        g.agregarCardenal(new Cardenal("Italia",     "1001", "Pietro Parolin",   70, TipoCardenal.OBISPO));
        g.agregarCardenal(new Cardenal("Filipinas",  "1002", "Luis Tagle",       68, TipoCardenal.OBISPO));
        g.agregarCardenal(new Cardenal("Hungria",    "1003", "Peter Erdo",       73, TipoCardenal.PRESBITERO));
        g.agregarCardenal(new Cardenal("Ghana",      "1004", "Peter Turkson",    76, TipoCardenal.OBISPO));
        g.agregarCardenal(new Cardenal("Colombia",   "1005", "Cardenal Colombia",65, TipoCardenal.PRESBITERO));
        g.agregarCardenal(new Cardenal("Brasil",     "1006", "Cardenal Brasil",  60, TipoCardenal.DIACONO));
        g.agregarCardenal(new Cardenal("Espana",     "1007", "Cardenal Espana",  72, TipoCardenal.OBISPO));
        g.agregarCardenal(new Cardenal("Francia",    "1008", "Cardenal Francia", 58, TipoCardenal.PRESBITERO));
        g.agregarCardenal(new Cardenal("Mexico",     "1009", "Cardenal Mexico",  66, TipoCardenal.DIACONO));
        g.agregarCardenal(new Cardenal("Portugal",   "1010", "Cardenal Portugal",85, TipoCardenal.OBISPO));
        g.agregarCardenal(new Cardenal("Alemania",   "1011", "Cardenal Alemania",82, TipoCardenal.PRESBITERO));
        g.agregarCardenal(new Cardenal("Polonia",    "1012", "Cardenal Polonia", 90, TipoCardenal.DIACONO));
    }
}