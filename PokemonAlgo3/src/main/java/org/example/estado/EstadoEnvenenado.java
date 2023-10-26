package org.example.estado;

import org.example.items.*;
import org.example.pokemon.Pokemon;

public class EstadoEnvenenado extends Estado {
    public EstadoEnvenenado(){
        this.nombre = "Envenenado";
    }
    @Override
    public Estado pasivo(Pokemon pokemon) {
        pokemon.envenenar();
        return this;
    }
    @Override
    public Estado curarEstado(EstadoEnvenenado estadoACurar){
        return new EstadoNormal();
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