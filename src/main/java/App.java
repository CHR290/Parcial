import java.util.Scanner;

public class App {
    static void main() {        Scanner sc = new Scanner(System.in);
        Supermercado supermercado = new Supermercado("MarketPlus", "Carrera 12", 320892986);
        int opcion;
        do {
            System.out.println("======Menú supermercado======");
            System.out.println("-----Clientes-----");
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
            System.out.println("9. Agregar Compra");
            System.out.println("10. Actualizar Compra");
            System.out.println("11. Eliminar Compra");
            System.out.println("12. Mostrar Compras");

            System.out.println("13. Salir");
            opcion = sc.nextInt();
        }
        while (opcion != 13);
        switch (opcion) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

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
            case 11:

                break;
            case 12:

                break;
            case 13:

                break;
        }
    }
}
