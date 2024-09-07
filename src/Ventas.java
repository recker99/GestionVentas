import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Ventas {
    // Atributos para registrar las ventas de cada canal
    private int[] ventasXcanal;
    private String[] nombresCanales = {"Presencial", "Telefónico", "Tienda web", "Tienda móvil"};
    private NumberFormat numberFormat; // Formateador de números para CLP

    // Constructor sin parámetros
    public Ventas() {
        ventasXcanal = new int[4];
        // Inicializa el formateador para usar separadores de miles y el símbolo de CLP (Pesos Chilenos)
        numberFormat = NumberFormat.getCurrencyInstance(new Locale("es", "CL"));
    }

    // Método para ingresar ventas por canal
    public void ListarCanales() {
        Scanner read = new Scanner(System.in);
        System.out.println("\nSeleccione el canal al que se le agregarán los datos:");
        System.out.println("1- Presencial");
        System.out.println("2- Telefónico");
        System.out.println("3- Tienda web");
        System.out.println("4- Tienda móvil");
        System.out.print("Ingrese el número del canal: ");
        int canalOpcion = read.nextInt();

        if (canalOpcion >= 1 && canalOpcion <= 4) {
            System.out.print("Ingrese el monto de la venta: ");
            int monto = read.nextInt();
            sumarVentas(monto, canalOpcion);
            System.out.println("Venta agregada exitosamente al canal " + nombresCanales[canalOpcion - 1] + ".");
        } else {
            System.out.println("Canal no válido.");
        }
    }

    // Método para sumar ventas al canal correspondiente
    public void sumarVentas(int montoVenta, int canal) {
        if (canal >= 1 && canal <= 4) {
            ventasXcanal[canal - 1] += montoVenta;
        } else {
            System.out.println("Canal no válido.");
        }
    }

    // Método para imprimir el total de ventas por canal
    public void imprimirCanales() {
        System.out.println("\nNombre del Canal   |   Total de Ventas");
        System.out.println("----------------------------------------");
        for (int i = 0; i < ventasXcanal.length; i++) {
            // Formatear el valor con separador de miles y el símbolo CLP
            String ventasFormateadas = numberFormat.format(ventasXcanal[i]);
            System.out.println(nombresCanales[i] + "     |   " + ventasFormateadas);
        }
    }

    // Método que muestra el canal con mayor venta y su monto
    public void canalMayorVenta() {
        int indiceMayor = 0;
        for (int i = 1; i < ventasXcanal.length; i++) {
            if (ventasXcanal[i] > ventasXcanal[indiceMayor]) {
                indiceMayor = i;
            }
        }
        // Formatear el valor con separador de miles y el símbolo CLP
        String ventasMayorFormateadas = numberFormat.format(ventasXcanal[indiceMayor]);
        System.out.println("\nCanal con mayor venta: " + nombresCanales[indiceMayor]);
        System.out.println("Monto acumulado de ventas: " + ventasMayorFormateadas);
    }
}
