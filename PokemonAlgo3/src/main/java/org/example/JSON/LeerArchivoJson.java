package org.example.JSON;

import org.example.pokemon.Pokemon;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Paths;

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
}
