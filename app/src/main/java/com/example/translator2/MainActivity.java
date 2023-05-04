package com.example.translator2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    public Button button;
    public EditText editText;
    public TextView text;

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
        text = findViewById(R.id.text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String userInput = editText.getText().toString().toLowerCase(Locale.ROOT);
                String str = "";
                for (int i = 0; i < userInput.length(); i++) {
                    str += translate(userInput.charAt(i))+" ";
                            

                }
                
                char[] chars = userInput.toCharArray();




                text.setText(str);



            }
        });


    }
    
    String translate(char letter){
        for (int i = 0; i < russian2.length; i++) {
            if (letter == russian2[i]) {
                return morse[i];
            }
        }

        return "@";
    }




}
