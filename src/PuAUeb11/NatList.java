package PuAUeb11;
import java.util.Arrays;

public class NatList {
    /*private int[] list = new int[0];
    public NatList() {}*/

    private int[] list;

    public NatList() {
        this.list = new int[0];
    }

    public int head() { return list[0]; }

    public NatList tail() {
        NatList temporary = new NatList();
        for (int i = 1; i < this.length(); i++) {
            temporary.append(list[i]);
        }
        return temporary;
    }

    public String toString() {
        return Arrays.toString(list);
    }

    public void append (int x) {
        int[] temporary = new int[list.length+1];
        for (int i = 0; i < list.length; i++) {
            temporary[i] = list[i];
        }
        temporary[list.length] = x;
        list = temporary;
    }

    public int length() { return list.length; }

    public boolean isSorted() {
        if (list.length == 1) return true;
        for (int i = 1; i < list.length; i++) {
            if (list[i-1] > list[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NatList list = new NatList();
        for (int i = 0; i < 10; i++) {
            list.append(i);
        }
        System.out.println("Liste erstellt");
        System.out.println(list.head());
        System.out.println(list.isSorted());
        list.append(3);
        System.out.println(list.isSorted());
        System.out.println(list.length());
        System.out.println(list.toString());
        list = list.tail();
        System.out.println(list.toString());
    }
}
