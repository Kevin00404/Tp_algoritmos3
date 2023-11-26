package org.example.habilidad;

import org.example.Estadisticas.Estadisticas;
import org.example.comando.CambiarEstadoComando;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.estado.Estado;
import org.example.pokemon.Pokemon;

public class HabilidadModificacionEstado extends Habilidad {
    private Estado asignarEstado;

    public HabilidadModificacionEstado(String nombre, Integer cantidadDisponible, Estado asignarEstado) {
        super(nombre + " (modifica estado a " + asignarEstado.getNombre() +")", cantidadDisponible, "Estado");
        this.asignarEstado = asignarEstado;
    }


    public Comando armarComando(Pokemon pokemon, Estadisticas estadisticas) {
        this.consumirUso();
        Comando comandoMensaje = new ComandoMensaje("se ha elegido la habilidad: " + this.nombre);
        Comando comandoJugada = new CambiarEstadoComando(pokemon, this.asignarEstado.copiar());
        comandoMensaje.concatComands(comandoJugada);
        return comandoMensaje;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }
}