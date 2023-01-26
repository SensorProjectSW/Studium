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

    /* selectors */
    public long numerator()   { return num;   }
    public long denominator() { return denom; }

    /* public methods */
    public RatNumber add(RatNumber r) {
        long n,d;
        n = numerator() * r.denominator() + r.numerator() * denominator();
        d = denominator() * r.denominator();
        return new RatNumber(n,d);
    }

    public void normalize() {
        /* TODO: implement */
    }

    public String toString() {
        return "TODO: implement";
    }
}

public class RatNumberProg {
    public static void main(String[] args) {

        RatNumber a = new RatNumber(1,2);
        RatNumber b = new RatNumber(3,2);

        RatNumber c = a.add(b);

        System.out.println(a + " + " + b + " = " + c);
    }
}
