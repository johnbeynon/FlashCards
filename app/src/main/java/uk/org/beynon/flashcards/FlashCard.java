package uk.org.beynon.flashcards;

/**
 * Created by jbeynon on 18/02/2017.
 */

public class FlashCard {

    private int mNumber;
    private String mNumberWord;

    public FlashCard(int number, String numberWord) {
        mNumber = number;
        mNumberWord = numberWord;
    }

    public int getNumber() {
        return mNumber;
    }

    public String getNumberWord() {
        return mNumberWord;
    }

}