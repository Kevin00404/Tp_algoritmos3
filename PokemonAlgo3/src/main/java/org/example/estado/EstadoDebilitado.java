package org.example.estado;

import org.example.items.*;
import org.example.pokemon.Pokemon;

public class EstadoDebilitado extends Estado{
    @Override
    public Estado revivir(Pokemon pokemon, Revivir itemDeRevivir) {
        pokemon.setVida(itemDeRevivir.getValor());
        return new EstadoNormal();
    }
    @Override
    public Estado curar(Pocion curar, Pokemon pokemon) {
        return this;
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
    public Estado curarEstado(PocionCurarParalisis curarParalisis) {
        return super.curarEstado(curarParalisis);
    }
    @Override
    public Estado curarEstado(CuraTotal curarCualquierEstado) {
        return this;
    }
    @Override
    public Estado aumentarAtaque(Pokemon pokemon, PocionDeAtaque itemDeAtaque) {
        return this;
    }
    @Override
    public Estado aumentarDefensa(Pokemon pokemon, PocionDeDefensa itemDeDefensa) {
        return this;
    }
}
