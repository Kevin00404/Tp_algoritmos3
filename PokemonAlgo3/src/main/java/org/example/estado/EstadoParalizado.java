package org.example.estado;

import org.example.Ataque;
import org.example.Elemento.Element;
import org.example.habilidad.Habilidad;
import org.example.items.*;
import org.example.pokemon.Pokemon;

public class EstadoParalizado extends Estado{
    public EstadoParalizado(){
        this.nombre = "Paralizado";
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

    @Override
    public Estado curarEstado(PocionCurarParalisis curarParalisis) {
        return new EstadoNormal();
    }
    @Override
    public Estado curarEstado(PocionDespertarDormido despertar) {
        return super.curarEstado(despertar);
    }
    @Override
    public Estado curarEstado(PocionAntiVeneno antiVeneno) {
        return super.curarEstado(antiVeneno);
    }

    @Override
    public Estado curarEstado(CuraTotal curarCualquierEstado) {
        return super.curarEstado(curarCualquierEstado);
    }

    @Override
    public Estado curar(Pocion curar, Pokemon pokemon) {
        return super.curar(curar, pokemon);
    }
    @Override
    public Estado revivir(Pokemon pokemon, Revivir itemDeRevivir) {
        return super.revivir(pokemon, itemDeRevivir);
    }

    @Override
    public Estado aumentarDefensa(Pokemon pokemon, PocionDeDefensa itemDeDefensa) {
        return super.aumentarDefensa(pokemon, itemDeDefensa);
    }

    @Override
    public Estado aumentarAtaque(Pokemon pokemon, PocionDeAtaque itemDeAtaque) {
        return super.aumentarAtaque(pokemon, itemDeAtaque);
    }

    @Override
    public boolean esNormal() {
        return super.esNormal();
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }
}
