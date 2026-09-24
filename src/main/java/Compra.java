import java.util.Date;
import java.util.List;
public class Compra {
    private int codigo;
    private Date fecha;
    private MetodoDePago metodoDePago;
    double valorTotal;
    private List<Producto> listaProductos;

    public Compra(int codigo, MetodoDePago metodoDePago, double valorTotal, List<Producto> productos) {
        this.codigo = codigo;
        this.fecha = new Date();
        this.metodoDePago = metodoDePago;
        this.valorTotal = valorTotal;
        listaProductos = productos;
    }
    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public MetodoDePago getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(MetodoDePago metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Producto> getProductos() {
        return listaProductos;
    }

    public void setProductos(List<Producto> productos) {
        this.listaProductos = productos;
    }

    @Override
    public String toString() {
        return "compra{" +
                "\ncodigo=" + codigo +
                "\n fecha=" + fecha +
                "\n metodoDePago=" + metodoDePago +
                "\n valorTotal=" + valorTotal +
                "\n listaProductos="+ listaProductos +
                '}';
    }
}
