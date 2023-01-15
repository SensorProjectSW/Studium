package PuAUeb8;
import java.util.Random;

public class IndSet {
    private static Random rng;
    public static void main(String[] args) {
        // use a random number generator with a seed to achieve reproducible results
        rng = new Random(42);
        // default: 1000 test runs on a graph with 100 nodes each
        int numberOfTests = 1000;
        int numberOfNodes = 100;
        testRoutine(numberOfTests, numberOfNodes);
    }

    public static int[] indSet(int[] V, int[][] E) {
        // Remember to call indSet recursively after some computations.
        // Recursive solutions are valid, only!
        // DO NOT CHANGE ANY OTHER CODE!

        // **ATTENTION: Do not modify variables V or E!**
        // - Changing E is not necessary anyway.
        // - Relevant contents of V should be copied into some other variable.

        // auswählen eines beliebigen v aus V und entfernen der Nachbarschaften
        // solange, bis leere Menge
        // Schritte vorher so lange rückgängig machen, bis die Menge nicht mehr unabhängig ist --> Lösung


        //Basisfall:
        if (V.length==0) return new int[0];

        //Entfernen beliebiger Knoten
        int v = V[0];

        //Finden der AZ der Nachbarn
        int neighbours = 1;
        for (int i = 0; i < V.length; i++) {
            int w = V[i];
            if (E[v][w]==1 && v!=w) ++neighbours;
        }

        //Menge der neuen, unabhängigen Menge
        int[] H = new int[V.length-neighbours];
        int j = 0;
        for (int i = 0; i < V.length; i++) {
            int w = V[i];
            if (E[v][w]==0 && v!=w) H[j++] = w;
        }

        int[] S = indSet(H,E);


        //Check, if noch unabhängig
        boolean vIndependentTos = true;
        for (int i = 0; i < S.length; i++) {
            int w = S[i];
            if (E[v][w]==1 || E[w][v] == 1) {
                vIndependentTos = false;
                break;
            }
        }

        if (vIndependentTos) {
            int[] Snew = new int[S.length+1];
            for (int i = 0; i < S.length; i++) {
                Snew[i]=S[i];
            }
            Snew[S.length] = v;
            return Snew;
        } else {
            return S;
        }
    }

    public static int[] append(int[] arr, int x) {
        int[] neu = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            neu[i] = arr[i];
        }
        neu[arr.length+1] = x;
        return neu;
    }
    public static void testRoutine(int runs, int n) {
        boolean ok = true;
        for(int r = 0; ok && r < runs; ++r) {
            ok = ok && runOnce(r, n);
        }
        if(ok) {
            System.out.println("Everything ok! Nicely done :)");
        } else {
            System.out.println("At least one test failed!");
        }
    }
    public static boolean runOnce(int r, int n) {
        int[] V = new int[n];
        for(int i = 0; i < n; ++i) {
            V[i] = i;
        }
        int E[][] = new int[n][n];
        randomizeE(E, rng.nextDouble());

        int[] indSet = indSet(V, E);
        return check(V, E, indSet, r);
    }
    public static void randomizeE(int[][] E, double density) {
        for(int i = 0; i < E.length; ++i) {
            for(int j = 0; j < E[i].length; ++j) {
                if(i != j && rng.nextDouble() < density) {
                    E[i][j] = 1;
                }
            }
        }
    }
    public static boolean check(int[] V, int[][] E, int[] indSet, int r) {
        // check if it is really an independent set
        for(int v : indSet) {
            for(int w : indSet) {
                if(v != w && (E[v][w] == 1 || E[w][v] == 1)) {
                    System.out.println("Run " + r + ": This is no independent set!");
                    return false;
                }
            }
        }

        // check if every node v in V is reachable from indSet within 2 hops
        for(int v : V) {
            boolean reachable = false;
            search:
            for(int w : indSet) {
                // check if node v is reachable from w as required
                if(w == v) {
                    reachable = true; // reachable in 0 hops
                    break search;
                }
                if(E[w][v] == 1) {
                    reachable = true; // reachable in 1 hop
                    break search;
                }
                for(int u : V) {
                    if(E[w][u] == 1 && E[u][v] == 1) {
                        reachable = true; // reachable in 2 hops (via u)
                        break search;
                    }
                }
            }

            if(!reachable) {
                System.out.println("Run " + r + ": Node " + v + " is not reachable within 2 hops");
                return false;
            }
        }
        return true;
    }
}
