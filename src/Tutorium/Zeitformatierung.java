package Tutorium;

public class Zeitformatierung {
    public static void main(String[] args) {
        int a = 284712;
        int s = a%60;
        int m = a/60%60;
        int h = a/60/60%24;
        int d = a/60/60/24;

        System.out.println(a);
        System.out.println(s);
        System.out.println(m);
        System.out.println(h);
        System.out.println(d);
    }
}
