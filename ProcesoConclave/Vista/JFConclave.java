package Vista;
import Modelo.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * Write a description of class JFConclave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JFConclave extends JFrame
{
   private JLabel lblTitulo, lblCardenales, lblRonda;
    private JComboBox<Cardenal> cbCardenales;
    private JTextField txtNumRonda;
    private JScrollPane scrollResultados;
    private JTextArea campoTexto;
    private JButton btnVotar, btnMostrarResultados, btnSiguienteRonda;

    private static final Color FONDO = new Color(217, 213, 245);
    private static final Color COLOR_TEXTO = new Color(40, 35, 90);
    private static final Color COLOR_BORDE = new Color(130, 125, 180);
    private static final Color COLOR_BOTON = new Color(245, 244, 255);
    private static final Font FUENTE_NEGRITA = new Font("Segoe UI", Font.BOLD, 14);
    private static final Font FUENTE_NORMAL = new Font("Segoe UI", Font.PLAIN, 13);

    public JFConclave(){
        setTitle("Proceso Conclave");
        setSize(470, 450);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(FONDO);

        lblTitulo = new JLabel("Votaciones Conclave");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblTitulo.setForeground(COLOR_TEXTO);
        lblTitulo.setBounds(25, 15, 260, 28);
        add(lblTitulo);

        lblCardenales = new JLabel("Lista de cardenales");
        lblCardenales.setFont(FUENTE_NEGRITA);
        lblCardenales.setForeground(COLOR_TEXTO);
        lblCardenales.setBounds(35, 65, 150, 28);
        add(lblCardenales);

        cbCardenales = new JComboBox<>();
        cbCardenales.setFont(FUENTE_NORMAL);
        cbCardenales.setBackground(Color.WHITE);
        cbCardenales.setBounds(195, 65, 225, 28);
        add(cbCardenales);

        btnVotar = crearBoton("Votar", true);
        btnVotar.setBounds(160, 113, 100, 32);
        add(btnVotar);

        lblRonda = new JLabel("Ronda No");
        lblRonda.setFont(FUENTE_NEGRITA);
        lblRonda.setForeground(COLOR_TEXTO);
        lblRonda.setBounds(305, 115, 75, 28);
        add(lblRonda);

        txtNumRonda = new JTextField("1");
        txtNumRonda.setFont(FUENTE_NEGRITA);
        txtNumRonda.setHorizontalAlignment(JTextField.CENTER);
        txtNumRonda.setEditable(false);
        txtNumRonda.setBackground(Color.WHITE);
        txtNumRonda.setBorder(BorderFactory.createLineBorder(COLOR_BORDE));
        txtNumRonda.setBounds(383, 117, 36, 26);
        add(txtNumRonda);

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
        scrollResultados.setBounds(30, 165, 390, 180);
        add(scrollResultados);

        btnMostrarResultados = crearBoton("Mostrar Resultados", false);
        btnMostrarResultados.setBounds(65, 365, 150, 32);
        add(btnMostrarResultados);

        btnSiguienteRonda = crearBoton("Siguiente Ronda", false);
        btnSiguienteRonda.setBounds(240, 365, 150, 32);
        btnSiguienteRonda.setEnabled(false);
        add(btnSiguienteRonda);
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

    //Start GetterSetterExtension Source Code

    /**GET Method Propertie lblTitulo*/
    public JLabel getLblTitulo(){
        return this.lblTitulo;
    }//end method getLblTitulo

    /**SET Method Propertie lblTitulo*/
    public void setLblTitulo(JLabel lblTitulo){
        this.lblTitulo = lblTitulo;
    }//end method setLblTitulo

    /**GET Method Propertie lblCardenales*/
    public JLabel getLblCardenales(){
        return this.lblCardenales;
    }//end method getLblCardenales

    /**SET Method Propertie lblCardenales*/
    public void setLblCardenales(JLabel lblCardenales){
        this.lblCardenales = lblCardenales;
    }//end method setLblCardenales

    /**GET Method Propertie lblRonda*/
    public JLabel getLblRonda(){
        return this.lblRonda;
    }//end method getLblRonda

    /**SET Method Propertie lblRonda*/
    public void setLblRonda(JLabel lblRonda){
        this.lblRonda = lblRonda;
    }//end method setLblRonda

    /**GET Method Propertie cbCardenales*/
    public JComboBox<Cardenal> getCbCardenales(){
        return this.cbCardenales;
    }//end method getCbCardenales

    /**SET Method Propertie cbCardenales*/
    public void setCbCardenales(JComboBox<Cardenal> cbCardenales){
        this.cbCardenales = cbCardenales;
    }//end method setCbCardenales

    /**GET Method Propertie txtNumRonda*/
    public JTextField getTxtNumRonda(){
        return this.txtNumRonda;
    }//end method getTxtNumRonda

    /**SET Method Propertie txtNumRonda*/
    public void setTxtNumRonda(JTextField txtNumRonda){
        this.txtNumRonda = txtNumRonda;
    }//end method setTxtNumRonda

    /**GET Method Propertie scrollResultados*/
    public JScrollPane getScrollResultados(){
        return this.scrollResultados;
    }//end method getScrollResultados

    /**SET Method Propertie scrollResultados*/
    public void setScrollResultados(JScrollPane scrollResultados){
        this.scrollResultados = scrollResultados;
    }//end method setScrollResultados

    /**GET Method Propertie campoTexto*/
    public JTextArea getCampoTexto(){
        return this.campoTexto;
    }//end method getCampoTexto

    /**SET Method Propertie campoTexto*/
    public void setCampoTexto(JTextArea campoTexto){
        this.campoTexto = campoTexto;
    }//end method setCampoTexto

    /**GET Method Propertie btnVotar*/
    public JButton getBtnVotar(){
        return this.btnVotar;
    }//end method getBtnVotar

    /**SET Method Propertie btnVotar*/
    public void setBtnVotar(JButton btnVotar){
        this.btnVotar = btnVotar;
    }//end method setBtnVotar

    /**GET Method Propertie btnMostrarResultados*/
    public JButton getBtnMostrarResultados(){
        return this.btnMostrarResultados;
    }//end method getBtnMostrarResultados

    /**SET Method Propertie btnMostrarResultados*/
    public void setBtnMostrarResultados(JButton btnMostrarResultados){
        this.btnMostrarResultados = btnMostrarResultados;
    }//end method setBtnMostrarResultados

    /**GET Method Propertie btnSiguienteRonda*/
    public JButton getBtnSiguienteRonda(){
        return this.btnSiguienteRonda;
    }//end method getBtnSiguienteRonda

    /**SET Method Propertie btnSiguienteRonda*/
    public void setBtnSiguienteRonda(JButton btnSiguienteRonda){
        this.btnSiguienteRonda = btnSiguienteRonda;
    }//end method setBtnSiguienteRonda

   //End GetterSetterExtension Source Code

 
}