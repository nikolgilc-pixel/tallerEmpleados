package co.edu.uniquindio.poo.App;

import co.edu.uniquindio.poo.Model.CategoriaEmpleado;
import co.edu.uniquindio.poo.Model.Empleado;
import co.edu.uniquindio.poo.Model.Empresa;

import javax.swing.*;

public class Main {
    public static void main (String [] args) {
        String nombreEmpresa = JOptionPane.showInputDialog("Ingrese el nombre de la empresa: ");
        Empresa empresa = new Empresa(nombreEmpresa);
        int opcion = 0;
        do {
            String menu = "    MENÚ    \n" +
                    "1. Agregar empleado de planta\n" +
                    "2. Agregar empleado de ventas\n" +
                    "3. Agregar empleado temporal\n" +
                    "4. Mostrar todos los empleados\n" +
                    "5. Buscar empleado por documento\n" +
                    "6. Mostrar empleado con mayor salario neto\n" +
                    "7. Mostrar nómina total\n" +
                    "8. Mostrar resumen de pagos\n" +
                    "9. Salir";

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1 -> {
                    try {
                        String nombre = JOptionPane.showInputDialog("Nombre:");
                        String documento = JOptionPane.showInputDialog("Documento:");
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                        float salario = Float.parseFloat(JOptionPane.showInputDialog("Salario base:"));
                        float salud = Float.parseFloat(JOptionPane.showInputDialog("Descuento salud (0-100):"));
                        float pension = Float.parseFloat(JOptionPane.showInputDialog("Descuento pensión(0-100):"));
                        int cat = Integer.parseInt(JOptionPane.showInputDialog("1.JUNIOR 2.SEMI 3.SENIOR"));
                        CategoriaEmpleado categoria = CategoriaEmpleado.obtenerCategoria(cat);
                        String cargo = JOptionPane.showInputDialog("Cargo:");
                        int horas = Integer.parseInt(JOptionPane.showInputDialog("Horas extra:"));
                        float valorHora = Float.parseFloat(JOptionPane.showInputDialog("Valor hora extra:"));
                        float auxilio = Float.parseFloat(JOptionPane.showInputDialog("Auxilio transporte:"));

                        String res = empresa.registrarEmpleadoPlanta(nombre, documento, edad, categoria,
                                salario, salud, pension, cargo, horas, valorHora, auxilio);

                        JOptionPane.showMessageDialog(null, res);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
                case 2 -> {
                    try {

                        String nombre = JOptionPane.showInputDialog("Nombre:");
                        String documento = JOptionPane.showInputDialog("Documento:");
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                        float salario = Float.parseFloat(JOptionPane.showInputDialog("Salario base:"));
                        float salud = Float.parseFloat(JOptionPane.showInputDialog("Descuento salud:"));
                        float pension = Float.parseFloat(JOptionPane.showInputDialog("Descuento pensión:"));
                        int cat = Integer.parseInt(JOptionPane.showInputDialog("1.JUNIOR 2.SEMI 3.SENIOR"));
                        CategoriaEmpleado categoria = CategoriaEmpleado.obtenerCategoria(cat);
                        float totalVentas = Float.parseFloat(JOptionPane.showInputDialog("Total Ventas:"));
                        float porcentajeComisio = Float.parseFloat(JOptionPane.showInputDialog("Porcentaje comisión:"));
                        String res = empresa.registrarEmpleadoVentas(nombre, documento, edad, categoria, salario,
                                salud, pension, totalVentas, porcentajeComisio);
                        JOptionPane.showMessageDialog(null, res);

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }


                case 3 -> {
                    try {

                        String nombre = JOptionPane.showInputDialog("Nombre:");
                        String documento = JOptionPane.showInputDialog("Documento:");
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                        float salario = Float.parseFloat(JOptionPane.showInputDialog("Salario base:"));
                        float salud = Float.parseFloat(JOptionPane.showInputDialog("Descuento salud:"));
                        float pension = Float.parseFloat(JOptionPane.showInputDialog("Descuento pensión:"));
                        int cat = Integer.parseInt(JOptionPane.showInputDialog("1.JUNIOR 2.SEMI 3.SENIOR"));
                        CategoriaEmpleado categoria = CategoriaEmpleado.obtenerCategoria(cat);
                        float valorDia= Float.parseFloat(JOptionPane.showInputDialog("Valor del día:"));
                        int diasTrabajados= Integer.parseInt(JOptionPane.showInputDialog("Dias trabajados:"));
                        String res = empresa.registrarEmpleadoVentas(nombre, documento, edad, categoria, salario,
                                salud, pension, valorDia, diasTrabajados);
                        JOptionPane.showMessageDialog(null, res);

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
                case 4 -> {
                    JOptionPane.showMessageDialog(null, empresa.mostrarEmpleados());
                }
                case 5 -> {
                    String documento= JOptionPane.showInputDialog("Ingrese el documento del empleado que desea buscar");
                    Empleado e = empresa.buscarEmpleado(documento);
                    if ( e != null ){
                        JOptionPane.showMessageDialog(null, e.mostrarInformacion());
                    }
                }
                case 6 -> {
                    Empleado e = empresa.empleadoMayorSalario();
                    if (e != null){
                        JOptionPane.showMessageDialog(null, e.mostrarInformacion());
                    }else {
                        JOptionPane.showMessageDialog(null,"No hay empleados");
                    }
                }
                case 7 -> {
                    JOptionPane.showMessageDialog (null, "Nomina Total: " + empresa.nominaTotal());
                }
                case 8 -> {
                    JOptionPane.showMessageDialog( null, empresa.mostrarResumenPagos());

                }
            }






            }
            while (opcion != 9) ;



    }
}
