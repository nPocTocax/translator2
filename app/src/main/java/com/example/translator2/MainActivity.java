package com.example.translator2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public Button button;
    public EditText editText;
    public EditText editMorse;
    public Button button2;

    


    char[] russian = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к',
            'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
            'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', ' ', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.', ',', '-', '?', '!', };

    String[] morse = {".-", "-...", ".--", "--.", "-..", ".", "...-", "--..", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", ".-.", "...", "-",
            "..-", "..-.", "....", "-.-.", "---.", "----", "--.-", "--.--", "-.--",
            "-..-", "..-..", "..--", ".-.-", "", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", ".-.-.-", "--..--", "-....-", "..--..", "-.-.--", " "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        editMorse = findViewById(R.id.editMorse);
        button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
                editMorse.setText("");

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textInput = editText.getText().toString().toLowerCase(Locale.ROOT);
                String morseInput = editMorse.getText().toString();
                if(textInput.equals("") && morseInput.equals("")) {
                    return;
                }
                if(!textInput.equals("")) {
                    String str = "";
                    for (int i = 0; i < textInput.length(); i++) {
                        str += translateToMorse(textInput.charAt(i)) + " ";
                    }
                    editMorse.setText(str);
                } else {
                    String[] s = morseInput.split(" ");
                    String str = "";
                    for (int i = 0; i < s.length; i++) {
                        str += traslateFromMorse(s[i]);
                    }
                    editText.setText(str);
                }
            }
        });
    }

    String translateToMorse(char letter){
        for (int i = 0; i < russian.length; i++) {
            if (letter == russian[i]) {
                return morse[i];
            }
        }

        return "@";
    }

    char traslateFromMorse(String str) {
        for (int i = 0; i < morse.length; i++) {
            if(str.equals(morse[i])){
                return russian[i];
            }
        }
        return '@';
    }




}
