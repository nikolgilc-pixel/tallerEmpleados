package co.edu.uniquindio.poo.Model;

public class EmpleadoPlanta extends Empleado{
    private String cargo;
    private int horasExtras;
    private float valorHoraExtras;
    private float auxilioDeTransporte;

    public EmpleadoPlanta (String nombre, String documento, int edad, CategoriaEmpleado categoriaEmpleado, float salarioBase,
                           float descuentoSalud, float descuentoPension,
                           String cargo, int horasExtras, float valorHoraExtras, float auxilioDeTransporte){
        super( nombre,documento,edad, categoriaEmpleado,salarioBase,descuentoSalud, descuentoPension);
        if (horasExtras<0){
            throw new IllegalArgumentException("Las horas extras no pueden ser negativas.");
        }
        if (valorHoraExtras < 0 ){
            throw new IllegalArgumentException("El valor de de las horas extras no puede ser negativo.");
        }
        if (auxilioDeTransporte<0){
            throw new IllegalArgumentException("El auxilio de transporte no puede ser negativo.");
        }
        this.cargo=cargo;
        this.horasExtras=horasExtras;
        this.valorHoraExtras=valorHoraExtras;
        this.auxilioDeTransporte=auxilioDeTransporte;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        if (horasExtras<0){
            throw new IllegalArgumentException("Las horas extras no pueden ser negativas.");
        }
        this.horasExtras = horasExtras;
    }

    public float getValorHoraExtras() {
        return valorHoraExtras;
    }

    public void setValorHoraExtras(float valorHoraExtras) {
        if (valorHoraExtras < 0 ){
            throw new IllegalArgumentException("El valor de de las horas extras no puede ser negativo.");
        }
        this.valorHoraExtras = valorHoraExtras;
    }

    public float getAuxilioDeTransporte() {
        return auxilioDeTransporte;
    }

    public void setAuxilioDeTransporte(float auxilioDeTransporte) {
        if (auxilioDeTransporte<0){
            throw new IllegalArgumentException("El auxilio de transporte no puede ser negativo.");
        }
        this.auxilioDeTransporte = auxilioDeTransporte;
    }

    @Override
    public String toString() {
        return "EmpleadoPlanta{" +
                "cargo='" + cargo + '\'' +
                ", horasExtras=" + horasExtras +
                ", valorHoraExtras=" + valorHoraExtras +
                ", auxilioDeTransporte=" + auxilioDeTransporte +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
public float calcularSalarioBruto () {
        float bonificacion= calcularBonificacionCategoria();
        float horaEx= horasExtras * valorHoraExtras;
        return getSalarioBase() + bonificacion + horaEx + auxilioDeTransporte;


}


}
