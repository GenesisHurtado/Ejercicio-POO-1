package Modelo;
import java.time.LocalDate;

public class Prestamo
{
    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;   // null mientras no se haya devuelto el libro
    private EstadoPrestamo estado;

    public Prestamo(Usuario usuario, Libro libro, LocalDate fechaPrestamo){
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.estado = EstadoPrestamo.PRESTADO;
    }

    // Fecha limite segun el plazo del tipo de usuario
    public LocalDate getFechaLimite(){
        return fechaPrestamo.plusDays(usuario.getPlazoMaximo());
    }

    public boolean estaActivo(){
        return fechaDevolucion == null;
    }

    // Se multa el prestamo cuando pasa el tiempo limite de devolucion
    public void actualizarEstado(LocalDate hoy){
        if(estaActivo() && hoy.isAfter(getFechaLimite())){
            estado = EstadoPrestamo.MULTADO;
        }
    }

    public boolean devolver(LocalDate fecha){
        if(!estaActivo() || fecha.isBefore(fechaPrestamo)){
            return false;
        }
        fechaDevolucion = fecha;
        libro.devolverCopia();
        estado = fecha.isAfter(getFechaLimite()) ? EstadoPrestamo.MULTADO : EstadoPrestamo.DEVUELTO;
        return true;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public Libro getLibro(){
        return libro;
    }

    public LocalDate getFechaPrestamo(){
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion(){
        return fechaDevolucion;
    }

    public EstadoPrestamo getEstado(){
        return estado;
    }

    public String toString(){
        return usuario.getNombre() + " - " + libro.getTitulo() + " [" + estado + "]";
    }
}
