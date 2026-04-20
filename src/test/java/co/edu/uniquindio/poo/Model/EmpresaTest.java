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


    //Verificar que los empleados almacenados en la empresa sean los correctos.

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

    //Verificar que la búsqueda de un empleado inexistente retorne null.
    @Test
    public void empeladoInexistente(){
        Empleado empleado = empresa.buscarEmpleado("9999");

        assertNull(empleado);

    }



    //Comprobar que el método buscarPorDocumento() retorne null cuando se busque un documento inexistente.
@Test
    public void buscarDocumento(){
        String nikol= empresa.registrarEmpleadoVentas("Nik","1235" , 21, CategoriaEmpleado.JUNIOR, 1250000,0,
                0, 1500000, 12 );
        Empleado resultado= empresa.buscarPorDocumento("0989");
        assertNull(resultado);
}



///Validar que el sistema no permita agregar empleados duplicados con el mismo documento en la empresa.
@Test
    public void noEmpleadosRepetidos(){
    empresa.registrarEmpleadoVentas("Nik","1235" , 21, CategoriaEmpleado.JUNIOR, 1250000,0,
            0, 1500000, 12 );
        assertThrows(IllegalArgumentException.class, () -> {
            empresa.registrarEmpleadoVentas("Sofia","1235" , 21, CategoriaEmpleado.JUNIOR, 1250000,0,
                    0, 1500000, 12 );
        } );
}





//verificar que el metodo que obtiene el empleado con mayor salario este correcto.
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



//Verificar que el emtodo que obtiene los empleados temporales que han trabajado mas de 100 horas es correcto.
@Test
    public void horasMasCien (){
    empresa.registrarEmpleadoTemporal("Laura", "1568", 25, CategoriaEmpleado.JUNIOR, 1200600,
            12,16, 26, 15000 );
    empresa.registrarEmpleadoTemporal("MATEO", "1251", 25, CategoriaEmpleado.JUNIOR, 1200600,
            12,16, 24, 15000 );
    empresa.registrarEmpleadoTemporal("Pepe", "9854", 25, CategoriaEmpleado.JUNIOR, 1200600,
            12,16, 12, 15000 );
    ArrayList <Empleado> resultado= empresa.empleadosTempCienHoras();

    assertNotEquals(1, resultado.size());
}




@Test
    public void salarioMayorA(){

    empresa.registrarEmpleadoVentas("fanny lu", "7584", 42, CategoriaEmpleado.SENIOR,1500000,4,8,
            1500000, 45);

    empresa.registrarEmpleadoPlanta(
            "lili", "8546", 36, CategoriaEmpleado.JUNIOR, 2300000,4,5,
            "Jefe", 20,80000,150000);

    empresa.registrarEmpleadoTemporal("Laura", "1568", 25, CategoriaEmpleado.JUNIOR, 2200600,
            12,16, 26, 15000 );

    ArrayList<Empleado> lista = empresa.empleadosConSalarioMayorA(2000000);

    assertEquals(2, lista.size());




}




}