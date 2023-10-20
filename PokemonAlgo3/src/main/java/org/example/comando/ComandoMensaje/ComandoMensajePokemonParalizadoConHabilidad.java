package org.example.comando.ComandoMensaje;

import org.example.comando.Comando;

public class ComandoMensajePokemonParalizadoConHabilidad extends ComandoMensaje {
    @Override
    public String armarMensaje() {
        return "El Pokémon esta Paralizado pero puedo lanzar la habilidad.";
    }
}
