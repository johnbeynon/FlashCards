package uk.org.beynon.flashcards.models;

/**
 * Created by jbeynon on 18/02/2017.
 */

public class FlashCard {

    private int mNumber;
    private String mNumberWord;
    private int mFileNameId = NO_FILE_PROVIDED;

    private static int NO_FILE_PROVIDED = -1;

    public FlashCard(int number, String numberWord) {
        mNumber = number;
        mNumberWord = numberWord;
    }

    public FlashCard(int number, String numberWord, int fileName) {
        mNumber = number;
        mNumberWord = numberWord;
        mFileNameId = fileName;
    }

    public int getNumber() {
        return mNumber;
    }

    public String getNumberWord() {
        return mNumberWord;
    }

    public int getFileName() {
        return mFileNameId;
    }

}