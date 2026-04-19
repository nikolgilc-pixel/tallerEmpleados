package co.edu.uniquindio.poo.Model;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebasEmpleadoVentasTest {
    private static final Logger LOG = Logger.getLogger( PruebasEmpleadoVentasTest.class.getName());

@Test
public void calcularSalarioBrutoTest(){
EmpleadoVentas empleadoVentas= new EmpleadoVentas ("Juan", "1234" , 25, CategoriaEmpleado.JUNIOR,1000000f,
        12, 10, 1500000, 12);
    float comision = 1500000 * 12 / 100; // 180000
    float bonificacion = empleadoVentas.calcularBonificacionCategoria();

    float esperado = 1000000f + comision + bonificacion;


assertEquals(esperado, empleadoVentas.calcularSalarioBruto());

}


}










