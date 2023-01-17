package PuAUeb10;

public class Aufgabe3 {
    public static void main(String[] args) {
        int[] a = {8,-14,0,1,2,2,2,2};
        int[] end = MinMax(a);
        System.out.println("Minimum: " + end[0]);
        System.out.println("Maximum: " + end[1]);
    }

    public static int[] MinMax(int[] a) {
        return MinMaxRec(a, 0, a.length);
    }

    public static int[] MinMaxRec(int[] a, int i, int j) {
        if (a.length==0) return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        if (i==j) return new int[] {a[i], a[j]};
        if (j - i == 2) {
            if (a[i] > a[j-1]) return new int[] {a[j-1], a[i]};
            else return new int[] {a[i], a[j-1]};
        } else {
            int[] b = MinMaxRec(a,i,(i+j)/2);
            int min1 = b[0], max1 = b[1];

            int[] c = MinMaxRec(a,(i+j)/2,j);
            int min2 = c[0], max2 = c[1];

            int min, max;

            if (min1 < min2) min = min1; else min = min2;
            if (max1 > max2) max = max1; else max = max2;

            return new int[] {min, max};
        }
    }


    public static int[] uebung(int[] a) {
        return uebung(a, 0, a.length-1);
        //bei r kann das -1 auch weggelassen werden, wenn man es als exklusive Obergrenze definiert
    }

    public static int[] uebung(int[] a, int l, int r) {
        if (l==r) {
            return new int[] {a[l], a[r]};
        } else if (l == r - 1) {
            if (a[l] < a[r]) {
                return new int[] {a[l], a[r]};
            } else {
                return new int[] {a[r], a[l]};
            }
        } else {
            int m = (l+r)/2;
            int[] lSol = uebung(a,l,m);
            int[] rSol = uebung(a, m+1, r);

            int min = lSol[0] < rSol[0] ? lSol[0] : rSol[0];
            int max = lSol[1] > rSol[1] ? lSol[1] : rSol[1];

            return new int[] {min, max};
        }
    }
}