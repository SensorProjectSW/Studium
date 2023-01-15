package PuAUeb2;

public class Aufgabe5 {
    public static int[] getAZBuchstaben (String s) {
        s = s.toUpperCase();
        int[] list =  new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ci = c - 65;
            list[ci]++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] az1 = getAZBuchstaben(args[0]);
        int[] az2 = getAZBuchstaben(args[1]);

        for (int i = 0; i < 26; i++) {
            if (az1[i] != az2[i]) {
                System.out.println("Es ist kein Anagramm!");
                break;
            } else if (i == 25) {
                System.out.println("Es ist ein Anagramm!");
            }
        }
    }
}