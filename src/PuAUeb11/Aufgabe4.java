package PuAUeb11;

class BigNum {
    int[] list;

    public BigNum (String s) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        list = arr;
    }




}


public class Aufgabe4 {
    public static void main(String[] args) {

    }
}
