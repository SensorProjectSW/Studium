package Bonusklausur;

import java.util.Arrays;

public class BonusklausurAverage {
    public static void main(String[] args) {
        double[] array = {1, 4, 4, 7, 8};
        System.out.println(Arrays.toString(array));
        System.out.println(average(array));
    }

    public static double ownaverage(double[] a) {
        if (a.length==1) return a[0];

        double[] a1 = new double[a.length/2];
        double[] a2 = new double[a.length - a1.length];

        for (int i = 0; i < a1.length; i++) {
            a1[i] = a[i];
        }

        for (int i = a2.length; i < a.length; i++) {
            a2[i-a2.length] = a[i];
        }

        return (ownaverage(a1) + ownaverage(a2))/2;
    }


    public static double average (double[] A) {
        return average(A, 0, A.length-1);
    }

    public static double average (double[] A, int start, int end) {
        if (start == end) {
            return A[start];
        } else {
            int m = (start + end) / 2;
            double a1 = average(A, start, m);
            double a2 = average(A, m+1, end);
            return (a1 + a2) / 2;
        }
    }
}
