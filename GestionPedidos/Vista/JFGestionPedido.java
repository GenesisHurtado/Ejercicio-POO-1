package Vista;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.geom.*;

public class JFGestionPedido extends JFrame
{
    private JTextField txtNumeroPedido;
    private JTextField txtCedula;
    private JTextField txtNombreCliente;
    private JTextField txtCodigoProducto;
    private JTextField txtNombreProducto;
    private JTextField txtPrecio;
    private JButton btnAgregarProducto;
    private JButton btnEliminarProducto;
    private JButton btnNuevoPedido;
    private JButton btnLimpiar;
    private JButton btnSalir;
    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;
    private JLabel lblTotal;
    private JLabel lblMensaje;

    private static final Color AZUL_TITULO = new Color(24, 58, 112);
    private static final Color AZUL_SECCION = new Color(31, 78, 140);
    private static final Color COLOR_BORDE = new Color(190, 200, 216);
    private static final Color FONDO_TOTAL = new Color(220, 233, 247);
    private static final Font FUENTE_NORMAL = new Font("Segoe UI", Font.PLAIN, 13);
    private static final Font FUENTE_NEGRITA = new Font("Segoe UI", Font.BOLD, 13);

    public JFGestionPedido(){
        setTitle("Gestión de Pedidos");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));
        crearTitulo();
        crearPanelCentral();
        crearPanelInferior();
    }

    // TITULO
    private void crearTitulo(){
        JLabel lblTitulo = new JLabel("GESTIÓN DE PEDIDOS", new Icono(Icono.CARRITO, 40), SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(AZUL_TITULO);
        lblTitulo.setIconTextGap(14);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(12, 10, 8, 10));
        add(lblTitulo, BorderLayout.NORTH);
    }

    // PANEL CENTRAL
    private void crearPanelCentral(){
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        panelCentral.add(fijarAlto(crearPanelPedidoCliente()));
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(fijarAlto(crearPanelProducto()));
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(crearPanelTabla());

        add(panelCentral, BorderLayout.CENTER);
    }

    private JPanel fijarAlto(JPanel panel){
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel.getPreferredSize().height));
        return panel;
    }

    // PANEL PEDIDO Y CLIENTE
    private JPanel crearPanelPedidoCliente(){
        JPanel panel = new JPanel(new GridLayout(1, 2, 15, 0));

        // Datos del pedido
        JPanel panelPedido = new JPanel(new GridBagLayout());
        panelPedido.setBorder(crearBorde("Datos del Pedido"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelPedido.add(crearEtiqueta("Número de pedido:"), gbc);
        txtNumeroPedido = crearCampo(12);
        txtNumeroPedido.setEditable(false);
        txtNumeroPedido.setBackground(Color.WHITE);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelPedido.add(txtNumeroPedido, gbc);

        // Datos del cliente
        JPanel panelCliente = new JPanel(new GridBagLayout());
        panelCliente.setBorder(crearBorde("Datos del Cliente"));
        GridBagConstraints gbcCliente = new GridBagConstraints();
        gbcCliente.insets = new Insets(5, 10, 5, 10);
        gbcCliente.anchor = GridBagConstraints.WEST;

        gbcCliente.gridx = 0;
        gbcCliente.gridy = 0;
        panelCliente.add(crearEtiqueta("Cédula:"), gbcCliente);
        txtCedula = crearCampo(15);
        gbcCliente.gridx = 1;
        gbcCliente.weightx = 1.0;
        gbcCliente.fill = GridBagConstraints.HORIZONTAL;
        panelCliente.add(txtCedula, gbcCliente);

        gbcCliente.gridx = 0;
        gbcCliente.gridy = 1;
        gbcCliente.weightx = 0;
        gbcCliente.fill = GridBagConstraints.NONE;
        panelCliente.add(crearEtiqueta("Nombre:"), gbcCliente);
        txtNombreCliente = crearCampo(15);
        gbcCliente.gridx = 1;
        gbcCliente.weightx = 1.0;
        gbcCliente.fill = GridBagConstraints.HORIZONTAL;
        panelCliente.add(txtNombreCliente, gbcCliente);

        panel.add(panelPedido);
        panel.add(panelCliente);
        return panel;
    }

    // PANEL PRODUCTO
    private JPanel crearPanelProducto(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(crearBorde("Datos del Producto"));

        JPanel campos = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 15));
        campos.add(crearEtiqueta("Código:"));
        txtCodigoProducto = crearCampo(8);
        campos.add(txtCodigoProducto);
        campos.add(crearEtiqueta("Nombre:"));
        txtNombreProducto = crearCampo(15);
        campos.add(txtNombreProducto);
        campos.add(crearEtiqueta("Precio:"));
        txtPrecio = crearCampo(10);
        campos.add(txtPrecio);

        btnAgregarProducto = crearBoton("Agregar Producto", new Icono(Icono.MAS, 22));
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 12));
        panelBoton.add(btnAgregarProducto);

        panel.add(campos, BorderLayout.WEST);
        panel.add(panelBoton, BorderLayout.EAST);
        return panel;
    }

    // TABLA DE PRODUCTOS
    private JPanel crearPanelTabla(){
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createCompoundBorder(
                crearBorde("Productos del Pedido"), BorderFactory.createEmptyBorder(0, 8, 8, 8)));

        String[] columnas = {"Código", "Nombre", "Precio"};
        modeloTabla = new DefaultTableModel(columnas, 0){
            public boolean isCellEditable(int fila, int columna){
                return false;
            }
        };

        tablaProductos = new JTable(modeloTabla);
        tablaProductos.setFont(FUENTE_NORMAL);
        tablaProductos.setRowHeight(25);
        tablaProductos.setShowVerticalLines(false);
        tablaProductos.setGridColor(new Color(225, 229, 236));
        tablaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaProductos.getTableHeader().setFont(FUENTE_NEGRITA);
        tablaProductos.getTableHeader().setReorderingAllowed(false);
        ((DefaultTableCellRenderer) tablaProductos.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer derecha = new DefaultTableCellRenderer();
        derecha.setHorizontalAlignment(SwingConstants.RIGHT);
        derecha.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 8));
        tablaProductos.getColumnModel().getColumn(2).setCellRenderer(derecha);

        JScrollPane scroll = new JScrollPane(tablaProductos);
        scroll.setBorder(BorderFactory.createLineBorder(COLOR_BORDE));
        scroll.getViewport().setBackground(Color.WHITE);
        panel.add(scroll, BorderLayout.CENTER);

        btnEliminarProducto = crearBoton("Eliminar Producto", new Icono(Icono.BASURA, 22));
        JPanel panelEliminar = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelEliminar.add(btnEliminarProducto);
        panel.add(panelEliminar, BorderLayout.EAST);

        return panel;
    }

    // PANEL INFERIOR
    private void crearPanelInferior(){
        JPanel panelInferior = new JPanel(new BorderLayout(0, 12));
        panelInferior.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 20, 12, 20),
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(COLOR_BORDE),
                        BorderFactory.createEmptyBorder(10, 12, 10, 12))));

        // Mensajes a la izquierda y total a la derecha
        JPanel panelTotal = new JPanel(new BorderLayout(10, 0));

        lblMensaje = new JLabel(" ");
        lblMensaje.setFont(FUENTE_NORMAL);
        lblMensaje.setForeground(new Color(150, 40, 40));
        panelTotal.add(lblMensaje, BorderLayout.CENTER);

        JPanel derecha = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 0));
        JLabel lblTextoTotal = new JLabel("TOTAL DEL PEDIDO:");
        lblTextoTotal.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTextoTotal.setForeground(AZUL_TITULO);

        lblTotal = new JLabel("$ 0", SwingConstants.CENTER);
        lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTotal.setForeground(AZUL_TITULO);
        lblTotal.setOpaque(true);
        lblTotal.setBackground(FONDO_TOTAL);
        lblTotal.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLOR_BORDE),
                BorderFactory.createEmptyBorder(6, 12, 6, 12)));
        lblTotal.setPreferredSize(new Dimension(190, 46));

        derecha.add(lblTextoTotal);
        derecha.add(lblTotal);
        panelTotal.add(derecha, BorderLayout.EAST);

        // Botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 30, 0));
        btnNuevoPedido = crearBoton("Nuevo Pedido", new Icono(Icono.DOCUMENTO, 22));
        btnLimpiar = crearBoton("Limpiar Campos", new Icono(Icono.ESCOBA, 22));
        btnSalir = crearBoton("Salir", new Icono(Icono.SALIR, 22));
        panelBotones.add(btnNuevoPedido);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnSalir);

        panelInferior.add(panelTotal, BorderLayout.NORTH);
        panelInferior.add(panelBotones, BorderLayout.CENTER);

        add(panelInferior, BorderLayout.SOUTH);
    }

    // AYUDAS DE ESTILO
    private TitledBorder crearBorde(String titulo){
        return BorderFactory.createTitledBorder(BorderFactory.createLineBorder(COLOR_BORDE), titulo,
                TitledBorder.LEFT, TitledBorder.TOP, FUENTE_NEGRITA, AZUL_SECCION);
    }

    private JLabel crearEtiqueta(String texto){
        JLabel l = new JLabel(texto);
        l.setFont(FUENTE_NORMAL);
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
        b.setIconTextGap(10);
        b.setFocusPainted(false);
        b.setMargin(new Insets(8, 14, 8, 14));
        return b;
    }

    // ICONOS DIBUJADOS (no se usan archivos de imagen)
    private static class Icono implements Icon
    {
        static final int CARRITO = 0, MAS = 1, BASURA = 2, DOCUMENTO = 3, ESCOBA = 4, SALIR = 5;
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

            if(tipo == CARRITO){
                g.setColor(AZUL_TITULO);
                g.setStroke(new BasicStroke(2.2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                Path2D p = new Path2D.Double();
                p.moveTo(1, 3); p.lineTo(5, 3); p.lineTo(8, 15); p.lineTo(18, 15); p.lineTo(20, 7); p.lineTo(6, 7);
                g.draw(p);
                g.fill(new Ellipse2D.Double(8, 17.5, 3.6, 3.6));
                g.fill(new Ellipse2D.Double(15, 17.5, 3.6, 3.6));
            }else if(tipo == MAS){
                g.setColor(new Color(46, 158, 58));
                g.fill(new RoundRectangle2D.Double(9, 3, 4, 16, 2, 2));
                g.fill(new RoundRectangle2D.Double(3, 9, 16, 4, 2, 2));
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
            }else if(tipo == DOCUMENTO){
                g.setColor(new Color(52, 118, 200));
                g.setStroke(new BasicStroke(1.8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                Path2D p = new Path2D.Double();
                p.moveTo(5, 2); p.lineTo(13, 2); p.lineTo(18, 7); p.lineTo(18, 20); p.lineTo(5, 20); p.closePath();
                g.draw(p);
                g.draw(new Line2D.Double(13, 2, 13, 7));
                g.draw(new Line2D.Double(13, 7, 18, 7));
                g.draw(new Line2D.Double(8, 12, 15, 12));
                g.draw(new Line2D.Double(8, 16, 15, 16));
            }else if(tipo == ESCOBA){
                g.setColor(new Color(52, 118, 200));
                g.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
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

    public JTextField getTxtNumeroPedido(){ return txtNumeroPedido; }
    public JTextField getTxtCedula(){ return txtCedula; }
    public JTextField getTxtNombreCliente(){ return txtNombreCliente; }
    public JTextField getTxtCodigoProducto(){ return txtCodigoProducto; }
    public JTextField getTxtNombreProducto(){ return txtNombreProducto; }
    public JTextField getTxtPrecio(){ return txtPrecio; }
    public JButton getBtnAgregarProducto(){ return btnAgregarProducto; }
    public JButton getBtnEliminarProducto(){ return btnEliminarProducto; }
    public JButton getBtnNuevoPedido(){ return btnNuevoPedido; }
    public JButton getBtnLimpiar(){ return btnLimpiar; }
    public JButton getBtnSalir(){ return btnSalir; }
    public JTable getTablaProductos(){ return tablaProductos; }
    public DefaultTableModel getModeloTabla(){ return modeloTabla; }
    public JLabel getLblTotal(){ return lblTotal; }
    public JLabel getLblMensaje(){ return lblMensaje; }
}
