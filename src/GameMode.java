import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.time.LocalTime;
//Game mode is the superclass of difficulty modes

public abstract class GameMode {
    Random rand = new Random();

    //Fields
    protected String[] m_wordBank;

    //Constructor
    public GameMode(String[] wordBank) {
        m_wordBank = wordBank;
    }

    private static void sleepSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            // Handle the exception, e.g., print a message
            System.out.println("Thread sleep interrupted");
            // Restore interrupted status
            Thread.currentThread().interrupt();
        }
    }

    public void displayPrompt() {
        System.out.println("Type the following text after the timer as fast as you can!");
        System.out.println("Also be sure to press Enter as soon as you're done typing.");
        System.out.println();
        System.out.println("3");
        sleepSeconds(1);
        System.out.println("2");
        sleepSeconds(1);
        System.out.println("1");
        sleepSeconds(1);
        System.out.println();
    }

    abstract public void initializeGame();

    //Function that displays the word bank of selected difficulty
    abstract void displayText();

    public void evaluateInput(String userInput, double startTime) {
        String[] inputWords = userInput.split(" "); // Split the user input into an array of words

        int correctWords = 0;
        for (String inputWord : inputWords) {
            for (String word : m_wordBank) {
                if (inputWord.equals(word)) {
                    correctWords++;
                    break; // If a match is found, break out of the inner loop
                }
            }
        }

        double end = LocalTime.now().toNanoOfDay();
        double elapsedTime = end - start;
        double seconds = elapsedTime / 1000000000.0;

        // (x characters / 5) / 1min = y WPM


        return wpm;
    }

}
