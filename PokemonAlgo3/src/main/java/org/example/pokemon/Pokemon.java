package org.example.pokemon;


import org.example.Elemento.*;
import org.example.estado.Estado;
import org.example.estado.EstadoNormal;
import org.example.habilidad.Habilidad;
import org.example.habilidad.HabilidadAtaque;

public class Pokemon {
    String nombre;
    Integer vida;
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
    public Pokemon(String nombre, Element tipo, String historia) {
        this.nombre = nombre;
        this.elemento = tipo;
        this.historia = historia;
        ataque = 10;
        defensa = 3;
        velocidad = 20;
        nivel = 1;
        vida = 100;
        estado = new EstadoNormal();
        primera_habilidad = new HabilidadAtaque("Ataque Normal", 10, new Normal(), 5, elemento.bonus_mismo_tipo(new Normal()));
        segunda_habilidad = new HabilidadAtaque("Ataque De Fuego", 10, new Fuego(), 5, elemento.bonus_mismo_tipo(new Normal()));
    }

}
