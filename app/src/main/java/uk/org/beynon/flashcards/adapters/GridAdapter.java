package uk.org.beynon.flashcards.adapters;

/**
 * Created by jbeynon on 05/03/2017.
 */

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import uk.org.beynon.flashcards.R;
import uk.org.beynon.flashcards.models.FlashCard;

/**
 * Created by jbeynon on 17/02/2017.
 */

public class GridAdapter extends ArrayAdapter<FlashCard> {

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;


    public GridAdapter(Activity context, ArrayList<FlashCard> cards) {
        super(context, 0, cards);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.grid_item, parent, false);
        }

        FlashCard currentCard = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.number);
        miwokTextView.setText(String.valueOf(currentCard.getNumber()));

//        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
//        defaultTextView.setText(currentWord.getDefaultTranslation());
//
//        ImageView imageView = (ImageView) listItemView.findViewById(R.id.resourceImage);
//
//        if (currentWord.hasImage()) {
//            imageView.setImageResource(currentWord.getImageResourceId());
//            imageView.setVisibility(View.VISIBLE);
//        } else {
//            imageView.setVisibility(View.GONE);
//        }


        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.grid_item);
        // Find the color that the resource ID maps to
        //int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(0xFF00FF00);

        return listItemView;
    }


}
