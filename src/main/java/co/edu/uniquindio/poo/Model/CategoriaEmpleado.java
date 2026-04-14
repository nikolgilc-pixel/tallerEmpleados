package co.edu.uniquindio.poo.Model;

public enum CategoriaEmpleado {
    JUNIOR, SEMI_SENIOR, SENIOR;

    public static CategoriaEmpleado obtenerCategoria(int opcionCategoria) {
        switch (opcionCategoria) {
            case 1:
                return JUNIOR;
            case 2:
                return SEMI_SENIOR;
            case 3:
                return SENIOR;
            default:
                throw  new IllegalArgumentException( "Opción Inválida");
        }

    }


}
