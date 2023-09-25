package org.example.pokemon;


import org.example.Ataque;
import org.example.Elemento.*;
import org.example.estado.Estado;
import org.example.estado.EstadoNormal;
import org.example.habilidad.Habilidad;

import java.util.Dictionary;
import java.util.Hashtable;

import static org.example.estado.Estado.estadoPokemon.NORMAL;

public class Pokemon {
    String nombre;
    Double vida;
    Double nivel;
    Integer velocidad;
    Double defensa;
    Double ataque;
    String historia;
    Estado estado;
    Element elemento;
    Dictionary<Integer, Habilidad> habilidades;

    //Integer critico = 1; // hay que cambiarlo...que es esto?
    //Integer random = 1; // hay que cambiarlo..que es esto?

    final Double NIVEL_INICIO = 1.0;
    final Double VIDAMAXIMA=100.0;


    public Pokemon(String nombre, Element elemento, String historia, Habilidad primeraHabilidad, Habilidad segundaHabilidad, Habilidad terceraHabilidad, Habilidad cuartaHabilidad) {
        this.nombre = nombre;
        this.elemento = elemento;
        this.historia = historia;
        this.ataque = 10.0;
        this.defensa = 10.0;
        nivel = NIVEL_INICIO;
        vida = VIDAMAXIMA;
        estado = new Estado();
        this.habilidades = new Hashtable<Integer, Habilidad>();
        this.habilidades.put(1, primeraHabilidad);
        this.habilidades.put(2, segundaHabilidad);
        this.habilidades.put(3, terceraHabilidad);
        this.habilidades.put(4, cuartaHabilidad);
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

    public Double getAtaque() {
        return ataque;
    }

    public boolean estaVivo(){
        return vida > 0;
    }

    //notaKevin:la habilidad atacar es única por pokemon. Creo no hay que pasarla por parámetro.
    //e Integer que seria el ataque se puede reemplazar por this.ataque.
    public void atacar(Pokemon pokemon /*pokemon a atacar*/, Integer habilidad_a_usar){
        Habilidad habilidad = this.habilidades.get(habilidad_a_usar);
        Ataque ataque_a_realizar = new Ataque();
        ataque_a_realizar.setAtaque(this.ataque);
        ataque_a_realizar.setNivel(this.nivel);
        System.out.println("Mi habilidad de pokemon es: " + this.elemento.get_tipo());
        switch (this.estado.verificarEstado()){
            case NORMAL:
                this.estado.atacar(pokemon /*pokemon al cuál se va a atacar*/, habilidad /*La habilidad que se usa*/, this.elemento /* elemento del pokemon que está atacando*/, ataque_a_realizar);
                break;
            case PARALIZADO:
                if (Math.random() < 0.5) {
                    System.out.println("El Pokémon está PARALIZADO y no pudo realizar la habilidad.");
                } else {
                    this.estado.atacar(pokemon /*pokemon al cuál se va a atacar*/, habilidad /* esto sería una clave de un diccionario*/, this.elemento /* elemento del pokemon que está atacando*/, ataque_a_realizar);
                    System.out.println("El Pokémon ya NO está PARALIZADO lanza la habilidad.");
                    this.estado.cambiarEstadoParalizado();
                }
                break;
            case DORMIDO:
                this.estado.puedeDespertarse(pokemon /*pokemon al cuál se va a atacar*/, habilidad /* esto sería una clave de un diccionario*/, this.elemento /* elemento del pokemon que está atacando*/);
                this.estado.verificarEstado();
                if(this.estado.verificarEstado() == NORMAL){
                    this.estado.atacar(pokemon /*pokemon al cuál se va a atacar*/, habilidad /* esto sería una clave de un diccionario*/, this.elemento /* elemento del pokemon que está atacando*/, ataque_a_realizar);
                }
                break;
            case ENVENENADO:
                this.estado.atacar(pokemon /*pokemon al cuál se va a atacar*/, habilidad /* esto sería una clave de un diccionario*/, this.elemento /* elemento del pokemon que está atacando*/, ataque_a_realizar);
                this.vida -= (this.vida*5)/100; /*si está envenenado ataca pero también pierde 5% de vida*/
                break;
        }
    }

    public void recibirDanio(Ataque ataque_a_realizar, Element element) {
        ataque_a_realizar.setTipo(element.mixElement(this.elemento));
        ataque_a_realizar.setDefensa(this.defensa);
        Double damage = ataque_a_realizar.calcular_danio();
        System.out.println("Danio que le afecta: " + damage);
        this.vida -= damage;
    }
}
