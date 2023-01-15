package PuAUeb9;
import java.util.Scanner;
import java.util.Arrays;
public class Aufgabe5 {
    public static void main(String[] args) {
        int[] a = {4,1,1,2,1};
        System.out.println(Arrays.toString(a));
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Element n: ");
        int n = Integer.parseInt(scn.nextLine());
        System.out.println(Arrays.toString(teila(a,n)));
    }

    public static int[] teila (int[] a, int m) {
        int[] counting = new int[m+1];
        for (int i = 0; i < a.length; i++) {
            counting[a[i]]++;
        }
        System.out.println(Arrays.toString(counting));
        int[] end = new int[a.length];
        int j = 0;
        for (int i = 0; i < end.length; i++) {
            if (counting[j]==0) {
                while (counting[j]==0) {
                    j++;
                }
                end[i]=j;
                counting[j]--;
            } else {
               end[i]=j;
               counting[j]--;
            }
        }
        return end;
    }


    public static void uebung (int[] a, int m) {
        int[] c = new int[m+1];
        for (int i = 0; i < a.length; i++) {
            ++c[a[i]];
        }
        int i = 0;
        for (int e = 0; e < c.length; e++) {
            for (int k = 0; k < c[e]; k++) {
                a[i] = e;
                ++i;
            }
        }
    }
}
