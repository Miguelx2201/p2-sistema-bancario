package model;

public class CuentaCorriente extends Cuenta{
    private final double INTERES_SOBREGIRO = 0.02;
    private final double COMISION = 15000;

    public CuentaCorriente(String titular, double saldo, String fechaApertura, EstadoCuenta estado) {
        super(titular, saldo, fechaApertura, estado);
    }

    /**
     * Metodo para validar el sobregiro. (Falta por realizar)
     * @return -> True si el sobregiro actual es valido, False en caso contrario.
     */
    public boolean validarSobregiro() {
        return false;
    }

    /**
     * Metodo para cobrar la comision mensual fija de 15000
     */
    public void cobrarComision() {
        this.saldo -= COMISION;
    }

    /**
     * Metodo para cobrar el interes mensual sobre el monto de sobregiro.
     * Primero validamos que este en sobregiro.
     */
    public void cobrarInteres() {
        if(this.saldo<0) {
            saldo -= Math.abs((INTERES_SOBREGIRO*this.saldo));
        }
    }

    /**
     * Metodo para retirar en una cuenta corriente.
     * @param valor -> Valor a retirar
     * @return
     * @throws Exception
     */
    @Override
    public boolean retirar(double valor) throws Exception {
        return false;
    }
}
