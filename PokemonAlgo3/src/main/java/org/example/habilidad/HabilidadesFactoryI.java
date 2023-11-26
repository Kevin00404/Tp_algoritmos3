package org.example.habilidad;

import org.json.simple.JSONObject;

import java.util.Dictionary;
import java.util.Hashtable;

public interface HabilidadesFactoryI {
    Hashtable<Integer, Habilidad> habilidades();

    Hashtable<Integer, Habilidad> crearHabilidadesEspecificas(JSONObject pokemonObjeto);

    void generadorHabilidadesRandom();
}
