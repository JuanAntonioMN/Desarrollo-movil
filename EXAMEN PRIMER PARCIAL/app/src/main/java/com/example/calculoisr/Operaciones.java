package com.example.calculoisr;
import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
public class Operaciones extends AppCompatActivity {
    RadioGroup group;//variable para el radiogrup
    RadioButton opcion1,opcion2,opcion3,opcion4,opcion5;//variables para los radiobutton
    EditText numero; //Variable para el editText
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operaciones);


           numero=findViewById(R.id.editText); //Obtenemos el id del editText

           String texto=numero.getText().toString().trim();//Casteamos el EditText a texto y obtener su contenido

          /*En esta seccion compara por medio de la propiedad isEmpty si el usuario introdujo informacion o no,
          en caso de que no seteamos el EditText con valores numericos  ya que solo procesamos numeros y no texto*/
           if(texto.isEmpty()){
               numero.setText("00.00");
           }
           //Hacemos el llamado a todas las propiedades  tanto del grupo como de los botones
           group=findViewById(R.id.radioGroup);
           opcion1=findViewById(R.id.radioButton1);
           opcion2=findViewById(R.id.radioButton2);
           opcion3=findViewById(R.id.radioButton3);
           opcion4=findViewById(R.id.radioButton4);
           opcion5=findViewById(R.id.radioButton5);
           group.clearCheck();//Limpiamos los check para que aparescan sin seleccionar

        //Creamos eventos para uno y cada uno de nuestros radioButton
           opcion1.setOnClickListener(evento);
           opcion2.setOnClickListener(evento);
           opcion3.setOnClickListener(evento);
           opcion4.setOnClickListener(evento);
           opcion5.setOnClickListener(evento);


    }

    //Creamos la funcion OnClickListener para trabajar sobre el los eventos a realizar
    private View.OnClickListener evento= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Resultados objeto=new Resultados(); //Cree una variable de la clase Resultados con la cual trabajaremos
            List<String>  resultado; //Tambien tenemos una varaible de tipo List string para obtener la informacion

            //Seteamos el valor de Ingreso para trabajar con el dentro de la clase resultado
            objeto.setIngreso(Float.parseFloat(numero.getText().toString()));
            //Se realizo la creacion de las opciones y cada una de sus operaciones a realizar
            if(view==opcion1){
                objeto.Calculo_diario(); //Se manda a llamar el metodo de calculo diario
            }
            if(view==opcion2){
                objeto.Calculo_semanal(); //Se manda a llamar el metodo de calculo semanal
            }
            if(view==opcion3){
                objeto.Calculo_decenal(); //Se manda a llamar el metodo de calculo decenal
            }
            if(view==opcion4){
                objeto.Calculo_quincenal(); //Se manda a llamar el metodo de calculo quincenal
            }
            if(view==opcion5){
                objeto.Calculo_mensual(); //Se manda a llamar el metodo de calculo mensual
            }

            resultado=objeto.informacion();//Obtenemos los resultados de las operaciones de acuerdo a su seleccion

            /* creamos la variable Intent fuera de los if para no repetir codigo innecesario.
            Pasamos el nombre la siguiente vista la cual es Vista.class*/
            Intent intent = new Intent(Operaciones.this, Vista.class);

            /*Utilizamos una propiedad de Intent el cual nos funciona para pasar el ArrayList de string que obtenemos
            del metodo infromacion y se lo pasamos a la siguiente vista para que pueda trabajar con ella esto se hace,
            para no perder la informacion generada. Esta utiliza una clave con la cual identificara los datos.
            */
            intent.putStringArrayListExtra("clave_resultado", (ArrayList<String>) resultado);
            startActivity(intent);
        }
    };


}
