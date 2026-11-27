package Modelo;

public class CandidatoRepresentante extends Candidato {

    private Estudiante formula;

    public CandidatoRepresentante() {
    }

    public CandidatoRepresentante(String nombre, String apellido, int grado, String grupo, String lema, int numeroTarjeton, int votos, Estudiante formula) {
        super(nombre, apellido, grado, grupo, lema, numeroTarjeton, votos);
        this.formula = formula;
    }

    public Estudiante getFormula() {
        return formula;
    }

    public void setFormula(Estudiante formula) {
        this.formula = formula;
    }

    @Override
    public String toString() {
        return super.toString() + "\n   Fórmula: " + formula;
    }
}
