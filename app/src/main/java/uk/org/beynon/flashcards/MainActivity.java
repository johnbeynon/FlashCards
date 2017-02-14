package uk.org.beynon.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button flashButton = (Button) findViewById(R.id.nextButton);



        flashButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                TextView flashNumber = (TextView) findViewById(R.id.flashNumber);

                Random r = new Random();
                int randomNumber = r.nextInt(11);
                flashNumber.setText(String.valueOf(randomNumber));
            }
        });
    }
}
