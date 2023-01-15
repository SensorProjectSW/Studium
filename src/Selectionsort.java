import java.util.Arrays;

public class Selectionsort {
    public static void main(String[] args) {
        double[] array = {1, 4, 2, 56, 7, 9, 3, 0, 8};
        System.out.println(Arrays.toString(array));
        selection(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selection(double[] a) {
        for (int i = 0; i < a.length; i++) {
            int max = 0;
            for (int j = 0; j < a.length-i; j++) {
                if (a[max] < a[j]) max = j;
            }
            double tmp = a[max];
            a[max] = a[a.length-i-1];
            a[a.length-i-1]=tmp;
        }
    }
}
