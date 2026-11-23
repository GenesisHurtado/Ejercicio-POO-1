package Modelo;

public abstract class Libro
{
    protected String titulo;
    protected Autor autor;
    protected String issn;
    protected int anioPublicacion;
    protected String editorial;
    protected int copiasTotales;
    protected int copiasDisponibles;

    public Libro(String titulo, Autor autor, String issn, int anioPublicacion, String editorial, int copias){
        this.titulo = titulo;
        this.autor = autor;
        this.issn = issn;
        this.anioPublicacion = anioPublicacion;
        this.editorial = editorial;
        this.copiasTotales = copias;
        this.copiasDisponibles = copias;
    }

    // Presta una copia si hay disponibles
    public boolean prestarCopia(){
        if(copiasDisponibles > 0){
            copiasDisponibles--;
            return true;
        }
        return false;
    }

    public void devolverCopia(){
        if(copiasDisponibles < copiasTotales){
            copiasDisponibles++;
        }
    }

    public abstract String getTipo();

    public String getTitulo(){
        return titulo;
    }

    public Autor getAutor(){
        return autor;
    }

    public String getIssn(){
        return issn;
    }

    public int getAnioPublicacion(){
        return anioPublicacion;
    }

    public String getEditorial(){
        return editorial;
    }

    public int getCopiasTotales(){
        return copiasTotales;
    }

    public int getCopiasDisponibles(){
        return copiasDisponibles;
    }

    public String toString(){
        return titulo + " (" + getTipo() + ")";
    }
}
