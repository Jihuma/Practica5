class Cuenta extends Banco {
    private String nombre;
    private long numtarjeta;
    private int pin;
    private float saldo;

    void setNombre(String nombre){
        this.nombre = nombre;
    }

    String getNombre(){
        return this.nombre;
    }

    void setNumtarjeta(long numtarjeta){
        this.numtarjeta = numtarjeta;
    }

    long getNumtarjeta(){
        return this.numtarjeta;
    }

    void setPin(int pin){
        this.pin = pin;
    }

    int getPin(){
        return this.pin;
    }

    void setSaldo(float saldo){
        if(saldo > 0){
            this.saldo = saldo;
        }
    }

    float getSaldo(){
        return this.saldo;
    }

    boolean accesocuenta(long pin){
        return pin == this.pin;
    }

    void depositar() {
        float dinero;

        dinero = Captura.capturaFloat("Ingrese la cantidad a depositar");
        this.saldo += dinero;
        System.out.println("El saldo actual es de: " + this.saldo);
    }

    void retirar() {
        float dinero;

        boolean retiro = false;
        do {
            if(retiro){
                System.out.println("No cuenta con esa cantidad de dinero");
            }

            dinero = Captura.capturaFloat("Ingrese la cantidad a retirar: ");
            retiro = true;
        } while (dinero > this.saldo);
        this.saldo -= dinero;
        System.out.println("Saldo actual: " + this.saldo);
    }
}
