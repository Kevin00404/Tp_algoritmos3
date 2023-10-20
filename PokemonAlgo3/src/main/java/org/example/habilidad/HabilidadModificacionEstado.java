package org.example.habilidad;

import org.example.Turno.Turno;
import org.example.Elemento.Element;
import org.example.estado.Estado;
import org.example.pokemon.Pokemon;

public class HabilidadModificacionEstado extends Habilidad {
    private Estado asignarEstado;

    public HabilidadModificacionEstado(String nombre, Integer cantidadDisponible, Estado asignarEstado) {
        super(nombre + " (modifica estado a " + asignarEstado.getNombre() +")", cantidadDisponible, "Estado");
        this.asignarEstado = asignarEstado;
    }


    public void atacar(Pokemon pokemon, Element element, Turno turno_a_realizar) {
        this.consumirUso();
        System.out.println("se ha elegido la habilidad: " + this.nombre);
        turno_a_realizar.setEstado(this.asignarEstado);
        pokemon.modificarEstado(turno_a_realizar);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }
}