package com.example.translator2;

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

    char[] russian = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к',
            'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
            'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', ' '};
    char[] russian2 = {'a', 'b', 'v', 'g', 'd', 'e', 'j', 'z', 'i', 'y', 'k',
            'l', 'm', 'n', 'o', 'p', 'r', 'c', 't', 'y', 'f', 'h', 'c',
            '4', 'W', 'W', '6', '7', '8', '9', '3', 'j', ' '};

    String[] morse = {".-", "-...", ".--", "--.", "-..", ".", "...-", "--..", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", ".-.", "...", "-",
            "..-", "..-.", "....", "-.-.", "---.", "----", "--.-", "--.--", "-.--",
            "-..-", "..-..", "..--", ".-.-", " "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        editMorse = findViewById(R.id.editMorse);

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
            if (letter == russian2[i]) {
                return morse[i];
            }
        }

        return "@";
    }

    char traslateFromMorse(String str) {
        for (int i = 0; i < morse.length; i++) {
            if(str.equals(morse[i])){
                return russian2[i];
            }
        }
        return '@';
    }




}
