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

        topB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed top button");
                topB.setText(player);
                if(player.equals("X")) {
                    topB.setTextColor(0xFFFF0000);
                    player = "O";
                    text.setText("O's Turn");
                    text.setTextColor(0xFF0000FF);
                }
                else {
                    topB.setTextColor(0xFF0000FF);
                    player = "X";
                    text.setText("X's Turn");
                    text.setTextColor(0xFFFF0000);
                }
            }
        });

        botB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed bottom button");
                botB.setText(player);
                if(player.equals("X")) {
                    botB.setTextColor(0xFFFF0000);
                    player = "O";
                    text.setText("O's Turn");
                    text.setTextColor(0xFF0000FF);
                }
                else {
                    botB.setTextColor(0xFF0000FF);
                    player = "X";
                    text.setText("X's Turn");
                    text.setTextColor(0xFFFF0000);
                }
            }
        });

        lB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed left button");
                lB.setText(player);
                if(player.equals("X")) {
                    lB.setTextColor(0xFFFF0000);
                    player = "O";
                    text.setText("O's Turn");
                    text.setTextColor(0xFF0000FF);
                }
                else {
                    lB.setTextColor(0xFF0000FF);
                    player = "X";
                    text.setText("X's Turn");
                    text.setTextColor(0xFFFF0000);
                }
            }
        });

        rB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed right button");
                rB.setText(player);
                if(player.equals("X")) {
                    rB.setTextColor(0xFFFF0000);
                    player = "O";
                    text.setText("O's Turn");
                    text.setTextColor(0xFF0000FF);
                }
                else {
                    rB.setTextColor(0xFF0000FF);
                    player = "X";
                    text.setText("X's Turn");
                    text.setTextColor(0xFFFF0000);
                }
            }
        });

        toplB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed top left button");
                toplB.setText(player);
                if(player.equals("X")) {
                    toplB.setTextColor(0xFFFF0000);
                    player = "O";
                    text.setText("O's Turn");
                    text.setTextColor(0xFF0000FF);
                }
                else {
                    toplB.setTextColor(0xFF0000FF);
                    player = "X";
                    text.setText("X's Turn");
                    text.setTextColor(0xFFFF0000);
                }
            }
        });

        toprB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed top right button");
                toprB.setText(player);
                if(player.equals("X")) {
                    toprB.setTextColor(0xFFFF0000);
                    player = "O";
                    text.setText("O's Turn");
                    text.setTextColor(0xFF0000FF);
                }
                else {
                    toprB.setTextColor(0xFF0000FF);
                    player = "X";
                    text.setText("X's Turn");
                    text.setTextColor(0xFFFF0000);
                }
            }
        });

        botlB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed bottom left button");
                botlB.setText(player);
                if(player.equals("X")) {
                    botlB.setTextColor(0xFFFF0000);
                    player = "O";
                    text.setText("O's Turn");
                    text.setTextColor(0xFF0000FF);
                }
                else {
                    botlB.setTextColor(0xFF0000FF);
                    player = "X";
                    text.setText("X's Turn");
                    text.setTextColor(0xFFFF0000);
                }
            }
        });

        botrB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed bottom right button");
                botrB.setText(player);
                if(player.equals("X")) {
                    botrB.setTextColor(0xFFFF0000);
                    player = "O";
                    text.setText("O's Turn");
                    text.setTextColor(0xFF0000FF);
                }
                else {
                    botrB.setTextColor(0xFF0000FF);
                    player = "X";
                    text.setText("X's Turn");
                    text.setTextColor(0xFFFF0000);
                }
            }
        });
    }
}
