package PuAUeb9;
import java.util.Arrays;

public class Aufgabe3und4 {
    public static void main(String[] args) {
        int [] a = {24, 15, 11, 42, 9, 28, 1};

        System.out.println("Array 1: " + Arrays.toString(a));
        //System.out.println("Sorted 1: " + Arrays.toString(BubbleSort(a)));
        System.out.println("Sorted 2: " + Arrays.toString((MergeSort(a))));
    }
    public static int[] BubbleSort (int[] a) {
        boolean flag;
        int j = 0;
        do {
            flag = true;
            for (int i = 0; i < a.length-1-j; i++) {
                if (a[i] > a[i+1]) {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    flag = false;
                }
            }
            j++;
        } while (!flag);
        return a;

        //Übung:
        /*
        for (int i = 0; i <= a.length; i++) {
            boolean swapped = false;
            for (int k = 0; k < a.length-i; k++) {
                if (a[k] > a[k+1]) {
                    swapped = true;
                    int tmp = a[k];
                    a[k] = a[k+1];
                    a[k+1] = tmp;
                }
            }
            if (!swapped) break;
        }*/
    }

    public static int[] MergeSort (int [] a) {
        if (a.length==1) return a;
        else {
            int grenze = a.length/2;
            int[] ersteHaelfte = new int[grenze];
            for (int i = 0; i < grenze; i++) {
                ersteHaelfte[i] = a[i];
            }
            int[] zweiteHaelfte = new int[a.length-grenze];
            for (int i = grenze, j = 0; i < a.length; i++, j++) {
                zweiteHaelfte[j] = a[i];
            }
            int[] F1 = MergeSort(ersteHaelfte);
            int[] F2 = MergeSort(zweiteHaelfte);
            return smartMerge(F1,F2);
        }
    }

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

    public static void MergeSortUebung (int[] a) {
        if (a.length<=1) return;
        int m = (a.length-1)/2;
        int[] left = new int[m+1];
        int[] right = new int[a.length-(m+1)];

        //Split
        for (int i = 0; i < a.length; i++) {
            if (i <= m) left[i] = a[i];
            else right[i-(m+1)] = a[i];
        }

        //Recursion
        MergeSortUebung(left);
        MergeSortUebung(right);

        //Merge
        int[] merged = merge(left, right);

        for (int i = 0; i < a.length; i++) {
            a[i] = merged[i];
        }
    }

    public static int[] merge (int[] a, int[] b) {
        int[] c = new int[a.length+b.length];
        int i_a = 0;
        int i_b = 0;

        for (int i_c = 0; i_c < c.length; i_c++) {
            if (i_c < a.length && (i_b== b.length || a[i_a] <= b[i_b])) {
                c[i_c] = a[i_a];
                i_a++;
            } else {
                c[i_c] = b[i_b];
                i_b++;
            }
        }
        return c;
    }
}
