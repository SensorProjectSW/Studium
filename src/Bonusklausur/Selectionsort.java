package Bonusklausur;

import java.util.Arrays;

public class Selectionsort {
    public static void main(String[] args) {
        int[] array = {1, 4, 2, 56, 7, 9, 3, 0, 8};
        System.out.println(Arrays.toString(array));
        selection(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selection(int[] a) {
        for (int end = a.length - 1; end >= 1; --end) {
            int max_i = 0;
            for (int i = 0; i <= end; ++i) {
                if (a[i] > a[max_i]) max_i = i;
            }
            int temp = a[max_i];
            a[max_i] = a[end];
            a[end] = temp;
        }
    }
}
