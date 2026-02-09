package model;

import org.junit.jupiter.api.Test;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

class CuentaCorrienteTest {
    private final Logger LOG =  Logger.getLogger(CuentaCorrienteTest.class.getName());
    @Test
    void retirarTest() throws Exception {
        LOG.info("Iniciando prueba de intento de retiro");
        Cuenta c1 = new CuentaCorriente("Juan", 50000,"9 Febrero del 2026", EstadoCuenta.ACTIVA);
        c1.retirar(400000);
        assertEquals(-350000,c1.getSaldo());
        LOG.info("Finalizando prueba de intento de retiro");
    }
}