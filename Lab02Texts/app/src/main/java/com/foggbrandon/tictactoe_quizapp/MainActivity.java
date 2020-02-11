package com.foggbrandon.tictactoe_quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    Button resetB;
    String player;
    Button submitB;
    EditText responseText;
    TextView nameField;
    String[] words;
    Button cycleB;
    int index = -1;


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
        resetB = findViewById(R.id.resetB);
        submitB = findViewById(R.id.submitB);
        responseText = findViewById(R.id.responseText);
        nameField = findViewById(R.id.nameField);
        words = getResources().getStringArray(R.array.words);
        cycleB = findViewById(R.id.cycleB);

        midB.setBackgroundColor(0x10909090);
        topB.setBackgroundColor(0x10909090);
        botB.setBackgroundColor(0x10909090);
        rB.setBackgroundColor(0x10909090);
        lB.setBackgroundColor(0x10909090);
        toprB.setBackgroundColor(0x10909090);
        toplB.setBackgroundColor(0x10909090);
        botrB.setBackgroundColor(0x10909090);
        botlB.setBackgroundColor(0x10909090);

        midB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed middle button");
                if(!midB.getText().equals("X") && !midB.getText().equals("O")) {
                    midB.setText(player);
                    if (player.equals("X")) {
                        midB.setTextColor(0xFFFF0000);
                        midB.setBackgroundColor(0x20FF0000);
                        player = "O";
                        text.setText("O's Turn");
                        text.setTextColor(0xFF0000FF);
                    } else {
                        midB.setTextColor(0xFF0000FF);
                        midB.setBackgroundColor(0x200000FF);
                        player = "X";
                        text.setText("X's Turn");
                        text.setTextColor(0xFFFF0000);
                    }
                }
            }
        });

        topB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed top button");
                if(!topB.getText().equals("X") && !topB.getText().equals("O")) {
                    topB.setText(player);
                    if (player.equals("X")) {
                        topB.setTextColor(0xFFFF0000);
                        topB.setBackgroundColor(0x20FF0000);
                        player = "O";
                        text.setText("O's Turn");
                        text.setTextColor(0xFF0000FF);
                    } else {
                        topB.setTextColor(0xFF0000FF);
                        topB.setBackgroundColor(0x200000FF);
                        player = "X";
                        text.setText("X's Turn");
                        text.setTextColor(0xFFFF0000);
                    }
                }
            }
        });

        botB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed bottom button");
                if(!botB.getText().equals("X") && !botB.getText().equals("O")) {
                    botB.setText(player);
                    if (player.equals("X")) {
                        botB.setTextColor(0xFFFF0000);
                        botB.setBackgroundColor(0x20FF0000);
                        player = "O";
                        text.setText("O's Turn");
                        text.setTextColor(0xFF0000FF);
                    } else {
                        botB.setTextColor(0xFF0000FF);
                        botB.setBackgroundColor(0x200000FF);
                        player = "X";
                        text.setText("X's Turn");
                        text.setTextColor(0xFFFF0000);
                    }
                }
            }
        });

        lB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed left button");
                if(!lB.getText().equals("X") && !lB.getText().equals("O")) {
                    lB.setText(player);
                    if (player.equals("X")) {
                        lB.setTextColor(0xFFFF0000);
                        lB.setBackgroundColor(0x20FF0000);
                        player = "O";
                        text.setText("O's Turn");
                        text.setTextColor(0xFF0000FF);
                    } else {
                        lB.setTextColor(0xFF0000FF);
                        lB.setBackgroundColor(0x200000FF);
                        player = "X";
                        text.setText("X's Turn");
                        text.setTextColor(0xFFFF0000);
                    }
                }
            }
        });

        rB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed right button");
                if(!rB.getText().equals("X") && !rB.getText().equals("O")) {
                    rB.setText(player);
                    if(player.equals("X")) {
                        rB.setTextColor(0xFFFF0000);
                        rB.setBackgroundColor(0x20FF0000);
                        player = "O";
                        text.setText("O's Turn");
                        text.setTextColor(0xFF0000FF);
                    }
                    else {
                        rB.setTextColor(0xFF0000FF);
                        rB.setBackgroundColor(0x200000FF);
                        player = "X";
                        text.setText("X's Turn");
                        text.setTextColor(0xFFFF0000);
                    }
                }
            }
        });

        toplB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed top left button");
                if(!toplB.getText().equals("X") && !toplB.getText().equals("O")) {
                    toplB.setText(player);
                    if (player.equals("X")) {
                        toplB.setTextColor(0xFFFF0000);
                        toplB.setBackgroundColor(0x20FF0000);
                        player = "O";
                        text.setText("O's Turn");
                        text.setTextColor(0xFF0000FF);
                    } else {
                        toplB.setTextColor(0xFF0000FF);
                        toplB.setBackgroundColor(0x200000FF);
                        player = "X";
                        text.setText("X's Turn");
                        text.setTextColor(0xFFFF0000);
                    }
                }
            }
        });

        toprB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed top right button");
                if(!toprB.getText().equals("X") && !toprB.getText().equals("O")) {
                    toprB.setText(player);
                    if (player.equals("X")) {
                        toprB.setTextColor(0xFFFF0000);
                        toprB.setBackgroundColor(0x20FF0000);
                        player = "O";
                        text.setText("O's Turn");
                        text.setTextColor(0xFF0000FF);
                    } else {
                        toprB.setTextColor(0xFF0000FF);
                        toprB.setBackgroundColor(0x200000FF);
                        player = "X";
                        text.setText("X's Turn");
                        text.setTextColor(0xFFFF0000);
                    }
                }
            }
        });

        botlB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed bottom left button");
                if(!botlB.getText().equals("X") && !botlB.getText().equals("O")) {
                    botlB.setText(player);
                    if (player.equals("X")) {
                        botlB.setTextColor(0xFFFF0000);
                        botlB.setBackgroundColor(0x20FF0000);
                        player = "O";
                        text.setText("O's Turn");
                        text.setTextColor(0xFF0000FF);
                    } else {
                        botlB.setTextColor(0xFF0000FF);
                        botlB.setBackgroundColor(0x200000FF);
                        player = "X";
                        text.setText("X's Turn");
                        text.setTextColor(0xFFFF0000);
                    }
                }
            }
        });

        botrB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed bottom right button");
                if(!botrB.getText().equals("X") && !botrB.getText().equals("O")) {
                    botrB.setText(player);
                    if (player.equals("X")) {
                        botrB.setTextColor(0xFFFF0000);
                        botrB.setBackgroundColor(0x20FF0000);
                        player = "O";
                        text.setText("O's Turn");
                        text.setTextColor(0xFF0000FF);
                    } else {
                        botrB.setTextColor(0xFF0000FF);
                        botrB.setBackgroundColor(0x200000FF);
                        player = "X";
                        text.setText("X's Turn");
                        text.setTextColor(0xFFFF0000);
                    }
                }
            }
        });

        submitB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", "Name " + responseText.getText().toString());
                nameField.setText(responseText.getText());
                responseText.setText("");
            }
        });

        cycleB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                index += 1;
                if(index == words.length){
                    index = 0;
                }
                Log.i("button", "Cycle " + words[index]);
                nameField.setText(words[index]);
            }
        });

        resetB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed reset button");
                midB.setText("");
                topB.setText("");
                botB.setText("");
                lB.setText("");
                rB.setText("");
                toplB.setText("");
                botlB.setText("");
                toprB.setText("");
                botrB.setText("");
                midB.setBackgroundColor(0x10909090);
                topB.setBackgroundColor(0x10909090);
                botB.setBackgroundColor(0x10909090);
                rB.setBackgroundColor(0x10909090);
                lB.setBackgroundColor(0x10909090);
                toprB.setBackgroundColor(0x10909090);
                toplB.setBackgroundColor(0x10909090);
                botrB.setBackgroundColor(0x10909090);
                botlB.setBackgroundColor(0x10909090);
                text.setText("X's Turn");
                text.setTextColor(0xFFFF0000);
                player = "X";
            }
        });
    }
}
