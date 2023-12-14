package com.example.controlespersonalizadoscombinandovarioscontroles;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FechaControl extends LinearLayout {
    TextView txtDia,txtMes,txtAnio;
    Button btnAtras,btnSiguiente;
    OnDateChangeListener listener=null;

    public  void SetOnDateChangeListener(OnDateChangeListener l){
        listener=l;
    }
    public FechaControl(Context context){
        super(context);
        inicializar();
    }

    public FechaControl(Context context, AttributeSet attrs){
        super(context,attrs);
        inicializar();

        TypedArray a=getContext().obtainStyledAttributes(attrs,R.styleable.FechaControl);
        String dia=a.getString(R.styleable.FechaControl_dia_text);
        String mes=a.getString(R.styleable.FechaControl_mes_text);
        String anio=a.getString(R.styleable.FechaControl_anio_text);

        txtDia.setText("01");
        txtMes.setText("01");
        txtAnio.setText("1900");

        if(dia!=null){
            txtDia.setText(dia);
        }
        if(mes!=null){
            txtMes.setText(mes);
        }
        if(anio!=null){
            txtAnio.setText(anio);
        }
        a.recycle();

    }

    public void inicializar(){
        LayoutInflater li=LayoutInflater.from(getContext());
        li.inflate(R.layout.fecha_control,this,true);
        txtAnio=findViewById(R.id.txtAnio);
        txtMes=findViewById(R.id.txtMes);
        txtDia=findViewById(R.id.txtDia);

        btnAtras=findViewById(R.id.btnAtras);
        btnSiguiente=findViewById(R.id.btnSiguiente);

        asignarEventos();
    }
    public void SetFecha(int dia,int mes,int anio){
        txtDia.setText(dia+"");
        txtMes.setText(mes+"");
        txtAnio.setText(anio+"");
    }

    public void asignarEventos(){
        btnAtras.setOnClickListener(evento);
        btnSiguiente.setOnClickListener(evento);
    }

    private View.OnClickListener evento=new View.OnClickListener(){
        @Override
        public  void onClick( View v){
            int dia= new Integer(txtDia.getText().toString());
            int mes= new Integer(txtMes.getText().toString());
            int anio= new Integer(txtAnio.getText().toString());

            if (v == btnAtras) {
                if(dia==1){
                    switch (mes){
                        case 1: dia=31; mes=12;break;
                        case 2: dia=28; mes--;break;
                        case 3: dia=31; mes--;break;
                        case 4: dia=30; mes--;break;
                        case 5: dia=31; mes--;break;
                        case 6: dia=30; mes--;break;
                        case 7: dia=31; mes--;break;
                        case 8: dia=31; mes--;break;
                        case 9: dia=30; mes--;break;
                        case 10: dia=31; mes--;break;
                        case 11: dia=30; mes--;break;
                        case 12: dia=31; mes--;break;
                    }
                }
                else{
                    dia--;
                }
                if(dia==31 && mes==12){
                    anio--;
                }

            }
            if (v == btnSiguiente) {

                if(dia==28 && mes==2) {
                    dia = 1;
                    mes++;
                }

                else if(dia==30 && mes==4 || dia==30 && mes==6 || dia==30 && mes==9 || dia==30 && mes==11){
                    dia=1; mes++;
                }

                else if(dia==31 && mes==1 || dia==31 && mes==3 ||dia==31 && mes==5 ||dia==31 && mes==7 ||dia==31 && mes==7 ||dia==31 && mes==10){
                    dia=1; mes++;
                }
                else if (dia==31 && mes==12) {
                    dia=1; mes=1;
                }
                else{
                    dia++;
                }

                if(dia==1 && mes==1){
                    anio++;
                }

            }

            txtDia.setText(dia+"");
            txtMes.setText(mes+"");
            txtAnio.setText(anio+"");

            listener.onDateChange(txtDia.getText().toString(),txtMes.getText().toString(),txtAnio.getText().toString());
        }
    };


}
