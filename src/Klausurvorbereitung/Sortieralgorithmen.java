package Klausurvorbereitung;
import java.util.Arrays;

public class Sortieralgorithmen {
    public static void main(String[] args) {
        int[] array = {0, 4, 2, 5, 7, 9, 8, 5};
        System.out.println(Arrays.toString(array));

        System.out.println(Arrays.toString(insertionsort(array)));

        int[] arr = array.clone();
        TimsInsertionSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(BubbleSort(array)));
    }

    public static int[] insertionsort(int[] a) {
        for (int i = 1; i < a.length - 1; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }

    public static void TimsInsertionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j + 1]) break;
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }

    public static int[] BubbleSort(int[] a) {
        boolean flag;
        int j = 0;
        do {
            flag = true;
            for (int i = 0; i < a.length-j-1; i++) {
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
    }
}
