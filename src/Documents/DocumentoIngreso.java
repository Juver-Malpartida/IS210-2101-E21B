package Documents;

public class DocumentoIngreso extends Documento{
      private String proveedor;

    public DocumentoIngreso(String id_Documento, Usuario usuario, String fecha, Item item, String proveedor) {
        super(id_Documento, usuario, fecha, item);
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "DocumentoIngreso{" +
                super.toString()+
                ", proveedor='" + proveedor + '\'' +
                ", "+super.getItem()+
                ", valor final= " + super.getItem().calcularValorEntrada()+
                '}';
    }
}
