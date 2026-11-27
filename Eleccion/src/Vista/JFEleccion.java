package Vista;

import Modelo.TipoAnimal;

public class JFEleccion extends javax.swing.JFrame {

    public JFEleccion() {
        initComponents();

        Integer[] grados = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        cmbGradoPersonero.setModel(new javax.swing.DefaultComboBoxModel<>(grados));
        cmbGradoRepresentante.setModel(new javax.swing.DefaultComboBoxModel<>(grados));
        cmbGradoFormula.setModel(new javax.swing.DefaultComboBoxModel<>(grados));
        cmbGeneroMascota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Macho", "Hembra"}));
        cmbTipoMascota.setModel(new javax.swing.DefaultComboBoxModel<>(TipoAnimal.values()));
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlPersonero = new javax.swing.JPanel();
        pnlCandidatoPersonero = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombrePersonero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidoPersonero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbGradoPersonero = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtGrupoPersonero = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtLemaPersonero = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTarjetonPersonero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtVotosPersonero = new javax.swing.JTextField();
        pnlMascota = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtIdMascota = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNombreMascota = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbGeneroMascota = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtEdadMascota = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCualidadesMascota = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cmbTipoMascota = new javax.swing.JComboBox<>();
        btnAgregarPersonero = new javax.swing.JButton();
        pnlRepresentante = new javax.swing.JPanel();
        pnlCandidatoRepresentante = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtNombreRepresentante = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtApellidoRepresentante = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cmbGradoRepresentante = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtGrupoRepresentante = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtLemaRepresentante = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTarjetonRepresentante = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtVotosRepresentante = new javax.swing.JTextField();
        pnlFormula = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtNombreFormula = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtApellidoFormula = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cmbGradoFormula = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        txtGrupoFormula = new javax.swing.JTextField();
        btnAgregarRepresentante = new javax.swing.JButton();
        pnlVotos = new javax.swing.JPanel();
        pnlDatosVotos = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtVotosNulos = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtVotosBlancos = new javax.swing.JTextField();
        btnGuardarVotos = new javax.swing.JButton();
        pnlResultados = new javax.swing.JPanel();
        btnVotosPorCandidato = new javax.swing.JButton();
        btnPersoneroElegido = new javax.swing.JButton();
        btnMenorVotacion = new javax.swing.JButton();
        btnPoblacionElectoral = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSalida = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Elecciones 2021 - Colegio La alegría de estudiar");

        pnlCandidatoPersonero.setBorder(javax.swing.BorderFactory.createTitledBorder("Candidato"));
        jLabel1.setText("Nombre");
        jLabel2.setText("Apellido");
        jLabel3.setText("Grado");
        jLabel4.setText("Grupo");
        jLabel5.setText("Lema");
        jLabel6.setText("N° tarjetón");
        jLabel7.setText("Votos");
        pnlMascota.setBorder(javax.swing.BorderFactory.createTitledBorder("Mascota"));
        jLabel8.setText("Identificación");
        jLabel9.setText("Nombre");
        jLabel10.setText("Género");
        jLabel11.setText("Edad");
        jLabel12.setText("Cualidades");
        jLabel13.setText("Tipo de animal");
        btnAgregarPersonero.setText("Agregar personero");
        pnlCandidatoRepresentante.setBorder(javax.swing.BorderFactory.createTitledBorder("Candidato"));
        jLabel14.setText("Nombre");
        jLabel15.setText("Apellido");
        jLabel16.setText("Grado");
        jLabel17.setText("Grupo");
        jLabel18.setText("Lema");
        jLabel19.setText("N° tarjetón");
        jLabel20.setText("Votos");
        pnlFormula.setBorder(javax.swing.BorderFactory.createTitledBorder("Fórmula"));
        jLabel21.setText("Nombre");
        jLabel22.setText("Apellido");
        jLabel23.setText("Grado");
        jLabel24.setText("Grupo");
        btnAgregarRepresentante.setText("Agregar representante");
        pnlDatosVotos.setBorder(javax.swing.BorderFactory.createTitledBorder("Votos"));
        jLabel25.setText("Votos nulos");
        jLabel26.setText("Votos en blanco");
        btnGuardarVotos.setText("Guardar votos");
        btnVotosPorCandidato.setText("Total de votos por candidato");
        btnPersoneroElegido.setText("Personero elegido");
        btnMenorVotacion.setText("Personero con menor votación");
        btnPoblacionElectoral.setText("Población electoral");
        txtSalida.setEditable(false);
        txtSalida.setColumns(20);
        txtSalida.setRows(5);
        javax.swing.GroupLayout pnlCandidatoPersoneroLayout = new javax.swing.GroupLayout(pnlCandidatoPersonero);
        pnlCandidatoPersonero.setLayout(pnlCandidatoPersoneroLayout);
        pnlCandidatoPersoneroLayout.setHorizontalGroup(
            pnlCandidatoPersoneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCandidatoPersoneroLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(pnlCandidatoPersoneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(pnlCandidatoPersoneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombrePersonero, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(txtApellidoPersonero, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(cmbGradoPersonero, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(txtGrupoPersonero, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(txtLemaPersonero, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(txtTarjetonPersonero, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(txtVotosPersonero, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addGap(10, 10, 10))
        );
        pnlCandidatoPersoneroLayout.setVerticalGroup(
            pnlCandidatoPersoneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCandidatoPersoneroLayout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addGroup(pnlCandidatoPersoneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombrePersonero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlCandidatoPersoneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApellidoPersonero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlCandidatoPersoneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbGradoPersonero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlCandidatoPersoneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGrupoPersonero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlCandidatoPersoneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtLemaPersonero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlCandidatoPersoneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTarjetonPersonero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlCandidatoPersoneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtVotosPersonero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout pnlMascotaLayout = new javax.swing.GroupLayout(pnlMascota);
        pnlMascota.setLayout(pnlMascotaLayout);
        pnlMascotaLayout.setHorizontalGroup(
            pnlMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlMascotaLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(pnlMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(pnlMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtIdMascota, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(txtNombreMascota, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(cmbGeneroMascota, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(txtEdadMascota, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(txtCualidadesMascota, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(cmbTipoMascota, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addGap(10, 10, 10))
        );
        pnlMascotaLayout.setVerticalGroup(
            pnlMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlMascotaLayout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addGroup(pnlMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombreMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbGeneroMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEdadMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCualidadesMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbTipoMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout pnlPersoneroLayout = new javax.swing.GroupLayout(pnlPersonero);
        pnlPersonero.setLayout(pnlPersoneroLayout);
        pnlPersoneroLayout.setHorizontalGroup(
            pnlPersoneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPersoneroLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(pnlPersoneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlPersoneroLayout.createSequentialGroup()
                            .addComponent(pnlCandidatoPersonero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(10, 10, 10)
                            .addComponent(pnlMascota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(btnAgregarPersonero, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10))
        );
        pnlPersoneroLayout.setVerticalGroup(
            pnlPersoneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPersoneroLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(pnlPersoneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlCandidatoPersonero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addComponent(btnAgregarPersonero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCandidatoRepresentanteLayout = new javax.swing.GroupLayout(pnlCandidatoRepresentante);
        pnlCandidatoRepresentante.setLayout(pnlCandidatoRepresentanteLayout);
        pnlCandidatoRepresentanteLayout.setHorizontalGroup(
            pnlCandidatoRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCandidatoRepresentanteLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(pnlCandidatoRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(pnlCandidatoRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombreRepresentante, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(txtApellidoRepresentante, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(cmbGradoRepresentante, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(txtGrupoRepresentante, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(txtLemaRepresentante, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(txtTarjetonRepresentante, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(txtVotosRepresentante, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addGap(10, 10, 10))
        );
        pnlCandidatoRepresentanteLayout.setVerticalGroup(
            pnlCandidatoRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCandidatoRepresentanteLayout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addGroup(pnlCandidatoRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombreRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlCandidatoRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApellidoRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlCandidatoRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbGradoRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlCandidatoRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGrupoRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlCandidatoRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtLemaRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlCandidatoRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTarjetonRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlCandidatoRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtVotosRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout pnlFormulaLayout = new javax.swing.GroupLayout(pnlFormula);
        pnlFormula.setLayout(pnlFormulaLayout);
        pnlFormulaLayout.setHorizontalGroup(
            pnlFormulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFormulaLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(pnlFormulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(pnlFormulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombreFormula, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(txtApellidoFormula, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(cmbGradoFormula, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(txtGrupoFormula, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addGap(10, 10, 10))
        );
        pnlFormulaLayout.setVerticalGroup(
            pnlFormulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFormulaLayout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addGroup(pnlFormulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombreFormula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlFormulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApellidoFormula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlFormulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbGradoFormula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlFormulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGrupoFormula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout pnlRepresentanteLayout = new javax.swing.GroupLayout(pnlRepresentante);
        pnlRepresentante.setLayout(pnlRepresentanteLayout);
        pnlRepresentanteLayout.setHorizontalGroup(
            pnlRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlRepresentanteLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(pnlRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlRepresentanteLayout.createSequentialGroup()
                            .addComponent(pnlCandidatoRepresentante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(10, 10, 10)
                            .addComponent(pnlFormula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(btnAgregarRepresentante, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10))
        );
        pnlRepresentanteLayout.setVerticalGroup(
            pnlRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlRepresentanteLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(pnlRepresentanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlCandidatoRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlFormula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addComponent(btnAgregarRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlDatosVotosLayout = new javax.swing.GroupLayout(pnlDatosVotos);
        pnlDatosVotos.setLayout(pnlDatosVotosLayout);
        pnlDatosVotosLayout.setHorizontalGroup(
            pnlDatosVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDatosVotosLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(pnlDatosVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(pnlDatosVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtVotosNulos, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(txtVotosBlancos, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addGap(10, 10, 10))
        );
        pnlDatosVotosLayout.setVerticalGroup(
            pnlDatosVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDatosVotosLayout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addGroup(pnlDatosVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtVotosNulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(pnlDatosVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtVotosBlancos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout pnlVotosLayout = new javax.swing.GroupLayout(pnlVotos);
        pnlVotos.setLayout(pnlVotosLayout);
        pnlVotosLayout.setHorizontalGroup(
            pnlVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlVotosLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(pnlVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlDatosVotos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarVotos, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10))
        );
        pnlVotosLayout.setVerticalGroup(
            pnlVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlVotosLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(pnlDatosVotos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(btnGuardarVotos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlResultadosLayout = new javax.swing.GroupLayout(pnlResultados);
        pnlResultados.setLayout(pnlResultadosLayout);
        pnlResultadosLayout.setHorizontalGroup(
            pnlResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlResultadosLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(pnlResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnVotosPorCandidato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPersoneroElegido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMenorVotacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPoblacionElectoral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(10, 10, 10))
        );
        pnlResultadosLayout.setVerticalGroup(
            pnlResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlResultadosLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(btnVotosPorCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(btnPersoneroElegido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(btnMenorVotacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(btnPoblacionElectoral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(txtSalida);

        jTabbedPane1.addTab("Personero", pnlPersonero);
        jTabbedPane1.addTab("Representante de grado", pnlRepresentante);
        jTabbedPane1.addTab("Votos nulos y en blanco", pnlVotos);
        jTabbedPane1.addTab("Resultados", pnlResultados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(10, 10, 10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void limpiarPersonero() {
        txtNombrePersonero.setText("");
        txtApellidoPersonero.setText("");
        cmbGradoPersonero.setSelectedIndex(0);
        txtGrupoPersonero.setText("");
        txtLemaPersonero.setText("");
        txtTarjetonPersonero.setText("");
        txtVotosPersonero.setText("");
        txtIdMascota.setText("");
        txtNombreMascota.setText("");
        cmbGeneroMascota.setSelectedIndex(0);
        txtEdadMascota.setText("");
        txtCualidadesMascota.setText("");
        cmbTipoMascota.setSelectedIndex(0);
    }

    public void limpiarRepresentante() {
        txtNombreRepresentante.setText("");
        txtApellidoRepresentante.setText("");
        cmbGradoRepresentante.setSelectedIndex(0);
        txtGrupoRepresentante.setText("");
        txtLemaRepresentante.setText("");
        txtTarjetonRepresentante.setText("");
        txtVotosRepresentante.setText("");
        txtNombreFormula.setText("");
        txtApellidoFormula.setText("");
        cmbGradoFormula.setSelectedIndex(0);
        txtGrupoFormula.setText("");
    }

    public javax.swing.JTextField getTxtNombrePersonero() {
        return txtNombrePersonero;
    }

    public javax.swing.JTextField getTxtApellidoPersonero() {
        return txtApellidoPersonero;
    }

    public javax.swing.JComboBox<Integer> getCmbGradoPersonero() {
        return cmbGradoPersonero;
    }

    public javax.swing.JTextField getTxtGrupoPersonero() {
        return txtGrupoPersonero;
    }

    public javax.swing.JTextField getTxtLemaPersonero() {
        return txtLemaPersonero;
    }

    public javax.swing.JTextField getTxtTarjetonPersonero() {
        return txtTarjetonPersonero;
    }

    public javax.swing.JTextField getTxtVotosPersonero() {
        return txtVotosPersonero;
    }

    public javax.swing.JTextField getTxtIdMascota() {
        return txtIdMascota;
    }

    public javax.swing.JTextField getTxtNombreMascota() {
        return txtNombreMascota;
    }

    public javax.swing.JComboBox<String> getCmbGeneroMascota() {
        return cmbGeneroMascota;
    }

    public javax.swing.JTextField getTxtEdadMascota() {
        return txtEdadMascota;
    }

    public javax.swing.JTextField getTxtCualidadesMascota() {
        return txtCualidadesMascota;
    }

    public javax.swing.JComboBox<Modelo.TipoAnimal> getCmbTipoMascota() {
        return cmbTipoMascota;
    }

    public javax.swing.JButton getBtnAgregarPersonero() {
        return btnAgregarPersonero;
    }

    public javax.swing.JTextField getTxtNombreRepresentante() {
        return txtNombreRepresentante;
    }

    public javax.swing.JTextField getTxtApellidoRepresentante() {
        return txtApellidoRepresentante;
    }

    public javax.swing.JComboBox<Integer> getCmbGradoRepresentante() {
        return cmbGradoRepresentante;
    }

    public javax.swing.JTextField getTxtGrupoRepresentante() {
        return txtGrupoRepresentante;
    }

    public javax.swing.JTextField getTxtLemaRepresentante() {
        return txtLemaRepresentante;
    }

    public javax.swing.JTextField getTxtTarjetonRepresentante() {
        return txtTarjetonRepresentante;
    }

    public javax.swing.JTextField getTxtVotosRepresentante() {
        return txtVotosRepresentante;
    }

    public javax.swing.JTextField getTxtNombreFormula() {
        return txtNombreFormula;
    }

    public javax.swing.JTextField getTxtApellidoFormula() {
        return txtApellidoFormula;
    }

    public javax.swing.JComboBox<Integer> getCmbGradoFormula() {
        return cmbGradoFormula;
    }

    public javax.swing.JTextField getTxtGrupoFormula() {
        return txtGrupoFormula;
    }

    public javax.swing.JButton getBtnAgregarRepresentante() {
        return btnAgregarRepresentante;
    }

    public javax.swing.JTextField getTxtVotosNulos() {
        return txtVotosNulos;
    }

    public javax.swing.JTextField getTxtVotosBlancos() {
        return txtVotosBlancos;
    }

    public javax.swing.JButton getBtnGuardarVotos() {
        return btnGuardarVotos;
    }

    public javax.swing.JButton getBtnVotosPorCandidato() {
        return btnVotosPorCandidato;
    }

    public javax.swing.JButton getBtnPersoneroElegido() {
        return btnPersoneroElegido;
    }

    public javax.swing.JButton getBtnMenorVotacion() {
        return btnMenorVotacion;
    }

    public javax.swing.JButton getBtnPoblacionElectoral() {
        return btnPoblacionElectoral;
    }

    public javax.swing.JTextArea getTxtSalida() {
        return txtSalida;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPersonero;
    private javax.swing.JButton btnAgregarRepresentante;
    private javax.swing.JButton btnGuardarVotos;
    private javax.swing.JButton btnMenorVotacion;
    private javax.swing.JButton btnPersoneroElegido;
    private javax.swing.JButton btnPoblacionElectoral;
    private javax.swing.JButton btnVotosPorCandidato;
    private javax.swing.JComboBox<String> cmbGeneroMascota;
    private javax.swing.JComboBox<Integer> cmbGradoFormula;
    private javax.swing.JComboBox<Integer> cmbGradoPersonero;
    private javax.swing.JComboBox<Integer> cmbGradoRepresentante;
    private javax.swing.JComboBox<Modelo.TipoAnimal> cmbTipoMascota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pnlCandidatoPersonero;
    private javax.swing.JPanel pnlCandidatoRepresentante;
    private javax.swing.JPanel pnlDatosVotos;
    private javax.swing.JPanel pnlFormula;
    private javax.swing.JPanel pnlMascota;
    private javax.swing.JPanel pnlPersonero;
    private javax.swing.JPanel pnlRepresentante;
    private javax.swing.JPanel pnlResultados;
    private javax.swing.JPanel pnlVotos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea txtSalida;
    private javax.swing.JTextField txtApellidoFormula;
    private javax.swing.JTextField txtApellidoPersonero;
    private javax.swing.JTextField txtApellidoRepresentante;
    private javax.swing.JTextField txtCualidadesMascota;
    private javax.swing.JTextField txtEdadMascota;
    private javax.swing.JTextField txtGrupoFormula;
    private javax.swing.JTextField txtGrupoPersonero;
    private javax.swing.JTextField txtGrupoRepresentante;
    private javax.swing.JTextField txtIdMascota;
    private javax.swing.JTextField txtLemaPersonero;
    private javax.swing.JTextField txtLemaRepresentante;
    private javax.swing.JTextField txtNombreFormula;
    private javax.swing.JTextField txtNombreMascota;
    private javax.swing.JTextField txtNombrePersonero;
    private javax.swing.JTextField txtNombreRepresentante;
    private javax.swing.JTextField txtTarjetonPersonero;
    private javax.swing.JTextField txtTarjetonRepresentante;
    private javax.swing.JTextField txtVotosBlancos;
    private javax.swing.JTextField txtVotosNulos;
    private javax.swing.JTextField txtVotosPersonero;
    private javax.swing.JTextField txtVotosRepresentante;
    // End of variables declaration//GEN-END:variables
}
