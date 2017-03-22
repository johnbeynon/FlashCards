package uk.org.beynon.flashcards.activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import uk.org.beynon.flashcards.FlashCardz;
import uk.org.beynon.flashcards.R;
import uk.org.beynon.flashcards.adapters.GridAdapter;
import uk.org.beynon.flashcards.models.FlashCard;

public class WhichNumber extends AppCompatActivity {

    FlashCardz flashCardz = new FlashCardz();
    ArrayList<FlashCard> flashCards;
    FlashCard randomCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_which_number);

        flashCards = flashCardz.getRandomizedCards();
        GridAdapter gridAdapter = new GridAdapter(this, flashCards);
        GridView gridView = (GridView) findViewById(R.id.whichNumberGrid);
        gridView.setAdapter(gridAdapter);

        nextCard();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                FlashCard thisCard = flashCards.get(position);

                if (thisCard == randomCard) {
                    Toast.makeText(WhichNumber.this, "YES!! You're right!", Toast.LENGTH_SHORT).show();
                    nextCard();
                }
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
                Log.i("WhichNumber", "reset selected");
                nextCard();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void nextCard() {
        Random r = new Random();
        randomCard = flashCards.get(r.nextInt(flashCards.size()));
        MediaPlayer mediaPlayer = MediaPlayer.create(WhichNumber.this, randomCard.getFileName());
        mediaPlayer.start();
    }


}
