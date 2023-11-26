package org.example.habilidad;

import org.example.Clima.Climas;
import org.example.Estadisticas.Estadisticas;
import org.example.comando.CambiarTerrenoComando;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.pokemon.Pokemon;

public class HabilidadModificacionTerreno extends Habilidad{

    private Climas asignarClima;

    public HabilidadModificacionTerreno(String nombre, Integer cantidadDisponible, Climas nuevoClima) {
        super(nombre + "( se cambia clima a " + nuevoClima.getNombre() + ")", cantidadDisponible, "clima");
        this.asignarClima = nuevoClima;
    }

    @Override
    public Comando armarComando(Pokemon pokemon, Estadisticas estadisticas) {
        this.consumirUso();
        Comando comandoMensaje = new ComandoMensaje("se ha elegido la habilidad: " + this.nombre );
        Comando comandoJugada = new CambiarTerrenoComando(pokemon, this.asignarClima);
        comandoMensaje.concatComands(comandoJugada);
        return comandoMensaje;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }
}
