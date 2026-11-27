package Modelo;

public enum TipoAnimal {
    AEREO("Aéreo"),
    TERRESTRE("Terrestre"),
    ACUATICO("Acuático");

    private final String descripcion;

    private TipoAnimal(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
