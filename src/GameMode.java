import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        int totalCorrectCharacters = 0;
        for (String inputWord : inputWords) {
            for (String word : m_wordBank) {
                if (inputWord.equals(word)) {
                    totalCorrectCharacters += inputWord.length();
                    correctWords++;
                    break; // If a match is found, break out of the inner loop
                }
            }
        }
        double test = LocalTime.now().toNanoOfDay();
        //double seconds = elapsedTime / 1000000000.0;

        double end = LocalTime.now().toNanoOfDay();
        double elapsedTime = end - startTime;
        double elapsedSeconds = elapsedTime / 1000000000.0;

        System.out.println();
        System.out.println("It took you: " + (int)elapsedSeconds + " seconds to type everything");
        System.out.println("You got: " + correctWords + " out of " + inputWords.length + " words correct" );
        if (correctWords != inputWords.length) {
            List<String> incorrectWords = new ArrayList<>();

// Iterate through each word in the user input
            for (String inputWord : inputWords) {
                // If the word is not in the word bank, add it to the list of incorrect words
                if (!Arrays.asList(m_wordBank).contains(inputWord)) {
                    incorrectWords.add(inputWord);
                }
            }
            System.out.print("This is where you messed up: ");
            for (String s :incorrectWords) {
                System.out.print(s + " ");
            }

        }
        System.out.println();

// Calculate total characters typed (including spaces)
        int wpm = (int)((((double) totalCorrectCharacters / 5) / elapsedSeconds) * 60);


        // Print or return the calculated WPM
        System.out.println("Your WPM is: " + wpm + "!");
    }
}
