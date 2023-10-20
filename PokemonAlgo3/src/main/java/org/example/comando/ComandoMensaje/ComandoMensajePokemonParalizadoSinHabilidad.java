package org.example.comando.ComandoMensaje;

public class ComandoMensajePokemonParalizadoSinHabilidad extends ComandoMensaje {

    @Override
    public String armarMensaje() {
        return "El Pokémon está PARALIZADO y no pudo realizar la habilidad.";
    }
}
