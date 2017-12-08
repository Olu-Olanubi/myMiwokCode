package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.miwok.WordAdapter.mPlayer;
import static java.security.AccessController.getContext;

public class Numbers extends AppCompatActivity {
    //MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

//LinearLayout layout = (LinearLayout) findViewById(R.id.activity_numbers);

        //create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);
        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);
        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);



        /**
         * //implement click listener for each item on the list
         * //This approach can be used if you don't want to implement the click listener in the adapter class.
         * It also works fine.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

        //once each item is clicked, play its corresponding audio
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //get the position of the item clicked
                Word word = words.get(i);
                Toast.makeText(Numbers.this, "Play Music", Toast.LENGTH_SHORT).show();
                mPlayer = MediaPlayer.create(Numbers.this, word.getAudioResourceId());
                mPlayer.start();

            }
        });
        */

        /**int index = 0;
        while(index < words.size()){
            TextView textView = new TextView(this);
            textView.setText(words.get(index));
            layout.addView(textView);
            index++;
        }

        for (int i =0; i < words.size(); i++){
            TextView textView = new TextView(this);
            textView.setText(words.get(i));
            layout.addView(textView);
        }
         */
    }

    @Override
    protected void onStop() {
        super.onStop();
       mPlayer.release();
    }
}
