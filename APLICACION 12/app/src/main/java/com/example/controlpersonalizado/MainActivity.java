package com.example.controlpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*SelectColor sc=findViewById(R.id.selectorColor);
        sc.setOnColorListener(new OnSelectedColorListener() {
            @Override
            public void onSelectedColor(int color) {
                Toast.makeText(getApplicationContext(), "Color:"+color, Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}