package co.edu.uniquindio.poo.Model;

public class EmpleadoTemporal extends Empleado{
    private int diasTrabajados;
    private float valorDia;

    public EmpleadoTemporal (String nombre, String documento, int edad, CategoriaEmpleado categoriaEmpleado, float salarioBase,
                             float descuentoSalud, float descuentoPension,int diasTrabajados, float valorDia){
        super(nombre,documento,edad, categoriaEmpleado,salarioBase,descuentoSalud, descuentoPension);
        if (diasTrabajados<0){
            throw new IllegalArgumentException("Los dias trabajados no pueden ser negativos." );
        }
        if ( valorDia< 0){
            throw new IllegalArgumentException("El valor del dia no puede ser negativo." );
        }
        this.diasTrabajados=diasTrabajados;
        this.valorDia=valorDia;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        if (diasTrabajados<0){
            throw new IllegalArgumentException("Los dias trabajados no pueden ser negativos." );
        }
        this.diasTrabajados = diasTrabajados;
    }

    public float getValorDia() {
        return valorDia;
    }

    public void setValorDia(float valorDia) {
        if ( valorDia< 0){
            throw new IllegalArgumentException("El valor del dia no puede ser negativo." );
        }
        this.valorDia = valorDia;
    }

    @Override
    public String toString() {
        return "EmpleadoTemporal{" +
                "diasTrabajados=" + diasTrabajados +
                ", valorDia=" + valorDia +
                '}';

}
    @Override
    public float calcularSalarioBruto (){
        float bonificacion= calcularBonificacionCategoria();
        return diasTrabajados*valorDia + bonificacion;
    }
}
