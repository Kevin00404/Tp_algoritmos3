package org.example.estado;

import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.items.*;
import org.example.pokemon.Pokemon;

public class EstadoParalizado extends Estado{
    public EstadoParalizado(){
        this.nombre = "Paralizado";
    }
    @Override
    public Comando condicionarComando(Comando comando){
        if (Math.random() < 0.5) {
            return new ComandoMensaje("El Pokémon está PARALIZADO y no pudo realizar la habilidad.");
        } else {
            Comando nuevoComando = new ComandoMensaje("El Pokémon esta Paralizado pero puedo lanzar la habilidad.");
            nuevoComando.concatComands(comando);
            return nuevoComando;
        }
    }

    @Override
    public Estado curarEstado(EstadoParalizado estadoACurar) {
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
