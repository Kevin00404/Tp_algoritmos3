package org.example;

import org.example.Elemento.*;
import org.example.JSON.LeerArchivoJson;
import org.example.habilidad.HabilidadAtaque;
import org.example.pokemon.Pokemon;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //Juego juego = new Juego();
        //juego.iniciar_Juego();
        LeerArchivoJson leer = new LeerArchivoJson();
        leer.LeerJson("HabilidadesAtaque.json");
    }
}