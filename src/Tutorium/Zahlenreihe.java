package Tutorium;

public class Zahlenreihe {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0;i <= 2*n; i++) {
            if (i%2==0) System.out.println(i);
        }
    }
}
