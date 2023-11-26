package org.example.habilidad;

import org.example.Log.Log;
import org.example.comando.Comando;
import org.example.comando.HacerDanioComando;
import org.example.CalculadoraDanio;
import org.example.Elemento.Element;
import org.example.Estadisticas.Estadisticas;
import org.example.pokemon.Pokemon;

public class HabilidadAtaque extends Habilidad{
    private Element elemento;

    private Double poder_de_ataque;

    public HabilidadAtaque(String nombre, Integer cantidadDisponible, Element elemento /*del pokemon que está atacando*/, Double poder_de_ataque) {
        super(nombre + " (Habilidad de Ataque)",cantidadDisponible,"Ataque");//se repite en las otras dos habilidades.
        this.elemento = elemento;
        this.poder_de_ataque = poder_de_ataque;
    }
    @Override
    public Comando armarComando(Pokemon pokemon, Estadisticas estadisticas){
        this.consumirUso();
        CalculadoraDanio calcDanio = armarDanio(pokemon, estadisticas);
        return new HacerDanioComando(pokemon, calcDanio);
    }

    public CalculadoraDanio armarDanio(Pokemon pokemon, Estadisticas estadisticas){
        return new CalculadoraDanio(estadisticas, pokemon.getEstadisticas(), this.poder_de_ataque, this.elemento);
    }

}
