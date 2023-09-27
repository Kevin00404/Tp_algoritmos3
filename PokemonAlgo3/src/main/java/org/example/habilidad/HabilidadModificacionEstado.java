package org.example.habilidad;

import org.example.Ataque;
import org.example.Elemento.Element;
import org.example.EstadoPokemon;
import org.example.Juego;
import org.example.estado.Estado;
import org.example.estado.EstadoNormal;
import org.example.pokemon.Pokemon;

public class HabilidadModificacionEstado extends Habilidad {
    private EstadoPokemon asignarEstado;

    public HabilidadModificacionEstado(Integer cantidadDisponible, EstadoPokemon asignarEstado) {
        super("modifica estado a " + asignarEstado, cantidadDisponible, "Estado");
        this.asignarEstado = asignarEstado;
    }


    public void atacar(Pokemon pokemon, Element element, Ataque ataque_a_realizar) {
        ataque_a_realizar.setEstado(this.asignarEstado);
        pokemon.modificarEstado(ataque_a_realizar);
    }
}