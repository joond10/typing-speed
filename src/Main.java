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
            System.out.println("Select a game mode difficulty");
            System.out.println("-----------------");
            System.out.println("|1. Easy mode   |");
            System.out.println("-----------------");
            System.out.println("|2. Normal mode |");
            System.out.println("-----------------");
            System.out.println("|3. Hard mode   |");
            System.out.println("-----------------");
            System.out.println("|0. Exit game   |");
            System.out.println("-----------------");
            System.out.print("> ");

            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    GameMode easyMode = new EasyMode();
                    easyMode.startGame();
                    break;
                case 2:
                    // normal
                    break;
                case 3:
                // hard mode
                    break;
                case 0:
                    System.out.print("Program terminated! See you again soon.");
                    break;
                default:
                    System.out.println("Invalid selection!\n3");
            }

        } while (selection < 0 && selection > 3);

    }
}