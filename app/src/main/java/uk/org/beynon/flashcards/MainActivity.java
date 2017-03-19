package uk.org.beynon.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import uk.org.beynon.flashcards.activities.FlashCards;
import uk.org.beynon.flashcards.activities.WhichNumber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button flash_cards_button = (Button) findViewById(R.id.flash_cards_button);

        flash_cards_button.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent flashCardsIntent = new Intent(MainActivity.this, FlashCards.class);
                startActivity(flashCardsIntent);
            }
        });

        Button numbers_button = (Button) findViewById(R.id.numbers_button);

        numbers_button.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent whichNumberIntent = new Intent(MainActivity.this, WhichNumber.class);
                startActivity(whichNumberIntent);
            }
        });
    }


}