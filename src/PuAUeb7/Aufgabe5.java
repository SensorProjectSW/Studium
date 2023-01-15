package PuAUeb7;

public class Aufgabe5 {
    public static void main(String[] args) {
        String[] alpha = {"1", "10111", "10"};
        String[] beta = {"111", "101", "0"};
        boolean fertig = false;
        String a;
        String b;
        int k = 16;

        if (CheckSameLength(alpha,beta)){
            System.out.println("Same Length!");
            if (CheckIfCorrectForm(alpha) && CheckIfCorrectForm(beta)) {
                System.out.println("Correct Form!");
                System.out.println();
                //Aufgabenteil c)
                for (int i = 0; i < alpha.length; i++) {
                    a = alpha[i];
                    b = beta[i];
                    String ausgabe = "[" + (i+1);

                    stopp:
                    for (int z = 0; z < 16; z++) {
                        for (int j = 0; j < alpha.length; j++) {
                            if (a.startsWith(b) || b.startsWith(a)) {
                                String test1 = a + alpha[j];
                                String test2 = b + beta[j];
                                if (test1.startsWith(test2) || test2.startsWith(test1)) {
                                    a += alpha[j];
                                    b += beta[j];
                                    ausgabe = ausgabe + ", " + (j+1);
                                }
                            }
                            if (a.equals(b)) {
                                System.out.println(a);
                                System.out.println(ausgabe + "]");
                                fertig = true;
                                break stopp;
                            }
                        }
                    }
                }
            }
        }
        if (!fertig) System.out.println("Keine Lösung gefunden!");
    }

    //Aufgabenteil a)
    public static boolean CheckSameLength(String[] a, String[] b) {
        return (a.length==b.length);
    }
    //Aufgabenteil b)
    public static boolean CheckIfCorrectForm(String[] arr) {
        if (arr.length == 0) return false;
        for (String s : arr) {
            if (!(isCorrect(s))) {
                return false;
            }
        }
        return true;
    }
    public static boolean isCorrect(String a) {
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (!(c>=48 && c<=57) || !(c>=97 && c<=123)) {
                return false;
            }
        }
        return true;
    }
}