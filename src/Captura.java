import java.util.Scanner;

public class Captura {
    public static int capturaEntero(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.println(""+msg+": ");
        return (sc.nextInt());
    }

    public static float capturaFloat(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.println(""+msg+": ");
        return (sc.nextFloat());
    }

    public static String capturaString(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.println(""+msg+": ");
        return (sc.next());
    }

    public static long capturaLong(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.println(""+msg+": ");
        return (sc.nextLong());
    }
}
