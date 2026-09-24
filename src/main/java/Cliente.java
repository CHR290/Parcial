import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private int documento;
    private int telefono;
    private String correo;
    private List<Compra> listaCompras;

    public Cliente(String nombre, int documento, int telefono, String correo) {
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.correo = correo;
        this.listaCompras = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public void agregarCompra(Compra compra){
        listaCompras.add(compra);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "\n nombre='" + nombre +
                "\n documento=" + documento +
                "\n telefono=" + telefono +
                "\n correo='" + correo +
                "\n listaCompras=" + listaCompras +
                '}';
    }
}
