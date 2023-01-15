package Tutorium;
import java.util.Arrays;

public class Sortierung {
    public static void main(String[] args) {
        int[] a = {3, 9, 2, 5, 8, 10};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(sort(a)));
    }
    public static int[] sort (int[] array) {
        int i=0;
        while (true) {
            if (sorted(array)) return array;
            if (i+1 > array.length) i=0;
            if (array[i] > array[i+1]) {
                int temp = array[i+1];
                array[i+1] = array[i];
                array[i] = temp;
            }
            i++;
        }
    }
    public static boolean sorted (int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] < array[i+1]) return false;
        }
        return true;
    }
}
