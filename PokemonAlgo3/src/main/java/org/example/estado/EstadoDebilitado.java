package org.example.estado;

import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.items.*;
import org.example.pokemon.Pokemon;

public class EstadoDebilitado extends Estado{
    public EstadoDebilitado(){
        this.nombre = "Debilitado";
    }

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
    public Estado aumentarAtaque(Pokemon pokemon, PocionDeAtaque itemDeAtaque) {
        return this;
    }
    @Override
    public Estado aumentarDefensa(Pokemon pokemon, PocionDeDefensa itemDeDefensa) {
        return this;
    }

    @Override
    public boolean esDebilitado() {
        return true;
    }

    @Override
    public boolean esNormal() {
        return super.esNormal();
    }
    public Estado curarEstado(EstadoDebilitado estadoACurar) {
        return new EstadoNormal();
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    public Comando condicionarComando(Comando comando){
        return new ComandoMensaje("Este pokemon esta debilitado");
    }
    public Comando permitirAplicarComando(Comando comando) {
        return new ComandoMensaje("Este pokemon esta debilitado");
    }
}
