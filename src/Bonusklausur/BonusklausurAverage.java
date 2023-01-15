package Bonusklausur;

import java.util.Arrays;

public class BonusklausurAverage {
    public static void main(String[] args) {
        double[] array = {1, 4, 4, 7};
        System.out.println(Arrays.toString(array));
        System.out.println(average(array));
    }

    public static double average(double[] a) {
        if (a.length==1) return a[0];

        double[] a1 = new double[a.length/2];
        double[] a2 = new double[a.length/2];

        for (int i = 0; i < a1.length; i++) {
            a1[i] = a[i];
        }

        for (int i = a2.length; i < a.length; i++) {
            a2[i-a2.length] = a[i];
        }

        return (average(a1) + average(a2))/2;
    }
}
