import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Joon's speed typing school!\n");
        displayMainMenu();
    }

    public static void displayMainMenu() {
        int selection = 0;
        int playAgain = 5;
        boolean validInput;
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
            do{
                validInput = false;
                do {
                    try {
                        System.out.print("> ");
                        selection = scanner.nextInt();
                        scanner.nextLine();
                        validInput = true;
                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                        scanner.nextLine();
                    }
                } while (!validInput);

                switch (selection) {
                    case 1:
                        GameMode easyMode = new EasyMode();
                        easyMode.initializeGame();
                        break;
                    case 2:
                        GameMode normalMode = new NormalMode();
                        normalMode.initializeGame();
                        break;
                    case 3:
                        GameMode hardMode = new HardMode();
                        hardMode.initializeGame();
                        break;
                    case 0:
                        System.out.println("Program terminated! See you again soon.");
                        return;
                    default:
                        System.out.println("Invalid selection!");
                }
            } while (selection < 0 || selection > 3);


            do {
                try {
                    System.out.println("Do you want to play again? (1 for yes, 0 for no)");
                    playAgain = scanner.nextInt();

                    if (!(playAgain == 1 || playAgain == 0)) {
                        System.out.println("Invalid selection!\n");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input\n");
                    scanner.nextLine();
                    //Set to arbitrary number to keep inside loop in case playAgain was set to 1
                    playAgain = 5;
                }
            } while (!(playAgain == 1 || playAgain == 0));

            if (playAgain == 0) {
                System.out.println("Program terminated! See you again soon.");
            }
        } while (playAgain == 1);
    }
}