package Users;

public class UsuarioAdministrador extends Usuario{
    public UsuarioAdministrador(String id, String nombres, String apellidos, String dni) {
        super(id, nombres, apellidos, dni);
    }

    @Override
    public String toString() {
        return "UsuarioAdministrador{" +
                super.toString()+
                "}";
    }
}

