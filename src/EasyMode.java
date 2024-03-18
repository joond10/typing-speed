import java.util.Random;

public class EasyMode extends GameMode {


    //Fields
    //Static - Belongs to the class itself and not instance, it is class wide
    //Final - barred from being modified making this variable constant
    private static final String[] easyWordBank = {
            "the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"
    };

    //Constructor
    public EasyMode() {
        super(easyWordBank);
    }

    @Override
    public void startGame() {
        super.startGame();
    }

    @Override
    protected void displayText() {
        super.displayText();
        //What to override and add here hmm

        //Otherwise this isn't polymorphism
    }
}
