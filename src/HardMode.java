import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class HardMode extends GameMode {
    String m_stringEntered;
    private static final String[] m_hardWordBank = {
            "multithreading", "serialization", "concurrency", "lambda", "stream",
            "reflection", "immutable", "singleton", "dependency", "injection",
            "serialization", "deserialization", "asynchronous", "synchronous", "exception",
            "transaction", "metadata", "middleware", "scalability", "microservice",
            "synchronization", "atomicity"
    };
    public HardMode() {
        super(m_hardWordBank);
    }

    public void initializeGame() {
        displayPrompt();
        displayText();
        double startTime = LocalTime.now().toNanoOfDay();
        System.out.println();
        m_stringEntered = scanner.nextLine();
        evaluateInput(m_stringEntered, startTime);
    }

    @Override
    public void displayText() {
        //HashSet is used for storing unique elements efficiently,
        //while ArrayList is used for storing a dynamic collection
        //of elements where duplicates and order are important.

        Set<String> printedWords = new HashSet<>();
        //Up until we have printed 10 words
        while (printedWords.size() < 10) {
            String word = m_wordBank[rand.nextInt(m_wordBank.length)];
            //If the hashset doesn't contain the word, we print it
            if (!printedWords.contains(word)) {
                System.out.print(word + " ");
                //Then add it to the hashset making it no longer unique
                printedWords.add(word);
            }
        }
    }
}
