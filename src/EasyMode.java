import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class EasyMode extends GameMode {

    Scanner scanner = new Scanner(System.in);
    String m_stringEntered;
    private static final String[] m_easyWordBank = {
            "the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"
    };

    public EasyMode() {
        super(m_easyWordBank);
        m_stringEntered = "";
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
    protected void displayText() {
        //For each loop, every element stored in s
        for (String s : m_easyWordBank) {
            System.out.print(s + " ");
        }
    }
}
