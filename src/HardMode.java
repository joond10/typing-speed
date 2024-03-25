import java.time.LocalTime;

public class HardMode extends GameMode {
    String m_previousWord;
    String m_stringEntered;
    private static final String[] m_hardWordBank = {
            "multithreading", "serialization", "concurrency", "lambda", "stream",
            "reflection", "immutable", "singleton", "dependency", "injection",
            "serialization", "deserialization", "asynchronous", "synchronous", "exception",
            "transaction", "metadata", "middleware", "scalability", "microservice"
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
        // Display a sequence of words with variations for hard mode
        for (int i = 0; i < 10; i++) {
            String word = m_wordBank[rand.nextInt(m_wordBank.length)];

            // Example constraint: Avoid consecutive repetitions of the same word
            while (i > 0 && word.equals(m_previousWord)) {
                word = m_wordBank[rand.nextInt(m_wordBank.length)];
            }
            // Print the word followed by a space
            System.out.print(word + " ");
            // Store the current word for comparison in the next iteration
            m_previousWord = word;
        }
    }
}
