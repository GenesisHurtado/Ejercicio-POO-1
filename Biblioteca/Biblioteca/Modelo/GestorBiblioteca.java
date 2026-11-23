package Modelo;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestorBiblioteca
{
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Prestamo> prestamos;

    public GestorBiblioteca(){
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    // GETTERS PARA LA VISTA
    public ArrayList<Libro> getLibros(){
        return libros;
    }

    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }

    public ArrayList<Prestamo> getPrestamos(){
        return prestamos;
    }

    // REGISTRO

    public boolean agregarLibro(Libro l){
        for(Libro libro : libros){
            if(libro.getIssn().equals(l.getIssn())){
                return false;
            }
        }
        libros.add(l);
        return true;
    }

    public boolean agregarUsuario(Usuario u){
        for(Usuario usuario : usuarios){
            if(usuario.getCodigo().equals(u.getCodigo())){
                return false;
            }
        }
        usuarios.add(u);
        return true;
    }

    // PRESTAMOS

    // Un usuario puede tener varios prestamos y un libro prestarse a varios usuarios,
    // pero no el mismo libro dos veces a la vez al mismo usuario
    public boolean tieneLibroPrestado(Usuario u, Libro l){
        for(Prestamo p : prestamos){
            if(p.getUsuario() == u && p.getLibro() == l && p.estaActivo()){
                return true;
            }
        }
        return false;
    }

    public Prestamo prestar(Usuario u, Libro l, LocalDate fecha){
        if(tieneLibroPrestado(u, l) || !l.prestarCopia()){
            return null;
        }
        Prestamo p = new Prestamo(u, l, fecha);
        prestamos.add(p);
        return p;
    }

    public boolean devolver(Prestamo p, LocalDate fecha){
        return p.devolver(fecha);
    }

    public void actualizarEstados(LocalDate hoy){
        for(Prestamo p : prestamos){
            p.actualizarEstado(hoy);
        }
    }

    public int contarPrestamosActivos(){
        int contador = 0;
        for(Prestamo p : prestamos){
            if(p.estaActivo()){
                contador++;
            }
        }
        return contador;
    }

    // CONSULTAS

    public String describirLibros(){
        String texto = "Libros (" + libros.size() + "):";
        for(Libro l : libros){
            texto += "\n - [" + l.getTipo() + "] " + l.getTitulo() + " | " + l.getAutor() +
                " | ISSN " + l.getIssn() + " | " + l.getAnioPublicacion() + " | " + l.getEditorial() +
                "\n     Copias disponibles: " + l.getCopiasDisponibles() + " de " + l.getCopiasTotales();
        }
        return texto;
    }

    public String describirPrestamos(){
        if(prestamos.isEmpty()){
            return "No hay prestamos registrados";
        }
        String texto = "Prestamos (" + prestamos.size() + "):";
        for(Prestamo p : prestamos){
            texto += "\n - " + p.getUsuario().getNombre() + " (" + p.getUsuario().getTipo() + ", plazo " +
                p.getUsuario().getPlazoMaximo() + " dias) | " + p.getLibro().getTitulo() +
                "\n     Prestado: " + p.getFechaPrestamo() + " | Limite: " + p.getFechaLimite() +
                " | Devuelto: " + (p.getFechaDevolucion() == null ? "pendiente" : p.getFechaDevolucion().toString()) +
                " | Estado: " + p.getEstado();
        }
        return texto;
    }
}
