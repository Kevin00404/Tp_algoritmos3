package org.example.habilidad;

import org.example.Eventos.Eventos;
import org.example.Elemento.Element;
import org.example.Estadisticas.Estadisticas;
import org.example.Log.Log;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.pokemon.Pokemon;

public abstract class Habilidad {
    String nombre;
    Integer cantidadDisponible;
    Integer catidadMax;
    String tipoDeHabilidad;

    protected Habilidad(String nombre, Integer cantidadDisponible, String tipoDeHabilidad) {
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.catidadMax = cantidadDisponible;
        this.tipoDeHabilidad = tipoDeHabilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean sePuedeUsar() {
        return cantidadDisponible > 0;
    }
    protected void consumirUso(){
        if (sePuedeUsar()){
            this.cantidadDisponible -= 1;
        } else {
            Eventos.getEventos().setearProblema(new ComandoMensaje("La habilidad " + this.nombre + "ya no tiene mas usos, elige otra"));
        }
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public Integer getCatidadMax(){
        return catidadMax;
    }

    public String getTipoDeHabilidad() {
        return tipoDeHabilidad;
    }

    public abstract Comando armarComando(Pokemon pokemon, Estadisticas estadisticas);
}
