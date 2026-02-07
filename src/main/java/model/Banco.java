package model;

public class Banco {
    private String nombre;
    private String nit;

    public Banco(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }
}
