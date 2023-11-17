package org.example.JSON;

import org.example.pokemon.Pokemon;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Paths;

public class LeerArchivoJson {

    public void LeerJson() throws IOException {
        String path = String.valueOf(Paths.get("datos.json"));
        JSONParser parser = new JSONParser();
        try {
            FileReader fr = new FileReader(path);
            Object obj = parser.parse(fr);
            JSONArray pkmn = (JSONArray) obj;
            for (Object actual : pkmn) {
                mostrarDatos((JSONObject) actual);
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private void mostrarDatos(JSONObject actual) {
        System.out.println(actual.get("nombre"));
        System.out.println(actual.get("id"));
    }
}
