package org.example.habilidad;

import org.example.Ataque;
import org.example.Elemento.Element;
import org.example.Estadistica.Estadistica;
import org.example.pokemon.Pokemon;

public class HabilidadModificacionEstadistica extends Habilidad {

    private Estadistica estadistica;

    public HabilidadModificacionEstadistica(String nombre, Integer cantidadDisponible, Estadistica estadistica) {
        super(nombre + " (Cambiar estadistica a " + estadistica.getNombre()+ ")", cantidadDisponible, "Estadística");
        this.estadistica = estadistica;
    }
    public void atacar(Pokemon pokemon, Element element, Ataque ataque_a_realizar) {
        this.consumirUso();
        System.out.println("se ha elegido la habilidad: " + this.nombre);
        estadistica.modificarEstadistica(ataque_a_realizar);
        pokemon.actualizarEstadisticas(ataque_a_realizar);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public Pokemon getObjetivo(Pokemon pokemon1, Pokemon pokemon2) {
        if (estadistica.danina()){
            return pokemon2;
        }
        return pokemon1;
    }
}


