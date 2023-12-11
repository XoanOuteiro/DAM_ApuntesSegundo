package com.example.rgbexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar redbar, greenbar, bluebar, alphabar;

    private int red, green , blue, alpha;

    private TextView valueText, fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redbar = findViewById(R.id.redbar);
        greenbar = findViewById(R.id.greenbar);
        bluebar = findViewById(R.id.bluebar);
        alphabar = findViewById(R.id.alphabar);

        valueText = findViewById(R.id.valueText);
        fondo = findViewById(R.id.fondo);

        SeekBar.OnSeekBarChangeListener changeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                red = redbar.getProgress();
                green = greenbar.getProgress();
                blue = bluebar.getProgress();
                alpha = alphabar.getProgress();

                String rgbShow = "Red: " + red + " / Green: " + green + " / Blue: " + blue + " / Alpha: " + alpha;

                valueText.setText(rgbShow);
                changeColor(red,green,blue,alpha);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        };

        //Assign listeners
        this.redbar.setOnSeekBarChangeListener(changeListener);
        this.greenbar.setOnSeekBarChangeListener(changeListener);
        this.bluebar.setOnSeekBarChangeListener(changeListener);
        this.alphabar.setOnSeekBarChangeListener(changeListener);

        red = redbar.getProgress();
        green = greenbar.getProgress();
        blue = bluebar.getProgress();
        alpha = alphabar.getProgress();

        String rgbShow = "Red: " + red + " / Green: " + green + " / Blue: " + blue + " / Alpha: " + alpha;

        valueText.setText(rgbShow);

        changeColor(red,green,blue,alpha);
    }


    private void changeColor(int red, int green, int blue, int alpha){
        fondo.setBackgroundColor(Color.argb(alpha,red,green,blue));
    }

}