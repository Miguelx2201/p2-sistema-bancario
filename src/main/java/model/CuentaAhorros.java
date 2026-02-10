package model;

public class CuentaAhorros extends Cuenta{
    private final double INTERES= 0.036;
    private final double SALDO_MINIMO = 100000;
    public CuentaAhorros(String titular, double saldo, String fechaApertura, EstadoCuenta estado) {
        super(titular, saldo, fechaApertura, estado);
    }

    /**
     * Metodo que retorna el interes mensual que debe recibir la cuenta
     * @return
     */
    public void pagarInteresMensual() {
        saldo+=saldo*(INTERES/12);
    }

    /**
     * Metodo que valida si el saldo es mayor o igual al saldo minimo estipulado previamente
     * @return
     */
    public boolean validarSaldoMinimo() {
        return saldo >= SALDO_MINIMO;
    }

    /**
     * Metodo que valida el sobre giro.
     * @return -> True si es valido, es decir no hay sobregiro
     */
    public boolean validarSobregiro() {
        return saldo>=0;
    }

    /**
     * Metodo para retirar de una cuenta de ahorros.
     * @param valor -> Valor a retirar
     * @return
     * @throws Exception
     */
    @Override
    public boolean retirar(double valor) throws Exception {
        if(valor == 0) throw new Exception("Ingrese un valor valido para retirar");
        if(valor < 0) throw new Exception("No es posible retirar cantidades negativas");
        double retiro = saldo - valor;
        if(retiro < 0) throw new Exception("Saldo insuficiente");
        if(retiro >= 0 && retiro < SALDO_MINIMO) throw new Exception("No cumple con la norma del saldo minimo");
        saldo -= valor;
        registrarTransaccion("Retiro", valor);
        return true;
    }

    public boolean verificarElegibilidadCredito(){
        double minimoCredito =300000;
        if(saldo>=minimoCredito){
            return true;
        }
        return false;
    }
}
