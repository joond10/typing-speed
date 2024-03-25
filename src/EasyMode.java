import java.time.LocalTime;

public class EasyMode extends GameMode {

    String m_stringEntered;
    private static final String[] m_easyWordBank = {
            "the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"
    };

    public EasyMode() {
        super(m_easyWordBank);
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
        for (String s : m_easyWordBank) {
            System.out.print(s + " ");
        }
    }
}
