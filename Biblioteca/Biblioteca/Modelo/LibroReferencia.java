package Modelo;

public class LibroReferencia extends Libro
{
    // Un libro de referencia solo tiene dos copias
    public LibroReferencia(String titulo, Autor autor, String issn, int anioPublicacion, String editorial){
        super(titulo, autor, issn, anioPublicacion, editorial, 2);
    }

    public String getTipo(){
        return "Referencia";
    }
}
