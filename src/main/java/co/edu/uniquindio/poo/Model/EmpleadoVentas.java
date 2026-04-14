package co.edu.uniquindio.poo.Model;

public class EmpleadoVentas extends Empleado {
    private float totalVentas;
    private float porcentajeComisio;

    public EmpleadoVentas(String nombre, String documento, int edad, CategoriaEmpleado categoriaEmpleado, float salarioBase,
                          float descuentoSalud, float descuentoPension,float totalVentas, float porcentajeComisio) {
        super(nombre,documento,edad, categoriaEmpleado,salarioBase,descuentoSalud, descuentoPension);
        if(porcentajeComisio < 0 || porcentajeComisio > 100){
            throw new IllegalArgumentException ("Porcentaje Invalido");
        }
        this.totalVentas = totalVentas;
        this.porcentajeComisio = porcentajeComisio;
    }

    public float getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(float totalVentas) {
        this.totalVentas = totalVentas;
    }

    public float getPorcentajeComisio() {
        return porcentajeComisio;
    }

    public void setPorcentajeComisio(float porcentajeComisio) {
        if(porcentajeComisio < 0 || porcentajeComisio > 100){
            throw new IllegalArgumentException ("Porcentaje Invalido");
        }
        this.porcentajeComisio = porcentajeComisio;
    }

    @Override
    public String toString() {
        return "EmpleadoVentas{" +
                "totalVentas=" + totalVentas +
                ", porcentajeComisio=" + porcentajeComisio +
                '}';
    }
    public float calcularComision (){
        return totalVentas* porcentajeComisio/100;
    }

    @Override
    public float calcularSalarioBruto (){
        float comision = calcularComision();
        float bonificacion= calcularBonificacionCategoria();
        return getSalarioBase() + comision + bonificacion;
    }
}
