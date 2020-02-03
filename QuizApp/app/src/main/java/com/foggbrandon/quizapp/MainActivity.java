package com.foggbrandon.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.util.Log;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button submitButton;
    EditText responseText;
    TextView displayText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = findViewById(R.id.clickButton);
        responseText = findViewById(R.id.responseEditText);
        displayText = findViewById(R.id.textBox);
        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.println("Hello mom");
                Log.i("testButton", "Hi dad! " + responseText.getText().toString());
                displayText.setText(displayText.getText() + " " + responseText.getText());
            }
        });
        responseText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    if(responseText.getText().toString().equals("TJ")) {
                        displayText.setText("TJ Rocks!");
                        responseText.setText("");
                        responseText.setHint("That's a good name.");
                    }
                }
            }
        });
    }
}
