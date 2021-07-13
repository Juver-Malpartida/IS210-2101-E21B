package Users;

public abstract class Usuario {
       private String id;
    private String nombres;
    private String apellidos;
    private int dni;

    public Usuario(String id, String nombres, String apellidos, int dni) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    @Override
    public String toString() {
        return 
                "id='" + id + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni=" + dni;
    }

}
