package org.example.comando;

import org.example.jugada.CalculadoraDanio;
import org.example.pokemon.Pokemon;

public class HacerDanioComando extends Comando{
    private Pokemon pokemonReceptor;
    private CalculadoraDanio calcDanio;
    public HacerDanioComando(Pokemon pokemonReceptor, CalculadoraDanio calcDanio) {
        this.pokemonReceptor = pokemonReceptor;
        this.calcDanio = calcDanio;
    }

    @Override
    protected void ejecutarEsteComando() {
        pokemonReceptor.recibirDanio(calcDanio.calcularDanio());
    }
}
