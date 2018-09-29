package com.mac.nilesh.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView hangman1;
    TextView tofill;
    TextView filled;
    EditText chartest;
    Button check;

    String with_spaces;
    String without_spaces;
    String hangman = "You DIE";
    int failed_tries = 0;
    char space = '-';

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        hangman1 = findViewById(R.id.tv2_1);
        tofill = findViewById(R.id.tv2_2);
        check = findViewById(R.id.btn2_1);
        filled = findViewById(R.id.tv2_3);
        chartest = findViewById(R.id.et2_1);

        with_spaces  = getIntent().getStringExtra("with_spaces");
        with_spaces = with_spaces.toUpperCase();
        without_spaces = getIntent().getStringExtra("without_spaces");
        without_spaces = without_spaces.toUpperCase();
        
        filled.setText(with_spaces);

            check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String et;
                    char chartest1;
                    int length_char;
                    et = chartest.getText().toString();
                    et = et.toUpperCase();
                    chartest1 = et.charAt(0);
                    length_char = et.length();
                    int length_string = without_spaces.length();
                                        
                    if (length_char > 1) {
                        Toast.makeText(SecondActivity.this, "Only The First Character is Taken", Toast.LENGTH_SHORT).show();
                    }

                    if (without_spaces.indexOf(chartest1) != -1)
                    {

                        for (int n = 0; n < length_string; n++) {
                            if (chartest1 == without_spaces.charAt(n) ) {
                                with_spaces = with_spaces.replaceFirst(with_spaces.charAt(n)+"", without_spaces.charAt(n)+"");
                            }
                        }
                        tofill.setText(with_spaces);

                        if (with_spaces.equals(without_spaces)) {
                            Toast.makeText(SecondActivity.this, "You Win", Toast.LENGTH_SHORT).show();
                            Intent takeback = new Intent(SecondActivity.this, MainActivity.class);
                            startActivity(takeback);
                        }
                    }

                   else {
                       failed_tries++;
                       hangman = hangman.replace(hangman.charAt(failed_tries - 1), space);
                       hangman1.setText(hangman);
                       if (failed_tries == 7) {
                           Toast.makeText(SecondActivity.this, "You Lose", Toast.LENGTH_SHORT).show();
                           Intent takeback = new Intent(SecondActivity.this, MainActivity.class);
                           startActivity(takeback);
                       }
                   }
                }
            });
        }
    }





/*int char_index[] = new int[char_occurence];

                       for (int j = 1; j <= char_occurence; j++) {
                           char_index[j] = without_spaces.indexOf(chartest1);
                       }

                       for (int j = 1; j <= char_occurence; j++) {
                           with_spaces = with_spaces.replace(with_spaces.charAt(char_index[j]), without_spaces.charAt(char_index[j]));
                           tofill.setText(with_spaces);

                       }

                       if (without_spaces.equalsIgnoreCase(with_spaces)) {
                           Toast.makeText(SecondActivity.this, "You Win", Toast.LENGTH_SHORT).show();
                           Intent intent_2 = new Intent(SecondActivity.this, MainActivity.class);
                           startActivity(intent_2);
                       }

                   } else {
                       hangman = hangman.replace(hangman.charAt(char_number), space);
                       hangman1.setText(hangman);
                       char_number++;
                   }

               }
           });
        }

        while (char_number < 7);

        Toast.makeText(SecondActivity.this, "You Lose", Toast.LENGTH_SHORT).show();
        Intent intent_3 = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent_3);
    }}
*/


