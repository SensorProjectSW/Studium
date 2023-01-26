package PuAUeb11;

class RatNumber {
    /* private variables */
    private long num=0l, denom=1l;

    /* constructors */
    public RatNumber() {}

    public RatNumber(long n, long d) {
        num = (d > 0) ? n : -n;
        denom = Math.abs(d);
        normalize();
    }

    //Aufgabe 2a): zusätzlicher Konstruktor mit Ganzzahl als Eingabe
    public RatNumber(long n) {
        num = n;
        denom = 1;
    }

    /* selectors */
    public long numerator()   { return num; }
    public long denominator() { return denom; }

    /* public methods */
    public RatNumber add(RatNumber r) {
        long n,d;
        n = numerator() * r.denominator() + r.numerator() * denominator();
        d = denominator() * r.denominator();
        return new RatNumber(n,d);
    }

    //Aufgabe 2b): Kürzen der rationalen Zahl
    public void normalize() {
        if (num == 0 || denom == 0) {
            num = 0;
            denom = 0;
        } else {
            //Verwenden des Euklidischen Algorithmus, um den ggT zu finden:
            long ggT = euklid(num, denom);
            //Kürzen:
            num /= ggT;
            denom /= ggT;
        }
    }

    private long euklid(long n, long d) {
        if (n==0) return d;
        else return euklid(d % n, n);
    }

    //Aufgabe 2c): Ausgabe als String
    public String toString() {
        return num + "/" + denom;
    }

    //Aufgabe 2d): Test auf Gleichheit zum Wert Null
    public boolean isZero() {
        if (num == 0 || denom == 0) return false;
        else return true;
    }

    //Aufgabe 2e): Test auf Gleichheit mit zweiter rationaler Zahl
    public boolean equals(RatNumber other) {
        other.normalize();
        if (num == other.num && denom == other.denom) return true;
        else return false;
    }

    //Aufgabe 2f) (1): Multiplikation
    public RatNumber mult (RatNumber other) {
        RatNumber ergebnis = new RatNumber();
        ergebnis.num = num * other.num;
        ergebnis.denom = denom * other.denom;
        ergebnis.normalize();
        return ergebnis;
    }

    //Aufgabe 2f) (2): Division
    public RatNumber div (RatNumber other) {
        RatNumber ergebnis = new RatNumber();
        ergebnis.num = num * other.denom;
        ergebnis.denom = denom * other.num;
        ergebnis.normalize();
        return ergebnis;
    }

    //Aufgabe 2f) (3): Minus
    public RatNumber minus (RatNumber other) {
        RatNumber ergebnis = new RatNumber();
        //Bringen der beiden Brüche auf den gleichen Nenner:
        num *= other.denom;
        other.num *= denom;
        ergebnis.num = num - other.num;
        ergebnis.denom = denom * other.denom;
        ergebnis.normalize();
        return ergebnis;
    }
}

public class RatNumberProg {
    public static void main(String[] args) {

        RatNumber a = new RatNumber(1,2);
        RatNumber b = new RatNumber(3,2);

        RatNumber c = a.add(b);
        System.out.println(a + " + " + b + " = " + c);

        RatNumber d = a.minus(b);
        System.out.println(a + " - " + b + " = " + d);

        RatNumber e = a.mult(b);
        System.out.println(a + " * " + b + " = " + e);

        RatNumber f = a.div(b);
        System.out.println(a + " : " + b + " = " + f);
    }
}
