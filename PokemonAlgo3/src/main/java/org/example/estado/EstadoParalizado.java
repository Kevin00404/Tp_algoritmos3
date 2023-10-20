package org.example.estado;

import org.example.comando.Comando;
import org.example.comando.ComandoMensaje.ComandoMensajePokemonParalizadoConHabilidad;
import org.example.comando.ComandoMensaje.ComandoMensajePokemonParalizadoSinHabilidad;
import org.example.items.*;
import org.example.pokemon.Pokemon;

public class EstadoParalizado extends Estado{
    public EstadoParalizado(){
        this.nombre = "Paralizado";
    }
    @Override
    public Comando condicionarComando(Comando comando){
        if (Math.random() < 0.5) {
            return new ComandoMensajePokemonParalizadoSinHabilidad();
        } else {
            Comando nuevoComando = new ComandoMensajePokemonParalizadoConHabilidad();
            nuevoComando.setNextComando(comando);
            return comando;
        }
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
