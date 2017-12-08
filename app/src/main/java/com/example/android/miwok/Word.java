package com.example.android.miwok;

/**
 * Created by USER on 11/27/2017.
 */

public class Word {

    //variable to hold english and miwok words.
    private String miwokWord, englishWord;
    //variable to hold image resource. default value is set to no image
    private int imageResourceId = NO_IMAGE_PROVIDED;
    private int audioResourceId;
    //Variable to represent state of no image
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String miwokWord, String englishWord, int audioResourceId){
        this.miwokWord = miwokWord;
        this.englishWord = englishWord;
        this.audioResourceId = audioResourceId;

    }
    //Constructor to initialize Word class
    public Word(String miwokWord, String englishWord, int imageResourceId, int audioResourceId){
        this.miwokWord = miwokWord;
        this.englishWord = englishWord;
        this.imageResourceId = imageResourceId;
        this.audioResourceId = audioResourceId;
    }
    //method to get english word
    public String getDefaultTranslation(){
        return englishWord;
    }
    //method to get miwok translation
    public String getMiwokTranslation(){
        return miwokWord;
    }

    //method to get image resource for each word.
    public int getImageResourceId(){
        return imageResourceId;
    }

    //method to get audio resource for each word

    public int getAudioResourceId(){
        return audioResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */

    public boolean hasImage(){

        return imageResourceId != NO_IMAGE_PROVIDED;
    }
}
