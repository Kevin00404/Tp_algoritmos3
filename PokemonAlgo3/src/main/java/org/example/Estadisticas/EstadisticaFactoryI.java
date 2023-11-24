package org.example.Estadisticas;

import org.json.simple.JSONObject;

public interface EstadisticaFactoryI {
    Estadisticas crearEstadisticas();

    Estadisticas crearEstadisticasEspecificas(JSONObject pokemonObjeto);
}
