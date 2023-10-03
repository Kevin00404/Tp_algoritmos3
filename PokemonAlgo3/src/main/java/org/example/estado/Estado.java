package org.example.estado;

import org.example.Ataque;
import org.example.Elemento.Element;
import org.example.habilidad.Habilidad;
import org.example.items.*;
import org.example.pokemon.Pokemon;

public abstract class Estado {
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
    public Estado revivir(Pokemon pokemon, Revivir itemDeRevivir){
        return this;
    }
    public Estado curar(Pocion curar, Pokemon pokemon) {
        pokemon.curarVida(curar);
        return this;
    }
    public Estado aumentarAtaque(Pokemon pokemon, PocionDeAtaque itemDeAtaque) {
        pokemon.aumentarAtaque(itemDeAtaque.getValor());
        return this;
    }
    public Estado aumentarDefensa(Pokemon pokemon, PocionDeDefensa itemDeDefensa) {
        pokemon.aumentarDefensa(itemDeDefensa.getValor());
        return this;
    }
    public Estado curarEstado(PocionDespertarDormido despertar){ return this; }
    public Estado curarEstado(PocionAntiVeneno antiVeneno) { return this; }
    public Estado curarEstado(PocionCurarParalisis curarParalisis){ return this; }
    public Estado curarEstado(CuraTotal curarCualquierEstado){
        return new EstadoNormal();
    }
}
