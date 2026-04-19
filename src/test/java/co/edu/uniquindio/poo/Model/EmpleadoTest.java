package co.edu.uniquindio.poo.Model;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTest {
    private static Logger LOG= Logger.getLogger(Empleado.class.getName());

    @Test
    public void clasJuniorMa0 (){
            Empleado empleadoP= new EmpleadoPlanta("Nathe" , "1209", 28, CategoriaEmpleado.JUNIOR,
                    1200000, 12,28,"Lider", 15,15000,
                    120000);

            float bonificacion= empleadoP.calcularBonificacionCategoria();

            assertTrue(bonificacion>0);

    }


    @Test
    public void netoNegativo (){
        Empleado empleadoB= new EmpleadoVentas("kats" , "1568", 28, CategoriaEmpleado.JUNIOR,
                1200000, 12,28,1600000, 12);

        float salarioNet= empleadoB.calcularSalarioNeto();

        assertTrue(salarioNet>=0);
    }

    @Test
    public void excepcionNegativo(){

        assertThrows(IllegalArgumentException.class, ()-> new EmpleadoVentas("Deku" , "1895", 28, CategoriaEmpleado.JUNIOR,
                -1200000, 12,28,1600000, 12)

    );




    }


}