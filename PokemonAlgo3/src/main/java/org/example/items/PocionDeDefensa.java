package org.example.items;

import org.example.Estadistica.ModDefensa;
import org.example.Turno.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.comando.ComandoModificarEstadistica;
import org.example.pokemon.Pokemon;

public class PocionDeDefensa extends ItemDeSoporte{
    public PocionDeDefensa(String nombre, Double valor , Integer disponible){
        super(disponible);
        this.nombre = nombre;
        this.valor = valor;
    }

    @Override
    public boolean usarItem(Pokemon pokemon) {
        if (this.disponibles < 0){
            return false;
        }
        Comando comando = new ComandoModificarEstadistica(new ModDefensa(this.valor), pokemon.getEstadisticas());
        comando = pokemon.habilitarComandoSiVive(comando);
        Comando comandoMensaje = new ComandoMensaje("Se ha gastado una pocion de defensa");
        this.disponibles -=1;
        comandoMensaje.concatComands(comando);
        Eventos.getEventos().agregarComando(comandoMensaje);
        return true;
    }

}
