package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by USER on 11/27/2017.
 */

public class WordAdapter extends ArrayAdapter<Word>{
   static MediaPlayer mPlayer;
   // private AudioManager mAudioManager;
   // private Context mContext;
    /**
    private AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {

        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mPlayer.pause();
                mPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                mPlayer.release();
            }
        }
    };
    */
    private int colorResourceId;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.release();
        }
    };
    public WordAdapter(Activity context, ArrayList<Word> words, int color) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        super(context, 0, words);
        colorResourceId = color;

    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link Word} object located at this position in the list
        final Word words = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID text1
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.text1);
        // Get the english word from the current Word object and
        // set this text on the english translation TextView
        englishTextView.setText(words.getDefaultTranslation());
        // Find the TextView in the list_item.xml layout with the ID text2
        TextView miwokTextView = (TextView)listItemView.findViewById(R.id.text2);
        // Get the miwok word from the current Word object and
        // set this text on the miwok translation TextView
        miwokTextView.setText(words.getMiwokTranslation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView, but check if word object has an image assigned. Otherwise, hide ImageView
        if(words.hasImage()) {
            iconView.setImageResource(words.getImageResourceId());
            iconView.setVisibility(View.VISIBLE);
        }
        else iconView.setVisibility(View.GONE);

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), colorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        View view = listItemView.findViewById(R.id.list_container);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mPlayer = MediaPlayer.create(getContext(), words.getAudioResourceId());
                mPlayer.start();
                mPlayer.setOnCompletionListener(mCompletionListener);
                /**
                mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);

                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback.
                    mPlayer = MediaPlayer.create(getContext(), words.getAudioResourceId());
                    mPlayer.start();
                    mPlayer.setOnCompletionListener(mCompletionListener);
                }
                 */


            }



        });


        /**Instead of using ContextCompat like the code above, we can just parse the resource directly
         * to textContainer using setBackgroundResource();
         * i.e. textContainer.setBackgroundResource(colorResourceId);
         */

        /**
         * This is another way of setting the color without having to declare a color resourceID
         * or set the color in the WordAdapter object declaration inside each view activity.
         * if (this.getContext() instanceof ColorsActivity)
         * { listView.setBackgroundColor(Color.parseColor("#8800A0")); }
         * else if (this.getContext() instanceof NumbersActivity)
         * { listView.setBackgroundColor(Color.parseColor("#FD8E09"));
         * } else if (this.getContext() instanceof PhrasesActivity)
         * { listView.setBackgroundColor(Color.parseColor("#16AFCA"));
         * } else if (this.getContext() instanceof FamilyMembersActivity)
         * { listView.setBackgroundColor(Color.parseColor("#379237")); }
         * */



        return listItemView;



    }
}
