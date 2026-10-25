
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFAlcancia extends JFrame implements ActionListener
{
    private Alcancia alcancia;

    private JLabel lblImagen;
    private JLabel lblSaldo;
    private JLabel lbl50;
    private JLabel lbl100;
    private JLabel lbl200;
    private JLabel lbl500;
    private JLabel lbl1000;
    private JLabel lblTotal;

    private ImageIcon iconoNormal;
    private ImageIcon iconoLlenando;
    private ImageIcon iconoRota;

    public JFAlcancia()
    {
        alcancia = new Alcancia();

        setTitle("Mi Alcancia - POO I");
        setSize(560, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        crearInterfaz();
        actualizarInterfaz();

        setVisible(true);
    }

    public void crearInterfaz()
    {
        JPanel principal = new JPanel(new BorderLayout(12, 12));
        principal.setBorder(new EmptyBorder(16, 20, 16, 20));
        principal.setBackground(new Color(245, 247, 250));

        principal.add(crearEncabezado(), BorderLayout.NORTH);
        principal.add(crearCentro(), BorderLayout.CENTER);
        principal.add(crearPie(), BorderLayout.SOUTH);

        setContentPane(principal);
    }

    private JPanel crearEncabezado()
    {
        JPanel encabezado = new JPanel();
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));
        encabezado.setOpaque(false);

        JLabel titulo = new JLabel("MI ALCANCÍA");
        titulo.setFont(new Font("Times New Roman", Font.BOLD, 28));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        iconoNormal = cargarIcono("images/cerdito.png", 150, 150);
        iconoLlenando = cargarIcono("images/cerdo.png", 150, 150);
        iconoRota = cargarIcono("images/rota.png", 150, 150);
        lblImagen = new JLabel(iconoNormal);
        lblImagen.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel textoSaldo = new JLabel("Saldo disponible");
        textoSaldo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        textoSaldo.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblSaldo = new JLabel("$0");
        lblSaldo.setFont(new Font("Times New Roman", Font.BOLD, 36));
        lblSaldo.setForeground(new Color(20, 90, 50));
        lblSaldo.setAlignmentX(Component.CENTER_ALIGNMENT);

        encabezado.add(titulo);
        encabezado.add(Box.createVerticalStrut(8));
        encabezado.add(lblImagen);
        encabezado.add(Box.createVerticalStrut(6));
        encabezado.add(textoSaldo);
        encabezado.add(lblSaldo);
        return encabezado;
    }

    private JPanel crearCentro()
    {
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setOpaque(false);

        JLabel tituloMonedas = new JLabel("INGRESAR MONEDAS");
        tituloMonedas.setFont(new Font("Times New Roman", Font.BOLD, 18));
        tituloMonedas.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));
        botones.setOpaque(false);
        botones.add(crearBotonMoneda("50"));
        botones.add(crearBotonMoneda("100"));
        botones.add(crearBotonMoneda("200"));
        botones.add(crearBotonMoneda("500"));
        botones.add(crearBotonMoneda("1000"));

        JLabel tituloDetalle = new JLabel("DETALLE DE MONEDAS");
        tituloDetalle.setFont(new Font("Times New Roman", Font.BOLD, 18));
        tituloDetalle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel detalle = new JPanel(new FlowLayout(FlowLayout.CENTER, 16, 4));
        detalle.setOpaque(false);
        lbl50 = etiquetaConteo("$50");
        lbl100 = etiquetaConteo("$100");
        lbl200 = etiquetaConteo("$200");
        lbl500 = etiquetaConteo("$500");
        lbl1000 = etiquetaConteo("$1000");
        detalle.add(lbl50);
        detalle.add(lbl100);
        detalle.add(lbl200);
        detalle.add(lbl500);
        detalle.add(lbl1000);

        lblTotal = new JLabel("Total monedas: 0");
        lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblTotal.setAlignmentX(Component.CENTER_ALIGNMENT);

        centro.add(tituloMonedas);
        centro.add(botones);
        centro.add(Box.createVerticalStrut(8));
        centro.add(tituloDetalle);
        centro.add(detalle);
        centro.add(lblTotal);
        return centro;
    }

    private JPanel crearPie()
    {
        JPanel pie = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pie.setOpaque(false);

        JButton btnVaciar = new JButton("Vaciar alcancía");
        btnVaciar.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnVaciar.setActionCommand("vaciar");
        btnVaciar.addActionListener(this);
        pie.add(btnVaciar);
        return pie;
    }

    private JButton crearBotonMoneda(String valor)
    {
        JButton boton = new JButton("$" + valor);
        boton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        boton.setActionCommand(valor);
        boton.addActionListener(this);
        return boton;
    }

    private JLabel etiquetaConteo(String denominacion)
    {
        JLabel etiqueta = new JLabel("<html><center>" + denominacion + "<br>0</center></html>");
        etiqueta.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        return etiqueta;
    }

    public void actionPerformed(ActionEvent evento)
    {
        String comando = evento.getActionCommand();
        if (comando.equals("vaciar"))
        {
            vaciarAlcancia();
        }
        else
        {
            agregarMoneda(Integer.parseInt(comando));
        }
    }

    private void agregarMoneda(int valor)
    {
        if (alcancia.agregarMonedas(valor))
        {
            lblImagen.setIcon(iconoLlenando);
            actualizarInterfaz();
        }
    }

    private void vaciarAlcancia()
    {
        alcancia.vaciar();
        lblImagen.setIcon(iconoRota);
        actualizarInterfaz();
    }

    public void actualizarInterfaz()
    {
        lblSaldo.setText("$" + alcancia.getSaldo());
        lbl50.setText("<html><center>$50<br>" + alcancia.getMonedas50() + "</center></html>");
        lbl100.setText("<html><center>$100<br>" + alcancia.getMonedas100() + "</center></html>");
        lbl200.setText("<html><center>$200<br>" + alcancia.getMonedas200() + "</center></html>");
        lbl500.setText("<html><center>$500<br>" + alcancia.getMonedas500() + "</center></html>");
        lbl1000.setText("<html><center>$1000<br>" + alcancia.getMonedas1000() + "</center></html>");
        lblTotal.setText("Total monedas: " + alcancia.getTotalMonedas());
    }

    private ImageIcon cargarIcono(String ruta, int ancho, int alto)
    {
        ImageIcon original = new ImageIcon(ruta);
        if (original.getIconWidth() <= 0)
        {
            return original;
        }
        Image escalada = original.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(escalada);
    }
}
