//import java.util.Scanner;
//
//public class NormalMode extends  GameMode{
//
//    String m_stringEntered;
//
//    private static final String[] m_normalWordBank = {
//            "algorithm", "concatenate", "iteration", "variable", "interface", "inheritance",
//            "polymorphism", "encapsulation", "recursion", "debugging", "framework", "optimization",
//            "abstraction", "database", "manipulation", "authentication", "authorization", "deployment"
//    };
//    public NormalMode() {
//        //Initialize base class with normal word bank
//        super(m_normalWordBank);
//    }
//
//    public void read() {
//        Scanner scanner = new Scanner(System.in);
//        m_stringEntered = scanner.nextLine(); // Read user input into userInput variable
//    }
//
//    @Override
//    public void displayText() {
//        //Override display text behaviour
//        for (int i = 0; i < 10; i++) {
//            System.out.print(m_wordBank[rand.nextInt(m_wordBank.length)] + " ");
//        }
//    }
//}
