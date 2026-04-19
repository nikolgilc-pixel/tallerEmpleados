package co.edu.uniquindio.poo.Model;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTemporalTest {
    private static Logger LOG = Logger.getLogger(EmpleadoTemporalTest.class.getName());

    @Test
    public void calcularSalarioNeto(){
        EmpleadoTemporal empleadoTemporal= new EmpleadoTemporal("Nikol" , "3446", 18,
                CategoriaEmpleado.JUNIOR, 1200000, 12, 0, 30, 35000);

        assertNotEquals( 0, empleadoTemporal.calcularSalarioNeto());

    }

}