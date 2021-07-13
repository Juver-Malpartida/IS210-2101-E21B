package Documents;

public abstract class Documento {
   private String id_Documento;
    private Usuario usuario;
    private String fecha;
    private Item item;

    public Documento(String id_Documento, Usuario usuario, String fecha, Item item) {
        this.id_Documento = id_Documento;
        this.usuario = usuario;
        this.fecha = fecha;
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return //"Documento{" +
                "id_Documento='" + id_Documento + '\'' +
                ", usuario=" + usuario.getNombres()+" " + usuario.getApellidos() +
                        //", usuario" + usuario+
                ", fecha='" + fecha + '\'' ;
               //'}';
    }
}
