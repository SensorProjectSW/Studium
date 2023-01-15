import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        String firstName; String lastName;

        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Firstname: ");
        firstName = scn.nextLine();

        System.out.print("Enter Lastname: ");
        lastName = scn.nextLine();

        System.out.println("Hello " + firstName + " " + lastName + "!");

        String test = "a";
        System.out.println(Integer.parseInt(test));
    }
}


