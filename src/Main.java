import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        Banco banco = new Banco();

        while (!salir) {
            System.out.println("---- Bienvenido al banco ----");
            System.out.println("    Seleccione una opcion ");
            System.out.println("1. Crear una cuenta");
            System.out.println("2. Acceder a una cuenta");
            System.out.println("3. Salir.");
            System.out.println("-----------------------------");

            try {
                System.out.println("Opcion: ");
                opcion = scan.nextInt();

                switch (opcion) {
                    case 1 -> {
                        banco.Registro(Captura.capturaString("Ingresa el nombre del titular"), Captura.capturaEntero("Ingresa tu PIN (Este servira para ingresar a tu cuenta)"));
                    }
                    case 2 -> banco.Acceso(Captura.capturaLong("Ingresa tu numero de cuenta"), Captura.capturaEntero("Ingresa tu PIN"));
                    case 3 -> salir = true;
                    default -> System.out.println("Ingrese una opcion valida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scan.next();
            }
        }
    }
}
