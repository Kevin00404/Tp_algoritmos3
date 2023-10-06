package org.example.habilidad;

import org.example.Ataque;
import org.example.Elemento.Element;
import org.example.EstadoPokemon;
import org.example.Juego;
import org.example.estado.Estado;
import org.example.estado.EstadoNormal;
import org.example.pokemon.Pokemon;

public class HabilidadModificacionEstado extends Habilidad {
    private Estado asignarEstado;

    public HabilidadModificacionEstado(String nombre, Integer cantidadDisponible, Estado asignarEstado) {
        super(nombre + " (modifica estado a " + asignarEstado.getNombre() +")", cantidadDisponible, "Estado");
        this.asignarEstado = asignarEstado;
    }


    public void atacar(Pokemon pokemon, Element element, Ataque ataque_a_realizar) {
        this.consumirUso();
        System.out.println("se ha elegido la habilidad: " + this.nombre);
        ataque_a_realizar.setEstado(this.asignarEstado);
        pokemon.modificarEstado(ataque_a_realizar);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }
}