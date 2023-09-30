package org.example.estado;

import org.example.Ataque;
import org.example.Elemento.Element;
import org.example.EstadoPokemon;
import org.example.habilidad.Habilidad;
import org.example.pokemon.Pokemon;
import org.example.habilidad.HabilidadAtaque;

import java.util.Random;

public class Estado {
    public Estado atacar(Pokemon pokemon /*pokemon a atacar*/, Habilidad habilidad /*habilidad seleccionada por el usuario*/, Element element /*elemento del pokemon que está atacando*/, Ataque ataque_a_realizar)
    {
        habilidad.atacar(pokemon, element, ataque_a_realizar);
        return this;
    }
    public Estado pasivo(Pokemon pokemon) {
        return this;
    }
    public Estado setEstadoActual(Estado estado){
        return this;
    }
}
