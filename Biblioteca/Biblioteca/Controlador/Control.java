package Controlador;
import Modelo.*;
import Vista.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Control
{
    private JFBiblioteca vistaGestor;
    private GestorBiblioteca modeloGestor;

    public Control(GestorBiblioteca modeloGestor, JFBiblioteca vistaGestor){
        this.vistaGestor = vistaGestor;
        this.modeloGestor = modeloGestor;

        // Libros: de referencia (2 copias) y de coleccion general
        agregar(new LibroReferencia("Enciclopedia de Ciencias", new Autor("Carlos Mendez"), "1111-0001", 2015, "Editorial Norte"));
        agregar(new LibroReferencia("Diccionario Juridico", new Autor("Laura Prieto"), "1111-0002", 2018, "Editorial Sur"));
        agregar(new LibroGeneral("Programacion Orientada a Objetos", new Autor("Ana Duarte"), "2222-0001", 2020, "Editorial Andina", 3));
        agregar(new LibroGeneral("Estructuras de Datos", new Autor("Jorge Salazar"), "2222-0002", 2019, "Editorial Andina", 4));
        agregar(new LibroGeneral("Calculo Diferencial", new Autor("Marta Rojas"), "2222-0003", 2017, "Editorial Central", 2));

        // Usuarios: estudiantes y profesores (15 dias), administrativos (3 dias)
        agregar(new Estudiante("E1001", "Laura Perez"));
        agregar(new Estudiante("E1002", "Juan Lopez"));
        agregar(new Profesor("P2001", "Carlos Ruiz"));
        agregar(new Administrativo("A3001", "Marta Gil"));

        vistaGestor.getTxtFecha().setText(LocalDate.now().toString());
        vistaGestor.getCampoTexto().setText("Libros: " + modeloGestor.getLibros().size() +
            " | Usuarios: " + modeloGestor.getUsuarios().size() +
            "\nSeleccione usuario y libro, indique la fecha (aaaa-mm-dd) y presione Prestar." +
            "\nPara devolver, seleccione el prestamo y presione Devolver.");

        // Prestar un libro
        vistaGestor.getBtnPrestar().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Usuario u = (Usuario) vistaGestor.getCbUsuarios().getSelectedItem();
                Libro l = (Libro) vistaGestor.getCbLibros().getSelectedItem();
                LocalDate fecha = leerFecha();
                if(u == null || l == null){
                    vistaGestor.getCampoTexto().setText("Seleccione un usuario y un libro");
                    return;
                }
                if(fecha == null){
                    return;
                }
                if(modeloGestor.tieneLibroPrestado(u, l)){
                    vistaGestor.getCampoTexto().setText(u.getNombre() + " ya tiene prestado ese libro");
                    return;
                }
                Prestamo p = modeloGestor.prestar(u, l, fecha);
                if(p == null){
                    vistaGestor.getCampoTexto().setText("No hay copias disponibles de " + l.getTitulo());
                    return;
                }
                vistaGestor.getCbPrestamos().addItem(p);
                vistaGestor.getCampoTexto().setText("Prestamo registrado" +
                    "\nUsuario: " + u.getNombre() + " (" + u.getTipo() + ")" +
                    "\nLibro: " + l.getTitulo() +
                    "\nFecha de prestamo: " + p.getFechaPrestamo() +
                    "\nFecha limite: " + p.getFechaLimite() + " (" + u.getPlazoMaximo() + " dias)" +
                    "\nCopias disponibles: " + l.getCopiasDisponibles() + " de " + l.getCopiasTotales());
            }
        });

        // Devolver un libro
        vistaGestor.getBtnDevolver().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Prestamo p = (Prestamo) vistaGestor.getCbPrestamos().getSelectedItem();
                LocalDate fecha = leerFecha();
                if(p == null){
                    vistaGestor.getCampoTexto().setText("Seleccione un prestamo");
                    return;
                }
                if(fecha == null){
                    return;
                }
                if(!modeloGestor.devolver(p, fecha)){
                    vistaGestor.getCampoTexto().setText("La fecha de devolucion no puede ser anterior a la del prestamo (" +
                        p.getFechaPrestamo() + ")");
                    return;
                }
                vistaGestor.getCbPrestamos().removeItem(p);
                String resultado = "Libro devuelto: " + p.getLibro().getTitulo() +
                    "\nFecha limite: " + p.getFechaLimite() +
                    "\nFecha de devolucion: " + p.getFechaDevolucion() +
                    "\nEstado del prestamo: " + p.getEstado();
                if(p.getEstado() == EstadoPrestamo.MULTADO){
                    resultado += "\nSe devolvio despues del plazo, el prestamo queda multado";
                }
                vistaGestor.getCampoTexto().setText(resultado);
            }
        });

        // Ver libros y su disponibilidad
        vistaGestor.getBtnVerLibros().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                vistaGestor.getCampoTexto().setText(modeloGestor.describirLibros());
                vistaGestor.getCampoTexto().setCaretPosition(0);
            }
        });

        // Ver prestamos (se multan los que pasaron el limite a la fecha indicada)
        vistaGestor.getBtnVerPrestamos().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                LocalDate fecha = leerFecha();
                if(fecha == null){
                    return;
                }
                modeloGestor.actualizarEstados(fecha);
                vistaGestor.getCbPrestamos().repaint();
                vistaGestor.getCampoTexto().setText(modeloGestor.describirPrestamos());
                vistaGestor.getCampoTexto().setCaretPosition(0);
            }
        });
    }

    // Lee la fecha del campo; si no es valida muestra el mensaje y devuelve null
    private LocalDate leerFecha(){
        try{
            return LocalDate.parse(vistaGestor.getTxtFecha().getText().trim());
        }catch(DateTimeParseException ex){
            vistaGestor.getCampoTexto().setText("Fecha no valida, use el formato aaaa-mm-dd");
            return null;
        }
    }

    private void agregar(Libro l){
        if(modeloGestor.agregarLibro(l)){
            vistaGestor.getCbLibros().addItem(l);
        }
    }

    private void agregar(Usuario u){
        if(modeloGestor.agregarUsuario(u)){
            vistaGestor.getCbUsuarios().addItem(u);
        }
    }
}
