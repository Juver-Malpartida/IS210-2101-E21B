package Documents;

import Store.Item;
import Users.Usuario;

import java.text.ParseException;

public class DocumentoIngreso extends Documento{
    private String proveedor;

    public DocumentoIngreso(String id_Documento, Usuario usuario, String fecha, Item item, String proveedor) throws ParseException {
        super(id_Documento, usuario, fecha, item);
        this.proveedor = proveedor;
    }

    public String getProveedor() {
        return proveedor;
    }

    @Override
    public String toString() {
        return "DocumentoIngreso{" +
                super.toString()+
                ", proveedor='" + proveedor + '\'' +
                ", "+getItem()+
                ", valor final= " + getItem().calcularValorEntrada()+
                '}';
    }
}
