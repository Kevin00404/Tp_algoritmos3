package org.example;

import org.example.JSON.LeerArchivoJson;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //Juego juego = new Juego();
        //juego.iniciar_Juego();
        LeerArchivoJson leer = new LeerArchivoJson();
        leer.LeerJson();
    }
}