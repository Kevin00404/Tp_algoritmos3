package org.example.estado;

import org.example.Ataque;
import org.example.Elemento.Element;
import org.example.habilidad.Habilidad;
import org.example.pokemon.Pokemon;

public class EstadoNormal extends Estado{
    public EstadoNormal(){

    }
    @Override
    public Estado setEstadoActual(Estado estado) {
        return estado;
    }


}
