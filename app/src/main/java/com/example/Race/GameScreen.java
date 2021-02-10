package com.example.Race;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.example.cars.R;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_game_screen);
        ImageView MyCar = (ImageView) findViewById(R.id.Mycar);
        ImageView BotCar = (ImageView) findViewById(R.id.Botcar);
        ImageView finish = (ImageView) findViewById(R.id.finish);
        Button btn_drive = (Button) findViewById(R.id.btn_drive);
        Button btn_start = (Button) findViewById(R.id.btn_Start);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float translationX = BotCar.getTranslationX();
                float translationY = BotCar.getTranslationY();
                    TranslateAnimation animation = new TranslateAnimation(translationX, translationX+2600, translationY,translationX);
                    animation.setDuration(TimeUnit.SECONDS.toMillis(4L));
                    animation.setFillAfter(true);
                BotCar.startAnimation(animation);
            }
        });

        btn_drive.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                float translationX = MyCar.getTranslationX();
                float translationY = MyCar.getTranslationY();
                    TranslateAnimation animation = new TranslateAnimation(translationX, translationX+2600, translationY,translationX);
                    animation.setDuration(TimeUnit.SECONDS.toMillis(4L));
                    animation.setFillAfter(true);
                MyCar.startAnimation(animation);

                    return false;
            }
        });
    }
}