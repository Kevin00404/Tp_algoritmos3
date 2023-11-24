package org.example.Estadisticas;

import org.example.Elemento.Element;
import org.json.simple.JSONObject;

import java.util.Random;

public class EstadisticaFactory implements EstadisticaFactoryI{
    Double maxVida;
    Double velocidad;
    Double defensa;
    Double ataque;
    Element elemento;

    public EstadisticaFactory(Element elemento){
        maxVida = randMaxVida();
        ataque = randAtaque();
        defensa = randDefensa();
        velocidad = randVelocidad();
        this.elemento = elemento;
    }
    @Override
    public Estadisticas crearEstadisticas() {
        return new EstadisticaPokemon(maxVida, ataque, defensa, velocidad, elemento);
    }

    private Double randVelocidad() {
        return randRango(5.0, 20.0);
    }

    private Double randRango(double base, double techo) {
        Random rand = new Random();
        return (base + rand.nextDouble(techo-base));
    }

    private Double randDefensa() {
        return randRango(5.0, 20.0);
    }

    private Double randAtaque() {
        return randRango(5.0, 20.0);
    }

    private Double randMaxVida() {
        return randRango(5.0, 20.0);
    }

    public void setElemento(Element elemento) {
        this.elemento = elemento;
    }
    public void setMaxVida(Double maxVida){
        this.maxVida = maxVida;
    }
    public void setAtaque(Double ataque){
        this.ataque = ataque;
    }
    public void setDefensa(Double defensa){
        this.defensa = defensa;
    }
    public void setVelocidad(Double velocidad){
        this.velocidad = velocidad;
    }

    public Estadisticas crearEstadisticasEspecificas(JSONObject pkmn){
        return new EstadisticaPokemon(pkmn, elemento);
    }
}
