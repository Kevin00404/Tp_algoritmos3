package org.example.Clima;

import org.example.Entrenador;
import org.example.Estadisticas.Estadisticas;

import java.util.ArrayList;
import java.util.List;

public abstract class Climas implements Clima {

    private String nombre;
    private List<String> elementosConVentaja = new ArrayList<>();

    @Override
    public Double ventajaDeClima(Double danioHipotetico, Estadisticas estadisticasPkmn) {
        if ( contieneElemento(estadisticasPkmn) ) {
            return danioHipotetico += (danioHipotetico*0.1);
        } else {
            return danioHipotetico;
        }
    }

    @Override
    public void danioPasivo(Entrenador jugador, Entrenador oponente) {
        jugador.getPokemonActual().recibirDanio(jugador.getPokemonActual().getEstadisticas().getMaxVida() * 0.03);
        oponente.getPokemonActual().recibirDanio(oponente.getPokemonActual().getEstadisticas().getMaxVida() * 0.03);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setElementosConVentaja(String elementosConVentaja) {
        this.elementosConVentaja.add(elementosConVentaja);
    }

    private boolean contieneElemento(Estadisticas estadisticas){
        return elementosConVentaja.contains(estadisticas.getElemento().get_tipo());
    }
}
