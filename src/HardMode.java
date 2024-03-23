//import java.util.Scanner;
//
//public class HardMode extends  GameMode{
//
//    String m_previousWord;
//    String m_stringEntered;
//
//    private static final String[] m_hardWordBank = {
//            "exacerbate", "quixotic", "equivocate", "labyrinthine", "perspicacious",
//            "circumlocution", "serendipity", "anachronistic", "incontrovertible", "sesquipedalian",
//            "antediluvian", "mellifluous", "sesquipedalian", "effervescent", "intransigent",
//            "nefarious", "vociferous", "pernicious", "ineffable", "antediluvian"
//    };
//    public HardMode() {
//        //Initialize base class with normal word bank
//        super(m_hardWordBank);
//    }
//
//    public void read() {
//        Scanner scanner = new Scanner(System.in);
//        m_stringEntered = scanner.nextLine(); // Read user input into userInput variable
//    }
//
//    @Override
//    public void displayText() {
//        // Display a sequence of words with variations for hard mode
//        for (int i = 0; i < 10; i++) {
//            String word = m_wordBank[rand.nextInt(m_wordBank.length)];
//
//            // Example constraint: Avoid consecutive repetitions of the same word
//            while (i > 0 && word.equals(m_previousWord)) {
//                word = m_wordBank[rand.nextInt(m_wordBank.length)];
//            }
//
//            // Print the word followed by a space
//            System.out.print(word + " ");
//
//            // Store the current word for comparison in the next iteration
//            m_previousWord = word;
//        }
//    }
//}
