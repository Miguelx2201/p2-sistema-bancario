package model;

import java.util.ArrayList;

public class Banco {
    private String nombre;
    private String nit;
    private ArrayList<Cuenta> cuentas;

    public Banco(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.cuentas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void agregarCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
    }

    public boolean registrarCuenta(Cuenta cuenta) {
        boolean existe = cuentas.stream()
                .anyMatch(m -> m.getNumeroCuenta().equals(cuenta.getNumeroCuenta()));
        if (existe) return false; // ya existe
        return cuentas.add(cuenta);
    }

    public Cuenta buscarCuenta(String codigo) {
        return cuentas
                .stream()
                .filter(m -> m.getNumeroCuenta().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public boolean eliminarCuenta(String codigo) {
        return cuentas.removeIf(m -> m.getNumeroCuenta().equals(codigo));
    }

}
