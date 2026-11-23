package vista;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class JFVecindad extends JFrame
{
    private JList<String> listaPersonajes;
    private DefaultListModel<String> modeloPersonajes;
    private JList<String> listaObjetos;
    private DefaultListModel<String> modeloObjetos;

    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtPersonalidad;
    private JTextField txtRol;

    private JTextField txtMensaje;
    private JComboBox<String> cmbDireccion;
    private JComboBox<String> cmbOtroPersonaje;

    private JButton btnHablar;
    private JButton btnMover;
    private JButton btnAccionEspecial;
    private JButton btnInteractuar;
    private JButton btnUsarObjeto;
    private JButton btnLimpiar;
    private JButton btnSalir;

    private JTextArea areaRegistro;
    private JLabel lblMensaje;

    private static final Color ROJO_TITULO = new Color(160, 48, 30);
    private static final Color VERDE_SECCION = new Color(46, 100, 60);
    private static final Color COLOR_BORDE = new Color(200, 204, 212);
    private static final Font FUENTE_NORMAL = new Font("Segoe UI", Font.PLAIN, 13);
    private static final Font FUENTE_NEGRITA = new Font("Segoe UI", Font.BOLD, 13);

    public JFVecindad(){
        setTitle("La Vecindad del Chavo del 8");
        setSize(980, 780);
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));
        crearTitulo();
        crearPanelCentral();
        crearPanelInferior();
    }

    // TITULO
    private void crearTitulo(){
        JLabel lblTitulo = new JLabel("LA VECINDAD DEL CHAVO DEL 8", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblTitulo.setForeground(ROJO_TITULO);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(12, 10, 4, 10));
        add(lblTitulo, BorderLayout.NORTH);
    }

    // PANEL CENTRAL: listas a la izquierda, acciones y registro a la derecha
    private void crearPanelCentral(){
        JPanel panelCentral = new JPanel(new BorderLayout(12, 0));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        panelCentral.add(crearPanelListas(), BorderLayout.WEST);

        JPanel derecha = new JPanel(new BorderLayout(0, 10));
        JPanel arriba = new JPanel();
        arriba.setLayout(new BoxLayout(arriba, BoxLayout.Y_AXIS));
        arriba.add(crearPanelDatos());
        arriba.add(Box.createVerticalStrut(10));
        arriba.add(crearPanelAcciones());
        derecha.add(arriba, BorderLayout.NORTH);
        derecha.add(crearPanelRegistro(), BorderLayout.CENTER);

        panelCentral.add(derecha, BorderLayout.CENTER);
        add(panelCentral, BorderLayout.CENTER);
    }

    // LISTAS DE PERSONAJES Y OBJETOS
    private JPanel crearPanelListas(){
        JPanel panel = new JPanel(new GridLayout(2, 1, 0, 10));
        panel.setPreferredSize(new Dimension(230, 100));

        modeloPersonajes = new DefaultListModel<>();
        listaPersonajes = crearLista(modeloPersonajes);
        panel.add(envolverLista(listaPersonajes, "Personajes"));

        modeloObjetos = new DefaultListModel<>();
        listaObjetos = crearLista(modeloObjetos);
        panel.add(envolverLista(listaObjetos, "Objetos de la vecindad"));
        return panel;
    }

    private JList<String> crearLista(DefaultListModel<String> modelo){
        JList<String> lista = new JList<>(modelo);
        lista.setFont(FUENTE_NORMAL);
        lista.setFixedCellHeight(26);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return lista;
    }

    private JPanel envolverLista(JList<String> lista, String titulo){
        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(BorderFactory.createCompoundBorder(
                crearBorde(titulo), BorderFactory.createEmptyBorder(0, 8, 8, 8)));
        JScrollPane scroll = new JScrollPane(lista);
        scroll.setBorder(BorderFactory.createLineBorder(COLOR_BORDE));
        p.add(scroll, BorderLayout.CENTER);
        return p;
    }

    // DATOS DEL PERSONAJE SELECCIONADO
    private JPanel crearPanelDatos(){
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createCompoundBorder(
                crearBorde("Personaje seleccionado"), BorderFactory.createEmptyBorder(2, 6, 8, 6)));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 6, 4, 6);
        gbc.anchor = GridBagConstraints.WEST;

        txtNombre = crearCampoLectura();
        txtEdad = crearCampoLectura();
        txtPersonalidad = crearCampoLectura();
        txtRol = crearCampoLectura();

        agregarFila(panel, gbc, 0, "Nombre:", txtNombre);
        agregarFila(panel, gbc, 1, "Edad:", txtEdad);
        agregarFila(panel, gbc, 2, "Personalidad:", txtPersonalidad);
        agregarFila(panel, gbc, 3, "Rol:", txtRol);
        return panel;
    }

    // ACCIONES DEL PERSONAJE
    private JPanel crearPanelAcciones(){
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createCompoundBorder(
                crearBorde("Acciones"), BorderFactory.createEmptyBorder(2, 6, 8, 6)));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 6, 4, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Hablar
        txtMensaje = new JTextField(15);
        txtMensaje.setFont(FUENTE_NORMAL);
        btnHablar = crearBoton("Hablar");
        agregarAccion(panel, gbc, 0, "Mensaje:", txtMensaje, btnHablar);

        // Mover
        cmbDireccion = new JComboBox<>(new String[]{"el norte", "el sur", "el este", "el oeste", "el patio", "el barril"});
        cmbDireccion.setFont(FUENTE_NORMAL);
        btnMover = crearBoton("Mover");
        agregarAccion(panel, gbc, 1, "Dirección:", cmbDireccion, btnMover);

        // Interactuar con otro personaje
        cmbOtroPersonaje = new JComboBox<>();
        cmbOtroPersonaje.setFont(FUENTE_NORMAL);
        btnInteractuar = crearBoton("Interactuar");
        agregarAccion(panel, gbc, 2, "Con personaje:", cmbOtroPersonaje, btnInteractuar);

        // Acciones sin campo: accion especial y usar objeto
        btnAccionEspecial = crearBoton("Acción especial");
        btnUsarObjeto = crearBoton("Usar objeto seleccionado");
        JPanel botones = new JPanel(new GridLayout(1, 2, 12, 0));
        botones.add(btnAccionEspecial);
        botones.add(btnUsarObjeto);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        panel.add(botones, gbc);
        return panel;
    }

    private void agregarAccion(JPanel panel, GridBagConstraints gbc, int fila, String texto, JComponent campo, JButton boton){
        gbc.gridwidth = 1;
        gbc.gridy = fila;
        gbc.gridx = 0;
        gbc.weightx = 0;
        panel.add(crearEtiqueta(texto), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        panel.add(campo, gbc);
        gbc.gridx = 2;
        gbc.weightx = 0;
        boton.setPreferredSize(new Dimension(150, 34));
        panel.add(boton, gbc);
    }

    private void agregarFila(JPanel panel, GridBagConstraints gbc, int fila, String texto, JComponent campo){
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(crearEtiqueta(texto), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(campo, gbc);
    }

    // REGISTRO DE LO QUE VA PASANDO
    private JPanel crearPanelRegistro(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createCompoundBorder(
                crearBorde("Lo que pasa en la vecindad"), BorderFactory.createEmptyBorder(0, 8, 8, 8)));

        areaRegistro = new JTextArea();
        areaRegistro.setEditable(false);
        areaRegistro.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        areaRegistro.setMargin(new Insets(8, 10, 8, 10));
        areaRegistro.setLineWrap(true);
        areaRegistro.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(areaRegistro);
        scroll.setBorder(BorderFactory.createLineBorder(COLOR_BORDE));
        panel.add(scroll, BorderLayout.CENTER);
        return panel;
    }

    // PANEL INFERIOR
    private void crearPanelInferior(){
        JPanel panelInferior = new JPanel(new BorderLayout(0, 10));
        panelInferior.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 20, 12, 20),
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(COLOR_BORDE),
                        BorderFactory.createEmptyBorder(10, 12, 10, 12))));

        lblMensaje = new JLabel(" ");
        lblMensaje.setFont(FUENTE_NORMAL);
        panelInferior.add(lblMensaje, BorderLayout.NORTH);

        JPanel botones = new JPanel(new GridLayout(1, 2, 30, 0));
        btnLimpiar = crearBoton("Limpiar registro");
        btnSalir = crearBoton("Salir");
        botones.add(btnLimpiar);
        botones.add(btnSalir);
        panelInferior.add(botones, BorderLayout.CENTER);

        add(panelInferior, BorderLayout.SOUTH);
    }

    // AYUDAS DE ESTILO
    private TitledBorder crearBorde(String titulo){
        return BorderFactory.createTitledBorder(BorderFactory.createLineBorder(COLOR_BORDE), titulo,
                TitledBorder.LEFT, TitledBorder.TOP, FUENTE_NEGRITA, VERDE_SECCION);
    }

    private JLabel crearEtiqueta(String texto){
        JLabel l = new JLabel(texto);
        l.setFont(FUENTE_NEGRITA);
        return l;
    }

    private JTextField crearCampoLectura(){
        JTextField t = new JTextField(20);
        t.setFont(FUENTE_NORMAL);
        t.setEditable(false);
        t.setBackground(Color.WHITE);
        return t;
    }

    private JButton crearBoton(String texto){
        JButton b = new JButton(texto);
        b.setFont(FUENTE_NEGRITA);
        b.setFocusPainted(false);
        b.setMargin(new Insets(6, 8, 6, 8));
        return b;
    }

    public JList<String> getListaPersonajes(){ return listaPersonajes; }
    public DefaultListModel<String> getModeloPersonajes(){ return modeloPersonajes; }
    public JList<String> getListaObjetos(){ return listaObjetos; }
    public DefaultListModel<String> getModeloObjetos(){ return modeloObjetos; }
    public JTextField getTxtNombre(){ return txtNombre; }
    public JTextField getTxtEdad(){ return txtEdad; }
    public JTextField getTxtPersonalidad(){ return txtPersonalidad; }
    public JTextField getTxtRol(){ return txtRol; }
    public JTextField getTxtMensaje(){ return txtMensaje; }
    public JComboBox<String> getCmbDireccion(){ return cmbDireccion; }
    public JComboBox<String> getCmbOtroPersonaje(){ return cmbOtroPersonaje; }
    public JButton getBtnHablar(){ return btnHablar; }
    public JButton getBtnMover(){ return btnMover; }
    public JButton getBtnAccionEspecial(){ return btnAccionEspecial; }
    public JButton getBtnInteractuar(){ return btnInteractuar; }
    public JButton getBtnUsarObjeto(){ return btnUsarObjeto; }
    public JButton getBtnLimpiar(){ return btnLimpiar; }
    public JButton getBtnSalir(){ return btnSalir; }
    public JTextArea getAreaRegistro(){ return areaRegistro; }
    public JLabel getLblMensaje(){ return lblMensaje; }
}
