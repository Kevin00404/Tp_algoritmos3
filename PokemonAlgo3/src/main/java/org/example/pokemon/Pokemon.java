package org.example.pokemon;


import org.example.Elemento.*;
import org.example.estado.Estado;
import org.example.estado.EstadoNormal;
import org.example.habilidad.Habilidad;

<<<<<<< HEAD
final int NIVEL_INICIO=1;
final double VIDAMAXIMA=100.0;

=======
import static org.example.estado.Estado.estadoPokemon.NORMAL;
>>>>>>> b9bad8d9362f907a82a5de84a0673a3be41e01c8

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

<<<<<<< HEAD
    Integer critico = 1;// Que es esto?
    Integer random = 1;//Que es esto?


=======
    Integer critico = 1; // hay que cambiarlo
    Integer random = 1; // hay que cambiarlo
>>>>>>> b9bad8d9362f907a82a5de84a0673a3be41e01c8


    //Constructores:

    public Pokemon(String nombre, Element tipo, String historia) {
        this.nombre = nombre;
        this.elemento = tipo;
        this.historia = historia;
<<<<<<< HEAD
        this.nivel = NIVEL_INICIO;
        this.vida = VIDAMAXIMA;
        this.estado = new EstadoNormal();
=======
        ataque = 10;
        defensa = 3;
        velocidad = 20;
        nivel = 1;
        vida = 100.0;
        estado = new Estado();

        //primera_habilidad = new HabilidadAtaque("Ataque Normal", 10, new Normal(), 5, elemento.bonus_mismo_tipo(new Normal()));
        //segunda_habilidad = new HabilidadAtaque("Ataque De Fuego", 10, new Fuego(), 5, elemento.bonus_mismo_tipo(new Normal()));
>>>>>>> b9bad8d9362f907a82a5de84a0673a3be41e01c8
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
        Double tipo = this.elemento.danio_final(element, poderDeAtaque /*este daño sale de la propia habilidad*/);
        /*this.defensa;*/
        Double damage = (((2 * this.nivel*critico*poderDeAtaque*(ataquePokemonAtaca/this.defensa))/5 + 2)/50)*mismoTipo*tipo*random;
        /* random y crítico son 1 por ahora */
        this.vida -= damage;
    }
}
