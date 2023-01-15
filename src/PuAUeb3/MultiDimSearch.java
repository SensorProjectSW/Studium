package PuAUeb3;

public class MultiDimSearch {
    public static void find1(char[][] a, char[][] m) {
      boolean gefunden = false;
      int korX, korY;

      for (int ia = 0; ia < a.length; ia++) { //Zeilen von a
        for (int ja = 0; ja < a[ia].length; ja++) { //Spalten von a
          if (a[ia][ja] == m[0][0]) {
            gefunden = true;
            korX = ia;
            korY = ja;
            // Mein Algorithmus:
            /*for (int im = 0; im < m.length; im++) { //Zeilen von m
              for (int jm = 0; jm < m[im].length; jm++) { //Spalten von m
                try {
                  if (gefunden && (a[ia+im][ja+jm] != m[im][jm])) {
                    gefunden = false;
                  }
                } catch(Exception e) {
                  gefunden = false;
                  break;
                }
              }
            }*/

            // Algorithmus aus der Übung:

            //testloop:
            for (int im = 0; gefunden && im < m.length; im++) { //Zeilen von m
              for (int jm = 0; jm < m[im].length; jm++) { //Spalten von m
                int xs = ia + im;
                int ys = ja + jm;

                if (xs >= a.length || ys >= a[im].length || m[im][jm] != a[xs][ys]) {
                  gefunden = false;
                  //break testloop;
                }
              }
            }

            if (gefunden) {
              System.out.println(korX + ", " + korY);
              return;
            }
          }
        }
      }
      System.out.println("-1, -1");
    }

    public static void find2(char[][] a, char[][] m) {
      boolean gefunden = false;
      int korX, korY;

      for (int ia = 0; ia < a.length; ia++) { //Zeilen von a
        for (int ja = 0; ja < a[ia].length; ja++) { //Spalten von a
          if (a[ia][ja] == m[0][0]) {
            gefunden = true;
            korX = ia;
            korY = ja;
            // Das ist mein Algorithmus
            /*for (int im = 0; im < m.length; im++) { //Zeilen von m
              for (int jm = 0; jm < m[im].length; jm++) { //Spalten von m
                try {
                  if (gefunden && (m[im][jm] != '*' && a[ia+im][ja+jm] != m[im][jm])) {
                    gefunden = false;

                  }
                } catch(Exception e) {
                  gefunden = false;
                  break;
                }
              }
            }*/

            // Das ist aus der Übung:
            for (int im = 0; gefunden && im < m.length; im++) { //Zeilen von m
              for (int jm = 0; jm < m[im].length; jm++) { //Spalten von m
                int xs = ia + im;
                int ys = ja + jm;

                if (xs >= a.length || ys >= a[im].length || (m[im][jm] != a[xs][ys] || m[im][jm] != '*')) {
                  gefunden = false;
                }
              }
            }

            if (gefunden) {
              System.out.println(korX + ", " + korY);
              return;
            }
          }
        }
      }
      System.out.println("-1, -1");
    }


    public static void main(String[] args) {
      char[][] a = new char[44][];

      a[ 0] = "                      .-.".toCharArray();
      a[ 1] = "                     (   )".toCharArray();
      a[ 2] = "                      '-'".toCharArray();
      a[ 3] = "                      J L".toCharArray();
      a[ 4] = "                      | |".toCharArray();
      a[ 5] = "                     J   L".toCharArray();
      a[ 6] = "                     |   |".toCharArray();
      a[ 7] = "                    J     L".toCharArray();
      a[ 8] = "                  .-'.___.'-.".toCharArray();
      a[ 9] = "                 /___________\\".toCharArray();
      a[10] = "            _.-'''           `bmw._".toCharArray();
      a[11] = "          .'                       `.".toCharArray();
      a[12] = "        J                            `.".toCharArray();
      a[13] = "       F                               L".toCharArray();
      a[14] = "      J                                 J".toCharArray();
      a[15] = "     J                                  `".toCharArray();
      a[16] = "     |                                   L".toCharArray();
      a[17] = "     |                                   |".toCharArray();
      a[18] = "     |                                   |".toCharArray();
      a[19] = "     |                                   J".toCharArray();
      a[20] = "     |                                    L".toCharArray();
      a[21] = "     |                                    |".toCharArray();
      a[22] = "     |             ,.___          ___....--._".toCharArray();
      a[23] = "     |           ,'     `'''''''''           `-._".toCharArray();
      a[24] = "     |          J           _____________________`-.".toCharArray();
      a[25] = "     |         F         .-'   `-88888-'    `Y8888b.`.".toCharArray();
      a[26] = "     |         |       .'         `P'         `88888b \\".toCharArray();
      a[27] = "     |         |      J       #     L      #    q8888b L".toCharArray();
      a[28] = "     |         |      |             |           )8888D )".toCharArray();
      a[29] = "     |         J      \\             J           d8888PP".toCharArray();
      a[30] = "     |          L      `.         .b.         ,88888P /".toCharArray();
      a[31] = "     |           `.      `-.___,o88888o.___,o88888P'.'".toCharArray();
      a[32] = "     |             `-.__________________________..-'".toCharArray();
      a[33] = "     |                                    |".toCharArray();
      a[34] = "     |         .-----.........____________J".toCharArray();
      a[35] = "     |       .' |       |      |       |".toCharArray();
      a[36] = "     |      J---|-----..|...___|_______|".toCharArray();
      a[37] = "     |      |   |       |      |       |".toCharArray();
      a[38] = "     |      Y---|-----..|...___|_______|".toCharArray();
      a[39] = "     |       `. |       |      |       |".toCharArray();
      a[40] = "     |         `'-------:....__|______.J".toCharArray();
      a[41] = "     |                                  |".toCharArray();
      a[42] = "      L___                              |".toCharArray();
      a[43] = "          '''----...______________....--'".toCharArray();

      char[][] m = { { '8','8','8','8' }, { '`','P','\'' }, { ' ',' ' } };

      char[][] m2 = { { '8','-' }, { '8','8'} };

      char[][] m3 = { { '.','*','.' }, { '8','*','8' } };

      find1(a,m);
      find1(a,m2);
      find2(a,m3);
    }
}
