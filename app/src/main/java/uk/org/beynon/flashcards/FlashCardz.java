package uk.org.beynon.flashcards;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import uk.org.beynon.flashcards.models.FlashCard;

/**
 * Created by jbeynon on 16/03/2017.
 */

public class FlashCardz {

    private ArrayList<FlashCard> mFlashCards;

    public FlashCardz() {
        mFlashCards = new ArrayList<FlashCard>();
        mFlashCards.add(new FlashCard(1, "One", R.raw.one));
        mFlashCards.add(new FlashCard(2, "Two", R.raw.two));
        mFlashCards.add(new FlashCard(3, "Three", R.raw.three));
        mFlashCards.add(new FlashCard(4, "Four", R.raw.four));
        mFlashCards.add(new FlashCard(5, "Five", R.raw.five));
        mFlashCards.add(new FlashCard(6, "Six", R.raw.six));
        mFlashCards.add(new FlashCard(7, "Seven", R.raw.seven));
        mFlashCards.add(new FlashCard(8, "Eight", R.raw.eight));
        mFlashCards.add(new FlashCard(9, "Nine", R.raw.nine));
        mFlashCards.add(new FlashCard(10, "Ten", R.raw.ten));
    }

    public ArrayList<FlashCard> getCards() {
        return mFlashCards;
    }

    public ArrayList<FlashCard> getCards(int minimum, int max) {
        return mFlashCards;
    }

    public FlashCard randomCard() {
        Random r = new Random();
        final FlashCard randomFlashCard = mFlashCards.get(r.nextInt(mFlashCards.size()));
        Log.d("WhichNumber", "Random FlashCard: " + randomFlashCard.getNumber());
        return randomFlashCard;
    }

}
