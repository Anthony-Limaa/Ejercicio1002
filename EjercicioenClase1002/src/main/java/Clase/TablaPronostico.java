package Clase;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class TablaPronostico {

    public void calculos(){
        double[] demanda = {133,292,283,203,400,505,608,667,783,785,799};
        double[] periodo =  {1,2,3,4,5,6,7,8,9,10,11,12};
        double pronostico = calcularPronostico(demanda, periodo, 10);

        //Creamos un Stream del Arreglo
        DoubleStream StreamPeriodo = DoubleStream.of(periodo);
        //Iterar en cada elemento
        StreamPeriodo.forEach((mes) -> {
            System.out.println("mes="+mes+" Pronostico:"+Math.round(calcularPronostico(demanda, periodo, mes)));
        });



    }

    private double calcularPronostico (double[] y, double[] x, double valorX){
        double n = y.length;
        double sumXY = 0;
        double sumX = Arrays.stream(x).sum();
        double sumY = Arrays.stream(y).sum();
        double sumX2 = Arrays.stream(x).map(xi -> xi*xi).sum();

        for (int i = 0; i< n; i++){
            sumXY += x[i]*y[i];
        }

        double a = (n*sumXY - sumX * sumY) / (n*sumX2 - sumX*sumX);
        double b = (sumY - a*sumX) / n;
        return a*valorX + b;
    }
}
