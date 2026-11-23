package Vista;
import Modelo.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class JFConflicto extends JFrame
{
    private JLabel lblTitulo, lblConflicto, lblGrupo;
    private JComboBox<Conflicto> cbConflictos;
    private JComboBox<GrupoArmado> cbGrupos;
    private JButton btnVerConflicto, btnVerGrupo, btnVerDialogos;
    private JScrollPane scrollResultados;
    private JTextArea campoTexto;

   
    private static final Color COLOR_TEXTO = new Color(40, 35, 90);
    private static final Color COLOR_BORDE = new Color(130, 125, 180);
    private static final Color COLOR_BOTON = new Color(245, 244, 255);
    private static final Font FUENTE_NEGRITA = new Font("Segoe UI", Font.BOLD, 14);
    private static final Font FUENTE_NORMAL = new Font("Segoe UI", Font.PLAIN, 13);

    public JFConflicto(){
        setTitle("Seguimiento de Conflictos Belicos");
        setSize(560, 560);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
      

        lblTitulo = new JLabel("Conflictos belicos");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblTitulo.setForeground(COLOR_TEXTO);
        lblTitulo.setBounds(25, 15, 300, 28);
        add(lblTitulo);

        lblConflicto = new JLabel("Conflicto");
        lblConflicto.setFont(FUENTE_NEGRITA);
        lblConflicto.setForeground(COLOR_TEXTO);
        lblConflicto.setBounds(30, 60, 100, 28);
        add(lblConflicto);

        cbConflictos = new JComboBox<>();
        cbConflictos.setFont(FUENTE_NORMAL);
        cbConflictos.setBackground(Color.WHITE);
        cbConflictos.setBounds(135, 60, 250, 28);
        add(cbConflictos);

        btnVerConflicto = crearBoton("Ver conflicto", true);
        btnVerConflicto.setBounds(400, 58, 120, 32);
        add(btnVerConflicto);

        lblGrupo = new JLabel("Grupo armado");
        lblGrupo.setFont(FUENTE_NEGRITA);
        lblGrupo.setForeground(COLOR_TEXTO);
        lblGrupo.setBounds(30, 105, 100, 28);
        add(lblGrupo);

        cbGrupos = new JComboBox<>();
        cbGrupos.setFont(FUENTE_NORMAL);
        cbGrupos.setBackground(Color.WHITE);
        cbGrupos.setBounds(135, 105, 250, 28);
        add(cbGrupos);

        btnVerGrupo = crearBoton("Ver grupo", true);
        btnVerGrupo.setBounds(400, 103, 120, 32);
        add(btnVerGrupo);

        btnVerDialogos = crearBoton("Ver dialogos", false);
        btnVerDialogos.setBounds(30, 150, 150, 32);
        add(btnVerDialogos);

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
        scrollResultados.setBounds(25, 200, 495, 310);
        add(scrollResultados);
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
    public JLabel getLblConflicto(){ return lblConflicto; }
    public JLabel getLblGrupo(){ return lblGrupo; }
    public JComboBox<Conflicto> getCbConflictos(){ return cbConflictos; }
    public JComboBox<GrupoArmado> getCbGrupos(){ return cbGrupos; }
    public JButton getBtnVerConflicto(){ return btnVerConflicto; }
    public JButton getBtnVerGrupo(){ return btnVerGrupo; }
    public JButton getBtnVerDialogos(){ return btnVerDialogos; }
    public JScrollPane getScrollResultados(){ return scrollResultados; }
    public JTextArea getCampoTexto(){ return campoTexto; }
}
