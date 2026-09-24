import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Supermercado {
    private String nombreComercial;
    private String direccion;
    private int telefono;
    private List<Cliente> listaClientes;
    private List<Compra> historialCompras;
    private List<Producto> listaProductos;
    private SimpleDateFormat formateadorDia;

    public Supermercado(String nombreComercial, String direccion, int telefono) {
        this.nombreComercial = nombreComercial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaClientes = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
        this.historialCompras = new ArrayList<>();
        this.formateadorDia = new SimpleDateFormat("dd/MM/yyyy");
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Compra> getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(List<Compra> historialCompras) {
        this.historialCompras = historialCompras;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public boolean agregarCliente(Cliente cliente) {
        boolean agregado = false;
        if (!verificarCliente(cliente.getDocumento())) {
            listaClientes.add(cliente);
            agregado = true;
        }
        return agregado;
    }

    public boolean verificarCliente(int documento) {
        boolean existe = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getDocumento() == documento) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    public boolean actualizarCliente(int documento, String nombre, int telefono, String correo) {
        boolean actualizado = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getDocumento() == documento) {
                cliente.setNombre(nombre);
                cliente.setCorreo(correo);
                cliente.setTelefono(telefono);
                actualizado = true;
                break;
            }
        }
        return actualizado;
    }

    public boolean eliminarCliente(int documento) {
        boolean eliminado = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getDocumento() == documento) {
                listaClientes.remove(cliente);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }

    public boolean mostrarCliente(int documento){
        boolean existe = false;
        for(Cliente cliente:listaClientes){
            if(cliente.getDocumento()==documento){
                System.out.println(cliente);
                existe = true;
                break;
            }
        }
        return existe;
    }

    public boolean verificarStockProducto(int codigo, int cantidad) {
        boolean disponible = false;
        for (Producto producto : listaProductos) {
            if (producto.getCodigo() == codigo && producto.getCantidad() >= cantidad) {
                disponible = true;
                actualizarProducto(codigo, producto.getNombre(),producto.getCategoria(),producto.getPrecio(), producto.getCantidad()-cantidad);
                break;
            }
        }
        return disponible;
    }

    public boolean registrarCompra(int documento, Compra compra) {
        boolean exitoso = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getDocumento() == documento) {
                cliente.agregarCompra(compra);
                historialCompras.add(compra);
                exitoso = true;
            }
        }
        return exitoso;
    }

    public boolean agregarProducto(Producto producto) {
        boolean agregado = false;
        if (!verificarCliente(producto.getCodigo())) {
            listaProductos.add(producto);
            agregado = true;
        }
        return agregado;
    }

    public boolean verificarProducto(int codigo) {
        boolean existe = false;
        for (Producto producto : listaProductos) {
            if (producto.getCodigo() == codigo) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    public boolean actualizarProducto(int codigo, String nombre, Categoria categoria, double precio, int cantidad){
        boolean actualizado = false;
        for(Producto producto: listaProductos){
            if(producto.getCodigo()==codigo){
                producto.setNombre(nombre);
                producto.setCategoria(categoria);
                producto.setPrecio(precio);
                producto.setCantidad(cantidad);
                actualizado = true;
            }
        }
        return actualizado;
    }

    public boolean eliminarProducto(int codigo) {
        boolean eliminado = false;
        for (Producto producto : listaProductos) {
            if (producto.getCodigo() == codigo){
                listaProductos.remove(producto);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }

    public boolean mostrarProducto(int codigo){
        boolean existe = false;
        for(Producto producto:listaProductos){
            if(producto.getCodigo()==codigo){
                System.out.println(producto);
                existe = true;
                break;
            }
        }
        return existe;
    }

    public List<Compra> consultarReporte(String fecha){
        List<Compra> reporteDeCompras = new ArrayList<>();
        for(Compra compra:historialCompras){
            String fechaCompra = formateadorDia.format(compra.getFecha());
            if(fechaCompra.equals(fecha)){
                System.out.println(compra);
            }
        }
        return reporteDeCompras;
    }

    @Override
    public String toString() {
        return "Supermercado{" +
                "\n nombreComercial='" + nombreComercial + '\'' +
                "\n direccion='" + direccion + '\'' +
                "\n telefono=" + telefono +
                "\n listaClientes=" + listaClientes +
                "\n historialCompras=" + historialCompras +
                "\n listaProductos=" + listaProductos +
                '}';
    }

}
