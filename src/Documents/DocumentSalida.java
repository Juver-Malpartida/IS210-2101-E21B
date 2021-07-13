package Documents;

import Store.Item;
import Users.Usuario;

import java.text.ParseException;

public class DocumentSalida extends Documento{
    private String cliente;

    public DocumentSalida(String id_Documento, Usuario usuario, String fecha, Item item, String cliente) throws ParseException {
        super(id_Documento, usuario, fecha, item);
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "DocumentSalida{" +
                super.toString()+
                ", cliente='" + cliente + '\'' +
                ", "+getItem()+
                ", Valor Final= " + getItem().calcularValorSalida()+
                '}';
    }
}
