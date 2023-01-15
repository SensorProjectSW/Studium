package PuAUeb2;

public class Aufgabe4 {
    public static int[] getPosI(int[] list) {
        // liefert alle positiven Stellen des Arrays,
        // da diese mögliche Startpositionen sein könnten
        int counter = 0;
        for (int i = 0; i < list.length; i++) {
            //Zählen aller positiven Stellen
            if (list[i] > 0) {
                counter++;
            }
        }
        int[] array = new int[counter];
        for (int i = 0; i < list.length; i++) {
            //Erzeugen eines Arrays mit den positiven Stellen
            if (list[i] > 0) {
                int c = 0;
                array[c] = list[i];
            }
        }
        return array;
    }
    public static int[] gethighestSum(int[] list, int start) {
        //liefert die höchste Summe für jede mögliche Startposition
        // und deren Ende in einem Array
        int highestSum = list[start];
        int partsum = 0;
        int end = list[start];
        for (int i = start; i < list.length; i++) {
            partsum = partsum + list[i];
            if (partsum > highestSum) {
                highestSum = partsum;
                end = i;
            }
        }
        int[] ret = new int[2];
        ret[0] = highestSum; ret[1] = end;
        return ret;
    }

    public static void main(String[] args) {
        int[] a = {31, -41, 59, 26, -53, 58, 97, -93, -23, 84};
        //int[] a = {};
        int[] start = getPosI(a);
        int maxSum = -999999999;
        int j = 0;
        int i = 0;

        if (a.length == 0) {
            maxSum = 0;
            j = -1;
            i = -1;
        } else {
            for (int n = 0; n < start.length; n++) {
                int[] check = gethighestSum(a, n);
                if (check[0] > maxSum) {
                    maxSum = check[0];
                    j = check[1];
                    i = n;
                }
            }
        }
        System.out.println("Maximale Summe: " + maxSum);
        System.out.println("Start: " + i + " Ende: " + j);
    }
}