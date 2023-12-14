package com.example.fichafutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Button play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            mediaPlayer = MediaPlayer.create(this, R.raw.musicaprincipal);
            play=findViewById(R.id.play);



        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pausar o detener la música principal
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {

                     mediaPlayer.stop(); // O puedes usar mediaPlayer.stop() para detener la música por completo
                }

                // Iniciar la actividad "Futbolito"
                Intent intent = new Intent(MainActivity.this, Futbolito.class);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        mediaPlayer = MediaPlayer.create(this, R.raw.musicaprincipal2);
        mediaPlayer.start();
    }



}