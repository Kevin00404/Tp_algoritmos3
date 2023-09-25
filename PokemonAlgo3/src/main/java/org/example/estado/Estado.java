package org.example.estado;

import org.example.Ataque;
import org.example.Elemento.Element;
import org.example.habilidad.Habilidad;
import org.example.pokemon.Pokemon;

import java.util.Random;

public class Estado {
    private estadoPokemon estadoActual;
    public Integer contadorTurnosPerdidos;
    private Integer turnosDormido;

    public enum estadoPokemon {
        NORMAL,
        PARALIZADO,
        ENVENENADO,
        DORMIDO
    }
    public Estado(){
        this.estadoActual = estadoPokemon.NORMAL;
        this.turnosDormido = 0;
        this.contadorTurnosPerdidos = 0;
    }
    public void atacar(Pokemon pokemon /*pokemon a atacar*/, Habilidad habilidad /*habilidad seleccionada por el usuario*/, Element element /*elemento del pokemon que está atacando*/, Ataque ataque_a_realizar){
        habilidad.atacar(pokemon, element, ataque_a_realizar);
    }
    public estadoPokemon verificarEstado(){
        return this.estadoActual;
    }
    public void cambiarEstadoParalizado(){
        this.estadoActual = estadoPokemon.NORMAL;
    }
    public void puedeDespertarse(Pokemon pokemon /*pokemon a atacar*/, Habilidad habilidad /*habilidad seleccionada por el usuario*/, Element element /*elemento del pokemon que está atacando*/){
        contadorTurnosPerdidos ++;
        double probabilidadDespertar = 0.25 + contadorTurnosPerdidos * 0.25;
        Random random = new Random();
        if (random.nextDouble() < probabilidadDespertar) {
            //System.out.println(nombre + " se ha despertado.");
            this.estadoActual = estadoPokemon.NORMAL;
            this.turnosDormido = 0;
            //this.atacar(Pokemon pokemon /*pokemon a atacar*/, Habilidad habilidad /*habilidad seleccionada por el usuario*/, Element element /*elemento del pokemon que está atacando*/);
        }
        else{
            this.turnosDormido ++;
            if(this.turnosDormido == 4){
                this.estadoActual = estadoPokemon.NORMAL;
                //this.atacar(Pokemon pokemon /*pokemon a atacar*/, Habilidad habilidad /*habilidad seleccionada por el usuario*/, Element element /*elemento del pokemon que está atacando*/);
            }
            //System.out.println(nombre + " está dormido, no puede atacar.");
        }
    }
    /*private estadoPokemon verificarEstado() {
        return estadoActual;
    }*/
}
