package com.gmail.myseekbar.bmichaelh13;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = (TextView) findViewById(R.id.resultId);
        seekBar = (SeekBar) findViewById(R.id.seekBarId);
        resultTextView.setText("Pain Level: " + seekBar.getProgress() + "/" + seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                resultTextView.setText("Pain Level: " + seekBar.getProgress() + "/" + seekBar.getMax());
                resultTextView.setTextColor(Color.DKGRAY);

                //Log.d("SB", "OnProgress !");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("SB", "OnStartTrackingTouched !");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                if (seekBar.getProgress() >= 7) {
                    resultTextView.setTextColor(Color.RED);
                }

                Log.d("SB", "OnStopTrackingReleased !");

            }
        });

    }
}
