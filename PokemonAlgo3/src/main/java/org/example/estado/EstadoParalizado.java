package org.example.estado;

import org.example.Ataque;
import org.example.Elemento.Element;
import org.example.habilidad.Habilidad;
import org.example.pokemon.Pokemon;

public class EstadoParalizado extends Estado{
    public EstadoParalizado(){

    }
    @Override
    public Estado atacar(Pokemon pokemon /*pokemon a atacar*/, Habilidad habilidad /*habilidad seleccionada por el usuario*/, Element element /*elemento del pokemon que está atacando*/, Ataque ataque_a_realizar){

        if (Math.random() < 0.5) {
            System.out.println("El Pokémon está PARALIZADO y no pudo realizar la habilidad.");
        } else {
            habilidad.atacar(pokemon, element, ataque_a_realizar);
            System.out.println("El Pokémon ya NO está PARALIZADO lanza la habilidad.");
            return new EstadoNormal();
        }
        return this;
    }
}
