import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        Moneda moneda = consultaMoneda.buscaMoneda();

        String[] opciones = {
                "Dolar a peso colombiano", "Peso colombiano a dolar",
                "Dolar a peso argentino", "Peso argentino a dolar",
                "Dolar a real brasileño", "Real brasileño a dolar",
                "Salir"
        };

        Map<Integer, String> conversionClaves = Map.of(
                1, "COP", 2, "COP",
                3, "ARS", 4, "ARS",
                5, "BRL", 6, "BRL"
        );

        int opcion = 0;
        while (opcion != 7) {
            System.out.println("\n***************************************************");
            System.out.println("Bienvenido al conversor de monedas: ");
            for (int i = 0; i < opciones.length; i++) {
                System.out.println((i + 1) + ". " + opciones[i]);
            }
            System.out.println("Escoja una opcion valida: ");
            System.out.println("***************************************************");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                String clave = conversionClaves.get(opcion);
                System.out.println("Digite la cantidad de " + (opcion % 2 == 1 ? "dolares" : clave) + " a convertir: ");
                double cantidad = scanner.nextDouble();
                double tasaCambio = moneda.conversion_rates().get(clave);

                double resultado = (opcion % 2 == 1) ? cantidad * tasaCambio : cantidad / tasaCambio;
                resultado = Math.round(resultado * 100.0) / 100.0;

                System.out.println(cantidad + (opcion % 2 == 1 ? " dolares equivalen a " : " " + clave + " equivalen a ") + resultado + " " + (opcion % 2 == 1 ? clave : "dolares"));
            } else if (opcion == 7) {
                System.out.println("Gracias por usar el servicio. Hasta luego");
            } else {
                System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
        scanner.close();
    }
}
