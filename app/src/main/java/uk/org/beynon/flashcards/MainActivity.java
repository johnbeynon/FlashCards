package uk.org.beynon.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

        updateQuestionNumber();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.resetMenu:
                Log.i("MainActivity", "reset selected");
                resetGame();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void resetGame() {
        mScore = 0;
        mQuestion = 1;
        updateQuestionNumber();
        updateScore();
    }

    public void nextCard() {
        mQuestion++;
        updateQuestionNumber();

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

    public void updateQuestionNumber() {
        String question = "Question #" + mQuestion;

        TextView questionView = (TextView) findViewById(R.id.questionNumberView);
        questionView.setText(question);
    }

    public void updateScore() {
        String score = "Score: " + mScore;

        TextView scoreView = (TextView) findViewById(R.id.scoreView);
        scoreView.setText(score);
    }

}
