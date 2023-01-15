package Tutorium;

public class Primzahltest {
    public static void main(String[] args) {
        int p = 7;

        System.out.println(CheckPrim(p));
    }

    public static boolean CheckPrim(int p) {
        for (int i = 2; i < p/2; i++) {
            if (p%i==0) return false;
        }

        return true;
    }
}
