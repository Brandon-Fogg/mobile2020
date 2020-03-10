package com.foggbrandon.tictactoe_quizapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@RequiresApi(api = Build.VERSION_CODES.O)
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
    Button history;
    TextView history_text;
    Button reset_history;
    String player;
    String player_mode;

    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now;

    Gson gson;
    Type category;


    public void setBoard(BoardState state){
        if(state != null){
            toplB.setText(state.getTl());
            topB.setText(state.getT());
            toprB.setText(state.getTr());
            lB.setText(state.getL());
            midB.setText(state.getM());
            rB.setText(state.getR());
            botlB.setText(state.getBl());
            botB.setText(state.getB());
            botrB.setText(state.getBr());
            player = state.getP();
        }
        if(toplB.getText().equals("X")) {
            toplB.setTextColor(0xFFFF0000);
            toplB.setBackgroundColor(0x20FF0000);
        }
        else if(toplB.getText().equals("O")) {
            toplB.setTextColor(0xFF0000FF);
            toplB.setBackgroundColor(0x200000FF);
        }

        if(topB.getText().equals("X")) {
            topB.setTextColor(0xFFFF0000);
            topB.setBackgroundColor(0x20FF0000);
        }
        else if(topB.getText().equals("O")) {
            topB.setTextColor(0xFF0000FF);
            topB.setBackgroundColor(0x200000FF);
        }

        if(toprB.getText().equals("X")) {
            toprB.setTextColor(0xFFFF0000);
            toprB.setBackgroundColor(0x20FF0000);
        }
        else if(toprB.getText().equals("O")) {
            toprB.setTextColor(0xFF0000FF);
            toprB.setBackgroundColor(0x200000FF);
        }

        if(lB.getText().equals("X")) {
            lB.setTextColor(0xFFFF0000);
            lB.setBackgroundColor(0x20FF0000);
        }
        else if(lB.getText().equals("O")) {
            lB.setTextColor(0xFF0000FF);
            lB.setBackgroundColor(0x200000FF);
        }

        if(midB.getText().equals("X")) {
            midB.setTextColor(0xFFFF0000);
            midB.setBackgroundColor(0x20FF0000);
        }
        else if(midB.getText().equals("O")) {
            midB.setTextColor(0xFF0000FF);
            midB.setBackgroundColor(0x200000FF);
        }

        if(rB.getText().equals("X")) {
            rB.setTextColor(0xFFFF0000);
            rB.setBackgroundColor(0x20FF0000);
        }
        else if(rB.getText().equals("O")) {
            rB.setTextColor(0xFF0000FF);
            rB.setBackgroundColor(0x200000FF);
        }

        if(botlB.getText().equals("X")) {
            botlB.setTextColor(0xFFFF0000);
            botlB.setBackgroundColor(0x20FF0000);
        }
        else if(botlB.getText().equals("O")) {
            botlB.setTextColor(0xFF0000FF);
            botlB.setBackgroundColor(0x200000FF);
        }

        if(botB.getText().equals("X")) {
            botB.setTextColor(0xFFFF0000);
            botB.setBackgroundColor(0x20FF0000);
        }
        else if(botB.getText().equals("O")) {
            botB.setTextColor(0xFF0000FF);
            botB.setBackgroundColor(0x200000FF);
        }

        if(botrB.getText().equals("X")) {
            botrB.setTextColor(0xFFFF0000);
            botrB.setBackgroundColor(0x20FF0000);
        }
        else if(botrB.getText().equals("O")) {
            botrB.setTextColor(0xFF0000FF);
            botrB.setBackgroundColor(0x200000FF);
        }
    }


    public String getState() {
        String to_ret = "";
        if(toplB.getText().toString().equals(""))
            to_ret += ".";
        else
            to_ret += toplB.getText().toString();
        if(topB.getText().toString().equals(""))
            to_ret += ".";
        else
            to_ret += topB.getText().toString();
        if(toprB.getText().toString().equals(""))
            to_ret += ".";
        else
            to_ret += toprB.getText().toString();
        if(lB.getText().toString().equals(""))
            to_ret += ".";
        else
            to_ret += lB.getText().toString();
        if(midB.getText().toString().equals(""))
            to_ret += ".";
        else
            to_ret += midB.getText().toString();
        if(rB.getText().toString().equals(""))
            to_ret += ".";
        else
            to_ret += rB.getText().toString();
        if(botlB.getText().toString().equals(""))
            to_ret += ".";
        else
            to_ret += botlB.getText().toString();
        if(botB.getText().toString().equals(""))
            to_ret += ".";
        else
            to_ret += botB.getText().toString();
        if(botrB.getText().toString().equals(""))
            to_ret += ".";
        else
            to_ret += botrB.getText().toString();
        BoardState temp = new BoardState(to_ret, player);
        String to_save = gson.toJson(temp);
        editor.putString(player_mode, to_save);
        editor.apply();
        return to_ret;
    }

    public String isWinner_string(String state) {
        String topRow = state.substring(0, 3);
        String midRow = state.substring(3, 6);
        String botRow = state.substring(6);
        String lVert = state.substring(0, 1) + state.substring(3, 4) + state.substring(6, 7);
        String midVert = state.substring(1, 2) + state.substring(4, 5) + state.substring(7, 8);
        String topVert = state.substring(2, 3) + state.substring(5, 6) + state.substring(8);
        String diag1 = state.substring(0, 1) + state.substring(4, 5) + state.substring(8);
        String diag2 = state.substring(2, 3) + state.substring(4, 5) + state.substring(6, 7);
        if(topRow.equals("OOO")||midRow.equals("OOO")||botRow.equals("OOO")||lVert.equals("OOO")||topVert.equals("OOO")||midVert.equals("OOO")||diag1.equals("OOO")||diag2.equals("OOO")){
            return "O Wins!";
        }
        if(topRow.equals("XXX")||midRow.equals("XXX")||botRow.equals("XXX")||lVert.equals("XXX")||topVert.equals("XXX")||midVert.equals("XXX")||diag1.equals("XXX")||diag2.equals("XXX")){
            return "X Wins!";
        }
        if(state.contains("."))
            return "";
        return "Tie Game!";
    }

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
        now = LocalDateTime.now();
        if(topRow.equals("OOO")||midRow.equals("OOO")||botRow.equals("OOO")||lVert.equals("OOO")||topVert.equals("OOO")||midVert.equals("OOO")||diag1.equals("OOO")||diag2.equals("OOO")){
            editor.putString("history", sharedPrefs.getString("history", "") + "O won in " + player_mode + ": " + dtf.format(now) + "\n");
            editor.apply();
            return "O Wins!";
        }
        if(topRow.equals("XXX")||midRow.equals("XXX")||botRow.equals("XXX")||lVert.equals("XXX")||topVert.equals("XXX")||midVert.equals("XXX")||diag1.equals("XXX")||diag2.equals("XXX")){
            editor.putString("history", sharedPrefs.getString("history", "") + "X won in " + player_mode + ": " + dtf.format(now) + "\n");
            editor.apply();
            return "X Wins!";
        }
        if(topRow.length()+midRow.length()+botRow.length()==9){
            editor.putString("history", sharedPrefs.getString("history", "") + "Tie game in " + player_mode + ": " + dtf.format(now) + "\n");
            editor.apply();
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
        editor.putString(player_mode, "");
        editor.apply();
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

    public int max(String state) {
        String win = isWinner_string(state);
        if(win.equals("X Wins!"))
            return 2;
        else if(win.equals("Tie Game!"))
            return 1;
        else if(win.equals("O Wins!"))
            return 0;
        int max=0;
        for(int i=0;i<9;i++) {
            if(state.substring(i,i+1).equals(".")) {
                int t_max;
                if(i==0)
                    t_max = min("X"+state.substring(1));
                else if(i==8)
                    t_max = min(state.substring(0,i)+"X");
                else
                    t_max = min(state.substring(0,i)+"X"+state.substring(i+1));
                if(t_max == 2)
                    return 2;
                else if(t_max == 1 && max == 0)
                    max = 1;
            }
        }
        return max;
    }

    public int min(String state) {
        String win = isWinner_string(state);
        if(win.equals("X Wins!"))
            return 2;
        else if(win.equals("Tie Game!"))
            return 1;
        else if(win.equals("O Wins!"))
            return 0;
        int min=2;
        for(int i=0;i<9;i++) {
            if(state.substring(i,i+1).equals(".")) {
                int t_min;
                if(i==0)
                    t_min = max("O"+state.substring(1));
                else if(i==8)
                    t_min = max(state.substring(0,i)+"O");
                else
                    t_min = max(state.substring(0,i)+"O"+state.substring(i+1));
                if(t_min == 0)
                    return 0;
                else if(t_min == 1 && min == 2)
                    min = 1;
            }
        }
        return min;
    }

    public void AI_take_turn(String other_player) {
        String state = getState();
        Log.i("button", state);
        Button[] buttons = {toplB,topB,toprB,lB,midB,rB,botlB,botB,botrB};
        if(other_player.equals("X")) {
            int min = 2;
            int idx = -1;
            for(int i=0;i<9;i++) {
                if(state.substring(i,i+1).equals(".")) {
                    int t_min;
                    if(i==0)
                        t_min = max("O"+state.substring(1));
                    else if(i==8)
                        t_min = max(state.substring(0,i)+"O");
                    else
                        t_min = max(state.substring(0,i)+"O"+state.substring(i+1));
                    if(t_min == 0) {
                        min = 0;
                        idx = i;
                    }
                    else if(t_min == 1 && min == 2) {
                        min = 1;
                        idx = i;
                    }
                }
            }
            buttons[idx].setTextColor(0xFF0000FF);
            buttons[idx].setBackgroundColor(0x200000FF);
            buttons[idx].setText("O");
        }
        else {
            int max = 0;
            int idx = -1;
            for(int i=0;i<9;i++) {
                if(state.substring(i,i+1).equals(".")) {
                    int t_max;
                    if(i==0)
                        t_max = min("X"+state.substring(1));
                    else if(i==8)
                        t_max = min(state.substring(0,i)+"X");
                    else
                        t_max = min(state.substring(0,i)+"X"+state.substring(i+1));
                    if(t_max == 2) {
                        max = 2;
                        idx = i;
                    }
                    else if(t_max == 1 && max == 0) {
                        max = 1;
                        idx = i;
                    }
                }
            }
            buttons[idx].setTextColor(0xFFFF0000);
            buttons[idx].setBackgroundColor(0x20FF0000);
            buttons[idx].setText("X");
        }
        state = getState();
    }

    public void startSinglePlayerGame() {
        setContentView(R.layout.single_player_screen);

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

        player_mode = "single player mode";

        BoardState temp = gson.fromJson(sharedPrefs.getString(player_mode,""), category);
        setBoard(temp);

        if(temp == null) {
            player = "";
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
        else {
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

        midB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("button", player + " pressed middle button");
                if (!midB.getText().equals("X") && !midB.getText().equals("O")) {
                    midB.setText(player);
                    if (player.equals("X")) {
                        midB.setTextColor(0xFFFF0000);
                        midB.setBackgroundColor(0x20FF0000);
                    } else {
                        midB.setTextColor(0xFF0000FF);
                        midB.setBackgroundColor(0x200000FF);
                    }
                    String win = isWinner();
                    String state = getState();
                    if(!win.equals(""))
                        endGame(win);
                    else {
                        AI_take_turn(player);
                        win = isWinner();
                        if (!win.equals(""))
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
                    } else {
                        topB.setTextColor(0xFF0000FF);
                        topB.setBackgroundColor(0x200000FF);
                    }
                    String win = isWinner();
                    String state = getState();
                    if(!win.equals(""))
                        endGame(win);
                    else {
                        AI_take_turn(player);
                        win = isWinner();
                        if (!win.equals(""))
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
                    } else {
                        botB.setTextColor(0xFF0000FF);
                        botB.setBackgroundColor(0x200000FF);
                    }
                    String win = isWinner();
                    String state = getState();
                    if(!win.equals(""))
                        endGame(win);
                    else {
                        AI_take_turn(player);
                        win = isWinner();
                        if (!win.equals(""))
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
                    } else {
                        lB.setTextColor(0xFF0000FF);
                        lB.setBackgroundColor(0x200000FF);
                    }
                    String win = isWinner();
                    String state = getState();
                    if(!win.equals(""))
                        endGame(win);
                    else {
                        AI_take_turn(player);
                        win = isWinner();
                        if (!win.equals(""))
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
                    }
                    else {
                        rB.setTextColor(0xFF0000FF);
                        rB.setBackgroundColor(0x200000FF);
                    }
                    String win = isWinner();
                    String state = getState();
                    if(!win.equals(""))
                        endGame(win);
                    else {
                        AI_take_turn(player);
                        win = isWinner();
                        if (!win.equals(""))
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
                    } else {
                        toplB.setTextColor(0xFF0000FF);
                        toplB.setBackgroundColor(0x200000FF);
                    }
                    String win = isWinner();
                    String state = getState();
                    if(!win.equals(""))
                        endGame(win);
                    else {
                        AI_take_turn(player);
                        win = isWinner();
                        if (!win.equals(""))
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
                    } else {
                        toprB.setTextColor(0xFF0000FF);
                        toprB.setBackgroundColor(0x200000FF);
                    }
                    String win = isWinner();
                    String state = getState();
                    if(!win.equals(""))
                        endGame(win);
                    else {
                        AI_take_turn(player);
                        win = isWinner();
                        if (!win.equals(""))
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
                    } else {
                        botlB.setTextColor(0xFF0000FF);
                        botlB.setBackgroundColor(0x200000FF);
                    }
                    String win = isWinner();
                    String state = getState();
                    if(!win.equals(""))
                        endGame(win);
                    else {
                        AI_take_turn(player);
                        win = isWinner();
                        if (!win.equals(""))
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
                    } else {
                        botrB.setTextColor(0xFF0000FF);
                        botrB.setBackgroundColor(0x200000FF);
                    }
                    String win = isWinner();
                    String state = getState();
                    if(!win.equals(""))
                        endGame(win);
                    else {
                        AI_take_turn(player);
                        win = isWinner();
                        if (!win.equals(""))
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
                editor.putString(player_mode, "");
                editor.apply();
            }
        });
    }

    public void startMultiPlayerGame() {
        setContentView(R.layout.multi_player_screen);

        player_mode = "multi player mode";
        player = "";

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

        BoardState temp = gson.fromJson(sharedPrefs.getString(player_mode,""), category);
        setBoard(temp);

        if(temp == null)
            player = "X";

        text.setText(player + "'s Turn");
        if(player.equals("X"))
            text.setTextColor(0xFFFF0000);
        else
            text.setTextColor(0xFF0000FF);

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
                    String state = getState();
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
                    String state = getState();
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
                    String state = getState();
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
                    String state = getState();
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
                    String state = getState();
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
                    String state = getState();
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
                    String state = getState();
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
                    String state = getState();
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
                    String state = getState();
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
                editor.putString(player_mode, "");
                editor.apply();
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

    public void showHistory() {
        setContentView(R.layout.history_screen);
        history_text = findViewById(R.id.history_text);
        reset_history = findViewById(R.id.reset_history);
        backB = findViewById(R.id.backB);
        history_text.setText(sharedPrefs.getString("history", ""));

        reset_history.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", "Pressed reset history button");
                editor.putString("history", "");
                editor.apply();
                history_text.setText(sharedPrefs.getString("history", ""));
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
        history = findViewById(R.id.history);

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

        history.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("button", "Play history button pressed");
                showHistory();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        category = new TypeToken<BoardState>(){}.getType();
        sharedPrefs = getSharedPreferences("Game_History", Context.MODE_PRIVATE);
        editor = sharedPrefs.edit();
        startScreen();
    }
}
