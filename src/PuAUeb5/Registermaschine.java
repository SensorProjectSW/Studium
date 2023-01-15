package PuAUeb5;

class Registermaschine {
    static public int   b; //< Befehlszähler
    static public int[] c; //< c-Register (c_0 == c[0], c_1 == c[1], ...)

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
                    break;
                case "CLOAD":
                    b++;
                    c[0] = Integer.parseInt(command[1]);
                    break;
                case "STORE":
                    b++;
                    c[Integer.parseInt(command[1])] = c[0];
                    break;
                case "ADD":
                    b++;
                    c[0] += c[Integer.parseInt(command[1])];
                    break;
                case "CADD":
                    b++;
                    c[0] += Integer.parseInt(command[1]);
                    break;
                case "SUB":
                    b++;
                    c[0] -= c[Integer.parseInt(command[1])];
                    break;
                case "CSUB":
                    b++;
                    c[0] -= Integer.parseInt(command[1]);
                    break;
                case "MULT":
                    b++;
                    c[0] *= c[Integer.parseInt(command[1])];
                    break;
                case "CMULT":
                    b++;
                    c[0] *= Integer.parseInt(command[1]);
                    break;
                case "DIV":
                    b++;
                    c[0] /= c[Integer.parseInt(command[1])];
                    break;
                case "CDIV":
                    b++;
                    c[0] /= Integer.parseInt(command[1]);
                    break;
                case "GOTO":
                    b = Integer.parseInt(command[1]);
                    break;
                case "IF c_0 = 0 GOTO":
                    if (c[0] == 0) {
                        b = Integer.parseInt(command[1]);
                    } else {
                        b++;
                    }
                    break;
                case "END":
                    break;
                default:
                    throw new RuntimeException("Command " + command[0] + " is not defined!");
            }
            Ausgabe();
        }
    }

    public static void main(String[] args) {
        // Beispiel aus Kapitel 5, Seite 17
        init(new int[]{0, 5, 3, 0});

        String[][] commands = {
            { "CLOAD",              "1"  },  //  1
            { "STORE",              "3"  },  //  2
            { "LOAD",               "2"  },  //  3
            { "IF c_0 = 0 GOTO",    "12" },  //  4
            { "LOAD",               "3"  },  //  5
            { "MULT",               "1"  },  //  6
            { "STORE",              "3"  },  //  7
            { "LOAD",               "2"  },  //  8
            { "CSUB",               "1"  },  //  9
            { "STORE",              "2"  },  // 10
            { "GOTO",               "4"  },  // 11
            { "END",                     },  // 12
        };

        System.out.print("(" + b);
        for (int i = 0; i < c.length; i++) {
            System.out.print(", " + c[i]);
        }
        System.out.print(")");
        System.out.println();

        while (b<12) {
            execCommand(commands[b-1]);
        }
    }
}