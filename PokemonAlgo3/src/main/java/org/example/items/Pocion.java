package org.example.items;

import org.example.Estadistica.ModVida;
import org.example.Turno.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.comando.ComandoModificarEstadistica;
import org.example.pokemon.Pokemon;

public class Pocion extends ItemDeCuracion {
    public Pocion(Double valor, String nombre, Integer disponible) {
        super(disponible);
        this.valor = valor;
        this.nombre = nombre;
    }

    @Override
    public boolean usarItem(Pokemon pokemon) {
        if (this.disponibles < 0){
            return false;
        }
        Comando comando = new ComandoModificarEstadistica(new ModVida(this.valor), pokemon.getEstadisticas());
        comando = pokemon.habilitarComandoSiVive(comando);
        Comando comandoMensaje = new ComandoMensaje("Se ha gastado una pocion");
        this.disponibles -=1;
        comandoMensaje.concatComands(comando);
        Eventos.getEventos().agregarComando(comandoMensaje);
        return true;
    }

}