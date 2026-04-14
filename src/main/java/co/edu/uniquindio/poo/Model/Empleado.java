package co.edu.uniquindio.poo.Model;

import java.util.ArrayList;

public abstract class Empleado {
    protected String nombre;
    private String documento;
    private int edad;
    private CategoriaEmpleado categoriaEmpleado;
    private float salarioBase;
    private float descuentoSalud;
    private float descuentoPension;
    private ArrayList <ResumenPago> listaResumenPago;

    public Empleado(String nombre, String documento, int edad,
                    CategoriaEmpleado categoriaEmpleado, float salarioBase, float descuentoSalud, float descuentoPension) {

        if (salarioBase < 0 ){
            throw new IllegalArgumentException("El salario base no puede ser negativo");
        }
        if (descuentoPension  < 0 || descuentoPension > 100  ) {
            throw new IllegalArgumentException("Descuento de pensión Invalido");
        }
        if (descuentoSalud  < 0 || descuentoSalud > 100  ) {
            throw new IllegalArgumentException("Descuento de pensión Invalido");
        }
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.categoriaEmpleado= categoriaEmpleado;
        this.salarioBase = salarioBase;
        this.descuentoSalud = descuentoSalud;
        this.descuentoPension = descuentoPension;
        listaResumenPago= new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public CategoriaEmpleado getCategoriaEmpleado() {
        return categoriaEmpleado;
    }

    public void setCategoriaEmpleado(CategoriaEmpleado categoriaEmpleado) {
        this.categoriaEmpleado = categoriaEmpleado;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        if (salarioBase < 0 ){
            throw new IllegalArgumentException("El salario base no puede ser negativo");
        }
        this.salarioBase = salarioBase;
    }

    public float getDescuentoSalud() {
        return descuentoSalud;
    }

    public void setDescuentoSalud(float descuentoSalud) {
        if (descuentoSalud  < 0 || descuentoSalud > 100  ) {
            throw new IllegalArgumentException("Descuento de pensión Invalido");
        }
        this.descuentoSalud = descuentoSalud;
    }

    public float getDescuentoPension() {
        return descuentoPension;
    }

    public void setDescuentoPension(float descuentoPension) {
        if (descuentoPension  < 0 || descuentoPension > 100  ) {
            throw new IllegalArgumentException("Descuento de pensión Invalido");
        }
        this.descuentoPension = descuentoPension;
    }

    public ArrayList<ResumenPago> getListaResumenPago() {
        return listaResumenPago;
    }

    public void setListaResumenPago(ArrayList<ResumenPago> listaResumenPago) {
        this.listaResumenPago = listaResumenPago;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", edad=" + edad +
                ", categoriaEmpleado=" + categoriaEmpleado +
                ", salarioBase=" + salarioBase +
                ", descuentoSalud=" + descuentoSalud +
                ", descuentoPension=" + descuentoPension +
                ", listaResumenPago=" + listaResumenPago +
                '}';
    }

    public abstract float calcularSalarioBruto ();
    public float calcularBonificacionCategoria(){
        return switch (categoriaEmpleado) {
            case JUNIOR -> salarioBase * 0.05f;
            case SEMI_SENIOR ->  salarioBase * 0.10f;
            case SENIOR -> salarioBase * 0.15f;

        };
    }
    public float calcularDescuento(){
        float descuento= (descuentoSalud + descuentoPension)/100;
        return salarioBase * descuento;
    }
    public float calcularSalarioNeto(){
        float salarioBruto= calcularSalarioBruto();
        float descuentos= calcularDescuento();
        return salarioBruto - descuentos;
    }
    public ResumenPago generarResumenPago(){

        float bruto = calcularSalarioBruto();
        float descuentos = calcularDescuento();
        float neto = calcularSalarioNeto();

        String tipoEmpleado = this.getClass().getSimpleName();

        return new ResumenPago(
                documento,
                nombre,
                tipoEmpleado,
                bruto,
                descuentos,
                neto
        );
    }
    public String mostrarInformacion(){

        ResumenPago resumen = generarResumenPago();
        return "----- RESUMEN DE PAGO -----\n" +
                "Documento: " + resumen.documento() + "\n" +
                "Nombre: " + resumen.nombre() + "\n" +
                "Tipo: " + resumen.tipoEmpleado() + "\n" +
                "Salario Bruto: " + resumen.salarioBruto() + "\n" +
                "Descuentos: " + resumen.descuentos() + "\n" +
                "Salario Neto: " + resumen.salarioNeto();

    }
    public String mostrarEmpleado(){

        ResumenPago resumen = generarResumenPago();
        return
                "Documento: " + resumen.documento() + "\n" +
                "Nombre: " + resumen.nombre() + "\n" +
                "Tipo: " + resumen.tipoEmpleado() + "\n" ;
    }

}
