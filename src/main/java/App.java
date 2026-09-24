import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
public class App {
    static void main(){
        Scanner sc = new Scanner(System.in);
        Supermercado supermercado = new Supermercado("MarketPlus", "Carrera 12", 320892986);
        int opcion = 0;
        String nombre;
        int documento;
        int telefono;
        int cantidad = 0;
        double precio;
        String correo;
        int codigoProducto;
        int codigoCompra = 1;
        do {
            System.out.println("======Menú supermercado======");
            System.out.println("-----Clientes  -----");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Actualizar cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Mostrar clientes");

            System.out.println("-----Productos-----");
            System.out.println("5. Agregar producto");
            System.out.println("6. Actualizar producto");
            System.out.println("7. Eliminar producto");
            System.out.println("8. Mostrar productos");

            System.out.println("-----Compra-----");
            System.out.println("9. Registrar Compra");
            System.out.println("10. Mostrar reporte");


            System.out.println("0. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("---Agregar cliente---");
                    System.out.println("ingrese el nombre: ");
                    nombre = sc.nextLine();

                    System.out.println("ingrese el documento: ");
                    documento = Integer.parseInt(sc.nextLine());
                    System.out.println("ingrese el telefono: ");
                    telefono = Integer.parseInt(sc.nextLine());
                    System.out.println("ingrese el correo: ");
                    correo = sc.nextLine();
                    Cliente cliente = new Cliente(nombre, documento, telefono, correo);
                    if(supermercado.agregarCliente(cliente)){
                        System.out.println("cliente agregado correctamente");
                    }else{
                        System.out.println("el cliente ya existe");
                    }
                    break;
                case 2:
                    System.out.println("---Actualizar cliente---");
                    System.out.println("ingrese el documento: ");
                    documento = Integer.parseInt(sc.nextLine());
                    System.out.println("ingrese el nuevo nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("ingrese el nuevo telefono: ");
                    telefono = Integer.parseInt(sc.nextLine());
                    System.out.println("ingrese el nuevo correo: ");
                    correo = sc.nextLine();
                    if(supermercado.actualizarCliente(documento, nombre, telefono, correo)){
                        System.out.println("cliente actualizado correctamente");
                    }else{
                        System.out.println("no se ha encontrado al cliente");
                    }
                    break;
                case 3:
                    System.out.println("---eliminar cliente---");
                    System.out.println("ingrese el documento: ");
                    documento = Integer.parseInt(sc.nextLine());
                    if(supermercado.eliminarCliente(documento)){
                        System.out.println("cliente eliminado correctamente");
                    }else{
                        System.out.println("no se ha encontrado al cliente");
                    }

                    break;
                case 4:
                    System.out.println("---Mostrar cliente---");
                    System.out.println("ingrese el documento, ingrese 0 para ver la lista completa");
                    documento = Integer.parseInt(sc.nextLine());
                    if(documento==0){
                        for(Cliente cliente1: supermercado.getListaClientes()){
                            System.out.println(cliente1);
                        }
                    }else{
                        for(Cliente cliente1: supermercado.getListaClientes()){
                            if(cliente1.getDocumento()==documento){
                                System.out.println(cliente1);
                                break;
                            }
                        }
                    }
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:
                    System.out.println("---registrar compra---");
                    boolean clienteEncontrado = false;
                    do {
                        System.out.println("ingrese el documento del cliente");
                        documento = Integer.parseInt(sc.nextLine());
                        if(supermercado.verificarCliente(documento)){
                            clienteEncontrado = true;
                        }else{
                            System.out.println("no se ha encontrado al cliente");
                        }
                    }while(!clienteEncontrado);
                    MetodoDePago metodoDePago = null;
                    int eleccion = 1;
                    List<Producto> productos = new ArrayList<>();
                    double valorTotal = 0;
                    do{
                        System.out.println("1. agregar producto a la compra");
                        System.out.println("2. continuar");
                        eleccion = Integer.parseInt(sc.nextLine());
                        if(eleccion==1){
                            System.out.println("ingrese el codigo del producto: ");
                            codigoProducto = Integer.parseInt(sc.nextLine());
                            System.out.println("ingrese la cantidad: ");
                            cantidad: Integer.parseInt(sc.nextLine());
                            if(supermercado.verificarStockProducto(codigoProducto, cantidad)){
                                for(Producto producto: supermercado.getListaProductos()){
                                    if(producto.getCodigo()==codigoProducto){
                                        productos.add(producto);
                                        valorTotal += producto.getPrecio();
                                    }
                                }
                            }
                        }
                    }while(eleccion==1);
                    System.out.println("seleccione el metodo de pago");
                    System.out.println("1. Tarjeta");
                    System.out.println("2. transferencia");
                    System.out.println("3. Efectivo");
                    eleccion = Integer.parseInt(sc.nextLine());
                    switch(eleccion){
                        case 1:
                            metodoDePago = MetodoDePago.TARJETA;
                            break;
                        case 2:
                            metodoDePago = MetodoDePago.TRASNFERENCIA;
                            break;
                        case 3:
                            metodoDePago = MetodoDePago.EFECTIVO;
                            break;
                    }
                    Compra compra = new Compra(codigoCompra, metodoDePago, valorTotal, productos);
                    if(supermercado.registrarCompra(documento, compra)){
                        System.out.println("se ha registrado la compra con exito");
                    }else{
                        System.out.println("no se ha podido registrar la compra");
                    }
                    break;
                case 10:

                    break;
                case 0:

                    break;

            }
            if (opcion != 0) {
                System.out.println("\nPresione ENTER para continuar...");
                sc.nextLine(); // Espera a que presione ENTER
            }
        } while (opcion != 0);
    }
}
