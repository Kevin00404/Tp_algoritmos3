package org.example.estado;

import org.example.Turno.Eventos;
import org.example.Elemento.Element;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.habilidad.Habilidad;
import org.example.items.*;
import org.example.pokemon.Pokemon;

public abstract class Estado {
    String nombre;
    public Estado atacar(Pokemon pokemon /*pokemon a atacar*/, Habilidad habilidad /*habilidad seleccionada por el usuario*/, Element element /*elemento del pokemon que está atacando*/, Eventos eventos_a_realizar)
    {
        habilidad.atacar(pokemon, element, eventos_a_realizar);
        return this;
    }
    public Estado pasivo(Pokemon pokemon) {
        return this;
    }
    public Estado setEstadoActual(Estado estado){
        System.out.println("este pokemon ya tiene un estado y no puede cambiarlo");
        return this;
    }

    public Comando mostrarEstado(){
        return new ComandoMensaje("Estado Actual: " + nombre);
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
    public Estado curarEstado(EstadoParalizado estadoACurar){ return this; }
    public Estado curarEstado(EstadoEnvenenado estadoACurar) { return this; }
    public Estado curarEstado(EstadoDormido estadoACurar){ return this; }
    public Estado curarEstado(EstadoDebilitado estadoACurar){ return this; }
    public Estado curarEstado(Estado estadoACurar){
        return new EstadoNormal();
    }

    public boolean esDebilitado() {
        return false;
    }
    public boolean esNormal() {return false;}
    public String getNombre() {
        return this.nombre;
    }

    public Comando condicionarComando(Comando comando) {
        return comando;

    }
    public Comando permitirAplicarComando(Comando comando) {
        return comando;
    }
}
