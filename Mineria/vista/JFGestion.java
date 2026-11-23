package vista;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.geom.*;

public class JFGestion extends JFrame
{
    private JTextField txtCodigo;
    private JTextField txtDescripcion;
    private JComboBox<String> cmbTipo;
    private JTextField txtNivel;
    private JButton btnAgregar;
    private JButton btnBuscar;
    private JButton btnEliminar;
    private JButton btnListar;
    private JButton btnLimpiar;
    private JButton btnSalir;
    private JTextArea areaRiesgos;
    private JLabel lblMensaje;

    private static final Color NARANJA_TITULO = new Color(191, 87, 0);
    private static final Color GRIS_SECCION = new Color(70, 78, 90);
    private static final Color COLOR_BORDE = new Color(200, 204, 212);
    private static final Font FUENTE_NORMAL = new Font("Segoe UI", Font.PLAIN, 13);
    private static final Font FUENTE_NEGRITA = new Font("Segoe UI", Font.BOLD, 13);

    public JFGestion(){
        setTitle("Gestor de Riesgos - Mina");
        setSize(760, 700);
        setMinimumSize(new Dimension(620, 560));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));
        crearTitulo();
        crearPanelCentral();
        crearPanelInferior();
    }

    // TITULO
    private void crearTitulo(){
        JLabel lblTitulo = new JLabel("GESTOR DE RIESGOS - MINA", new Icono(Icono.ALERTA, 40), SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblTitulo.setForeground(NARANJA_TITULO);
        lblTitulo.setIconTextGap(14);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(12, 10, 4, 10));
        add(lblTitulo, BorderLayout.NORTH);
    }

    // PANEL CENTRAL: formulario arriba y area de texto que ocupa el resto
    private void crearPanelCentral(){
        JPanel panelCentral = new JPanel(new BorderLayout(0, 10));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        panelCentral.add(crearPanelEntrada(), BorderLayout.NORTH);
        panelCentral.add(crearPanelRiesgos(), BorderLayout.CENTER);
        add(panelCentral, BorderLayout.CENTER);
    }

    // PANEL DE ENTRADA (se estira con la ventana)
    private JPanel crearPanelEntrada(){
        JPanel panel = new JPanel(new BorderLayout(0, 8));
        panel.setBorder(BorderFactory.createCompoundBorder(
                crearBorde("Datos del Riesgo"), BorderFactory.createEmptyBorder(2, 8, 10, 8)));

        JPanel campos = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 6, 5, 6);
        gbc.anchor = GridBagConstraints.WEST;

        txtCodigo = crearCampo(20);
        txtDescripcion = crearCampo(20);
        cmbTipo = new JComboBox<>(new String[]{"Físico", "Químico", "Mecánico", "Biológico", "Eléctrico", "Ergonómico"});
        cmbTipo.setEditable(true);
        cmbTipo.setFont(FUENTE_NORMAL);
        txtNivel = crearCampo(20);

        agregarFila(campos, gbc, 0, "Código:", txtCodigo);
        agregarFila(campos, gbc, 1, "Descripción:", txtDescripcion);
        agregarFila(campos, gbc, 2, "Tipo:", cmbTipo);
        agregarFila(campos, gbc, 3, "Nivel de Peligro (1-5):", txtNivel);

        btnAgregar = crearBoton("Agregar", new Icono(Icono.MAS, 22));
        btnBuscar = crearBoton("Buscar", new Icono(Icono.LUPA, 22));
        JPanel botones = new JPanel(new GridLayout(1, 2, 12, 0));
        botones.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 6));
        botones.add(btnAgregar);
        botones.add(btnBuscar);

        panel.add(campos, BorderLayout.CENTER);
        panel.add(botones, BorderLayout.SOUTH);
        return panel;
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

    // AREA DE TEXTO
    private JPanel crearPanelRiesgos(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createCompoundBorder(
                crearBorde("Riesgos Registrados"), BorderFactory.createEmptyBorder(0, 8, 8, 8)));

        areaRiesgos = new JTextArea();
        areaRiesgos.setEditable(false);
        areaRiesgos.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        areaRiesgos.setMargin(new Insets(8, 10, 8, 10));
        areaRiesgos.setLineWrap(true);
        areaRiesgos.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(areaRiesgos);
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

        JPanel botones = new JPanel(new GridLayout(1, 4, 12, 0));
        btnListar = crearBoton("Listar Todos", new Icono(Icono.LISTA, 22));
        btnEliminar = crearBoton("Eliminar", new Icono(Icono.BASURA, 22));
        btnLimpiar = crearBoton("Limpiar", new Icono(Icono.ESCOBA, 22));
        btnSalir = crearBoton("Salir", new Icono(Icono.SALIR, 22));
        botones.add(btnListar);
        botones.add(btnEliminar);
        botones.add(btnLimpiar);
        botones.add(btnSalir);
        panelInferior.add(botones, BorderLayout.CENTER);

        add(panelInferior, BorderLayout.SOUTH);
    }

    // AYUDAS DE ESTILO
    private TitledBorder crearBorde(String titulo){
        return BorderFactory.createTitledBorder(BorderFactory.createLineBorder(COLOR_BORDE), titulo,
                TitledBorder.LEFT, TitledBorder.TOP, FUENTE_NEGRITA, GRIS_SECCION);
    }

    private JLabel crearEtiqueta(String texto){
        JLabel l = new JLabel(texto);
        l.setFont(FUENTE_NEGRITA);
        return l;
    }

    private JTextField crearCampo(int columnas){
        JTextField t = new JTextField(columnas);
        t.setFont(FUENTE_NORMAL);
        return t;
    }

    private JButton crearBoton(String texto, Icon icono){
        JButton b = new JButton(texto, icono);
        b.setFont(FUENTE_NEGRITA);
        b.setIconTextGap(8);
        b.setFocusPainted(false);
        b.setMargin(new Insets(8, 10, 8, 10));
        return b;
    }

    // ICONOS DIBUJADOS (no se usan archivos de imagen)
    private static class Icono implements Icon
    {
        static final int ALERTA = 0, MAS = 1, LUPA = 2, LISTA = 3, BASURA = 4, ESCOBA = 5, SALIR = 6;
        private int tipo;
        private int tam;

        Icono(int tipo, int tam){
            this.tipo = tipo;
            this.tam = tam;
        }

        public int getIconWidth(){
            return tam;
        }

        public int getIconHeight(){
            return tam;
        }

        public void paintIcon(Component c, Graphics g0, int x, int y){
            Graphics2D g = (Graphics2D) g0.create();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.translate(x, y);
            double e = tam / 22.0;
            g.scale(e, e);
            g.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

            if(tipo == ALERTA){
                // Triangulo de advertencia
                Path2D p = new Path2D.Double();
                p.moveTo(11, 2); p.lineTo(21, 19.5); p.lineTo(1, 19.5); p.closePath();
                g.setColor(new Color(255, 193, 7));
                g.fill(p);
                g.setColor(NARANJA_TITULO);
                g.setStroke(new BasicStroke(1.8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g.draw(p);
                g.setColor(new Color(50, 50, 50));
                g.setStroke(new BasicStroke(2.2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g.draw(new Line2D.Double(11, 8, 11, 13));
                g.fill(new Ellipse2D.Double(10, 15, 2, 2));
            }else if(tipo == MAS){
                g.setColor(new Color(46, 158, 58));
                g.fill(new RoundRectangle2D.Double(9, 3, 4, 16, 2, 2));
                g.fill(new RoundRectangle2D.Double(3, 9, 16, 4, 2, 2));
            }else if(tipo == LUPA){
                g.setColor(new Color(52, 118, 200));
                g.setStroke(new BasicStroke(2.2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g.draw(new Ellipse2D.Double(3, 3, 11, 11));
                g.draw(new Line2D.Double(12, 12, 19, 19));
            }else if(tipo == LISTA){
                g.setColor(new Color(52, 118, 200));
                for(int i = 0; i < 3; i++){
                    double yy = 5 + i * 6;
                    g.fill(new Ellipse2D.Double(2, yy - 1.5, 3, 3));
                    g.draw(new Line2D.Double(8, yy, 20, yy));
                }
            }else if(tipo == BASURA){
                g.setColor(new Color(214, 48, 49));
                g.setStroke(new BasicStroke(1.8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g.draw(new Line2D.Double(3, 5, 19, 5));
                g.draw(new Line2D.Double(8, 5, 8, 2.5));
                g.draw(new Line2D.Double(8, 2.5, 14, 2.5));
                g.draw(new Line2D.Double(14, 2.5, 14, 5));
                Path2D p = new Path2D.Double();
                p.moveTo(5, 7); p.lineTo(6.5, 20); p.lineTo(15.5, 20); p.lineTo(17, 7);
                g.draw(p);
                g.draw(new Line2D.Double(9, 9.5, 9, 17.5));
                g.draw(new Line2D.Double(13, 9.5, 13, 17.5));
            }else if(tipo == ESCOBA){
                g.setColor(new Color(52, 118, 200));
                g.draw(new Line2D.Double(19, 2, 11, 10));
                Path2D p = new Path2D.Double();
                p.moveTo(11, 8); p.lineTo(15, 12); p.lineTo(8, 20); p.lineTo(2, 20); p.lineTo(4, 14); p.closePath();
                g.fill(p);
                g.setColor(Color.WHITE);
                g.setStroke(new BasicStroke(1f));
                g.draw(new Line2D.Double(6, 15, 9, 18));
            }else{
                g.setColor(new Color(214, 48, 49));
                g.setStroke(new BasicStroke(1.9f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                Path2D p = new Path2D.Double();
                p.moveTo(9, 3); p.lineTo(3, 3); p.lineTo(3, 19); p.lineTo(9, 19);
                g.draw(p);
                g.draw(new Line2D.Double(8, 11, 19, 11));
                g.draw(new Line2D.Double(15, 7, 19, 11));
                g.draw(new Line2D.Double(15, 15, 19, 11));
            }
            g.dispose();
        }
    }

    public JTextField getTxtCodigo(){ return txtCodigo; }
    public JTextField getTxtDescripcion(){ return txtDescripcion; }
    public JComboBox<String> getCmbTipo(){ return cmbTipo; }
    public JTextField getTxtNivel(){ return txtNivel; }
    public JButton getBtnAgregar(){ return btnAgregar; }
    public JButton getBtnBuscar(){ return btnBuscar; }
    public JButton getBtnEliminar(){ return btnEliminar; }
    public JButton getBtnListar(){ return btnListar; }
    public JButton getBtnLimpiar(){ return btnLimpiar; }
    public JButton getBtnSalir(){ return btnSalir; }
    public JTextArea getAreaRiesgos(){ return areaRiesgos; }
    public JLabel getLblMensaje(){ return lblMensaje; }
}
