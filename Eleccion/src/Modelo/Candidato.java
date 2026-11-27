package Modelo;

public class Candidato extends Estudiante {

    private String lema;
    private int numeroTarjeton;
    private int votos;

    public Candidato() {
    }

    public Candidato(String nombre, String apellido, int grado, String grupo, String lema, int numeroTarjeton, int votos) {
        super(nombre, apellido, grado, grupo);
        this.lema = lema;
        this.numeroTarjeton = numeroTarjeton;
        this.votos = votos;
    }

    public String getLema() {
        return lema;
    }

    public void setLema(String lema) {
        this.lema = lema;
    }

    public int getNumeroTarjeton() {
        return numeroTarjeton;
    }

    public void setNumeroTarjeton(int numeroTarjeton) {
        this.numeroTarjeton = numeroTarjeton;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tarjetón: " + numeroTarjeton + " | Lema: " + lema + " | Votos: " + votos;
    }
}
