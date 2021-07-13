package Users;

public class UsuarioAlmacenero extends Usuario{
   public UsuarioAlmacenero(String id, String nombres, String apellidos, int dni) {
        super(id, nombres, apellidos, dni);
    }

    @Override
    public String toString() {
        return "UsuarioAlmacenero{" +
                super.toString()+
                "}";
    }
}
