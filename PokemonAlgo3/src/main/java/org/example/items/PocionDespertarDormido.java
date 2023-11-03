package org.example.items;

import org.example.Eventos.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoCurarEstado;
import org.example.comando.ComandoMensaje;
import org.example.estado.EstadoDormido;
import org.example.pokemon.Pokemon;

public class PocionDespertarDormido extends ItemDeEstado{
    public PocionDespertarDormido(String nombre , Integer disponible){
        super(disponible);
        this.nombre = nombre;
    }
    @Override
    public boolean usarItem(Pokemon pokemon) {
        Comando comando = new ComandoCurarEstado(new EstadoDormido(), pokemon);
        Comando comandoMensaje = new ComandoMensaje("Pocion de despertar ha sido aplicada");
        comandoMensaje.concatComands(comando);
        Eventos.getEventos().agregarComando(comandoMensaje);
        this.disponibles -= 1;
        return true;
    }
}
