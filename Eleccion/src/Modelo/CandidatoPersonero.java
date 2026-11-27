package Modelo;

public class CandidatoPersonero extends Candidato {

    private Mascota mascota;

    public CandidatoPersonero() {
    }

    public CandidatoPersonero(String nombre, String apellido, int grado, String grupo, String lema, int numeroTarjeton, int votos, Mascota mascota) {
        super(nombre, apellido, grado, grupo, lema, numeroTarjeton, votos);
        this.mascota = mascota;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public String toString() {
        return super.toString() + "\n   Mascota: " + mascota;
    }
}
