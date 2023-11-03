package org.example.items;

import org.example.Eventos.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoCurarEstado;
import org.example.comando.ComandoMensaje;
import org.example.estado.EstadoEnvenenado;
import org.example.pokemon.Pokemon;

public class PocionAntiVeneno extends ItemDeEstado{
    public PocionAntiVeneno(String nombre , Integer disponible){
        super(disponible);
        this.nombre = nombre;
    }
    @Override
    public boolean usarItem(Pokemon pokemon) {
        Comando comando = new ComandoCurarEstado(new EstadoEnvenenado(), pokemon);
        Comando comandoMensaje = new ComandoMensaje("Pocion antiveneno aplicada");
        comandoMensaje.concatComands(comando);
        Eventos.getEventos().agregarComando(comandoMensaje);
        this.disponibles -= 1;
        return true;
    }
}
