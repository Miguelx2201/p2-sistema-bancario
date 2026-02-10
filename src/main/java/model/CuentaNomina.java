package model;

public class CuentaNomina extends Cuenta{
    private final double COMISION = 8000;
    private int numDepositosMensual = 0;
    private int mesesSinSalarioConsecutivos = 0;
    public CuentaNomina(String titular, double saldo, String fechaApertura, EstadoCuenta estado) {
        super(titular, saldo, fechaApertura, estado);
    }


    /**
     * Metodo que retorna True en caso de que se deba cobrar comision. Es decir que la cuenta
     * no haya recibido ningun deposito en el mes
     * @return
     */
    public boolean validarComision() {
        return numDepositosMensual == 0;
    }

    /**
     * Se sobreescribe el metodo de depositar para tener un registro de el numero de depositos
     * de la cuenta en el mes
     * @param valor -> valor a depositar
     * @return
     * @throws Exception
     */
    @Override
    public boolean depositar(double valor) throws Exception {
        numDepositosMensual++;
        return super.depositar(valor);
    }

    /**
     * Metodo para cobrar la comision mensual en caso de ser necesario, primero se realiza la
     * respectiva validacion y en caso de ser necesario se cobra, finalmente se reinicia el
     * contador de depositos mensual en cero para el nuevo mes o periodo de cobro.
     */
    public void cobrarComision() {
        if(validarComision()) {
            saldo -= COMISION;
            mesesSinSalarioConsecutivos++;
        } else {
            mesesSinSalarioConsecutivos = 0;
        }
        numDepositosMensual = 0;
    }

    /**
     * Metodo para validar si el usuario ha recibido un salario en la cuenta en los ultimos tres meses
     * @return -> retorna True si lleva 3 meses o mas sin recibir salario.
     */
    public boolean validarSalarioTresMeses() {
        return (mesesSinSalarioConsecutivos >= 3);
    }

    /**
     * Metodo que hace la transicion de una cuenta de tipo nomina a tipo corriente.
     * @return
     */
    public Cuenta validarTipoDeCuenta() {
        if(validarSalarioTresMeses()){
            return new CuentaCorriente(titular, saldo, fechaApertura, estado);
        }
        return this;
    }

    /**
     * Metodo para retirar dinero de la cuenta.
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
        saldo -= valor;
        registrarTransaccion("Retiro", valor);
        return true;
    }

    public boolean verificarElegibilidadCredito(){
        if(numDepositosMensual>4){
            return true;
        }
        return false;
    }
}
