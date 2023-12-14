package com.example.paletadecolores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private SeekBar seekBar;
   private  ColorLienzo colorLienzo;
   private Button copiarrgb,copiarhex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paleta_colores);

        colorLienzo = findViewById(R.id.lienzoCanvas);
        seekBar = findViewById(R.id.seekBar);
        copiarrgb=findViewById(R.id.copiarrgb);
        copiarhex=findViewById(R.id.copiarhex);

        int color=colorLienzo.getColor();
        updateViews(color);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int color =calculateColorFromProgress(progress);
                updateViews(color);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        copiarrgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto del mismo boton
                String textToCopy = copiarrgb.getText().toString();

                // Copiar el texto al Portapapeles
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("RGB", textToCopy);
                clipboard.setPrimaryClip(clip);

                // Notificar al usuario que el texto se ha copiado
                Toast.makeText(getApplicationContext(), "Color copiado", Toast.LENGTH_SHORT).show();
            }
        });
        copiarhex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto del TextView
                String textToCopy = copiarhex.getText().toString();

                // Copiar el texto al Portapapeles
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("HEXADECIMAL", textToCopy);
                clipboard.setPrimaryClip(clip);

                // Notificar al usuario que el texto se ha copiado
                Toast.makeText(getApplicationContext(), "Color copiado", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private int calculateColorFromProgress(int progress) {
        int max = seekBar.getMax();
        // Calcula los componentes de color rojo, verde y azul utilizando operaciones matemáticas
        int red = (int) (Math.sin(2.0 * Math.PI * progress / max) * 127 + 128);
        int green = (int) (Math.sin(2.0 * Math.PI * progress / max + 2.0 * Math.PI / 3) * 127 + 128);
        int blue = (int) (Math.sin(2.0 * Math.PI * progress / max + 4.0 * Math.PI / 3) * 127 + 128);

        return Color.rgb(red, green, blue);
    }

    private void updateViews(int color) {
       //Se pinta el lienzo del color
        colorLienzo.setColor(color);
        //Se pinta el seekbar del color de seleccion
        seekBar.getProgressDrawable().setColorFilter(color, PorterDuff.Mode.SRC_IN);
        seekBar.getThumb().setColorFilter(color, PorterDuff.Mode.SRC_IN);
        //Se pintan los botones igual del color del lienzo
        copiarrgb.setTextColor(color);
        copiarhex.setTextColor(color);

        //Se obtienen los valores rgb de la aplicacion
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);

        //Se transforman a cadenas para mostrar en pantalla

        String rgbText = "Color RGB: (" + red + ", " + green + ", " + blue+")";

        String hexText = "Color Hexadecimal: #" + Integer.toHexString(color).toUpperCase();
        //Modificamos los textos de la aplicacion para mostrar los colores en pantalla
        copiarrgb.setText(rgbText);
        copiarhex.setText(hexText);
    }


}