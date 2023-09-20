package org.example.pokemon;


import org.example.Elemento.*;
import org.example.estado.Estado;
import org.example.estado.EstadoNormal;
import org.example.habilidad.Habilidad;

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
    Habilidad primera_habilidad;
    Habilidad segunda_habilidad;
    Habilidad tercera_habilidad;
    Habilidad cuarta_habilidad;

    Integer critico = 1;
    Integer random = 1;



    public Pokemon(String nombre, Element tipo, String historia) {
        this.nombre = nombre;
        this.elemento = tipo;
        this.historia = historia;
        ataque = 10;
        defensa = 3;
        velocidad = 20;
        nivel = 1;
        vida = 100.0;
        estado = new EstadoNormal();

        //primera_habilidad = new HabilidadAtaque("Ataque Normal", 10, new Normal(), 5, elemento.bonus_mismo_tipo(new Normal()));
        //segunda_habilidad = new HabilidadAtaque("Ataque De Fuego", 10, new Fuego(), 5, elemento.bonus_mismo_tipo(new Normal()));
    }
    public Integer getAtaque() {
        return ataque;
    }

    public boolean estaVivo(){ //
        if (vida > 0){
            return true;
        }
        else return false;
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
