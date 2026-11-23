package Vista;
import Modelo.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class JFBiblioteca extends JFrame
{
    private JLabel lblTitulo, lblUsuario, lblLibro, lblFecha, lblPrestamo;
    private JComboBox<Usuario> cbUsuarios;
    private JComboBox<Libro> cbLibros;
    private JComboBox<Prestamo> cbPrestamos;
    private JTextField txtFecha;
    private JButton btnPrestar, btnDevolver, btnVerLibros, btnVerPrestamos;
    private JScrollPane scrollResultados;
    private JTextArea campoTexto;

    private static final Color FONDO = new Color(217, 213, 245);
    private static final Color COLOR_TEXTO = new Color(40, 35, 90);
    private static final Color COLOR_BORDE = new Color(130, 125, 180);
    private static final Color COLOR_BOTON = new Color(245, 244, 255);
    private static final Font FUENTE_NEGRITA = new Font("Segoe UI", Font.BOLD, 14);
    private static final Font FUENTE_NORMAL = new Font("Segoe UI", Font.PLAIN, 13);

    public JFBiblioteca(){
        setTitle("Biblioteca UFPS");
        setSize(580, 580);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(FONDO);

        lblTitulo = crearEtiqueta("Gestion de Biblioteca", 25, 15, 300, new Font("Segoe UI", Font.BOLD, 17));

        lblUsuario = crearEtiqueta("Usuario", 30, 60, 90, FUENTE_NEGRITA);
        cbUsuarios = new JComboBox<>();
        cbUsuarios.setFont(FUENTE_NORMAL);
        cbUsuarios.setBackground(Color.WHITE);
        cbUsuarios.setBounds(130, 60, 410, 28);
        add(cbUsuarios);

        lblLibro = crearEtiqueta("Libro", 30, 100, 90, FUENTE_NEGRITA);
        cbLibros = new JComboBox<>();
        cbLibros.setFont(FUENTE_NORMAL);
        cbLibros.setBackground(Color.WHITE);
        cbLibros.setBounds(130, 100, 410, 28);
        add(cbLibros);

        lblFecha = crearEtiqueta("Fecha", 30, 140, 90, FUENTE_NEGRITA);
        txtFecha = new JTextField();
        txtFecha.setFont(FUENTE_NORMAL);
        txtFecha.setHorizontalAlignment(JTextField.CENTER);
        txtFecha.setBorder(BorderFactory.createLineBorder(COLOR_BORDE));
        txtFecha.setBounds(130, 140, 120, 28);
        add(txtFecha);

        btnPrestar = crearBoton("Prestar", true);
        btnPrestar.setBounds(280, 138, 110, 32);
        add(btnPrestar);

        lblPrestamo = crearEtiqueta("Prestamo", 30, 185, 90, FUENTE_NEGRITA);
        cbPrestamos = new JComboBox<>();
        cbPrestamos.setFont(FUENTE_NORMAL);
        cbPrestamos.setBackground(Color.WHITE);
        cbPrestamos.setBounds(130, 185, 410, 28);
        add(cbPrestamos);

        btnDevolver = crearBoton("Devolver", true);
        btnDevolver.setBounds(130, 228, 110, 32);
        add(btnDevolver);

        btnVerLibros = crearBoton("Ver libros", false);
        btnVerLibros.setBounds(280, 228, 120, 32);
        add(btnVerLibros);

        btnVerPrestamos = crearBoton("Ver prestamos", false);
        btnVerPrestamos.setBounds(415, 228, 125, 32);
        add(btnVerPrestamos);

        campoTexto = new JTextArea();
        campoTexto.setFont(new Font("Monospaced", Font.PLAIN, 12));
        campoTexto.setEditable(false);
        campoTexto.setLineWrap(true);
        campoTexto.setWrapStyleWord(true);
        campoTexto.setMargin(new Insets(4, 6, 4, 6));

        scrollResultados = new JScrollPane(campoTexto);
        scrollResultados.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(COLOR_BORDE), "Resultados",
                TitledBorder.LEFT, TitledBorder.TOP, FUENTE_NORMAL, COLOR_TEXTO));
        scrollResultados.setOpaque(false);
        scrollResultados.getViewport().setOpaque(false);
        scrollResultados.setBounds(25, 280, 520, 255);
        add(scrollResultados);
    }

    private JLabel crearEtiqueta(String texto, int x, int y, int ancho, Font fuente){
        JLabel l = new JLabel(texto);
        l.setFont(fuente);
        l.setForeground(COLOR_TEXTO);
        l.setBounds(x, y, ancho, 28);
        add(l);
        return l;
    }

    private JButton crearBoton(String texto, boolean destacado){
        JButton b = new JButton(texto);
        b.setFont(destacado ? FUENTE_NEGRITA : FUENTE_NORMAL);
        b.setForeground(COLOR_TEXTO);
        b.setBackground(COLOR_BOTON);
        b.setFocusPainted(false);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLOR_BORDE),
                BorderFactory.createEmptyBorder(4, 12, 4, 12)));
        return b;
    }

    public JLabel getLblTitulo(){ return lblTitulo; }
    public JLabel getLblUsuario(){ return lblUsuario; }
    public JLabel getLblLibro(){ return lblLibro; }
    public JLabel getLblFecha(){ return lblFecha; }
    public JLabel getLblPrestamo(){ return lblPrestamo; }
    public JComboBox<Usuario> getCbUsuarios(){ return cbUsuarios; }
    public JComboBox<Libro> getCbLibros(){ return cbLibros; }
    public JComboBox<Prestamo> getCbPrestamos(){ return cbPrestamos; }
    public JTextField getTxtFecha(){ return txtFecha; }
    public JButton getBtnPrestar(){ return btnPrestar; }
    public JButton getBtnDevolver(){ return btnDevolver; }
    public JButton getBtnVerLibros(){ return btnVerLibros; }
    public JButton getBtnVerPrestamos(){ return btnVerPrestamos; }
    public JScrollPane getScrollResultados(){ return scrollResultados; }
    public JTextArea getCampoTexto(){ return campoTexto; }
}
