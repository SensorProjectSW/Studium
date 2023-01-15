package PuAUeb6;

public class Aufgabe5 {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        int x = 2;

        while (true) {
            if (f(x,a) < g(b,x)) {
                System.out.println(x);
                break;
            }
            x++;
        }
    }

    public static double f(int x, double a) {
        return Math.pow(x,a);
    }
    public static double g(double b, int x) {
        return Math.pow(b,x);
    }
}
