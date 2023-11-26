package org.example.habilidad;

import org.example.Estadistica.ModEstadistica;
import org.example.Estadisticas.Estadisticas;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.comando.ComandoModificarEstadistica;
import org.example.pokemon.Pokemon;

public class HabilidadModificacionEstadistica extends Habilidad {

    private ModEstadistica modificacionEstadistica;

    public HabilidadModificacionEstadistica(String nombre, Integer cantidadDisponible, ModEstadistica modificacionEstadistica) {
        super(nombre + " (Cambiar estadistica a " + modificacionEstadistica.getNombre()+ ")", cantidadDisponible, "Estadística");
        this.modificacionEstadistica = modificacionEstadistica;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public Comando armarComando(Pokemon pokemon, Estadisticas estadisticas) {
        this.consumirUso();
        Comando comandoMensaje = new ComandoMensaje("se ha elegido la habilidad: " + this.nombre);
        Comando comandoJugada;
        if (modificacionEstadistica.danina()){
            comandoJugada = new ComandoModificarEstadistica(modificacionEstadistica, pokemon.getEstadisticas());
        } else {
            comandoJugada = new ComandoModificarEstadistica(modificacionEstadistica, estadisticas);
        }
        comandoMensaje.concatComands(comandoJugada);
        return comandoMensaje;
    }
}


