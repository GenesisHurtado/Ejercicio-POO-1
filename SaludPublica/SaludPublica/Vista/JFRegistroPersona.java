package Vista;

import Modelo.*;
import javax.swing.*;
import java.awt.*;

public class JFRegistroPersona extends JFrame
{
    private JComboBox<TipoDocumento> cbTipoDocumento;
    private JTextField txtDocumento;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtEdad;
    private JTextField txtEstrato;
    private JTextField txtEstadoCivil;
    private JComboBox<String> cbTipoPersona;
    private JTextField txtInstitucion;
    private JTextField txtEspecialidad;
    private JComboBox<String> cbNivel;
    private JCheckBox chkCabezaHogar;

    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JButton btnBuscar;

    private JPanel panelSalud;
    private JTextField txtElementoBioseguridad;
    private JTextField txtMedicinaSalud;

    private JPanel panelDocente;
    private JTextField txtImplementosTecnologicos;
    private JTextField txtInternetEnergia;

    private JPanel panelIndependiente;
    private JTextField txtMedicinaIndependiente;
    private JTextField txtCanastaFamiliar;

    private JTextArea campoTexto;

    public JFRegistroPersona() {
        setTitle("Gestión de Distribución de Bonos");
        setSize(950, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));

        crearPanelIzquierdo();
        crearPanelDerecho();

        crearCampoTexto();
    }

    private void crearPanelIzquierdo() {
        JPanel panelIzquierdo = new JPanel(new GridLayout(14, 2, 10, 8));
        panelIzquierdo.setBorder(BorderFactory.createTitledBorder("Registro datos básicos"));

        panelIzquierdo.add(new JLabel("Tipo Documento:"));
        cbTipoDocumento = new JComboBox<TipoDocumento>(TipoDocumento.values());
        panelIzquierdo.add(cbTipoDocumento);

        panelIzquierdo.add(new JLabel("Documento:"));
        txtDocumento = new JTextField();
        panelIzquierdo.add(txtDocumento);

        panelIzquierdo.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelIzquierdo.add(txtNombre);

        panelIzquierdo.add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        panelIzquierdo.add(txtApellido);

        panelIzquierdo.add(new JLabel("Direccion:"));
        txtDireccion = new JTextField();
        panelIzquierdo.add(txtDireccion);

        panelIzquierdo.add(new JLabel("Telefono:"));
        txtTelefono = new JTextField();
        panelIzquierdo.add(txtTelefono);

        panelIzquierdo.add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        panelIzquierdo.add(txtEdad);

        panelIzquierdo.add(new JLabel("Estrato:"));
        txtEstrato = new JTextField();
        panelIzquierdo.add(txtEstrato);

        panelIzquierdo.add(new JLabel("Estado Civil:"));
        txtEstadoCivil = new JTextField();
        panelIzquierdo.add(txtEstadoCivil);

        panelIzquierdo.add(new JLabel("Tipo:"));
        cbTipoPersona = new JComboBox<String>(new String[]{"Salud", "Docente", "Independiente"});
        panelIzquierdo.add(cbTipoPersona);

        panelIzquierdo.add(new JLabel("Institucion:"));
        txtInstitucion = new JTextField();
        panelIzquierdo.add(txtInstitucion);

        panelIzquierdo.add(new JLabel("Especialidad:"));
        txtEspecialidad = new JTextField();
        panelIzquierdo.add(txtEspecialidad);

        panelIzquierdo.add(new JLabel("Nivel:"));
        cbNivel = new JComboBox<String>(new String[]{"Pregrado", "Posgrado", "Ninguno"});
        panelIzquierdo.add(cbNivel);

        chkCabezaHogar = new JCheckBox("Cabeza de hogar");
        panelIzquierdo.add(chkCabezaHogar);
        panelIzquierdo.add(new JLabel());

        add(panelIzquierdo, BorderLayout.WEST);
    }

    private void crearPanelDerecho() {
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
        panelDerecho.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 15));

        panelDerecho.add(crearPanelBotones());
        panelDerecho.add(Box.createVerticalStrut(15));
        panelDerecho.add(crearPanelBonoSalud());
        panelDerecho.add(Box.createVerticalStrut(15));
        panelDerecho.add(crearPanelBonoDocente());
        panelDerecho.add(Box.createVerticalStrut(15));
        panelDerecho.add(crearPanelBonoIndependiente());

        add(panelDerecho, BorderLayout.CENTER);
    }

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new GridLayout(1, 3, 15, 0));
        panel.setBorder(BorderFactory.createTitledBorder("Panel botones"));

        btnGuardar = new JButton("Guardar");
        btnLimpiar = new JButton("Limpiar");
        btnBuscar = new JButton("Buscar");

        panel.add(btnGuardar);
        panel.add(btnLimpiar);
        panel.add(btnBuscar);

        return panel;
    }

    private JPanel crearPanelBonoSalud() {
        panelSalud = new JPanel(new GridLayout(2, 2, 10, 10));
        panelSalud.setBorder(BorderFactory.createTitledBorder("Distribución Bono Prof Salud"));

        panelSalud.add(new JLabel("Elemento Bioseguridad:"));
        txtElementoBioseguridad = new JTextField();
        panelSalud.add(txtElementoBioseguridad);

        panelSalud.add(new JLabel("Medicina:"));
        txtMedicinaSalud = new JTextField();
        panelSalud.add(txtMedicinaSalud);

        return panelSalud;
    }

    private JPanel crearPanelBonoDocente() {
        panelDocente = new JPanel(new GridLayout(2, 2, 10, 10));
        panelDocente.setBorder(BorderFactory.createTitledBorder("Distribución Bono Docente"));

        panelDocente.add(new JLabel("Implementos Tecnológicos:"));
        txtImplementosTecnologicos = new JTextField();
        panelDocente.add(txtImplementosTecnologicos);

        panelDocente.add(new JLabel("Servicio Internet / Energía:"));
        txtInternetEnergia = new JTextField();
        panelDocente.add(txtInternetEnergia);

        return panelDocente;
    }

    private JPanel crearPanelBonoIndependiente() {
        panelIndependiente = new JPanel(new GridLayout(2, 2, 10, 10));
        panelIndependiente.setBorder(BorderFactory.createTitledBorder("Distribución Bono Persona Independiente"));

        panelIndependiente.add(new JLabel("Medicina:"));
        txtMedicinaIndependiente = new JTextField();
        panelIndependiente.add(txtMedicinaIndependiente);

        panelIndependiente.add(new JLabel("Canasta Familiar:"));
        txtCanastaFamiliar = new JTextField();
        panelIndependiente.add(txtCanastaFamiliar);

        return panelIndependiente;
    }

    private void crearCampoTexto() {
        campoTexto = new JTextArea(5, 40);
        campoTexto.setEditable(false);
        campoTexto.setLineWrap(true);
        campoTexto.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(campoTexto);
        scroll.setBorder(BorderFactory.createTitledBorder("Mensajes"));
        add(scroll, BorderLayout.SOUTH);
    }

    public JComboBox<TipoDocumento> getCbTipoDocumento() { return cbTipoDocumento; }
    public JTextField getTxtDocumento() { return txtDocumento; }
    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtApellido() { return txtApellido; }
    public JTextField getTxtDireccion() { return txtDireccion; }
    public JTextField getTxtTelefono() { return txtTelefono; }
    public JTextField getTxtEdad() { return txtEdad; }
    public JTextField getTxtEstrato() { return txtEstrato; }
    public JTextField getTxtEstadoCivil() { return txtEstadoCivil; }
    public JComboBox<String> getCbTipoPersona() { return cbTipoPersona; }
    public JTextField getTxtInstitucion() { return txtInstitucion; }
    public JTextField getTxtEspecialidad() { return txtEspecialidad; }
    public JComboBox<String> getCbNivel() { return cbNivel; }
    public JCheckBox getChkCabezaHogar() { return chkCabezaHogar; }
    public JButton getBtnGuardar() { return btnGuardar; }
    public JButton getBtnLimpiar() { return btnLimpiar; }
    public JButton getBtnBuscar() { return btnBuscar; }
    public JPanel getPanelSalud() { return panelSalud; }
    public JTextField getTxtElementoBioseguridad() { return txtElementoBioseguridad; }
    public JTextField getTxtMedicinaSalud() { return txtMedicinaSalud; }
    public JPanel getPanelDocente() { return panelDocente; }
    public JTextField getTxtImplementosTecnologicos() { return txtImplementosTecnologicos; }
    public JTextField getTxtInternetEnergia() { return txtInternetEnergia; }
    public JPanel getPanelIndependiente() { return panelIndependiente; }
    public JTextField getTxtMedicinaIndependiente() { return txtMedicinaIndependiente; }
    public JTextField getTxtCanastaFamiliar() { return txtCanastaFamiliar; }
    public JTextArea getCampoTexto() { return campoTexto; }
}
