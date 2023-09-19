package org.example.estado;

import org.example.Elemento.Element;
import org.example.habilidad.Habilidad;
import org.example.habilidad.HabilidadAtaque;
import org.example.pokemon.Pokemon;

public class Estado {
    public Estado(){

    }

    public void atacar(Pokemon pokemon /*pokemon a atacar*/, Habilidad habilidad /*habilidad seleccionada por el usuario*/, Element element /*elemento del pokemon que está atacando*/){
        habilidad.atacar(pokemon, element);
    }
}
