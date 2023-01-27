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

    public String toString() {
        String s = "" + list[0];
        for (int i = 1; i < list.length; i++) {
            s = s + list[i];
        }
        return s;
    }

    private String IntArrToString(int[] arr) {
        String s = String.valueOf(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            s += arr[i];
        }
        return s;
    }

    private int[] frontappend(int[] l) {
        int[] neu = new int[l.length+1];
        neu[0] = 0;
        for (int i = 1; i < neu.length; i++) {
            neu[i] = l[i-1];
        }
        return neu;
    }

    public BigNum mult (BigNum x) {
        if (Integer.parseInt(this.toString()) >= Integer.parseInt(x.toString())) return mult(this, x);
        else return mult(x, this);
    }

    private BigNum mult (BigNum g, BigNum k) {
        BigNum sum = new BigNum("0");
        for (int i = 0; i < Integer.parseInt(k.toString()); i++) {
            sum = sum.add(g);
        }
        return sum;
    }

    public BigNum add (BigNum x) {
        boolean carry = false;
        int[] ergebnis = (this.list.length >= x.list.length) ? new int[this.list.length] : new int[x.list.length];
        if (this.list.length > x.list.length) {
            while (this.list.length > x.list.length) x.list = frontappend(x.list);
        } else if (this.list.length < x.list.length) {
            while (this.list.length < x.list.length) list = frontappend(list);
        }
        for (int i = ergebnis.length-1; i >= 0; --i) {
            if (!carry) {
                if (x.list[i]+this.list[i] <= 9) {
                    ergebnis[i] = x.list[i]+this.list[i];
                    carry = false;
                } else {
                    ergebnis[i] = x.list[i]+this.list[i] - 10;
                    carry = true;
                }
            } else {
                if (x.list[i]+this.list[i] <= 8) {
                    ergebnis[i] = x.list[i]+this.list[i] + 1;
                    carry = false;
                } else {
                    ergebnis[i] = x.list[i]+this.list[i] - 9;
                    carry = true;
                }
            }
        }
        if (carry) {
            return new BigNum(1 + IntArrToString(ergebnis));
        } else {
            return new BigNum(IntArrToString(ergebnis));
        }
    }
}

public class Aufgabe4 {
    public static void main(String[] args) {
        BigNum test1 = new BigNum("36");
        BigNum test2 = new BigNum("2");
        System.out.println(test1.toString());
        System.out.println(test2.toString());
        System.out.println("Add: " + test1.add(test2));
        System.out.println("Mult: " + test1.mult(test2));
    }
}