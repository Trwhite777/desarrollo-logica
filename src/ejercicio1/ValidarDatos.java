package ejercicio1;
import java.util.Scanner;

public class ValidarDatos {

    public static String validarCadenasVacias(String nombre) {
        Scanner scanner = new Scanner(System.in);
        while (nombre.isEmpty()) {
            try {
                System.out.println("INVALIDO INGRESE NUEVAMENTE");
                nombre = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("TIPO DE DATO");
            }
        }
        System.out.println("DATO YA HA SIDO INGRESADO EXITOSAMENTE");
        return nombre;
    }

    public static int validarNumeroNegativos(int numero) {
        Scanner scanner = new Scanner(System.in);
        while (numero<0) {
            try {
                System.out.println("INVALIDO INGRESE NUEVAMENTE");
                numero = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("TIPO DE DATO");
            }
        }
        System.out.println("DATO YA HA SIDO INGRESADO EXITOSAMENTE");
        return numero;
    }

}
