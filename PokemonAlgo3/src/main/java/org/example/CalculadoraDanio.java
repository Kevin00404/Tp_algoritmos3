package org.example;

import org.example.Clima.ManejoDeClima;
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

    public Double critico(){
        Random rand = new Random();
        int upperbound = 100;
        int random = rand.nextInt(upperbound);
        if(random >= 90){
            return 1.0;
        }
        return 2.0;
    }

    public Double randomNum(){
        Random rand = new Random();
        Double upperbound = 39.0;
        Double random = rand.nextDouble(upperbound);
        random += 217;
        return random/255;
    }

    public Double calcularDanio(){
        Double critico = this.critico();
        Double random = randomNum();
        Double danioHipotetico = (((2*estadisticasPropias.getNivel()*critico*this.poder*(estadisticasPropias.getAtaque()/estadisticasEnemigas.getDefensa())/5)+2)/50) * estadisticasPropias.bufeoReaccionElemento(this.elementoDeAtaque) * estadisticasEnemigas.debufeoReaccionElemento(estadisticasPropias.getElemento()) * random;
        return ManejoDeClima.getTerreno().ventajaDelTerreno(danioHipotetico, estadisticasPropias);
    }
}
