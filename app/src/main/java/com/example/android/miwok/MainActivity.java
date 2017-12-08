/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        TextView numbers  = (TextView) findViewById(R.id.numbers);
        TextView colors = (TextView) findViewById(R.id.colors);
        TextView familyMembers = (TextView) findViewById(R.id.family);
        TextView Phrases = (TextView) findViewById(R.id.phrases);


        numbers.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(view.getContext(), "Open the list of numbers",Toast.LENGTH_SHORT).show();
                Intent numbersIntent = new Intent(MainActivity.this, Numbers.class);
                startActivity(numbersIntent);
            }
        });

        colors.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(view.getContext(), "Open the list of colors",Toast.LENGTH_SHORT).show();

                Intent colorsIntent = new Intent(MainActivity.this, Colors.class);
                startActivity(colorsIntent);
            }
        });

        familyMembers.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(view.getContext(), "Open the list of family members",Toast.LENGTH_SHORT).show();

                Intent familyMembersIntent = new Intent(MainActivity.this, FamilyMembers.class);
                startActivity(familyMembersIntent);
            }
        });

        Phrases.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(view.getContext(), "Open the list of Phrases",Toast.LENGTH_SHORT).show();
                Intent phrasesIntent = new Intent(MainActivity.this, Phrases.class);
                startActivity(phrasesIntent);
            }
        });

    }

}
