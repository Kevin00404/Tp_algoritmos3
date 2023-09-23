package org.example.pokemon;


import org.example.Elemento.*;
import org.example.estado.Estado;
import org.example.estado.EstadoNormal;
import org.example.habilidad.Habilidad;

final int NIVEL_INICIO=1;
final double VIDAMAXIMA=100.0;


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

    Integer critico = 1;// Que es esto?
    Integer random = 1;//Que es esto?




    //Constructores:

    public Pokemon(String nombre, Element tipo, String historia) {
        this.nombre = nombre;
        this.elemento = tipo;
        this.historia = historia;
        this.nivel = NIVEL_INICIO;
        this.vida = VIDAMAXIMA;
        this.estado = new EstadoNormal();
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


    public Integer getAtaque() {
        return ataque;
    }

    public boolean estaVivo(){
        if (vida > 0){
            return true;
        }
        return false;
    }


    public void atacar(Pokemon pokemon /*pokemon a atacar*/, Habilidad habilidad /*habilidad seleccionada por el usuario*/, Integer ataque /*ataque del pokemon que ataca (creo que hay que cambiarla, no está bien la sintaxis*/){
        this.estado.atacar(pokemon, habilidad /* esto sería una clave de un diccionario*/, this.elemento);
    }

    public void recibirDanio(Double poderDeAtaque /*de la habilidad*/, Double mismoTipo, Element element /*elemento de la habilidad*/, Integer ataquePokemonAtaca) {
        Double tipo = this.elemento.danio_final(element, poderDeAtaque /*este daño sale de la propia habilidad*/);
        /*this.defensa;*/
        Double damage = (((2 * this.nivel*critico*poderDeAtaque*(ataquePokemonAtaca/this.defensa))/5 + 2)/50)*mismoTipo*tipo*random;
        /* random y crítico son 1 por ahora */
        this.vida -= damage;
    }
}
