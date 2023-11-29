package org.example.JSON;

import org.example.Entrenador;
import org.example.Juego;
import org.example.items.Items;
import org.example.items.Mochila;
import org.example.pokemon.Pokemon;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.List;

public class LeerArchivoJson {

    public JSONArray obtenerArrayJSON(String ruta){
        String path = String.valueOf(Paths.get(ruta));
        JSONParser parser = new JSONParser();
        try {
            FileReader fr = new FileReader(path);
            Object obj = parser.parse(fr);
            JSONArray pkmn = (JSONArray) obj;
            return pkmn;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void crearInforme(Juego juego, String ganadorDeBatalla){

        // Crear un objeto JSON principal
        JSONArray informe = new JSONArray();

        Entrenador entrenadorGanador = juego.getEntrenadorUno();
        Entrenador entrenadorPerdedor = juego.getEntrenadorDos();

        if (ganadorDeBatalla.equals(juego.getEntrenadorUnoNombre())){
            entrenadorGanador = juego.getEntrenadorUno();
            entrenadorPerdedor = juego.getEntrenadorDos();
        } else {
            entrenadorGanador = juego.getEntrenadorDos();
            entrenadorPerdedor = juego.getEntrenadorUno();
        }

        // Crear el primer objeto
        JSONObject ganador = new JSONObject();
        ganador.put("nombre", ganadorDeBatalla);
        ganador.put("ganador", true);

        // Crear el objeto 'items' para ganador
        JSONObject itemsGanador = new JSONObject();
        itemsGanador = ponerItemsEnJson(itemsGanador, entrenadorGanador);
        ganador.put("items", itemsGanador);

        // Crear el array 'pokemons' para ganador
        JSONArray pokemonsGanador = new JSONArray();
        pokemonsGanador = ponerPokemonesEnObjeto(pokemonsGanador, entrenadorGanador);
        ganador.put("pokemons", pokemonsGanador);

        // Agregar el objeto del ganador al array principal
        informe.add(ganador);

        // Crear el segundo objeto
        JSONObject perdedor = new JSONObject();
        perdedor.put("nombre", entrenadorPerdedor.getNombre());
        perdedor.put("ganador", false);

        // Crear el objeto 'items' para perdedor
        JSONObject itemsPerdedor = new JSONObject();
        itemsPerdedor = ponerItemsEnJson(itemsPerdedor, entrenadorPerdedor);
        perdedor.put("items", itemsPerdedor);

        // Crear el array 'pokemons' para perdedor
        JSONArray pokemonsPerdedor = new JSONArray();
        pokemonsPerdedor = ponerPokemonesEnObjeto(pokemonsPerdedor, entrenadorPerdedor);
        perdedor.put("pokemons", pokemonsPerdedor);

        // Agregar el objeto del perdedor al array principal
        informe.add(perdedor);

        // Escribir el array JSON en un archivo
        try (FileWriter file = new FileWriter("Informe.json")) {
            file.write(informe.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private JSONArray ponerPokemonesEnObjeto(JSONArray pokemonsGanador, Entrenador entrenadorGanador) {

        List<Pokemon> pokemones = entrenadorGanador.getPokemones().getPokemones();

        for (Pokemon poke: pokemones ) {

            JSONObject pokeAAgregar = new JSONObject();
            pokeAAgregar.put("id", obtenerIdPoke(poke.getNombre()));
            pokeAAgregar.put("nombre", poke.getNombre());
            pokeAAgregar.put("vida restante", poke.getEstadisticas().getVida());
            pokemonsGanador.add(pokeAAgregar);

        }

        //TODO pokemonAAgregar.put("estado", "unEstado o dos");


        return pokemonsGanador;

    }

    private Integer obtenerIdPoke(String nombre) {
        if (nombre.equals("Bulbasaur")){

            return 1;

        } else if (nombre.equals("Charmander")) {

            return 2;

        } else if (nombre.equals("Squirtle")) {

            return 3;

        } else if (nombre.equals("Pikachu")) {

            return 4;

        } else if (nombre.equals("Jigglypuff")) {

            return 5;

        } else if (nombre.equals("Geodude")) {

            return 6;

        } else if (nombre.equals("Eevee")) {

            return 7;

        } else if (nombre.equals("Vulpix")) {

            return 8;

        } else if (nombre.equals("Spearow")) {

            return 9;

        } else if (nombre.equals("Sandshrew")) {

            return 10;

        } else if (nombre.equals("Oddish")) {

            return 11;

        } else if (nombre.equals("Psyduck")) {

            return 12;

        } else if (nombre.equals("Mankey")) {

            return 13;

        } else if (nombre.equals("Growlithe")) {

            return 14;

        }else if (nombre.equals("Poliwag")) {

            return 15;

        }else if (nombre.equals("Abra")) {

            return 16;

        }else if (nombre.equals("Machop")) {

            return 17;

        }else if (nombre.equals("Tentacool")) {

            return 18;

        }else if (nombre.equals("Doduo")) {

            return 19;

        }else if (nombre.equals("Seel")) {

            return 20;

        } else if (nombre.equals("Grimer")) {

            return 21;

        } else if (nombre.equals("Flygon")) {

            return 22;

        } else if (nombre.equals("Swellow")) {

            return 23;

        } else if (nombre.equals("Hariyama")) {

            return 24;

        } else if (nombre.equals("Swampert")) {

            return 25;

        } else if (nombre.equals("Claydol")) {

            return 26;

        } else if (nombre.equals("Exploud")) {

            return 27;

        } else if (nombre.equals("Ludicolo")) {

            return 28;

        } else {

            return 29;

        }
    }

    private JSONObject ponerItemsEnJson(JSONObject itemsGanador, Entrenador ganador) {

        List<Items> mochila = ganador.getMochila().getItems();

        for ( Items item : mochila ) {
            itemsGanador.put(obteterIdItem(item.getNombre()), item.getDisponibles());
        }

        return itemsGanador;

    }

    private String obteterIdItem(String nombre) {
        if (nombre.equals("Pocion")){
            return "7";
        } else if (nombre.equals("Hiper Poción")){
            return "1";
        } else if (nombre.equals("Defensa x")){
            return "2";
        } else if (nombre.equals("Cura Total")){
            return "3";
        } else if (nombre.equals("Revivir")){
            return "4";
        } else if (nombre.equals("Ataque X")){
            return "5";
        } else if (nombre.equals("Despertar")){
            return "6";
        } else if (nombre.equals("AntiParalizar")){
            return "8";
        } else {
            return "9";
        }
    }
}
