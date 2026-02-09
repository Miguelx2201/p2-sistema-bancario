package model;

import org.junit.jupiter.api.Test;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;


class CuentaAhorrosTest {
    private static final Logger LOG=Logger.getLogger(CuentaAhorrosTest.class.getName());
    @Test
    void retirarTest() {
        LOG.info("Iniciando prueba de intento de retiro");
        Cuenta c1 = new CuentaAhorros("Maria", 500000, "8 Febrero 2026", EstadoCuenta.ACTIVA);
        assertThrows(Exception.class, () -> c1.retirar(450000));
        LOG.info("Finalizando prueba de intento de retiro");
    }
}