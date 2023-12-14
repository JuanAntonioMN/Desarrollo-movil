package com.example.calculoisr;
import java.util.List;
import java.util.ArrayList;
public class Resultados {
    //Creamos la variables que utilizaremos para el programa
    private float ingreso;
    private float limite_inferior;
    private float diferencia;
    private float tasa;
    private float impuesto_marginal;
    private float cuota_fija;
    private float impuesto_retener;
    private float percepcion_impuestos;

    //Creamos un constructor y los inicializamos en ceros para tener las variables listas para utilizar
    public Resultados(){
        this.ingreso=0;
        this.limite_inferior=0;
        this.diferencia=0;
        this.tasa=0;
        this.impuesto_marginal=0;
        this.cuota_fija=0;
        this.impuesto_retener=0;
        this.percepcion_impuestos=0;


    }
    //Solo cree el metodo set de la variable Ingresos para poder obtener su valor de la vista Operaciones
    public void setIngreso(float ingreso) {
        this.ingreso = ingreso;
    }

    //Creamos los metodos de cada calculo de ISR

    //Metodo del calculo de ISR diario
    public void Calculo_diario(){
        //Tenemos condicionales para cada uno de los rangos de ingresos el cual se puede encontrar en la tabla de ingresos

        if(ingreso>=0.01 && ingreso <=24.54){
            //A cada variable se le asigna su valor para poder trabajar con el mas adelante
            limite_inferior=(float)(0.01); //Se castea a float para no tener errores
            diferencia=ingreso-limite_inferior; //se resta el ingreso menos el limite inferior y obtner la diferencia
            tasa=(float)1.92;//Se le asigna su tasa de acuerdo a la tabla
            impuesto_marginal=(diferencia*(tasa/100));//Se hace la multiplicacion de la tasa por la diferencia
            cuota_fija=0;//su caso fijo es asignado
            impuesto_retener=impuesto_marginal+cuota_fija;//Se hace la suma para obtener el ISR
            percepcion_impuestos=ingreso-impuesto_retener;/*Por ultimo restamos el ingreso menos el ISR para obtener
            el valor final que le queda al usuario*/
        }

        if(ingreso>=24.55 && ingreso<=208.29){
            limite_inferior=(float) (24.55);
            diferencia=ingreso-limite_inferior;
            tasa=(float)6.4;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)0.47;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }

        if(ingreso>=208.30 && ingreso<=366.05){
            limite_inferior=(float) (208.30);
            diferencia=ingreso-limite_inferior;
            tasa=(float)10.88;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float) 12.23;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }

        if(ingreso>=366.06 && ingreso<=425.52){
            limite_inferior=(float) (366.06);
            diferencia=ingreso-limite_inferior;
            tasa=16;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float) 29.40;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }

        if(ingreso>=425.53 && ingreso<=509.46){
            limite_inferior=(float) (425.53);
            diferencia=ingreso-limite_inferior;
            tasa=(float)17.92;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)38.91;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }

        if(ingreso>=509.47 && ingreso<=1027.52){
            limite_inferior=(float) (509.47);
            diferencia=ingreso-limite_inferior;
            tasa=(float)21.36;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)53.95;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }

        if(ingreso>=1027.53 && ingreso<=1619.51){
            limite_inferior=(float) (1027.53);
            diferencia=ingreso-limite_inferior;
            tasa=(float)23.52;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)164.61;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }

        if(ingreso>=1619.52 && ingreso<=3091.90){
            limite_inferior=(float) (1619.52);
            diferencia=ingreso-limite_inferior;
            tasa=30;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)303.85;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }

        if(ingreso>=3091.91 && ingreso<=4122.54){
            limite_inferior=(float) (3091.91);
            diferencia=ingreso-limite_inferior;
            tasa=32;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)745.56;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }

        if(ingreso>=4122.55 && ingreso<=12367.62){
            limite_inferior=(float) (4122.55);
            diferencia=ingreso-limite_inferior;
            tasa=34;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)1075.37;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }

        if(ingreso>=12367.63){
            limite_inferior=ingreso;
            diferencia=ingreso-limite_inferior;
            tasa=35;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)3878.69;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }

    }//cierre del metodo calculo diario

    //Metodo del calculo de ISR semanal
    public void Calculo_semanal( ){
        if(ingreso>=0.01 && ingreso <=171.78){
            limite_inferior=(float)(0.01);
            diferencia=ingreso-limite_inferior;
            tasa=(float)1.92;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=0;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=171.79 && ingreso<=1458.03){
            limite_inferior=(float) (171.79);
            diferencia=ingreso-limite_inferior;
            tasa=(float)6.4;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)3.29;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=1458.04 && ingreso<=2562.35){
            limite_inferior=(float) (1458.04);
            diferencia=ingreso-limite_inferior;
            tasa=(float)10.88;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float) 85.61;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=2562.36 && ingreso<=2978.64){
            limite_inferior=(float) (2562.36);
            diferencia=ingreso-limite_inferior;
            tasa=16;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float) 205.8;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=2978.65 && ingreso<=3566.22){
            limite_inferior=(float) (2978.65);
            diferencia=ingreso-limite_inferior;
            tasa=(float)17.92;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)272.37;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=3566.23 && ingreso<=7192.64){
            limite_inferior=(float) (3566.23);
            diferencia=ingreso-limite_inferior;
            tasa=(float)21.36;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)377.65;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=7192.65 && ingreso<=11336.57){
            limite_inferior=(float) (7192.65);
            diferencia=ingreso-limite_inferior;
            tasa=(float)23.52;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)1152.27;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=11336.58 && ingreso<=21643.30){
            limite_inferior=(float) (11336.58);
            diferencia=ingreso-limite_inferior;
            tasa=30;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)2126.95;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=21643.31 && ingreso<=28857.78){
            limite_inferior=(float) (21643.31);
            diferencia=ingreso-limite_inferior;
            tasa=32;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)5218.92;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=28857.79 && ingreso<=86573.34){
            limite_inferior=(float) (28857.79);
            diferencia=ingreso-limite_inferior;
            tasa=34;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)7527.59;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=86573.35){
            limite_inferior=ingreso;
            diferencia=ingreso-limite_inferior;
            tasa=35;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)58180.35;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
    }

    //Metodo del calculo de ISR decenal
    public void Calculo_decenal(){
        if(ingreso>=0.01 && ingreso <=245.40){
            limite_inferior=(float)(0.01);
            diferencia=ingreso-limite_inferior;
            tasa=(float)1.92;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=0;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=245.41 && ingreso<=2082.90){
            limite_inferior=(float) (245.41);
            diferencia=ingreso-limite_inferior;
            tasa=(float)6.4;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)4.70;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=2082.91 && ingreso<=3660.50){
            limite_inferior=(float) (2082.91);
            diferencia=ingreso-limite_inferior;
            tasa=(float)10.88;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float) 122.30;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=3660.51 && ingreso<=4255.20){
            limite_inferior=(float) (3660.51);
            diferencia=ingreso-limite_inferior;
            tasa=16;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float) 294.00;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=4255.21 && ingreso<=5094.60){
            limite_inferior=(float) (4255.21);
            diferencia=ingreso-limite_inferior;
            tasa=(float)17.92;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)389.10;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=5094.61 && ingreso<=10275.20){
            limite_inferior=(float) (5094.61);
            diferencia=ingreso-limite_inferior;
            tasa=(float)21.36;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)539.50;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=10275.21 && ingreso<=16195.10){
            limite_inferior=(float) (10275.21);
            diferencia=ingreso-limite_inferior;
            tasa=(float)23.52;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)1646.10;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=16195.11 && ingreso<=30919.00){
            limite_inferior=(float) (16195.11);
            diferencia=ingreso-limite_inferior;
            tasa=30;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)3038.50;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=30919.01 && ingreso<=41225.40){
            limite_inferior=(float) (30919.01);
            diferencia=ingreso-limite_inferior;
            tasa=32;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)7455.60;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=41225.41 && ingreso<=123676.20){
            limite_inferior=(float) (41225.41);
            diferencia=ingreso-limite_inferior;
            tasa=34;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)10753.70;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=123676.21){
            limite_inferior=ingreso;
            diferencia=ingreso-limite_inferior;
            tasa=35;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)58180.35;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
    }
    //Metodo del calculo de ISR quincenal
    public  void Calculo_quincenal( ){

        if(ingreso>=0.01 && ingreso <=368.1){
            limite_inferior=(float)(0.01);
            diferencia=ingreso-limite_inferior;
            tasa=(float)1.92;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=0;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=368.11 && ingreso<=3124.35){
            limite_inferior=(float) (368.11);
            diferencia=ingreso-limite_inferior;
            tasa=(float)6.4;
            impuesto_marginal=(float)(diferencia*(tasa/100));
            cuota_fija=(float)7.05;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=3124.36 && ingreso<=5490.75){
            limite_inferior=(float) (3124.36);
            diferencia=ingreso-limite_inferior;
            tasa=(float)10.88;
            impuesto_marginal=(float)(diferencia*(tasa/100));
            cuota_fija=(float) 183.45;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=5490.76 && ingreso<=6382.80){
            limite_inferior=(float) (5490.76);
            diferencia=ingreso-limite_inferior;
            tasa=16;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float) 441;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=6382.81 && ingreso<=7641.90){
            limite_inferior=(float) (6382.81);
            diferencia=ingreso-limite_inferior;
            tasa=(float)17.92;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)583.65;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=7641.91 && ingreso<=5412.80){
            limite_inferior=(float) (7641.91);
            diferencia=ingreso-limite_inferior;
            tasa=(float)21.36;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)809.25;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=15412.81 && ingreso<=24292.65){
            limite_inferior=(float) (15412.81);
            diferencia=ingreso-limite_inferior;
            tasa=(float)23.52;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)2469.15;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=24292.66 && ingreso<=46378.50){
            limite_inferior=(float) (24292.66);
            diferencia=ingreso-limite_inferior;
            tasa=30;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)4557.75;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=46378.51 && ingreso<=61838.10){
            limite_inferior=(float) (46378.51);
            diferencia=ingreso-limite_inferior;
            tasa=32;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)11183.40;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=61838.11 && ingreso<=185514.30){
            limite_inferior=(float) (61838.11);
            diferencia=ingreso-limite_inferior;
            tasa=34;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)16130.55;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=185514.31){
            limite_inferior=ingreso;
            diferencia=ingreso-limite_inferior;
            tasa=35;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)58180.35;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
    }

    //Metodo del calculo de ISR mensual
    public void Calculo_mensual( ){
        if(ingreso>=0.01 && ingreso <=746.04){
            limite_inferior = (float) 0.01;
            diferencia = ingreso - limite_inferior;
            tasa = (float) 1.92;
            impuesto_marginal =  (diferencia * (tasa / 100));
            cuota_fija = 0;
            impuesto_retener = impuesto_marginal + cuota_fija;
            percepcion_impuestos = ingreso - impuesto_retener;
        }
        if(ingreso>=746.05 && ingreso<=6332.05){
            limite_inferior=(float) (746.05);
            diferencia=ingreso-limite_inferior;
            tasa=(float)6.4;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)14.32;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=6332.06 && ingreso<=11128.01){
            limite_inferior=(float) (6332.06);
            diferencia=ingreso-limite_inferior;
            tasa=(float)10.88;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float) 371.83;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=11128.02 && ingreso<=12935.82){
            limite_inferior=(float) (11128.02);
            diferencia=ingreso-limite_inferior;
            tasa=16;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float) 893.63;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=12935.83 && ingreso<=15487.71){
            limite_inferior=(float) (12935.83);
            diferencia=ingreso-limite_inferior;
            tasa=(float)17.92;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)1182.88;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=15487.72 && ingreso<=31236.49){
            limite_inferior=(float) (15487.72);
            diferencia=ingreso-limite_inferior;
            tasa=(float)21.36;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)1640.18;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=31236.5 && ingreso<=49233){
            limite_inferior=(float) (31236.5);
            diferencia=ingreso-limite_inferior;
            tasa=(float)23.52;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)5004.12;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=49233.01 && ingreso<=93993.9){
            limite_inferior=(float) (49233.01);
            diferencia=ingreso-limite_inferior;
            tasa=30;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)9236.89;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=93993.91 && ingreso<=125325.2){
            limite_inferior=(float) (93993.91);
            diferencia=ingreso-limite_inferior;
            tasa=32;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)22665.17;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=125325.21 && ingreso<=375975.61){
            limite_inferior=(float) (125325.21);
            diferencia=ingreso-limite_inferior;
            tasa=34;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)32691.18;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }
        if(ingreso>=375975.62){
            limite_inferior=ingreso;
            diferencia=ingreso-limite_inferior;
            tasa=35;
            impuesto_marginal=(diferencia*(tasa/100));
            cuota_fija=(float)117912.32;
            impuesto_retener=impuesto_marginal+cuota_fija;
            percepcion_impuestos=ingreso-impuesto_retener;
        }


    }


    //El metodo que manda la informacion calculada por medio de un Li
    public List<String>  informacion(){
        List<String> resultados = new ArrayList<>();//Creamos una variable la cual contendra la informacion de las variables
        //Pasamos la informacion a manera de string por eso tenemos varios add para cada variable
        resultados.add("Ingreso: $" + ingreso);
        resultados.add("Límite Inferior: $" + limite_inferior);
        resultados.add("Diferencia: $" + diferencia);
        resultados.add("Tasa: " + tasa+" %");
        resultados.add("Impuesto Marginal: $" + impuesto_marginal);
        resultados.add("Cuota Fija: $" + cuota_fija);
        resultados.add("Impuesto a Retener: $" + impuesto_retener);
        resultados.add("Percepción menos Impuestos: $" + percepcion_impuestos);

        return resultados;//Por ultimo retornamos el resultado
    }



}
