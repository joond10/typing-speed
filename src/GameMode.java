import java.util.Random;
//Game mode is the superclass of difficulty modes
//If a class contains one or more  abstract method, the class becomes abstract

public abstract class GameMode {

    Random rand = new Random();

    //Fields
    //This is our word bank stored in an array to compare to the user input array
    protected String[] wordBank;

    //Constructor
    public GameMode(String[] wordBank) {
        this.wordBank = wordBank;
    }

    public void startGame() {
        System.out.println("Type the following text as fast as you can!");
        displayText();
        System.out.println();
        System.out.println("Press Enter as soon as you're done typing!");
    }

    //Abstract keyword is similar to virtual keyword, sets a contract that subclasses must implement this function.
    //Function that displays the word bank of selected difficulty
    protected void displayText() {
        for (int i = 0; i < this.wordBank.length; i++) {
            System.out.print(this.wordBank[rand.nextInt(this.wordBank.length)] + " ");
        }
    }

    //Abstract function that calculates wpm
}
