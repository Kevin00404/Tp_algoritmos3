package org.example.estado;

import org.example.Ataque;
import org.example.Elemento.Element;
import org.example.EstadoPokemon;
import org.example.habilidad.Habilidad;
import org.example.pokemon.Pokemon;
import org.example.habilidad.HabilidadAtaque;

import java.util.Random;

public class Estado {
    public EstadoPokemon estadoActual;
    public Integer contadorTurnosPerdidos;
    private Integer turnosDormido;

    public Estado(){
        this.estadoActual = EstadoPokemon.NORMAL;
        this.turnosDormido = 0;
        this.contadorTurnosPerdidos = 0;
    }

    public void setEstado(EstadoPokemon estado){
        this.estadoActual=estado;
    }


    public EstadoPokemon getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoPokemon estadoActual) {
        this.estadoActual = estadoActual;
    }

    public void atacar(Pokemon pokemon /*pokemon a atacar*/, Habilidad habilidad /*habilidad seleccionada por el usuario*/, Element element /*elemento del pokemon que está atacando*/, Ataque ataque_a_realizar){
        habilidad.atacar(pokemon, element, ataque_a_realizar);
    }
    public EstadoPokemon verificarEstado(){
        return this.estadoActual;
    }
    public void cambiarEstadoParalizado(){
        this.estadoActual = EstadoPokemon.NORMAL;
    }
    public void puedeDespertarse(Pokemon pokemon /*pokemon a atacar*/, Habilidad habilidad /*habilidad seleccionada por el usuario*/, Element element /*elemento del pokemon que está atacando*/){
        contadorTurnosPerdidos ++;
        double probabilidadDespertar = 0.25 + contadorTurnosPerdidos * 0.25;
        Random random = new Random();
        if (random.nextDouble() < probabilidadDespertar) {
            //System.out.println(nombre + " se ha despertado.");
            this.estadoActual = EstadoPokemon.NORMAL;
            this.turnosDormido = 0;
            //this.atacar(Pokemon pokemon /*pokemon a atacar*/, Habilidad habilidad /*habilidad seleccionada por el usuario*/, Element element /*elemento del pokemon que está atacando*/);
        }
        else{
            this.turnosDormido ++;
            if(this.turnosDormido == 4){
                this.estadoActual = EstadoPokemon.NORMAL;
                //this.atacar(Pokemon pokemon /*pokemon a atacar*/, Habilidad habilidad /*habilidad seleccionada por el usuario*/, Element element /*elemento del pokemon que está atacando*/);
            }
            //System.out.println(nombre + " está dormido, no puede atacar.");
        }
    }


    /*private estadoPokemon verificarEstado() {
        return estadoActual;
    }*/
}
