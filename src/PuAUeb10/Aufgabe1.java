package PuAUeb10;
import java.util.Scanner;

public class Aufgabe1 {
    public static void main (String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = Double.parseDouble(scn.nextLine());
        Scanner scn2 = new Scanner(System.in);
        System.out.print("Enter k: ");
        int k = Integer.parseInt(scn2.nextLine());

        System.out.println("a^k: " + pot(a,k));
    }

    public static double pot(double a, int k) {
        if (k==0) return 1;
        double pot = pot(a,k/2);
        if (k%2 == 0) return pot*pot;
        else return a*pot*pot;
    }

    public static double potuebung(double a, int k) {
        if (k==0) return 1.0;
        double tmp = potuebung(a, k/2);
        double pow = tmp * tmp;
        if (k%2 == 0) pow *= a;
        return pow;
    }
}
