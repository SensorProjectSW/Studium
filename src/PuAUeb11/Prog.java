package PuAUeb11;

class X {
    int x;

    public X(int x) { this.x = x; }
    public int a(int x, int y) { return x * y; }
    public int a(int x) { return a(x, this.x); }
}
class Y extends X {
    public Y(int x) { super(x); } // Konstr. d. Oberkl.
    public int a(int x, int y) { return a(x * y, x, y); }
    public int a(int x, int y, int z) { return x * y + z; }
}
class Prog {
    public static void main(String[] args) {
        X[] x = new X[4];
        for(int i = 0; i < x.length; ++i) {
            x[i] = new Y(i);
        }
        int sum = 0;
        for(int i = 0; i < x.length; ++i) {
            sum += x[i].a(i); /** A **/
        }
        System.out.println(sum);
    }
}