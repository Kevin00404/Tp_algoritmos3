package org.example.pokemon;


import org.example.Elemento.*;
import org.example.estado.Estado;
import org.example.estado.EstadoNormal;
import org.example.habilidad.Habilidad;

import static org.example.estado.Estado.estadoPokemon.NORMAL;

public class Pokemon {
    String nombre;
    Double vida;
    Integer nivel;
    Integer velocidad;
    Integer defensa;
    Integer ataque;
    String historia;
    Estado estado;
    Element elemento;
    Habilidad primeraHabilidad;
    Habilidad segundaHabilidad;
    Habilidad terceraHabilidad;
    Habilidad cuartaHabilidad;

    //Integer critico = 1; // hay que cambiarlo...que es esto?
    //Integer random = 1; // hay que cambiarlo..que es esto?

    final int NIVEL_INICIO=1;
    final double VIDAMAXIMA=100.0;


    public Pokemon(String nombre, Element tipo, String historia) {
        this.nombre = nombre;
        this.elemento = tipo;
        this.historia = historia;
        nivel = NIVEL_INICIO;
        vida = VIDAMAXIMA;
        estado = new EstadoNormal();
    }

    public Pokemon(String nombre, String historia, Element elemento, Habilidad primeraHabilidad, Habilidad segundaHabilidad, Habilidad terceraHabilidad, Habilidad cuartaHabilidad) {
        this.nombre = nombre;
        this.historia = historia;
        this.elemento = elemento;
        this.primeraHabilidad = primeraHabilidad;
        this.segundaHabilidad = segundaHabilidad;
        this.terceraHabilidad = terceraHabilidad;
        this.cuartaHabilidad = cuartaHabilidad;
        this.nivel = NIVEL_INICIO;
        this.vida = VIDAMAXIMA;
        this.estado = new EstadoNormal();
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public boolean estaVivo(){
        return vida > 0;
    }

    //notaKevin:la habilidad atacar es única por pokemon. Creo no hay que pasarla por parámetro.
    //e Integer que seria el ataque se puede reemplazar por this.ataque.
    public void atacar(Pokemon pokemon /*pokemon a atacar*/, Habilidad habilidad /*habilidad seleccionada por el usuario*/, Integer ataque /*ataque del pokemon que ataca (creo que hay que cambiarla, no está bien la sintaxis*/){
        switch (this.estado.verificarEstado()){
            case NORMAL:
                this.estado.atacar(pokemon /*pokemon al cuál se va a atacar*/, habilidad /* esto sería una clave de un diccionario*/, this.elemento /* elemento del pokemon que está atacando*/);
                break;
            case PARALIZADO:
                if (Math.random() < 0.5) {
                    System.out.println("El Pokémon está PARALIZADO y no pudo realizar la habilidad.");
                } else {
                    this.estado.atacar(pokemon /*pokemon al cuál se va a atacar*/, habilidad /* esto sería una clave de un diccionario*/, this.elemento /* elemento del pokemon que está atacando*/);
                    System.out.println("El Pokémon ya NO está PARALIZADO lanza la habilidad.");
                    this.estado.cambiarEstadoParalizado();
                }
                break;
            case DORMIDO:
                this.estado.puedeDespertarse(pokemon /*pokemon al cuál se va a atacar*/, habilidad /* esto sería una clave de un diccionario*/, this.elemento /* elemento del pokemon que está atacando*/);
                this.estado.verificarEstado();
                if(this.estado.verificarEstado() == NORMAL){
                    this.estado.atacar(pokemon /*pokemon al cuál se va a atacar*/, habilidad /* esto sería una clave de un diccionario*/, this.elemento /* elemento del pokemon que está atacando*/);
                }
                break;
            case ENVENENADO:
                this.estado.atacar(pokemon /*pokemon al cuál se va a atacar*/, habilidad /* esto sería una clave de un diccionario*/, this.elemento /* elemento del pokemon que está atacando*/);
                this.vida -= (this.vida*5)/100; /*si está envenenado ataca pero también pierde 5% de vida*/
                break;
        }
    }

    public void recibirDanio(Double poderDeAtaque /*de la habilidad*/, Double mismoTipo, Element element /*elemento de la habilidad*/, Integer ataquePokemonAtaca) {
        Double tipo;
        Element elementos = new Fuego();
        tipo = this.elemento.danio_final(elementos, poderDeAtaque /*este daño sale de la propia habilidad*/);
        /*this.defensa;*/
        Double damage = (((2 * this.nivel*critico*poderDeAtaque*(ataquePokemonAtaca/this.defensa))/5 + 2)/50)*mismoTipo*tipo*random;
        /* random y crítico son 1 por ahora */
        this.vida -= damage;
    }
}
