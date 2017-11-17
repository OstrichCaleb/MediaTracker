package com.example.ostri.runnablesandobservables;

import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by ostri on 11/16/2017.
 */

public class ChangeTextRunnable implements Runnable {

    private long delay_time = 100;

    TextView message;
    Handler handler;

    EditText minEntry;
    EditText maxEntry;
    EditText speedEntry;

    int min = 0;
    int max = 100;

    Random rand = new Random();

    int num = 0;

    boolean shouldRun = true;

    public ChangeTextRunnable(TextView message, Handler handler, EditText minEntry, EditText maxEntry, EditText speedEntry) {
        this.message = message;
        this.handler = handler;
        this.minEntry = minEntry;
        this.maxEntry = maxEntry;
        this.speedEntry = speedEntry;
    }

    @Override
    public void run() {
        if (minEntry.getText().toString().equals("")){
            min = 0;
        } else {
            min = Integer.parseInt(minEntry.getText().toString());
        }

        if (maxEntry.getText().toString().equals("")){
            max = 100;
        } else {
            max = Integer.parseInt(maxEntry.getText().toString());
        }

        if (!speedEntry.getText().toString().equals("")) {
            this.delay_time = Integer.parseInt(speedEntry.getText().toString());
        } else {
            this.delay_time = 100;
        }

        num = rand.nextInt(max) + min;

        message.setText(num + "");

        if(shouldRun) handler.postDelayed(this, delay_time);
    }

    public void stopRunnable(){
        shouldRun = false;
    }

    public void startRunnable(){
        shouldRun = true;
        run();
    }
}
