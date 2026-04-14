package co.edu.uniquindio.poo.Model;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Empleado> listaEmpleados;


    public Empresa(String nombre) {
        this.nombre = nombre;
        listaEmpleados = new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", listaEmpleados=" + listaEmpleados +
                '}';
    }

    //Crud (falta optimizar)
    public String registrarEmpleadoPlanta(String nombre, String documento, int edad, CategoriaEmpleado categoriaEmpleado, float salarioBase,
                                          float descuentoSalud, float descuentoPension,
                                          String cargo, int horasExtras, float valorHoraExtras, float auxilioDeTransporte) {
        String resultado = "";
        //1. Verificcar si el cliente esta registrado:
        Empleado empleadoEncontrado = buscarEmpleado(documento);
        if (empleadoEncontrado != null) {
            resultado = "El empleado no se puede resgistrar, ya se encuentra en la base de"
                    + "datos";
        } else {
            Empleado empleado = new EmpleadoPlanta(nombre, documento, edad,
                    categoriaEmpleado, salarioBase, descuentoSalud, descuentoPension, cargo, horasExtras, valorHoraExtras, auxilioDeTransporte);
            listaEmpleados.add(empleado);
            resultado = "El empleado de planta se ha registrado exitosamente";

        }

        return resultado;

    }

    public String registrarEmpleadoVentas(String nombre, String documento, int edad, CategoriaEmpleado categoriaEmpleado,
                                          float salarioBase,
                                          float descuentoSalud, float descuentoPension, float totalVentas,
                                          float porcentajeComisio) {
        String resultado = "";
        //1. Verificcar si el cliente esta registrado:
        Empleado empleadoEncontrado = buscarEmpleado(documento);
        if (empleadoEncontrado != null) {
            resultado = "El empleado no se puede resgistrar, ya se encuentra en la base de"
                    + "datos";
        } else {
            Empleado empleado = new EmpleadoVentas(nombre, documento, edad,
                    categoriaEmpleado, salarioBase, descuentoSalud, descuentoPension, totalVentas, porcentajeComisio);
            listaEmpleados.add(empleado);
            resultado = "El empleado de ventas se ha registrado exitosamente";

        }

        return resultado;

    }

    public String registrarEmpleadoTemporal(String nombre, String documento, int edad, CategoriaEmpleado categoriaEmpleado, float salarioBase,
                                            float descuentoSalud, float descuentoPension, int diasTrabajados, float valorDia) {
        String resultado = "";
        //1. Verificcar si el cliente esta registrado:
        Empleado empleadoEncontrado = buscarEmpleado(documento);
        if (empleadoEncontrado != null) {
            resultado = "El empleado no se puede resgistrar, ya se encuentra en la base de"
                    + "datos";
        } else {
            Empleado empleado = new EmpleadoTemporal(nombre, documento, edad,
                    categoriaEmpleado, salarioBase, descuentoSalud, descuentoPension, diasTrabajados, valorDia);
            listaEmpleados.add(empleado);
            resultado = "El empleado temporal se ha registrado exitosamente";

        }

        return resultado;

    }


    public Empleado buscarEmpleado(String documento) {
        Empleado resultado = null;

        for (Empleado empleadoNuevo : listaEmpleados) {
            if (empleadoNuevo.getDocumento().equals(documento)) {
                resultado = empleadoNuevo;
                return resultado;
            }
        }

        return resultado;
    }

    public String eliminarEmpleado(String documento) {
        String resultado = "";

        Empleado empleadoN = buscarEmpleado(documento);

        if (empleadoN != null) {
            listaEmpleados.remove(empleadoN);
            resultado = "Empleado eliminado";
        } else {
            resultado = "El empleado no puede ser eliminado, porque no existe";
        }

        return resultado;
    }

    public String actualizarEmpleado(String nombre, String documento, int edad,
                                     CategoriaEmpleado categoriaEmpleado, float salarioBase, float descuentoSalud,
                                     float descuentoPension, String cargo, int horasExtras, float valorHoraExtras,
                                     float auxilioDeTransporte, float totalVentas, float porcentajeComisio, int diasTrabajados,
                                     float valorDia) {
        String resultado = "";

        Empleado empleadoNu = buscarEmpleado(documento);

        if (empleadoNu != null) {

            empleadoNu.setNombre(nombre);
            empleadoNu.setDocumento(documento);
            empleadoNu.setEdad(edad);
            empleadoNu.setCategoriaEmpleado(categoriaEmpleado);
            empleadoNu.setSalarioBase(salarioBase);
            empleadoNu.setDescuentoSalud(descuentoSalud);
            empleadoNu.setDescuentoPension(descuentoPension);

            if (empleadoNu instanceof EmpleadoPlanta planta) {
                planta.setCargo(cargo);
                planta.setHorasExtras(horasExtras);
                planta.setValorHoraExtras(valorHoraExtras);
                planta.setAuxilioDeTransporte(auxilioDeTransporte);

            } else if (empleadoNu instanceof EmpleadoVentas ventas) {
                ventas.setTotalVentas(totalVentas);
                ventas.setPorcentajeComisio(porcentajeComisio);

            } else if (empleadoNu instanceof EmpleadoTemporal temporal) {
                temporal.setDiasTrabajados(diasTrabajados);
                temporal.setValorDia(valorDia);

            }

            resultado = "Cliente actualizado";
        } else {
            resultado = "El cliente no existe";
        }

        return resultado;

    }

    public String mostrarEmpleados() {
        String resultado = "";

        if (listaEmpleados.isEmpty()) {
            return "No hay empleados registrados";
        }

        for (Empleado e : listaEmpleados) {
            resultado += e.mostrarEmpleado() + "\n-----------------\n";
        }

        return resultado;
    }

    public Empleado empleadoMayorSalario() {
        if (listaEmpleados.isEmpty()) {
            return null;
        } else {
            Empleado mayor = listaEmpleados.get(0);
            for (Empleado e : listaEmpleados) {
                if (e.calcularSalarioNeto() > mayor.calcularSalarioNeto()) {
                    mayor = e;
                }
            }
            return mayor;
        }
    }

    public float nominaTotal() {
        float total = 0;
        for (Empleado e : listaEmpleados) {
            total += e.calcularSalarioNeto();
        }
        return total;
    }

    public String mostrarResumenPagos() {
        String resultado = "";

        if (listaEmpleados.isEmpty()) {
            resultado = "No hay Resumenes de pago";
        } else {
            for (Empleado e : listaEmpleados) {
                ResumenPago r = e.generarResumenPago();
                resultado = "______Resumen Pago______\n" +

                        "Documento: " + r.documento() +
                        "\nNombre: " + r.nombre() +
                        "\nTipo: " + r.tipoEmpleado() +
                        "\nSalario Bruto: " + r.salarioBruto() +
                        "\nDescuentos: " + r.descuentos() +
                        "\nSalario Neto: " + r.salarioNeto() +
                        "\n----------------------\n";
            }
        }
        return resultado;
    }
}