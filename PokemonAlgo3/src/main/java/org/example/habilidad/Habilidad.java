package org.example.habilidad;

import org.example.Turno.Eventos;
import org.example.Elemento.Element;
import org.example.Estadisticas.Estadisticas;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.pokemon.Pokemon;

public abstract class Habilidad {
    String nombre;
    Integer cantidadDisponible;
    String tipoDeHabilidad;

    protected Habilidad(String nombre, Integer cantidadDisponible, String tipoDeHabilidad) {
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.tipoDeHabilidad = tipoDeHabilidad;
    }
    public void atacar(Pokemon pokemon, Element element, Eventos eventos_a_realizar){}

    public String getNombre() {
        return nombre;
    }

    public Pokemon getObjetivo(Pokemon pokemon1 , Pokemon pokemon2) {
        return pokemon2;
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

    public abstract Comando armarComando(Pokemon pokemon, Estadisticas estadisticas);
}
