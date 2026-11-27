package Controlador;

import Modelo.*;
import Vista.JFEleccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Control implements ActionListener {

    private JFEleccion vista;
    private Gestor modelo;

    public Control(JFEleccion vista, Gestor modelo) {
        this.vista = vista;
        this.modelo = modelo;

        this.vista.getBtnAgregarPersonero().addActionListener(this);
        this.vista.getBtnAgregarRepresentante().addActionListener(this);
        this.vista.getBtnGuardarVotos().addActionListener(this);
        this.vista.getBtnVotosPorCandidato().addActionListener(this);
        this.vista.getBtnPersoneroElegido().addActionListener(this);
        this.vista.getBtnMenorVotacion().addActionListener(this);
        this.vista.getBtnPoblacionElectoral().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vista.getBtnAgregarPersonero()) {
            agregarPersonero();
        } else if (source == vista.getBtnAgregarRepresentante()) {
            agregarRepresentante();
        } else if (source == vista.getBtnGuardarVotos()) {
            guardarVotos();
        } else if (source == vista.getBtnVotosPorCandidato()) {
            mostrarVotosPorCandidato();
        } else if (source == vista.getBtnPersoneroElegido()) {
            mostrarPersoneroElegido();
        } else if (source == vista.getBtnMenorVotacion()) {
            mostrarMenorVotacion();
        } else if (source == vista.getBtnPoblacionElectoral()) {
            mostrarPoblacionElectoral();
        }
    }

    private void mostrar(String mensaje) {
        vista.getTxtSalida().setText(mensaje);
    }

    private void agregarPersonero() {
        String nombre = vista.getTxtNombrePersonero().getText().trim();
        String apellido = vista.getTxtApellidoPersonero().getText().trim();
        String grupo = vista.getTxtGrupoPersonero().getText().trim();
        String lema = vista.getTxtLemaPersonero().getText().trim();
        String tarjetonTexto = vista.getTxtTarjetonPersonero().getText().trim();
        String votosTexto = vista.getTxtVotosPersonero().getText().trim();
        String idMascota = vista.getTxtIdMascota().getText().trim();
        String nombreMascota = vista.getTxtNombreMascota().getText().trim();
        String edadTexto = vista.getTxtEdadMascota().getText().trim();
        String cualidades = vista.getTxtCualidadesMascota().getText().trim();

        if (nombre.isEmpty() || apellido.isEmpty() || grupo.isEmpty() || lema.isEmpty()
                || tarjetonTexto.isEmpty() || votosTexto.isEmpty() || idMascota.isEmpty()
                || nombreMascota.isEmpty() || edadTexto.isEmpty() || cualidades.isEmpty()) {
            mostrar("Completa todos los campos del personero y de su mascota");
            return;
        }

        int tarjeton;
        int votos;
        int edad;
        try {
            tarjeton = Integer.parseInt(tarjetonTexto);
            votos = Integer.parseInt(votosTexto);
            edad = Integer.parseInt(edadTexto);
        } catch (NumberFormatException ex) {
            mostrar("El tarjetón, los votos y la edad deben ser números enteros");
            return;
        }

        if (tarjeton <= 0 || votos < 0 || edad < 0) {
            mostrar("El tarjetón debe ser mayor a 0 y los votos y la edad no pueden ser negativos");
            return;
        }

        int grado = (Integer) vista.getCmbGradoPersonero().getSelectedItem();
        String genero = (String) vista.getCmbGeneroMascota().getSelectedItem();
        TipoAnimal tipo = (TipoAnimal) vista.getCmbTipoMascota().getSelectedItem();

        Mascota mascota = new Mascota(idMascota, nombreMascota, genero, edad, cualidades, tipo);
        CandidatoPersonero personero = new CandidatoPersonero(nombre, apellido, grado, grupo, lema, tarjeton, votos, mascota);

        if (modelo.agregarPersonero(personero)) {
            mostrar("Personero agregado correctamente");
            vista.limpiarPersonero();
        } else {
            mostrar("Ya existe un personero con ese número de tarjetón");
        }
    }

    private void agregarRepresentante() {
        String nombre = vista.getTxtNombreRepresentante().getText().trim();
        String apellido = vista.getTxtApellidoRepresentante().getText().trim();
        String grupo = vista.getTxtGrupoRepresentante().getText().trim();
        String lema = vista.getTxtLemaRepresentante().getText().trim();
        String tarjetonTexto = vista.getTxtTarjetonRepresentante().getText().trim();
        String votosTexto = vista.getTxtVotosRepresentante().getText().trim();
        String nombreFormula = vista.getTxtNombreFormula().getText().trim();
        String apellidoFormula = vista.getTxtApellidoFormula().getText().trim();
        String grupoFormula = vista.getTxtGrupoFormula().getText().trim();

        if (nombre.isEmpty() || apellido.isEmpty() || grupo.isEmpty() || lema.isEmpty()
                || tarjetonTexto.isEmpty() || votosTexto.isEmpty() || nombreFormula.isEmpty()
                || apellidoFormula.isEmpty() || grupoFormula.isEmpty()) {
            mostrar("Completa todos los campos del representante y de su fórmula");
            return;
        }

        int tarjeton;
        int votos;
        try {
            tarjeton = Integer.parseInt(tarjetonTexto);
            votos = Integer.parseInt(votosTexto);
        } catch (NumberFormatException ex) {
            mostrar("El tarjetón y los votos deben ser números enteros");
            return;
        }

        if (tarjeton <= 0 || votos < 0) {
            mostrar("El tarjetón debe ser mayor a 0 y los votos no pueden ser negativos");
            return;
        }

        int grado = (Integer) vista.getCmbGradoRepresentante().getSelectedItem();
        int gradoFormula = (Integer) vista.getCmbGradoFormula().getSelectedItem();

        Estudiante formula = new Estudiante(nombreFormula, apellidoFormula, gradoFormula, grupoFormula);
        CandidatoRepresentante representante = new CandidatoRepresentante(nombre, apellido, grado, grupo, lema, tarjeton, votos, formula);

        if (modelo.agregarRepresentante(representante)) {
            mostrar("Representante agregado correctamente");
            vista.limpiarRepresentante();
        } else {
            mostrar("Ya existe un representante con ese número de tarjetón");
        }
    }

    private void guardarVotos() {
        String nulosTexto = vista.getTxtVotosNulos().getText().trim();
        String blancosTexto = vista.getTxtVotosBlancos().getText().trim();

        if (nulosTexto.isEmpty() || blancosTexto.isEmpty()) {
            mostrar("Completa los votos nulos y los votos en blanco");
            return;
        }

        int nulos;
        int blancos;
        try {
            nulos = Integer.parseInt(nulosTexto);
            blancos = Integer.parseInt(blancosTexto);
        } catch (NumberFormatException ex) {
            mostrar("Los votos nulos y en blanco deben ser números enteros");
            return;
        }

        if (nulos < 0 || blancos < 0) {
            mostrar("Los votos no pueden ser negativos");
            return;
        }

        modelo.setVotosNulos(nulos);
        modelo.setVotosBlancos(blancos);
        mostrar("Votos nulos y en blanco guardados correctamente");
    }

    private void mostrarVotosPorCandidato() {
        if (modelo.getPersoneros().isEmpty() && modelo.getRepresentantes().isEmpty()) {
            mostrar("No hay candidatos registrados");
            return;
        }

        StringBuilder texto = new StringBuilder();
        texto.append("TOTAL DE VOTOS POR CANDIDATO\n\n");
        texto.append("Personeros:\n");
        for (CandidatoPersonero p : modelo.getPersoneros()) {
            texto.append("  Tarjetón ").append(p.getNumeroTarjeton()).append(" - ")
                    .append(p.getNombre()).append(" ").append(p.getApellido())
                    .append(": ").append(p.getVotos()).append(" votos\n");
        }
        texto.append("\nRepresentantes de grado:\n");
        for (CandidatoRepresentante r : modelo.getRepresentantes()) {
            texto.append("  Tarjetón ").append(r.getNumeroTarjeton()).append(" - ")
                    .append(r.getNombre()).append(" ").append(r.getApellido())
                    .append(" (Grado ").append(r.getGrado()).append(")")
                    .append(": ").append(r.getVotos()).append(" votos\n");
        }
        mostrar(texto.toString());
    }

    private void mostrarPersoneroElegido() {
        ArrayList<CandidatoPersonero> elegidos = modelo.personerosMasVotados();

        if (elegidos.isEmpty()) {
            mostrar("No hay personeros registrados");
            return;
        }

        StringBuilder texto = new StringBuilder();
        if (elegidos.size() == 1) {
            texto.append("PERSONERO ELEGIDO PARA 2021\n\n");
        } else {
            texto.append("EMPATE ENTRE LOS PERSONEROS MÁS VOTADOS\n\n");
        }
        for (CandidatoPersonero p : elegidos) {
            texto.append(p.toString()).append("\n");
        }
        mostrar(texto.toString());
    }

    private void mostrarMenorVotacion() {
        ArrayList<CandidatoPersonero> menores = modelo.personerosMenosVotados();

        if (menores.isEmpty()) {
            mostrar("No hay personeros registrados");
            return;
        }

        StringBuilder texto = new StringBuilder();
        if (menores.size() == 1) {
            texto.append("PERSONERO CON MENOR VOTACIÓN\n\n");
        } else {
            texto.append("EMPATE ENTRE LOS PERSONEROS CON MENOR VOTACIÓN\n\n");
        }
        for (CandidatoPersonero p : menores) {
            texto.append(p.toString()).append("\n");
        }
        mostrar(texto.toString());
    }

    private void mostrarPoblacionElectoral() {
        StringBuilder texto = new StringBuilder();
        texto.append("POBLACIÓN ELECTORAL\n\n");
        texto.append("Votos de personeros: ").append(modelo.totalVotosPersoneros()).append("\n");
        texto.append("Votos de representantes: ").append(modelo.totalVotosRepresentantes()).append("\n");
        texto.append("Votos nulos: ").append(modelo.getVotosNulos()).append("\n");
        texto.append("Votos en blanco: ").append(modelo.getVotosBlancos()).append("\n");
        texto.append("----------------------------------\n");
        texto.append("Total: ").append(modelo.poblacionElectoral()).append("\n");
        mostrar(texto.toString());
    }
}
