package PuAUeb2;

public class PuAUebungsblatt2Aufgabe3 {
    public static int forloop(int[] a) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }

        return sum;
    }

    public static int whileloop(int[] a) {
        int sum = 0;
        int i = 0;

        while (i < a.length) {
            sum = sum + a[i];
            i++;
        }

        return sum;
    }

    public static int dowhileloop(int[] a) {
        int sum = 0;
        int i = 0;

        do {
            if (a.length == 0) {
                return sum;
            } else {
                sum = sum + a[i];
                i++;
            }
        } while (i<a.length);

        return sum;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 7, 5};
        //int[] a = {};

        System.out.println(forloop(a));
        System.out.println(whileloop(a));
        System.out.println(dowhileloop(a));
    }
}
