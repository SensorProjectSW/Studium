package PuAUeb7;
import java.util.Arrays;

public class Aufgabe4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        int[] brr = {4};

        System.out.println("Array 1: " + Arrays.toString(arr));
        System.out.println("Array 2: " + Arrays.toString(brr));
        System.out.println("= Array 3: " + Arrays.toString(smartMerge(arr, brr)));
    }

    //in O(la+lb):
    public static int[] smartMerge(int[] a, int[] b) {
        int ia = a.length;
        int ib = b.length;
        int[] c = new int[a.length+ b.length];
        int index = c.length;
        while (index>0){
            if (ia!=0 && ib!=0) {
                if (a[ia-1] > b[ib-1]) {
                    c[index-1] = a[ia-1];
                    ia--;
                } else if (a[ia-1] < b[ib-1]) {
                    c[index-1] = b[ib-1];
                    ib--;
                }
            } else if (ia == 0) {
                c[index-1] = b[ib-1];
                ib--;
            } else if (ib == 0) {
                c[index-1] = a[ia-1];
                ia--;
            }
            index--;
        }
        return c;
    }
}
