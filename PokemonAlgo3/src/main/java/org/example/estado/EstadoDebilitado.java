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
    public boolean esDebilitado() {
        return true;
    }
    public Estado curarEstado(EstadoDebilitado estadoACurar) {
        return new EstadoNormal();
    }
    public Comando condicionarComando(Comando comando){
        return new ComandoMensaje("Este pokemon esta debilitado");
    }
    public Comando permitirAplicarComando(Comando comando) {
        return new ComandoMensaje("Este pokemon esta debilitado");
    }
    public void aceptarEstado(Estado estado) {
        estado.curarEstado(this);
    }
}
