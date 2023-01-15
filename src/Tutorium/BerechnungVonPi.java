package Tutorium;

public class BerechnungVonPi {
    public static void main(String[] args) {
        double i = 1;
        double pi = 0;
        int n = 0;
        while (true) {
            pi = pi + 4/i;
            i += 2;
            n++;
            pi = pi - 4/i;
            i +=2;
            n++;
            if (Math.abs(pi - (pi + 4/i)) < 0.0000001) {
                System.out.println(pi);
                System.out.println(n);
                break;
            }

        }
    }
}
