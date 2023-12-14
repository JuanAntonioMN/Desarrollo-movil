package com.example.control_personalizado;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class buscarControl extends LinearLayout {

    TextView informacion;
    Button buscar;
    EditText busqueda;

    public buscarControl(Context context){
        super(context);
        inicializar();

    }
    public buscarControl(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
        inicializar();
    }

    public void inicializar(){
        LayoutInflater li=LayoutInflater.from(getContext());
        li.inflate(R.layout.navegador,this,true);
        informacion = findViewById(R.id.Informacion);
        buscar = findViewById(R.id.Buscar);
        busqueda = findViewById(R.id.Busqueda);

        eventos();
    }

    public void eventos(){
        buscar.setOnClickListener(evento);
    }

    private View.OnClickListener evento= new View.OnClickListener(){
        @Override
        public void onClick(View view){
            int posicion=0;
            boolean bandera=false;

            String []estados={"Aguascalientes","Oaxaca","Puebla","Sinaloa","Jalisco","Colima"};
            String []descripcion={"Conocido por su Feria Nacional de San Marcos, una de las fiestas más grandes y antiguas de México.",
                    "Famoso por su rica tradición culinaria, que incluye el delicioso mole negro y una gran variedad de mezcales artesanales.",
                    "Conocido por su hermosa arquitectura colonial y la espectacular iglesia de Cholula, que es la más grande del mundo por volumen.",
                    "Famoso por su música de banda, playas espectaculares en Mazatlán y una rica tradición culinaria que incluye el ceviche de camarón.",
                    "Cuna del mariachi y el tequila, Jalisco es famoso por su música tradicional, la Feria de Guadalajara y la belleza natural de la Sierra Madre Occidental.",
                    "El estado más pequeño de México, conocido por su belleza natural, incluyendo el volcán de Colima y playas tranquilas en la costa del Pacífico."};

            if(view==buscar){
                for(int i=0;i<estados.length;i++){
                    if(estados[i].equalsIgnoreCase(busqueda.getText().toString())){
                        posicion=i;
                        bandera=true;
                        break;
                    }
                }
                if(bandera==true){

                    informacion.setText(estados[posicion]+"\n"+descripcion[posicion]);
                }
                else{
                    informacion.setText("El estado no existe");
                }
            }
        }
    };

}
