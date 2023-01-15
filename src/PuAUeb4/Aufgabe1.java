package PuAUeb4;

public class Aufgabe1 {
    public static void main(String[] args) {
        int x = 2;
        int y = -3;

        System.out.println(f(x, y));
    }

    public static double f(int x, int y) {
        if (y == 0) {
            return 1.0;
        } else if (y < 0) {
            double erg = 1;
            for (int i = 0; i < -y; i++) {
                erg = erg * x;
            }
            return (1.0) / erg;
        } else {
            double erg = 1;
            for (int i = 0; i < y; i++) {
                erg = erg * x;
            }
            return erg;
        }
    }
}
