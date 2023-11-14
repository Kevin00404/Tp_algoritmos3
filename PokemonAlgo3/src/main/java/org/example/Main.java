package org.example;

import org.example.Elemento.*;
import org.example.JSON.LeerJSON;
import org.example.habilidad.HabilidadAtaque;
import org.example.pokemon.Pokemon;

public class Main {
    public static void main(String[] args) {

        //Juego juego = new Juego();
        //juego.iniciar_Juego();
        LeerJSON leer = new LeerJSON();
        leer.leerJson();
    }
}