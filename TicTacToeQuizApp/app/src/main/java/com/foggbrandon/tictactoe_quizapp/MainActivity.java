package com.foggbrandon.tictactoe_quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button singlePlayer;
    Button multiPlayer;
    Button chooseX;
    Button chooseO;
    Button backB;
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


    public String isWinner(){
        String[] state = {toplB.getText().toString(),topB.getText().toString(),toprB.getText().toString(),lB.getText().toString(), midB.getText().toString(),rB.getText().toString(),botlB.getText().toString(),botB.getText().toString(),botrB.getText().toString()};
        String topRow = state[0]+state[1]+state[2];
        String midRow = state[3]+state[4]+state[5];
        String botRow = state[6]+state[7]+state[8];
        String lVert = state[0]+state[3]+state[6];
        String midVert = state[1]+state[4]+state[7];
        String topVert = state[2]+state[5]+state[8];
        String diag1 = state[0]+state[4]+state[8];
        String diag2 = state[2]+state[4]+state[6];
        if(topRow.equals("OOO")||midRow.equals("OOO")||botRow.equals("OOO")||lVert.equals("OOO")||topVert.equals("OOO")||midVert.equals("OOO")||diag1.equals("OOO")||diag2.equals("OOO")){
            return "O Wins!";
        }
        if(topRow.equals("XXX")||midRow.equals("XXX")||botRow.equals("XXX")||lVert.equals("XXX")||topVert.equals("XXX")||midVert.equals("XXX")||diag1.equals("XXX")||diag2.equals("XXX")){
            return "X Wins!";
        }
        if(topRow.length()+midRow.length()+botRow.length()==9){
            return "Tie Game!";
        }
        return "";
    }

    public void endGame(String winner){
        Log.i("button", winner);
        text.setText(winner);
        if(winner.charAt(0)=='X'){
            text.setTextColor(0xFFFF0000);
        }
        else if(winner.charAt(0)=='O'){
            text.setTextColor(0xFF0000FF);
        }
        else{
            text.setTextColor(0xFF000000);
        }
        toplB.setClickable(false);
        topB.setClickable(false);
        toprB.setClickable(false);
        lB.setClickable(false);
        midB.setClickable(false);
        rB.setClickable(false);
        botrB.setClickable(false);
        botB.setClickable(false);
        botlB.setClickable(false);
    }

    public void AI_take_turn(String other_player) {
        String AI_player = "";
        if(other_player.equals("X")) {
            AI_player = "O";
        }
        else {
            AI_player = "X";
        }
    }

    public void startSinglePlayerGame() {
        setContentView(R.layout.single_player_screen);

        player = "";
        text = findViewById(R.id.text);
        backB = findViewById(R.id.backB);
        chooseX = findViewById((R.id.chooseX));
        chooseO = findViewById((R.id.chooseO));
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

        midB.setBackgroundColor(0x10909090);
        topB.setBackgroundColor(0x10909090);
        botB.setBackgroundColor(0x10909090);
        rB.setBackgroundColor(0x10909090);
        lB.setBackgroundColor(0x10909090);
        toprB.setBackgroundColor(0x10909090);
        toplB.setBackgroundColor(0x10909090);
        botrB.setBackgroundColor(0x10909090);
        botlB.setBackgroundColor(0x10909090);

        midB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed middle button");
                if (!midB.getText().equals("X") && !midB.getText().equals("O")) {
                    midB.setText(player);
                    if (player.equals("X")) {
                        midB.setTextColor(0xFFFF0000);
                        midB.setBackgroundColor(0x20FF0000);
                        AI_take_turn(player);
                    } else {
                        midB.setTextColor(0xFF0000FF);
                        midB.setBackgroundColor(0x200000FF);
                        AI_take_turn(player);
                    }
                    String win = isWinner();
                    if(!win.equals("")){
                        endGame(win);
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
                        AI_take_turn(player);
                    } else {
                        topB.setTextColor(0xFF0000FF);
                        topB.setBackgroundColor(0x200000FF);
                        AI_take_turn(player);
                    }
                    String win = isWinner();
                    if(!win.equals("")){
                        endGame(win);
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
                        AI_take_turn(player);
                    } else {
                        botB.setTextColor(0xFF0000FF);
                        botB.setBackgroundColor(0x200000FF);
                        AI_take_turn(player);
                    }
                    String win = isWinner();
                    if(!win.equals("")){
                        endGame(win);
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
                        AI_take_turn(player);
                    } else {
                        lB.setTextColor(0xFF0000FF);
                        lB.setBackgroundColor(0x200000FF);
                        AI_take_turn(player);
                    }
                    String win = isWinner();
                    if(!win.equals("")){
                        endGame(win);
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
                        AI_take_turn(player);
                    }
                    else {
                        rB.setTextColor(0xFF0000FF);
                        rB.setBackgroundColor(0x200000FF);
                        AI_take_turn(player);
                    }
                    String win = isWinner();
                    if(!win.equals("")){
                        endGame(win);
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
                        AI_take_turn(player);
                    } else {
                        toplB.setTextColor(0xFF0000FF);
                        toplB.setBackgroundColor(0x200000FF);
                        AI_take_turn(player);
                    }
                    String win = isWinner();
                    if(!win.equals("")){
                        endGame(win);
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
                        AI_take_turn(player);
                    } else {
                        toprB.setTextColor(0xFF0000FF);
                        toprB.setBackgroundColor(0x200000FF);
                        AI_take_turn(player);
                    }
                    String win = isWinner();
                    if(!win.equals("")){
                        endGame(win);
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
                        AI_take_turn(player);
                    } else {
                        botlB.setTextColor(0xFF0000FF);
                        botlB.setBackgroundColor(0x200000FF);
                        AI_take_turn(player);
                    }
                    String win = isWinner();
                    if(!win.equals("")){
                        endGame(win);
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
                        AI_take_turn(player);
                    } else {
                        botrB.setTextColor(0xFF0000FF);
                        botrB.setBackgroundColor(0x200000FF);
                        AI_take_turn(player);
                    }
                    String win = isWinner();
                    if(!win.equals("")){
                        endGame(win);
                    }
                }
            }
        });

        backB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", "Pressed back button");
                startScreen();
            }
        });

        chooseO.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", "Player chose O");
                player = "O";
                chooseO.setVisibility(View.INVISIBLE);
                chooseX.setVisibility(View.INVISIBLE);
                chooseO.setClickable(false);
                chooseX.setClickable(false);
                toplB.setClickable(true);
                topB.setClickable(true);
                toprB.setClickable(true);
                lB.setClickable(true);
                midB.setClickable(true);
                rB.setClickable(true);
                botrB.setClickable(true);
                botB.setClickable(true);
                botlB.setClickable(true);
                AI_take_turn(player);
            }
        });

        chooseX.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", "Player chose X");
                player = "X";
                chooseO.setVisibility(View.INVISIBLE);
                chooseX.setVisibility(View.INVISIBLE);
                chooseO.setClickable(false);
                chooseX.setClickable(false);
                toplB.setClickable(true);
                topB.setClickable(true);
                toprB.setClickable(true);
                lB.setClickable(true);
                midB.setClickable(true);
                rB.setClickable(true);
                botrB.setClickable(true);
                botB.setClickable(true);
                botlB.setClickable(true);
            }
        });

        resetB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", "Pressed reset button");
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
                toplB.setClickable(false);
                topB.setClickable(false);
                toprB.setClickable(false);
                lB.setClickable(false);
                midB.setClickable(false);
                rB.setClickable(false);
                botrB.setClickable(false);
                botB.setClickable(false);
                botlB.setClickable(false);
                player = "";
                chooseO.setVisibility(View.VISIBLE);
                chooseX.setVisibility(View.VISIBLE);
                chooseO.setClickable(true);
                chooseX.setClickable(true);
                text.setText("");
            }
        });

        toplB.setClickable(false);
        topB.setClickable(false);
        toprB.setClickable(false);
        lB.setClickable(false);
        midB.setClickable(false);
        rB.setClickable(false);
        botrB.setClickable(false);
        botB.setClickable(false);
        botlB.setClickable(false);
    }

    public void startMultiPlayerGame() {
        setContentView(R.layout.multi_player_screen);
        player = "X";
        text = findViewById(R.id.text);
        backB = findViewById(R.id.backB);
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

        midB.setBackgroundColor(0x10909090);
        topB.setBackgroundColor(0x10909090);
        botB.setBackgroundColor(0x10909090);
        rB.setBackgroundColor(0x10909090);
        lB.setBackgroundColor(0x10909090);
        toprB.setBackgroundColor(0x10909090);
        toplB.setBackgroundColor(0x10909090);
        botrB.setBackgroundColor(0x10909090);
        botlB.setBackgroundColor(0x10909090);

        midB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed middle button");
                if (!midB.getText().equals("X") && !midB.getText().equals("O")) {
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
                    String win = isWinner();
                    if(!win.equals("")){
                        endGame(win);
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
                    String win = isWinner();
                    if(!win.equals("")){
                        endGame(win);
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
                    String win = isWinner();
                    if(!win.equals("")){
                        endGame(win);
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
                    String win = isWinner();
                    if(!win.equals("")){
                        endGame(win);
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
                    String win = isWinner();
                    if(!win.equals("")){
                        endGame(win);
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
                    String win = isWinner();
                    if(!win.equals("")){
                        endGame(win);
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
                    String win = isWinner();
                    if(!win.equals("")){
                        endGame(win);
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
                    String win = isWinner();
                    if(!win.equals("")){
                        endGame(win);
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
                    String win = isWinner();
                    if(!win.equals("")){
                        endGame(win);
                    }
                }
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
                toplB.setClickable(true);
                topB.setClickable(true);
                toprB.setClickable(true);
                lB.setClickable(true);
                midB.setClickable(true);
                rB.setClickable(true);
                botrB.setClickable(true);
                botB.setClickable(true);
                botlB.setClickable(true);
            }
        });

        backB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", "Pressed back button");
                startScreen();
            }
        });
    }

    public void startScreen() {
        setContentView(R.layout.start_screen);
        singlePlayer = findViewById(R.id.singlePlayer);
        multiPlayer = findViewById(R.id.multiPlayer);

        singlePlayer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", "Single player mode.");
                startSinglePlayerGame();
            }
        });

        multiPlayer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", "Multi player mode.");
                startMultiPlayerGame();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startScreen();
    }
}
