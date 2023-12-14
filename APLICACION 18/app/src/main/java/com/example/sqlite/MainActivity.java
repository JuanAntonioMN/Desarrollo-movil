package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView salida=findViewById(R.id.salida);
        DBSLite aSQLite=new DBSLite(this);
        aSQLite.guardaDatos("Juan", (new Date()).getTime());
        aSQLite.guardaDatos("Pedro",(new Date()).getTime());
        aSQLite.guardaDatos("Alberto",(new Date()).getTime());
        Vector<String>datos=aSQLite.listDatos();
        for (String str:datos){
            salida.append("\n"+str);
        }
    }
}