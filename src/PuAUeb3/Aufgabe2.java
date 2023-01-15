package PuAUeb3;

public class Aufgabe2 {
    public static boolean CheckIfBefreundet(int a, int b) {
        if (a == b) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i <= a/2; i++) {
            if (a % i == 0) {
                sum += i;
            }
        }
        if (sum == b) {
            sum = 0;
            for (int i = 1; i <= b/2; i++) {
                if (b % i == 0) {
                    sum += i;
                }
            }
            if (sum == a) {
                return true;
            }
        }
        return false;
    }

    public static void GetAllBefreundet(int o) {
        for (int i = 1; i < o; i++) {
            for (int j = i; j < o; j++) {
                /* if (i == j) {
                    continue;
                }*/
                if (CheckIfBefreundet(i, j)) {
                    System.out.println("a=" + i + " b=" + j);
                }
            }
        }
    }

    public static void main (String[] args) {
        int a = 220; int b = 284; int o = 400;

        System.out.println(CheckIfBefreundet(a, b));
        GetAllBefreundet(o);
    }
}
