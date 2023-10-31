package org.example.items;

import org.example.Turno.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoCurarEstado;
import org.example.comando.ComandoMensaje;
import org.example.estado.EstadoNormal;
import org.example.pokemon.Pokemon;

public class CuraTotal extends ItemDeEstado{
    String nombre;
    public CuraTotal(String nombre , Integer disponibles){
        super(disponibles);
        this.nombre = nombre;
    }
    @Override
    public boolean usarItem(Pokemon pokemon) {
        Comando comando = new ComandoCurarEstado(new EstadoNormal(), pokemon);
        Comando comandoMensaje = new ComandoMensaje("Pocion de Cura Total aplicada");
        comandoMensaje.concatComands(comando);
        Eventos.getEventos().agregarComando(comandoMensaje);
        this.disponibles -= 1;
        return true;
    }

}
