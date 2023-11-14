package org.example.JSON;


import org.json.JSONArray;
import org.json.JSONTokener;
import org.json.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LeerJSON {

    public void leerJson(){
        File file = new File("datos.json");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            JSONTokener tokener = new JSONTokener(fileInputStream);
            JSONObject jsonObject = new JSONObject(tokener);

            JSONArray pokemonesPrimeraGeneracion = jsonObject.getJSONArray("pokemones_primera_generacion");
            for (int i = 0; i < pokemonesPrimeraGeneracion.length(); i++) {
                JSONObject pokemon = pokemonesPrimeraGeneracion.getJSONObject(i);
                String nombre = pokemon.getString("nombre");
                JSONArray tipos = pokemon.getJSONArray("tipo");
                int numero = pokemon.getInt("numero");
                System.out.println("Nombre: " + nombre);
                System.out.println("Tipos: " + tipos.toString());
                System.out.println("Número: " + numero);
                System.out.println("----------------------------------");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
