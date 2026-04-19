package co.edu.uniquindio.poo.Model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class EmpresaTest {
    private static Logger LOG= Logger.getLogger(EmpresaTest.class.getName());
    private static Empresa empresa;

    @BeforeAll
    public static void setUp() {
        empresa = new Empresa("Kade");
    }

    @Test
            public void empleadosCorrectos(){
         empresa.registrarEmpleadoVentas("Sofia","7890" , 21, CategoriaEmpleado.JUNIOR, 1250000,0,
                 0, 1500000, 12 );
         empresa.registrarEmpleadoPlanta("Mario" , "3873", 34, CategoriaEmpleado.JUNIOR, 1100000,
                 0, 0, "jefe", 12, 12000, 120000);
        ArrayList <String> esperados= new ArrayList<>();
        esperados.add("Sofia");
        esperados.add ("Mario");
        ArrayList <String> actuales = new ArrayList<>();
        for (Empleado e: empresa.getListaEmpleados()){
            actuales.add(e.getNombre());
        }


         assertIterableEquals(esperados,actuales);


    }
    @Test
    public void empeladoInexistente(){
        Empleado empleado = empresa.buscarEmpleado("9999");

        assertNull(empleado);

    }

@Test
    public void buscarDocumento(){
        String nikol= empresa.registrarEmpleadoVentas("Nik","1235" , 21, CategoriaEmpleado.JUNIOR, 1250000,0,
                0, 1500000, 12 );
        Empleado resultado= empresa.buscarPorDocumento("0989");
        assertNull(resultado);
}

@Test
    public void noEmpleadosRepetidos(){
    empresa.registrarEmpleadoVentas("Nik","1235" , 21, CategoriaEmpleado.JUNIOR, 1250000,0,
            0, 1500000, 12 );
        assertThrows(IllegalArgumentException.class, () -> {
            empresa.registrarEmpleadoVentas("Sofia","1235" , 21, CategoriaEmpleado.JUNIOR, 1250000,0,
                    0, 1500000, 12 );
        } );
}
@Test
    public void rectificarMetodo (){
    empresa.registrarEmpleadoVentas("Nik","1235" , 21, CategoriaEmpleado.JUNIOR, 1250000,0,
            0, 1500000, 12 );
    empresa.registrarEmpleadoVentas("Sofia","2564" , 21, CategoriaEmpleado.JUNIOR, 1350000,0,
            0, 1500000, 12 );
    empresa.registrarEmpleadoPlanta("Mario" , "3873", 34, CategoriaEmpleado.JUNIOR, 1100000,
            0, 0, "jefe", 12, 12000, 120000);
    Empleado resultado= empresa.empleadoMayorSalario();

    assertEquals("Sofia", resultado.getNombre());

}

@Test
    public void horasMasCien (){

}




}