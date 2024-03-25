import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.time.LocalTime;

public abstract class GameMode {
    protected String[] m_wordBank;
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

     GameMode(String[] wordBank) {
        m_wordBank = wordBank;
    }

    //Helper function for timer
    private static void sleepSeconds(int seconds) {
        //The try block contains the code that might throw an exception
        try {
            TimeUnit.SECONDS.sleep(seconds);
        //Contains code that handles the exception.
        } catch (InterruptedException e) {
            System.out.println("Thread sleep interrupted");
            //Restore interrupted status
            Thread.currentThread().interrupt();
        }
    }

    protected void displayPrompt() {
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

    //Contains the game implementation, derived classes will send their user input
    abstract void initializeGame();

    //Displays a specific word bank based on selected difficulty
    abstract void displayText();

    //Evaluates what the user input and returns the results
    protected void evaluateInput(String userInput, double startTime) {
        int correctWords = 0;
        int totalCorrectCharacters = 0;

        String[] inputWords = userInput.split(" ");
       //For every word they input
        for (String inputWord : inputWords) {
            //For every word in the word bank
            for (String word : m_wordBank) {
                //If what they entered is equivalent to a valid word
                if (inputWord.equals(word)) {
                    //Count valid characters and words
                    totalCorrectCharacters += inputWord.length();
                    correctWords++;
                    break;
                }
            }
        }

        double end = LocalTime.now().toNanoOfDay();
        double elapsedTime = end - startTime;
        //Convert nanoseconds to seconds
        double elapsedSeconds = elapsedTime / 1000000000.0;

        System.out.println();
        System.out.println("It took you: " + (int)elapsedSeconds + " seconds to type everything");
        System.out.println("You got: " + correctWords + " out of " + inputWords.length + " words correct" );
        if (correctWords != inputWords.length) {
            //ArrayList, which is used for storing many values that are of the same type
            ArrayList<String> incorrectWords = new ArrayList<>();

            //For each word they input
            for (String inputWord : inputWords) {
                //Whatever they entered that is not in the word bank is added to list of incorrect words
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
        //WPM formula
        int wpm = (int)((((double) totalCorrectCharacters / 5) / elapsedSeconds) * 60);
        System.out.println("Your WPM is: " + wpm + "!");
    }
}
