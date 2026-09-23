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
