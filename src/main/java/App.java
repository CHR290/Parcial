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
        int opcionCategoria;
        Categoria categoria = null;
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
            System.out.println("10. consultar reporte");


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
                    System.out.println("---Agregar producto---");
                    System.out.println("ingrese el nombre del producto: ");
                    nombre = sc.nextLine();
                    System.out.println("ingrese la cantidad: ");
                    cantidad = Integer.parseInt(sc.nextLine());
                    System.out.println("ingrese el codigo: ");
                    codigoProducto = Integer.parseInt(sc.nextLine());
                    System.out.println("ingrese el precio por unidad: ");
                    precio = Integer.parseInt(sc.nextLine());
                    System.out.println("ingrese la categoria");
                    System.out.println("1. Alimentos");
                    System.out.println("2. Bebidas");
                    System.out.println("3. Aseo");
                    System.out.println("4. Cuidado personal");
                    opcionCategoria = Integer.parseInt(sc.nextLine());
                    switch(opcionCategoria){
                        case 1:
                            categoria = Categoria.ALIMENTOS;
                            break;
                        case 2:
                            categoria = Categoria.BEBIDAS;
                            break;
                        case 3:
                            categoria = Categoria.ASEO;
                            break;
                        case 4:
                            categoria = Categoria.CUIDADO_PERSONAL;
                            break;
                    }
                    Producto producto = new Producto(codigoProducto,nombre,categoria, precio, cantidad);
                    if(supermercado.agregarProducto(producto)){
                        System.out.println("producto agregado correctamente");
                    }else{
                        System.out.println("el producto ya existe");
                    }
                    break;
                case 6:
                    System.out.println("ingrese el codigo: ");
                    codigoProducto = Integer.parseInt(sc.nextLine());
                    System.out.println("---Actualizar producto---");
                    System.out.println("ingrese el nuevo nombre del producto: ");
                    nombre = sc.nextLine();
                    System.out.println("ingrese la nueva cantidad: ");
                    cantidad = Integer.parseInt(sc.nextLine());
                    System.out.println("ingrese el nuevo precio por unidad: ");
                    precio = Integer.parseInt(sc.nextLine());
                    System.out.println("ingrese la nueva categoria");
                    System.out.println("1. Alimentos");
                    System.out.println("2. Bebidas");
                    System.out.println("3. Aseo");
                    System.out.println("4. Cuidado personal");
                    opcionCategoria = Integer.parseInt(sc.nextLine());
                    switch(opcionCategoria){
                        case 1:
                            categoria = Categoria.ALIMENTOS;
                            break;
                        case 2:
                            categoria = Categoria.BEBIDAS;
                            break;
                        case 3:
                            categoria = Categoria.ASEO;
                            break;
                        case 4:
                            categoria = Categoria.CUIDADO_PERSONAL;
                            break;
                    }
                    if(supermercado.actualizarProducto(codigoProducto, nombre, categoria, precio, cantidad)){
                        System.out.println("el producto se ha actualziado correctamente");
                    }else{
                        System.out.println("no se ha encontrado el producto");
                    }
                    break;
                case 7:
                    System.out.println("---Eliminar producto---");
                    System.out.println("ingrese el codigo del producto: ");
                   codigoProducto = Integer.parseInt(sc.nextLine());
                    if(supermercado.eliminarProducto(codigoProducto)){
                        System.out.println("Producto eliminado correctamente");
                    }else{
                        System.out.println("no se ha encontrado el producto");
                    }
                    break;
                case 8:
                    System.out.println("---Mostrar producto---");
                    System.out.println("ingrese el codigo, ingrese 0 para ver la lista completa");
                    codigoProducto = Integer.parseInt(sc.nextLine());
                    if(codigoProducto ==0){
                        for(Producto producto1: supermercado.getListaProductos()){
                            System.out.println(producto1);
                        }
                    }else{
                        for(Producto producto1: supermercado.getListaProductos()){
                            if(producto1.getCodigo()==codigoProducto){
                                System.out.println(producto1);
                                break;
                            }
                        }
                    }
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
                                for(Producto producto1: supermercado.getListaProductos()){
                                    if(producto1.getCodigo()==codigoProducto){
                                        productos.add(producto1);
                                        valorTotal += producto1.getPrecio()*cantidad;
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
                        System.out.println("--resumen--");
                        System.out.println(compra);
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
