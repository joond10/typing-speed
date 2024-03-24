import java.time.LocalTime;
import java.util.Scanner;


public class NormalMode extends GameMode{

    Scanner scanner = new Scanner(System.in);
    String m_stringEntered;
    private static final String[] m_normalWordBank = {
            "algorithm", "concatenate", "iteration", "variable", "interface", "inheritance",
            "polymorphism", "encapsulation", "recursion", "debugging", "framework", "optimization",
            "abstraction", "database", "manipulation", "authentication", "authorization", "deployment"
    };

    public NormalMode() {
        //Initialize base class with normal word bank
        super(m_normalWordBank);
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
        //Override display text behaviour
        for (int i = 0; i < 10; i++) {
            System.out.print(m_wordBank[rand.nextInt(m_wordBank.length)] + " ");
        }
    }
}
