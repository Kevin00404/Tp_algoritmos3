package org.example.estado;

import org.example.items.*;
import org.example.pokemon.Pokemon;

public class EstadoNormal extends Estado{
    public EstadoNormal(){
        this.nombre = "Normal";
    }
    @Override
    public Estado setEstadoActual(Estado estado) {
        return estado;
    }
    @Override
    public Estado curarEstado(PocionCurarParalisis curarParalisis) {
        return super.curarEstado(curarParalisis);
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
        return this;
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
        return true;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }
}
