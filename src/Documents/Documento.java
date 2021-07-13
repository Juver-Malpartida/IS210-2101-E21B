package Documents;

import Store.Item;
import Users.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class Documento {
    private String id_Documento;
    private Usuario usuario;
    private Date fecha;
    private Item item;

    public Documento(String id_Documento, Usuario usuario, String fecha, Item item) throws ParseException {
        this.id_Documento = id_Documento;
        this.usuario = usuario;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.fecha = simpleDateFormat.parse( fecha);
        this.item = item;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getFecha() {
        return fecha;
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
