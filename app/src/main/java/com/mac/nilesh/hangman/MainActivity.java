package com.mac.nilesh.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

    EditText film;
    Button Challenge;

    String req_name;
    String film_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        film = findViewById(R.id.et1_1);
        Challenge = findViewById(R.id.btn1_1);

        Challenge.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent second_screen = new Intent(MainActivity.this, SecondActivity.class);


               film_name = film.getText().toString();
               film_name = film_name.toUpperCase();
               req_name = film_name.toUpperCase();
               req_name = req_name.replaceAll("[BCDFGHJKLMNPQRSTVWXYZ]", "_ ");


               second_screen.putExtra("with_spaces", req_name);
               second_screen.putExtra("without_spaces", film_name);

               startActivity(second_screen);
           }
        });
    }
}