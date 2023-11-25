package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.Elemento.*;
import org.example.JSON.LeerArchivoJson;
import org.example.habilidad.HabilidadAtaque;
import org.example.pokemon.Pokemon;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        /*Juego juego = new Juego();
        juego.iniciarJuegoConJSON("Partida.json");*/
        /*LeerArchivoJson json = new LeerArchivoJson();
        JSONArray array = json.obtenerArrayJSON("Partida.json");
        JSONObject object = (JSONObject) array.get(0);
        JSONObject hab = (JSONObject) object.get("items");
        Set<String> claves = hab.keySet();
        for (String key : claves) {
            System.out.println(key);
        }
        System.out.println(claves);*/
    }

}