import java.util.Scanner;
import java.util.ArrayList;

public class Banco {
    int j, opcion;
    ArrayList<Cuenta> bankaccounts = new ArrayList<>();

    public void Registro(String nombre, int pin, float dinero) {
        Cuenta newaccount = new Cuenta();
        newaccount.setNombre(nombre);
        newaccount.setNumtarjeta(crearnumtarjeta());
        newaccount.setPin(pin);
        newaccount.setSaldo(dinero);
        this.bankaccounts.add(newaccount);
    }

    public void Registro(String nombre, int pin){
        Cuenta newaccount = new Cuenta();
        newaccount.setNombre(nombre);
        newaccount.setNumtarjeta(crearnumtarjeta());
        newaccount.setPin(pin);
        newaccount.setSaldo(Captura.capturaFloat("Ingresa la cantidad de tu primer deposito"));
        this.bankaccounts.add(newaccount);
        System.out.println("Cuenta registrada con exito");
        imprimirDatos(this.bankaccounts.size()-1);
    }

    private long crearnumtarjeta(){
        int i;
        int numero;
        numero = 1;
        for (i = 0; i < this.bankaccounts.size() ; i++) {
            numero++;
        }
        return numero;
    }

    private void imprimirDatos(int dato){
        System.out.println("Titular: "+this.bankaccounts.get(dato).getNombre());
        System.out.println("Numero de la Tarjeta: "+this.bankaccounts.get(dato).getNumtarjeta());
        System.out.println("Saldo actual: "+this.bankaccounts.get(dato).getSaldo());
    }

    public void Acceso(long numtarjeta,int pin){
        int datoCuenta;
        datoCuenta = buscarCuenta(numtarjeta);
        if(this.bankaccounts.get(datoCuenta).accesocuenta(pin)) {
            System.out.println("Accesado con exito");
            Menu(this.bankaccounts.get(datoCuenta).getNombre(),datoCuenta);
        }
        else {
            System.out.println("PIN incorrecto");
            System.exit(0);
        }
    }

    private int buscarCuenta(long cuenta){
        int k;
        for (k = 0; k < this.bankaccounts.size(); k++){
            if(this.bankaccounts.get(k).getNumtarjeta() == cuenta) {
                return k;
            }
        }
        System.out.println("No se encontro ninguna cuenta con ese numero de cuenta");
        System.exit(0);
        return 0;
    }

    private void Menu(String nombre, int dato){
        Scanner sn = new Scanner(System.in);
        System.out.println("Bienvenido: " + nombre);
        do {
            j = 0;
            System.out.println("Seleccione una opcion");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Salir");
            System.out.println("Opcion:");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1 -> this.bankaccounts.get(dato).depositar();
                case 2 -> {
                    System.out.println("Saldo actual: " + this.bankaccounts.get(dato).getSaldo());
                    this.bankaccounts.get(dato).retirar();
                }
                case 3-> j = 1;
                default -> System.out.println("\n----- Ingrese una opcion valida -----\n");
            }
        } while ( j == 0);
    }

}
