package com.example.ostri.runnablesandobservables;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView message;
    Button button;
    EditText speedEntry;
    EditText minEntry;
    EditText maxEntry;

    SeekBar seekBar;

    boolean going;

    ChangeTextRunnable changeText;

    Runnable tbd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        going = true;

        message = findViewById(R.id.message);
        button = findViewById(R.id.button);

        speedEntry = findViewById(R.id.speedEntry);
        minEntry = findViewById(R.id.minEntry);
        maxEntry = findViewById(R.id.maxEntry);
        seekBar = findViewById(R.id.seekBar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (going){
                    onStop();
                    going = false;
                }
                else {
                    start();
                    going = true;
                }
            }
        });

        // perform seek bar change listener event used for getting the progress value
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String spd = String.valueOf(progress);
                if (spd.equals("0")) {
                    speedEntry.setText("100");
                } else if (spd.equals("1")) {
                    speedEntry.setText("1000");
                } else if (spd.equals("2")) {
                    speedEntry.setText("2000");
                } else  {
                    speedEntry.setText("3000");
                }
            }
        });

        Handler handler = new Handler();
        changeText = new ChangeTextRunnable(message, handler, minEntry, maxEntry, speedEntry);
        handler.post(changeText);
        onStop();
    }

    @Override
    protected void onStop() {
        super.onStop();

        changeText.stopRunnable();

        button.setText("Start");
    }

    protected void start(){
        changeText.startRunnable();

        button.setText("Stop");
    }
}
