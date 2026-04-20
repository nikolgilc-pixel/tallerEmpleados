package co.edu.uniquindio.poo.Model;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoPlantaTest {

    private static Logger LOG= Logger.getLogger(EmpleadoPlantaTest.class.getName());

//Verificar que el método calcularSalarioNeto de
// un empleado de planta sea mayor que su salario base.
    @Test
    public void netoMayorBase(){

        EmpleadoPlanta ni= new EmpleadoPlanta("Laila", "5896", 24, CategoriaEmpleado.JUNIOR,
                2500000,8,2, "Secretario", 12,
                12500, 125000);

        float exp= ni.calcularSalarioNeto();
        float arr= ni.getSalarioBase();

        assertTrue(exp > arr);
    }

}