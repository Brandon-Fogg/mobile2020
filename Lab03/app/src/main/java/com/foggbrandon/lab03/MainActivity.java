package com.foggbrandon.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView view1;
    TextView view2;
    TextView view3;
    TextView view4;

    /*int count1;
    int count2;
    int count3;
    int count4;*/
    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;

    Context context;
    int duration = Toast.LENGTH_SHORT;

    View.OnClickListener viewListener;

    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPrefs = getSharedPreferences("Click_Count", Context.MODE_PRIVATE);
        editor = sharedPrefs.edit();

        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        view4 = findViewById(R.id.view4);
        context = getApplicationContext();

        seekBar = findViewById(R.id.seekBar);

        viewListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView currView = (TextView) v;
                String name = currView.getTag().toString();
                int value = sharedPrefs.getInt(name, 0) + 1;
                editor.putInt(name, value);
                editor.apply();
                String text = name+" pressed "+value+" times.";
                Log.i("press", name+" pressed "+value+" times.");
                Toast.makeText(context, text, duration).show();
            }
        };
        view1.setOnClickListener(viewListener);
        view2.setOnClickListener(viewListener);
        view3.setOnClickListener(viewListener);
        view4.setOnClickListener(viewListener);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("press", "SeekBar changed to "+(progress+14));
                view1.setTextSize(progress+14);
                view2.setTextSize(progress+14);
                view3.setTextSize(progress+14);
                view4.setTextSize(progress+14);

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
