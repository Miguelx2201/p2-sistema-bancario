package model;

import org.junit.jupiter.api.Test;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

class CuentaNominaTest {
    private final Logger LOG =  Logger.getLogger(CuentaNominaTest.class.getName());
    @Test
    void tipoCuentaTest() throws Exception {
        LOG.info("Iniciando prueba de tipo de cuenta");
        CuentaNomina c1 = new CuentaNomina("Pedro", 200000, "28 Enero del 2026", EstadoCuenta.ACTIVA);
        c1.depositar(100000);
        c1.cobrarComision();
        c1.cobrarComision();
        c1.cobrarComision();
        c1.cobrarComision();
        assertInstanceOf(CuentaCorriente.class, c1.validarTipoDeCuenta());
        LOG.info("Finalizando prueba de tipo de cuenta");
    }
}