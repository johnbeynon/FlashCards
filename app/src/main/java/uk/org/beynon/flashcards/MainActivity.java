package uk.org.beynon.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    final private ArrayList<FlashCard> mFlashCards = new ArrayList<FlashCard>();
    int mScore = 0;
    int mQuestion = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFlashCards.add(new FlashCard(1, getString(R.string.numberOne)));
        mFlashCards.add(new FlashCard(2, "Two"));
        mFlashCards.add(new FlashCard(3, "Three"));
        mFlashCards.add(new FlashCard(4, "Four"));
        mFlashCards.add(new FlashCard(5, "Five"));
        mFlashCards.add(new FlashCard(6, "Six"));
        mFlashCards.add(new FlashCard(7, "Seven"));
        mFlashCards.add(new FlashCard(8, "Eight"));
        mFlashCards.add(new FlashCard(9, "Nine"));
        mFlashCards.add(new FlashCard(10, "Ten"));

        Button rightButton = (Button) findViewById(R.id.rightButton);

        rightButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                incrementScore();
                nextCard();
            }
        });

        Button wrongButton = (Button) findViewById(R.id.wrongButton);

        wrongButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nextCard();
            }
        });

    }

    public void nextCard() {
        mQuestion++;

        Random r = new Random();
        FlashCard randomFlashCard = mFlashCards.get(r.nextInt(mFlashCards.size()));

        TextView flashNumber = (TextView) findViewById(R.id.flashNumber);
        flashNumber.setText(String.valueOf(randomFlashCard.getNumber()));

        TextView flashNumberWord = (TextView) findViewById(R.id.flashNumberWord);
        flashNumberWord.setText(String.valueOf(randomFlashCard.getNumberWord()));
    }

    public void incrementScore() {
        mScore++;
        updateScore();
    }

    public void updateScore() {
        String score = "Score: " + mScore;

        TextView scoreView = (TextView) findViewById(R.id.scoreView);
        scoreView.setText(score);
    }

}
