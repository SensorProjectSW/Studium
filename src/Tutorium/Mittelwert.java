package Tutorium;

public class Mittelwert {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6, 9};
        double s = 0;

        for (int i = 0; i < a.length; i++) {
            s += a[i];
        }

        System.out.println(s/a.length);
    }
}
