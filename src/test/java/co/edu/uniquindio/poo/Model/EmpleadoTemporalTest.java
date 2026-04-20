package co.edu.uniquindio.poo.Model;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTemporalTest {
    private static Logger LOG = Logger.getLogger(EmpleadoTemporalTest.class.getName());




//Verificar que el salario neto de un empleado temporal no sea igual a 0.
    @Test
    public void calcularSalarioNeto(){
        EmpleadoTemporal empleadoTemporal= new EmpleadoTemporal("Nikol" , "3446", 18,
                CategoriaEmpleado.JUNIOR, 1200000, 12, 0, 30, 35000);

        assertNotEquals( 0, empleadoTemporal.calcularSalarioNeto());

    }



    //Verificar que el salario neto de un empleado temporal sea
    // mayor a cero cuando los días trabajados y el valor día son válidos.
    @Test
    public void salarioNetoMayorCero (){
        EmpleadoTemporal empleadoTemporal= new EmpleadoTemporal("Peppa", "5684",
                42, CategoriaEmpleado.SEMI_SENIOR, 1500000, 8, 10, 25,
                40000);

        float neto= empleadoTemporal.calcularSalarioNeto();

        assertTrue(neto > 0);
    }

}