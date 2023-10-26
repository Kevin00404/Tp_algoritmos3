package org.example.items;

import org.example.Turno.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoCurarEstado;
import org.example.comando.ComandoMensaje;
import org.example.estado.EstadoParalizado;
import org.example.pokemon.Pokemon;

public class PocionCurarParalisis extends ItemDeEstado{
    String nombre;
    public PocionCurarParalisis(String nombre , Integer disponible){
        super(disponible);
        this.nombre = nombre;
    }
    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public boolean usarItem(Pokemon pokemon) {
        Comando comando = new ComandoCurarEstado(new EstadoParalizado(), pokemon);
        Comando comandoMensaje = new ComandoMensaje("Pocion antiparalisis aplicada");
        comandoMensaje.concatComands(comando);
        Eventos.getEventos().agregarComando(comandoMensaje);
        this.disponibles -= 1;
        return true;
    }

    @Override
    public boolean sePuedeUsar(Pokemon pokemon) {
        return pokemon.getEstado().getNombre().equals("Paralizado");
    }
}
