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
        String correo;
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
