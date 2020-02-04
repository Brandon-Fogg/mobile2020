package com.foggbrandon.tictactoe_quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button midB;
    Button topB;
    Button toplB;
    Button toprB;
    Button lB;
    Button rB;
    Button botB;
    Button botlB;
    Button botrB;
    String player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = "X";
        text = findViewById(R.id.text);
        midB = findViewById(R.id.midB);
        topB = findViewById(R.id.topB);
        toplB = findViewById(R.id.toplB);
        toprB = findViewById(R.id.toprB);
        lB = findViewById(R.id.lB);
        rB = findViewById(R.id.rB);
        botB = findViewById(R.id.botB);
        botlB = findViewById(R.id.botlB);
        botrB = findViewById(R.id.botrB);
        midB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed middle button");
                midB.setText(player);
                if(player.equals("X")) {
                    midB.setTextColor(0xFFFF0000);
                    player = "O";
                    text.setText("O's Turn");
                    text.setTextColor(0xFF0000FF);
                }
                else {
                    midB.setTextColor(0xFF0000FF);
                    player = "X";
                    text.setText("X's Turn");
                    text.setTextColor(0xFFFF0000);
                }
            }
        });

    }
}
