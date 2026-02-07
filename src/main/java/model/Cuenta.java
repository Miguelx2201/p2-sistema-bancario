package model;

public abstract class Cuenta {
    private final String numeroCuenta = asignarNumeroCuenta();
    protected String titular;
    protected double saldo;
    protected String fechaApertura;
    protected EstadoCuenta estado;

    public Cuenta(String titular, double saldo, String fechaApertura, EstadoCuenta estado) {
        this.titular = titular;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
    }

    /**
     * Metodo que deposita dinero al saldo de la cuenta
     * @param valor -> valor a depositar
     * @return -> True si fue posible el deposito
     * @throws Exception -> Excepciones si hubo errores en el monto a depositar
     */
    public boolean depositar(double valor) throws Exception {
        if(valor < 0) throw new Exception("El saldo a depositar no puede ser negativo");
        if(valor == 0) throw  new Exception("El saldo a depositar no puede ser cero");
        this.saldo += valor;
        return true;
    }

    /**
     * Metodo de retirar que debe ser implementado de diferentes maneras en cada clase hija
     * @param valor -> Valor a retirar
     * @return -> True si fue posible el retiro
     * @throws Exception -> En caso de algun error en el retiro
     */
    public abstract boolean retirar(double valor) throws Exception;

    public double getSaldo() {
        return this.saldo;
    }

    /**
     * Metodo para establecer el estado de la cuenta en BLOQUEADO
     */
    public void bloquear() {
        this.estado = EstadoCuenta.BLOQUEADA;
    }

    /**
     * Metodo para desbloquear la cuenta.
     */
    public void desbloquear() {
        this.estado = EstadoCuenta.ACTIVA;
    }

    /**
     * Metodo para mostrar informacion sobre la cuenta en consola
     */
    public void mostrarInformacion() {
        StringBuilder info =  new StringBuilder();
        info.append("Titular: ").append(this.titular).append("\n");
        info.append("Saldo: ").append(this.saldo).append("\n");
        info.append("Estado: ").append(this.estado);
        System.out.println(info.toString());
    }

    /**
     * Metodo para asignarle un numero de cuenta unico a cada cuenta
     */
    private int numeroCuentas = 0;
    private String asignarNumeroCuenta() {
        return String.valueOf(this.numeroCuentas++);
    }
}
