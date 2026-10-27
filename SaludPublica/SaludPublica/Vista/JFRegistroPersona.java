package Vista;

import Modelo.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class JFRegistroPersona extends JFrame
{
    public JComboBox<TipoDocumento> cbTipoDocumento;
    public JTextField txtDocumento;
    public JTextField txtNombre;
    public JTextField txtApellido;
    public JTextField txtDireccion;
    public JTextField txtTelefono;
    public JTextField txtEdad;
    public JTextField txtEstrato;
    public JTextField txtEstadoCivil;
    public JComboBox<String> cbTipoPersona;
    public JTextField txtInstitucion;
    public JTextField txtEspecialidad;
    public JComboBox<String> cbNivel;
    public JCheckBox chkCabezaHogar;

    private ArrayList<Persona> personas = new ArrayList<Persona>();

    public JButton btnGuardar;
    public JButton btnLimpiar;
    public JButton btnBuscar;

    public JPanel panelSalud;
    public JTextField txtElementoBioseguridad;
    public JTextField txtMedicinaSalud;

    public JPanel panelDocente;
    public JTextField txtImplementosTecnologicos;
    public JTextField txtInternetEnergia;

    public JPanel panelIndependiente;
    public JTextField txtMedicinaIndependiente;
    public JTextField txtCanastaFamiliar;

    public JFRegistroPersona() {
        setTitle("Gestión de Distribución de Bonos");
        setSize(950, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));

        crearPanelIzquierdo();
        crearPanelDerecho();

        cbTipoPersona.addActionListener(e -> habilitarSegunTipo());
        btnGuardar.addActionListener(e -> guardar());
        btnBuscar.addActionListener(e -> buscarYMostrar());
        btnLimpiar.addActionListener(e -> limpiar());
        limpiar();

        setVisible(true);
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

    public void habilitarSegunTipo() {
        String tipo = (String) cbTipoPersona.getSelectedItem();
        boolean salud = "Salud".equals(tipo);
        boolean docente = "Docente".equals(tipo);
        boolean independiente = "Independiente".equals(tipo);

        txtInstitucion.setEnabled(salud || docente);
        txtEspecialidad.setEnabled(salud);
        cbNivel.setEnabled(docente);

        if (!(salud || docente)) txtInstitucion.setText("");
        if (!salud) txtEspecialidad.setText("");
        if (!docente) cbNivel.setSelectedIndex(-1);

        habilitarPanel(panelSalud, salud);
        habilitarPanel(panelDocente, docente);
        habilitarPanel(panelIndependiente, independiente);
    }

    private void habilitarPanel(JPanel panel, boolean habilitar) {
        panel.setEnabled(habilitar);
        for (Component c : panel.getComponents()) {
            c.setEnabled(habilitar);
            if (!habilitar && c instanceof JTextField) {
                ((JTextField) c).setText("");
            }
        }
    }

    public void limpiar() {
        cbTipoDocumento.setSelectedIndex(-1);
        txtDocumento.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtEdad.setText("");
        txtEstrato.setText("");
        txtEstadoCivil.setText("");
        chkCabezaHogar.setSelected(false);
        cbTipoPersona.setSelectedIndex(-1);
        habilitarSegunTipo();
    }

    public Persona buscar(String documento) {
        for (Persona p : personas) {
            if (p.getNumDocumento().equals(documento)) {
                return p;
            }
        }
        return null;
    }

    private void guardar() {
        try {
            Persona p = construirPersona();
            if (p == null) return;

            if (!p.distribucionValida()) {
                mensaje("La distribución ($" + formato(p.getTotalGastado())
                      + ") supera el bono asignado ($" + formato(p.getBono().getMonto()) + ")");
                return;
            }

            personas.add(p);
            mensaje("Guardado: " + p.getTipo() + "\nPersonas registradas: " + personas.size());
            limpiar();
        } catch (NumberFormatException ex) {
            mensaje("Edad, estrato y montos deben ser numéricos");
        } catch (IllegalArgumentException ex) {
            mensaje(ex.getMessage());
        }
    }

    private Persona construirPersona() {
        String tipo = (String) cbTipoPersona.getSelectedItem();
        TipoDocumento td = (TipoDocumento) cbTipoDocumento.getSelectedItem();
        String doc = txtDocumento.getText().trim();
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String estadoCivil = txtEstadoCivil.getText().trim();

        if (td == null || tipo == null || doc.isEmpty() || nombre.isEmpty() || apellido.isEmpty()
                || direccion.isEmpty() || telefono.isEmpty() || estadoCivil.isEmpty()) {
            mensaje("Complete todos los datos básicos y seleccione el tipo");
            return null;
        }

        int edad = Integer.parseInt(txtEdad.getText().trim());
        int estrato = Integer.parseInt(txtEstrato.getText().trim());

        if (edad < 0 || edad > 120) {
            mensaje("Edad no válida");
            return null;
        }
        if (estrato < 1 || estrato > 6) {
            mensaje("El estrato debe estar entre 1 y 6");
            return null;
        }
        if (buscar(doc) != null) {
            mensaje("Ya existe una persona con ese documento");
            return null;
        }

        boolean cabeza = chkCabezaHogar.isSelected();

        if (tipo.equals("Salud")) {
            String inst = txtInstitucion.getText().trim();
            String esp = txtEspecialidad.getText().trim();
            if (inst.isEmpty() || esp.isEmpty()) {
                mensaje("Ingrese institución y especialidad");
                return null;
            }
            return new ProfesionalSalud(td, doc, nombre, apellido, direccion, telefono, edad,
                    estadoCivil, estrato, cabeza, inst, esp,
                    new ElementoBioseguridad(monto(txtElementoBioseguridad)),
                    new Medicina(monto(txtMedicinaSalud)));
        }

        if (tipo.equals("Docente")) {
            String inst = txtInstitucion.getText().trim();
            String nivel = (String) cbNivel.getSelectedItem();
            if (inst.isEmpty() || nivel == null) {
                mensaje("Ingrese institución y nivel educativo");
                return null;
            }
            return new Docente(td, doc, nombre, apellido, direccion, telefono, edad,
                    estadoCivil, estrato, cabeza, inst, nivel,
                    new ImplementoTecnologico(monto(txtImplementosTecnologicos)),
                    new Servicio(monto(txtInternetEnergia)));
        }

        if (estrato > 2) {
            mensaje("La persona independiente debe ser de estrato 1 o 2");
            return null;
        }
        return new Ciudadano(td, doc, nombre, apellido, direccion, telefono, edad,
                estadoCivil, estrato, cabeza,
                new Medicina(monto(txtMedicinaIndependiente)),
                new CanastaFamiliar(monto(txtCanastaFamiliar)));
    }

    private void buscarYMostrar() {
        String doc = txtDocumento.getText().trim();
        if (doc.isEmpty()) {
            mensaje("Ingrese el número de documento a buscar");
            return;
        }

        Persona p = buscar(doc);
        if (p == null) {
            mensaje("No se encontró ninguna persona con documento " + doc);
            return;
        }

        String tipo = "Independiente";
        if (p instanceof ProfesionalSalud) tipo = "Salud";
        else if (p instanceof Docente) tipo = "Docente";

        cbTipoPersona.setSelectedItem(tipo);
        cbTipoDocumento.setSelectedItem(p.getTipoDocumento());
        txtDocumento.setText(p.getNumDocumento());
        txtNombre.setText(p.getNombre());
        txtApellido.setText(p.getApellido());
        txtDireccion.setText(p.getDireccion());
        txtTelefono.setText(p.getTelefono());
        txtEdad.setText(String.valueOf(p.getEdad()));
        txtEstrato.setText(String.valueOf(p.getEstrato()));
        txtEstadoCivil.setText(p.getEstadoCivil());
        chkCabezaHogar.setSelected(p.getCabezaHogar());

        if (p instanceof ProfesionalSalud) {
            ProfesionalSalud ps = (ProfesionalSalud) p;
            txtInstitucion.setText(ps.getInstSalud());
            txtEspecialidad.setText(ps.getEspecialidad());
            txtElementoBioseguridad.setText(formato(ps.getElemento().getMonto()));
            txtMedicinaSalud.setText(formato(ps.getMedicina().getMonto()));
        } else if (p instanceof Docente) {
            Docente d = (Docente) p;
            txtInstitucion.setText(d.getInstEducativa());
            cbNivel.setSelectedItem(d.getNivelEducativo());
            txtImplementosTecnologicos.setText(formato(d.getImplemento().getMonto()));
            txtInternetEnergia.setText(formato(d.getServicio().getMonto()));
        } else {
            Ciudadano c = (Ciudadano) p;
            txtMedicinaIndependiente.setText(formato(c.getMedicina().getMonto()));
            txtCanastaFamiliar.setText(formato(c.getCanasta().getMonto()));
        }

        mensaje(p.toString());
    }

    private double monto(JTextField campo) {
        String texto = campo.getText().trim();
        if (texto.isEmpty()) return 0;
        double valor = Double.parseDouble(texto);
        if (valor < 0) {
            throw new IllegalArgumentException("Los montos no pueden ser negativos");
        }
        return valor;
    }

    private String formato(double valor) {
        if (valor == (long) valor) return String.valueOf((long) valor);
        return String.valueOf(valor);
    }

    private void mensaje(String texto) {
        JOptionPane.showMessageDialog(this, texto);
    }
}
