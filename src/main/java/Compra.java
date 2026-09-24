import java.util.Date;
public class Compra {
    private int codigo;
    private Date fecha;
    private MetodoDePago metodoDePago;
    double valorTotal;

    public Compra(int codigo, MetodoDePago metodoDePago, double valorTotal, List<Producto> productos) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.metodoDePago = metodoDePago;
        this.valorTotal = valorTotal;
        listaProductos = productos;
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

    @Override
    public String toString() {
        return "compra{" +
                "codigo=" + codigo +
                ", fecha=" + fecha +
                ", metodoDePago=" + metodoDePago +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
