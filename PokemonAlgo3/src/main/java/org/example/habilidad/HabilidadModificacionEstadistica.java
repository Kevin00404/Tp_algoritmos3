package org.example.habilidad;

import org.example.EstadoPokemon;
import org.example.Juego;
import org.example.TipoHabilidadEstadistica;
import org.example.pokemon.Pokemon;

public class HabilidadModificacionEstadistica extends Habilidad{

    private TipoHabilidadEstadistica estadistica;

    public HabilidadModificacionEstadistica( Integer cantidadDisponible, TipoHabilidadEstadistica estadistica) {
        super("Cambiar estadistica a "+ estadistica, cantidadDisponible, "Estadística");
        this.estadistica=estadistica;
    }
    final Integer AUMENTO  =5;
    final Integer DISMINUYE =5;
    final Double MAX_VALOR=100.0;
    final Double MIN_VALOR= 0.0;
    final Integer MAX_VALORI=100;
    final Integer MIN_VALORI=100;


    public void usar(Pokemon pokemon) {
            switch (estadistica) {
                case VELOCIDAD_PROPIO:
                    pokemon.setVelocidad(pokemon.getVelocidad()+AUMENTO);
                    if (pokemon.getVelocidad()>MAX_VALORI) {
                        pokemon.setVelocidad(MAX_VALORI);
                    }
                    break;
                case VELOCIDAD_ENEMIGO:
                    pokemon.setVelocidad(pokemon.getVelocidad()-DISMINUYE);
                    if (pokemon.getVelocidad()<MIN_VALORI) {
                        pokemon.setVelocidad(MIN_VALORI);
                    }
                    break;
                case DEFENSA_PROPIO:
                    pokemon.setDefensa(pokemon.getDefensa()+AUMENTO);
                    if (pokemon.getDefensa()>MAX_VALOR) {
                        pokemon.setDefensa(MAX_VALOR);
                    }
                    break;
                case DEFENSA_ENEMIGO:
                    pokemon.setDefensa(pokemon.getDefensa()-DISMINUYE);
                    if (pokemon.getDefensa()<MIN_VALOR) {
                        pokemon.setDefensa(MIN_VALOR);
                    }
                    break;
                case ATAQUE_PROPIO:
                    pokemon.setAtaque(pokemon.getAtaque()+AUMENTO);
                    if (pokemon.getAtaque()>MAX_VALOR) {
                        pokemon.setAtaque(MAX_VALOR);
                    }
                    break;
                case ATAQUE_ENEMIGO:
                    pokemon.setAtaque(pokemon.getAtaque()-DISMINUYE);
                    if (pokemon.getAtaque()<MIN_VALOR) {
                        pokemon.setAtaque(MIN_VALOR);
                    }
                    break;
                case VIDA_PROPIO:
                    pokemon.setVida(pokemon.getVida()+AUMENTO);
                    if (pokemon.getVida()>MAX_VALOR) {
                        pokemon.setVida(MAX_VALOR);
                    }
                    break;
                default:
                    System.out.println("error: no se realizó la modificación de estadística.");
                    break;
            }
        }
    }


