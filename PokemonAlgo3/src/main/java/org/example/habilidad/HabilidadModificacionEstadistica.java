package org.example.habilidad;

import org.example.Ataque;
import org.example.Elemento.Element;
import org.example.Estadistica.Estadistica;
import org.example.pokemon.Pokemon;

public class  HabilidadModificacionEstadistica extends Habilidad {

    private Estadistica estadistica;

    public HabilidadModificacionEstadistica(Integer cantidadDisponible, Estadistica estadistica) {
        super("Cambiar estadistica a " + estadistica, cantidadDisponible, "Estadística");
        this.estadistica = estadistica;
    }
    public void atacar(Pokemon pokemon, Element element, Ataque ataque_a_realizar) {
        estadistica.modificarEstadistica(ataque_a_realizar);
        pokemon.actualizarEstadisticas(ataque_a_realizar);
    }
}


