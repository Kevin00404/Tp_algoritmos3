package org.example.estado;

import org.example.Ataque;
import org.example.Elemento.Element;
import org.example.EstadoPokemon;
import org.example.habilidad.Habilidad;
import org.example.pokemon.Pokemon;

import java.util.Random;

public class EstadoDormido extends Estado{
    public Integer contadorTurnosPerdidos;
    private Integer turnosDormido;

    public EstadoDormido() {
        contadorTurnosPerdidos = 0;
        turnosDormido = 0;
    }
    @Override
    public Estado pasivo(Pokemon pokemon){
        return this.puedeDespertarse();
    }

    public Estado puedeDespertarse(){
        contadorTurnosPerdidos ++;
        double probabilidadDespertar = 0.25 + contadorTurnosPerdidos * 0.25;
        Random random = new Random();
        if (random.nextDouble() < probabilidadDespertar) {
            return new EstadoNormal();
        }
        else{
            this.turnosDormido ++;
            if(this.turnosDormido == 4){
                return new EstadoNormal();
            }
        }
        return this;

    }
}
