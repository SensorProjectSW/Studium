class RMEmulator {
    static public int   b; //< Befehlszähler
    static public int[] c; //< c-Register (c_0 == c[0], c_1 == c[1], ...)
    static public boolean end = false;

    public static void init(int[] initialConfiguration) {
        b = 1;
        c = initialConfiguration.clone();
    }

    public static void Ausgabe() {
        System.out.print("(" + b);
        for (int i = 0; i < c.length; i++) {
            System.out.print(", " + c[i]);
        }
        System.out.print(")");
        System.out.println();
    }

    static public void execCommand(String[] command) {
        if(command.length == 0) {
            throw new RuntimeException("Empty command!");
        }
        if(
            // Ungültige Eingabe: END hat keinen Parameter
            (command[0].equals("END") && command.length != 1) ||
            // Ungültige Eingabe: Alle Befehle außer END haben genau einen Parameter
            (!command[0].equals("END") && command.length != 2) 
        ) {
            throw new RuntimeException(command[0] + " either does not exist or requires a single parameter.");
        } else {
            switch(command[0]) {
                case "LOAD":
                    b++;
                    c[0] = c[Integer.parseInt(command[1])];
                    Ausgabe();
                    break;
                case "CLOAD":
                    b++;
                    c[0] = Integer.parseInt(command[1]);
                    Ausgabe();
                    break;
                case "STORE":
                    b++;
                    c[Integer.parseInt(command[1])] = c[0];
                    Ausgabe();
                    break;
                case "ADD":
                    b++;
                    c[0] += c[Integer.parseInt(command[1])];
                    Ausgabe();
                    break;
                case "CADD":
                    b++;
                    c[0] += Integer.parseInt(command[1]);
                    Ausgabe();
                    break;
                case "SUB":
                    b++;
                    c[0] -= c[Integer.parseInt(command[1])];
                    if (c[0] < 0) c[0] = 0;
                    Ausgabe();
                    break;
                case "CSUB":
                    b++;
                    c[0] -= Integer.parseInt(command[1]);
                    if (c[0] < 0) c[0] = 0;
                    Ausgabe();
                    break;
                case "MULT":
                    b++;
                    c[0] *= c[Integer.parseInt(command[1])];
                    Ausgabe();
                    break;
                case "CMULT":
                    b++;
                    c[0] *= Integer.parseInt(command[1]);
                    Ausgabe();
                    break;
                case "DIV":
                    b++;
                    c[0] /= c[Integer.parseInt(command[1])];
                    Ausgabe();
                    break;
                case "CDIV":
                    b++;
                    c[0] /= Integer.parseInt(command[1]);
                    Ausgabe();
                    break;
                case "GOTO":
                    b = Integer.parseInt(command[1]);
                    Ausgabe();
                    break;
                case "IF c_0 = 0 GOTO":
                    if (c[0] == 0) {
                        b = Integer.parseInt(command[1]);
                    } else {
                        b++;
                    }
                    Ausgabe();
                    break;
                case "END":
                    end = true;
                    break;
                default:
                    throw new RuntimeException("Command " + command[0] + " is not defined!");
            }
        }
    }

    public static void main(String[] args) {
        init(new int[]{0, 5, 0, 0, 0});

        String[][] commands = {
/*01*/                {"CLOAD", "1"}, //Laden von #1 und Speichern in Reg 2
/*02*/                {"STORE", "2"}, //Speicherort der Catalanzahlen
/*03*/                {"LOAD", "1"},
/*04*/                {"SUB", "4"},
/*05*/                {"IF c_0 = 0 GOTO", "19"},
/*06*/                {"LOAD", "4"}, //Lade #2
/*07*/                {"CADD", "2"}, //Addiere n
/*08*/                {"STORE", "3"}, //Speichern in Reg 3 -> Speicherort der Division (unterm Bruchstrich)
/*09*/                {"LOAD", "4"}, //Laden von n
/*10*/                {"CMULT", "4"}, //Multiplikation: 4*n
/*11*/                {"CADD", "2"}, //Addition von 4*n  + 2
/*12*/                {"MULT", "2"}, //(4*n +2)*C
/*13*/                {"DIV", "3"}, //Division
/*14*/                {"STORE", "2"}, //Speichern in Reg 2 --> neue Catalanzahl
/*15*/                {"LOAD", "4"}, //Laden von k
/*16*/                {"CADD", "1"}, //k++
/*17*/                {"STORE", "4"},
/*18*/                {"GOTO", "5"},
/*19*/                {"END", } };

        Ausgabe();
        while (!end && b<commands.length) {
            execCommand(commands[b-1]);
        }
    }
}