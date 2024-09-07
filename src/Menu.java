import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static final int INGRESAR_DATOS = 1;
    private static final int LISTAR_CANALES = 2;
    private static final int MOSTRAR_CANALES_MAYOR = 3;
    private static final int SALIR = 0;

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        Scanner read = new Scanner(System.in);
        int opcion = -1; 
        Ventas ven = new Ventas(); 

        do {
            mostrarMenu();
            opcion = leerOpcion(read);

            switch (opcion) {
                case INGRESAR_DATOS:
                    ven.ListarCanales();
                    break;
                case LISTAR_CANALES:
                    ven.imprimirCanales();
                    break;
                case MOSTRAR_CANALES_MAYOR:
                    ven.canalMayorVenta();
                    break;
                case SALIR:
                    System.out.println("PROGRAMA CERRADO");
                    break;
                default:
                    System.out.println("OPCIÓN INVÁLIDA, vuelve a ingresar tu opción nuevamente.");
                    break;
            }
        } while (opcion != SALIR);

        read.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n---- Menú de Ventas ----");
        System.out.println("1. Ingrese Datos");
        System.out.println("2. Listar Canales");
        System.out.println("3. Mostrar Canal Mayor");
        System.out.println("0. Salir");
        System.out.print("Escribe una de las opciones: ");
    }

    private static int leerOpcion(Scanner read) {
        int opcion = -1;
        try {
            opcion = read.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresa un número válido.");
            read.next(); 
        }
        return opcion;
    }
}
