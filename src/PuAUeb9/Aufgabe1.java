package PuAUeb9;
import java.util.Scanner;

public class Aufgabe1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Element you want to find: ");
        int k = Integer.parseInt(scn.nextLine());
        int[] F = {0,1,2,4,5,8,9,12,13,18};

        System.out.println(k + " ist an Stelle " + BinarySearch(F,k) + " im übergebenen Array");
    }

    public static int BinarySearch(int[] F, int k) {
        return BinarySearchRec(F,k,0,F.length);
    }
    public static int uebung(int[] F, int k) {
        return uebungrec(F, k, 0, F.length-1);
    }
    public static int BinarySearchRec(int[] F, int k, int u, int o) {
        int m = (u + o) / 2;
        if (F[m] == k) {return m;}
        else if (k < F[u]) {
            return -1;
        } else if (k > F[o-1]) {
            return -1;
        } else if (F[m] > k) {
            return BinarySearchRec(F,k,u,m);
        } else if (F[m] < k) {
            return BinarySearchRec(F,k,m,o);
        }
        return -1;
    }

    public static int uebungrec(int[] F, int k, int u, int o) {
        if (u>o) return -1;
        int m = (u+o) / 2;
        if (k==0) return m;
        else if (k<F[m]) return uebungrec(F,k,u,m-1);
        else return uebungrec(F,k,m+1,o);
    }
}
