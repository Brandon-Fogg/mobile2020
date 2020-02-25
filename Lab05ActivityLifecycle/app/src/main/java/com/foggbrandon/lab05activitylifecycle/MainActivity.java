package com.foggbrandon.lab05activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;

    TextView view;
    Button reset;

    Lifecycle set1;
    Lifecycle set2;

    public void updateScreen() {
        view.setText(set1.toString() + "\n\n" + set2.toString());
    }

    public void updateSharedPrefs() {
        editor.putInt("create", set2.getOnCreateCount());
        editor.putInt("start", set2.getOnStartCount());
        editor.putInt("resume", set2.getOnResumeCount());
        editor.putInt("pause", set2.getOnPauseCount());
        editor.putInt("stop", set2.getOnStopCount());
        editor.putInt("restart", set2.getOnRestartCount());
        editor.putInt("destroy", set2.getOnDestroyCount());
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset = findViewById(R.id.reset);
        view = findViewById(R.id.view);

        sharedPrefs = getSharedPreferences("Click_Count", Context.MODE_PRIVATE);
        editor = sharedPrefs.edit();

        set1 = new Lifecycle(0, 0, 0, 0, 0, 0, 0);
        set2 = new Lifecycle(sharedPrefs.getInt("create", 0), sharedPrefs.getInt("start", 0), sharedPrefs.getInt("resume", 0), sharedPrefs.getInt("pause", 0), sharedPrefs.getInt("stop", 0), sharedPrefs.getInt("restart", 0), sharedPrefs.getInt("destroy", 0));

        set1.setOnCreateCount(set1.getOnCreateCount() + 1);
        set2.setOnCreateCount(set2.getOnCreateCount() + 1);

        updateScreen();
        updateSharedPrefs();

        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                set1 = new Lifecycle(0, 0, 0, 0, 0, 0, 0);
                set2 = new Lifecycle(0, 0, 0, 0, 0, 0, 0);
                updateScreen();
                updateSharedPrefs();
            }
        });
    }

    protected void onStart() {
        super.onStart();
        set1.setOnStartCount(set1.getOnStartCount()+1);
        set2.setOnStartCount(set2.getOnStartCount()+1);

        updateScreen();
        updateSharedPrefs();
    }

    protected void onResume() {
        super.onResume();
        set1.setOnResumeCount(set1.getOnResumeCount()+1);
        set2.setOnResumeCount(set2.getOnResumeCount()+1);

        updateScreen();
        updateSharedPrefs();
    }

    protected void onPause() {
        super.onPause();
        set1.setOnPauseCount(set1.getOnPauseCount()+1);
        set2.setOnPauseCount(set2.getOnPauseCount()+1);

        updateScreen();
        updateSharedPrefs();
    }

    protected void onStop() {
        super.onStop();
        set1.setOnStopCount(set1.getOnStopCount()+1);
        set2.setOnStopCount(set2.getOnStopCount()+1);

        updateScreen();
        updateSharedPrefs();
    }

    protected void onRestart() {
        super.onRestart();
        set1.setOnRestartCount(set1.getOnRestartCount()+1);
        set2.setOnRestartCount(set2.getOnRestartCount()+1);

        updateScreen();
        updateSharedPrefs();
    }

    protected void onDestroy() {
        super.onDestroy();
        set1.setOnDestroyCount(set1.getOnDestroyCount()+1);
        set2.setOnDestroyCount(set2.getOnDestroyCount()+1);

        updateScreen();
        updateSharedPrefs();
    }
}