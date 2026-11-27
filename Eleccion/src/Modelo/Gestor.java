package Modelo;

import java.util.ArrayList;

public class Gestor {

    private ArrayList<CandidatoPersonero> personeros;
    private ArrayList<CandidatoRepresentante> representantes;
    private int votosNulos;
    private int votosBlancos;

    public Gestor() {
        personeros = new ArrayList<>();
        representantes = new ArrayList<>();
    }

    public Gestor(ArrayList<CandidatoPersonero> personeros, ArrayList<CandidatoRepresentante> representantes, int votosNulos, int votosBlancos) {
        this.personeros = personeros;
        this.representantes = representantes;
        this.votosNulos = votosNulos;
        this.votosBlancos = votosBlancos;
    }

    public ArrayList<CandidatoPersonero> getPersoneros() {
        return personeros;
    }

    public void setPersoneros(ArrayList<CandidatoPersonero> personeros) {
        this.personeros = personeros;
    }

    public ArrayList<CandidatoRepresentante> getRepresentantes() {
        return representantes;
    }

    public void setRepresentantes(ArrayList<CandidatoRepresentante> representantes) {
        this.representantes = representantes;
    }

    public int getVotosNulos() {
        return votosNulos;
    }

    public void setVotosNulos(int votosNulos) {
        this.votosNulos = votosNulos;
    }

    public int getVotosBlancos() {
        return votosBlancos;
    }

    public void setVotosBlancos(int votosBlancos) {
        this.votosBlancos = votosBlancos;
    }

    public boolean agregarPersonero(CandidatoPersonero personero) {
        for (CandidatoPersonero p : personeros) {
            if (p.getNumeroTarjeton() == personero.getNumeroTarjeton()) {
                return false;
            }
        }
        personeros.add(personero);
        return true;
    }

    public boolean agregarRepresentante(CandidatoRepresentante representante) {
        for (CandidatoRepresentante r : representantes) {
            if (r.getNumeroTarjeton() == representante.getNumeroTarjeton()) {
                return false;
            }
        }
        representantes.add(representante);
        return true;
    }

    public int totalVotosPersoneros() {
        int total = 0;
        for (CandidatoPersonero p : personeros) {
            total += p.getVotos();
        }
        return total;
    }

    public int totalVotosRepresentantes() {
        int total = 0;
        for (CandidatoRepresentante r : representantes) {
            total += r.getVotos();
        }
        return total;
    }

    public ArrayList<CandidatoPersonero> personerosMasVotados() {
        ArrayList<CandidatoPersonero> resultado = new ArrayList<>();
        int mayor = -1;
        for (CandidatoPersonero p : personeros) {
            if (p.getVotos() > mayor) {
                mayor = p.getVotos();
                resultado.clear();
                resultado.add(p);
            } else if (p.getVotos() == mayor) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public ArrayList<CandidatoPersonero> personerosMenosVotados() {
        ArrayList<CandidatoPersonero> resultado = new ArrayList<>();
        int menor = Integer.MAX_VALUE;
        for (CandidatoPersonero p : personeros) {
            if (p.getVotos() < menor) {
                menor = p.getVotos();
                resultado.clear();
                resultado.add(p);
            } else if (p.getVotos() == menor) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public int poblacionElectoral() {
        return totalVotosPersoneros() + totalVotosRepresentantes() + votosNulos + votosBlancos;
    }

    @Override
    public String toString() {
        return "Gestor{" + "personeros=" + personeros + ", representantes=" + representantes + ", votosNulos=" + votosNulos + ", votosBlancos=" + votosBlancos + '}';
    }
}
