package com.example.calculoisr;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Obtenemos el id del boton
        Button boton=findViewById(R.id.button2);
        //Creamos un evento
        boton.setOnClickListener(evento);
    }

    //La funcion del evento
   private View.OnClickListener evento = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            /* En el momento que el usuario le click al boton
            lo mandara a la siguiente actividad Operaciones.class con ayuda del Intent*/
            Intent intent = new Intent(MainActivity.this, Operaciones.class);
            startActivity(intent);
        }
    };
}