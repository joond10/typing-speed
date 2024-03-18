import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Joon's speed typing school!\n");
        displayMainMenu();
    }

    public static void displayMainMenu() {
        int selection;

        do {
            System.out.println("|Select a game mode |");
            System.out.println("---------------------");
            System.out.println("|1. Random word rush|");
            System.out.println("|2. Set paragraph   |");
            System.out.println("|0. Exit            |");
            System.out.println("---------------------");
            System.out.print("> ");

            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    // random word game
                    break;
                case 2:
                    // difficulty menu
                    break;
                case 0:
                    System.out.print("Program terminated! See you again soon.");
                    break;
                default:
                    System.out.println("Invalid selection!\n3");
            }

        } while (selection != 0);

    }
}