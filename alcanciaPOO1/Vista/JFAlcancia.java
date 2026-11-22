package Vista;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JFAlcancia extends JFrame
{
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

    private JButton btn50, btn100, btn200, btn500, btn1000, btnVaciar;

    public JFAlcancia()
    {
        setTitle("Mi Alcancia - POO I");
        setSize(560, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        crearInterfaz();
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
        btn50 = crearBotonMoneda("50");
        btn100 = crearBotonMoneda("100");
        btn200 = crearBotonMoneda("200");
        btn500 = crearBotonMoneda("500");
        btn1000 = crearBotonMoneda("1000");
        botones.add(btn50);
        botones.add(btn100);
        botones.add(btn200);
        botones.add(btn500);
        botones.add(btn1000);

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

        btnVaciar = new JButton("Vaciar alcancía");
        btnVaciar.setFont(new Font("Times New Roman", Font.BOLD, 16));
        pie.add(btnVaciar);
        return pie;
    }

    private JButton crearBotonMoneda(String valor)
    {
        JButton boton = new JButton("$" + valor);
        boton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        return boton;
    }

    private JLabel etiquetaConteo(String denominacion)
    {
        JLabel etiqueta = new JLabel("<html><center>" + denominacion + "<br>0</center></html>");
        etiqueta.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        return etiqueta;
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


//Start GetterSetterExtension Source Code

    /**GET Method Propertie lblImagen*/
    public JLabel getLblImagen(){
        return this.lblImagen;
    }//end method getLblImagen

    /**SET Method Propertie lblImagen*/
    public void setLblImagen(JLabel lblImagen){
        this.lblImagen = lblImagen;
    }//end method setLblImagen

    /**GET Method Propertie lblSaldo*/
    public JLabel getLblSaldo(){
        return this.lblSaldo;
    }//end method getLblSaldo

    /**SET Method Propertie lblSaldo*/
    public void setLblSaldo(JLabel lblSaldo){
        this.lblSaldo = lblSaldo;
    }//end method setLblSaldo

    /**GET Method Propertie lbl50*/
    public JLabel getLbl50(){
        return this.lbl50;
    }//end method getLbl50

    /**SET Method Propertie lbl50*/
    public void setLbl50(JLabel lbl50){
        this.lbl50 = lbl50;
    }//end method setLbl50

    /**GET Method Propertie lbl100*/
    public JLabel getLbl100(){
        return this.lbl100;
    }//end method getLbl100

    /**SET Method Propertie lbl100*/
    public void setLbl100(JLabel lbl100){
        this.lbl100 = lbl100;
    }//end method setLbl100

    /**GET Method Propertie lbl200*/
    public JLabel getLbl200(){
        return this.lbl200;
    }//end method getLbl200

    /**SET Method Propertie lbl200*/
    public void setLbl200(JLabel lbl200){
        this.lbl200 = lbl200;
    }//end method setLbl200

    /**GET Method Propertie lbl500*/
    public JLabel getLbl500(){
        return this.lbl500;
    }//end method getLbl500

    /**SET Method Propertie lbl500*/
    public void setLbl500(JLabel lbl500){
        this.lbl500 = lbl500;
    }//end method setLbl500

    /**GET Method Propertie lbl1000*/
    public JLabel getLbl1000(){
        return this.lbl1000;
    }//end method getLbl1000

    /**SET Method Propertie lbl1000*/
    public void setLbl1000(JLabel lbl1000){
        this.lbl1000 = lbl1000;
    }//end method setLbl1000

    /**GET Method Propertie lblTotal*/
    public JLabel getLblTotal(){
        return this.lblTotal;
    }//end method getLblTotal

    /**SET Method Propertie lblTotal*/
    public void setLblTotal(JLabel lblTotal){
        this.lblTotal = lblTotal;
    }//end method setLblTotal

    /**GET Method Propertie iconoNormal*/
    public ImageIcon getIconoNormal(){
        return this.iconoNormal;
    }//end method getIconoNormal

    /**SET Method Propertie iconoNormal*/
    public void setIconoNormal(ImageIcon iconoNormal){
        this.iconoNormal = iconoNormal;
    }//end method setIconoNormal

    /**GET Method Propertie iconoLlenando*/
    public ImageIcon getIconoLlenando(){
        return this.iconoLlenando;
    }//end method getIconoLlenando

    /**SET Method Propertie iconoLlenando*/
    public void setIconoLlenando(ImageIcon iconoLlenando){
        this.iconoLlenando = iconoLlenando;
    }//end method setIconoLlenando

    /**GET Method Propertie iconoRota*/
    public ImageIcon getIconoRota(){
        return this.iconoRota;
    }//end method getIconoRota

    /**SET Method Propertie iconoRota*/
    public void setIconoRota(ImageIcon iconoRota){
        this.iconoRota = iconoRota;
    }//end method setIconoRota

    /**GET Method Propertie btn50*/
    public JButton getBtn50(){
        return this.btn50;
    }//end method getBtn50

    /**SET Method Propertie btn50*/
    public void setBtn50(JButton btn50){
        this.btn50 = btn50;
    }//end method setBtn50

    /**GET Method Propertie btn100*/
    public JButton getBtn100(){
        return this.btn100;
    }//end method getBtn100

    /**SET Method Propertie btn100*/
    public void setBtn100(JButton btn100){
        this.btn100 = btn100;
    }//end method setBtn100

    /**GET Method Propertie btn200*/
    public JButton getBtn200(){
        return this.btn200;
    }//end method getBtn200

    /**SET Method Propertie btn200*/
    public void setBtn200(JButton btn200){
        this.btn200 = btn200;
    }//end method setBtn200

    /**GET Method Propertie btn500*/
    public JButton getBtn500(){
        return this.btn500;
    }//end method getBtn500

    /**SET Method Propertie btn500*/
    public void setBtn500(JButton btn500){
        this.btn500 = btn500;
    }//end method setBtn500

    /**GET Method Propertie btn1000*/
    public JButton getBtn1000(){
        return this.btn1000;
    }//end method getBtn1000

    /**SET Method Propertie btn1000*/
    public void setBtn1000(JButton btn1000){
        this.btn1000 = btn1000;
    }//end method setBtn1000

    /**GET Method Propertie btnVaciar*/
    public JButton getBtnVaciar(){
        return this.btnVaciar;
    }//end method getBtnVaciar

    /**SET Method Propertie btnVaciar*/
    public void setBtnVaciar(JButton btnVaciar){
        this.btnVaciar = btnVaciar;
    }//end method setBtnVaciar

//End GetterSetterExtension Source Code


}//End class