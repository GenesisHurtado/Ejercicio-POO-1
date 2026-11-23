package Modelo;

public class LibroGeneral extends Libro
{
    // Un libro de coleccion general tiene varias copias
    public LibroGeneral(String titulo, Autor autor, String issn, int anioPublicacion, String editorial, int copias){
        super(titulo, autor, issn, anioPublicacion, editorial, copias);
        if(copias < 1){
            throw new IllegalArgumentException("Debe haber al menos una copia");
        }
    }

    public String getTipo(){
        return "Coleccion general";
    }
}
