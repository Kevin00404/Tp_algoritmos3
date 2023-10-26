package org.example;

import org.example.Elemento.Element;
import org.example.Estadisticas.Estadisticas;

import java.util.Random;

public class CalculadoraDanio {
    private Double poder;
    private Element elementoDeAtaque;
    private Estadisticas estadisticasPropias;
    private Estadisticas estadisticasEnemigas;

    public CalculadoraDanio(Estadisticas estadisticasPropias, Estadisticas estadisticasEnemigas, Double poderDeAtaque, Element elementoDeAtaque) {
        this.poder = poderDeAtaque;
        this.elementoDeAtaque = elementoDeAtaque;
        this.estadisticasPropias = estadisticasPropias;
        this.estadisticasEnemigas = estadisticasEnemigas;
    }

    private Double critico(){
        Random rand = new Random();
        int upperbound = 100;
        int random = rand.nextInt(upperbound);
        if(random >= 90){
            return 1.0;
        }
        return 2.0;
    }

    private int randomNum(){
        Random rand = new Random();
        int upperbound = 39;
        int random = rand.nextInt(upperbound);
        random += 217;
        return random/255;
    }

    public Double calcularDanio(){
        return (((2*estadisticasPropias.getNivel()*this.critico()*this.poder*(estadisticasPropias.getAtaque()/estadisticasEnemigas.getDefensa())/5)+2)/50) * estadisticasPropias.bufeoReaccionElemento(this.elementoDeAtaque) * estadisticasEnemigas.debufeoReaccionElemento(estadisticasPropias.getElemento()) * randomNum();
    }
}
