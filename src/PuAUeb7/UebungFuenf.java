package PuAUeb7;
import java.util.regex.Pattern;

public class UebungFuenf {
    public static void main(String[] args) {
        String[] a = {"101", "00", "11"};
        String[] b = {"1", "10", "011"};

        if (a.length!=b.length) return;
        for (int i = 0; i < a.length; i++) {
            if(!Pattern.matches("^[a-z0-9]+$",a[i])) return;
        }
        for (int i = 0; i < b.length; i++) {
            if(!Pattern.matches("^[a-z0-9]+$",b[i])) return;
        }
        pcp(a,b,"","", 0,16);
    }

    public static boolean pcp(String[] a, String[] b, String ta, String tb, int recCurrent, int recMax) {
        if (ta.equals(tb) && ta.length() > 0) {
            System.out.println("Lösung gefunden: " + ta);
            return true;
        }
        if (recCurrent>=recMax) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (pcp(a,b,ta+a[i],tb+b[i],recCurrent+1,recMax)) {
                System.out.println("Korrespondenzindex: " + i);
                return true;
            }
        }
        return false;
    }
}
