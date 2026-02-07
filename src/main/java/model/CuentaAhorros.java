package model;

public class CuentaAhorros extends Cuenta{
    private final double INTERES = 0.036;
    private final double SALDO_MINIMO = 100000;
    public CuentaAhorros(String titular, double saldo, String fechaApertura, EstadoCuenta estado) {
        super(titular, saldo, fechaApertura, estado);
    }

    /**
     * Metodo que retorna el interes mensual que debe recibir la cuenta
     * @return
     */
    public double cobrarInteres() {
        return saldo*(INTERES/12);
    }

    /**
     * Metodo que valida si el saldo es mayor o igual al saldo minimo estipulado previamente
     * @return
     */
    public boolean validarSaldoMinimo() {
        return saldo >= SALDO_MINIMO;
    }

    /**
     * Metodo que valida el sobre giro. (Falta por realizar)
     * @return
     */
    public boolean validarSobregiro() {
        return false;
    }

    /**
     * Metodo para retirar de una cuenta de ahorros. (Falta por realizar)
     * @param valor -> Valor a retirar
     * @return
     * @throws Exception
     */
    @Override
    public boolean retirar(double valor) throws Exception {
        return false;
    }
}
