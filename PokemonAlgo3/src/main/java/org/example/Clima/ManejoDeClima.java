package org.example.Clima;

import org.example.Entrenador;
import org.example.Estadisticas.Estadisticas;

import java.util.Random;

public class ManejoDeClima {

    private static ManejoDeClima terreno;
    private Climas clima;

    private Integer duracion;

    private ManejoDeClima(){
        clima = setClima();
        duracion = 5;
    }

    public Double ventajaDelTerreno(Double danioHipotetico, Estadisticas estadisticasPkmn){
        return clima.ventajaDeClima(danioHipotetico, estadisticasPkmn);
    }

    public void danioPasivoDelTerreno(Entrenador jugador, Entrenador oponente){
        clima.danioPasivo(jugador, oponente);
        duracion -= 1;
        verificarFinalDeClima();
    }

    void verificarFinalDeClima(){
        if ( duracion < 0 ){
            clima = setClima();
        }
    }
    public static ManejoDeClima getTerreno(){
        if( terreno == null){
            terreno = new ManejoDeClima();
            return terreno;
        }
        return terreno;
    }

    public void aplicarDanioClima(Entrenador jugador, Entrenador oponente){
        clima.danioPasivo(jugador, oponente);
    }
    public void cambiarClima(Climas nuevoClima){
        clima = nuevoClima;
    }
    private static Integer numeroAleatorio(Integer maximo){
        Random rand = new Random();
        return rand.nextInt(maximo) + 1;
    }
    private static Climas setClima() {
        int numeroAleatorio = numeroAleatorio(3);
        if ( numeroAleatorio == 3 ){
            numeroAleatorio = numeroAleatorio(7);
            switch (numeroAleatorio){
                case 1:
                    return new Soleado();
                case 2:
                    return new Lluvia();
                case 3:
                    return new TormentaDeArena();
                case 4:
                    return new Niebla();
                case 5:
                    return new TormentaDeRayo();
                case 6:
                    return new Huracan();
                case 7:
                    return new Granizo();

            }
        }
        return new Despejado();
    }

}
