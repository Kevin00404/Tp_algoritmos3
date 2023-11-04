package org.example.Clima;

import org.example.Entrenador;
import org.example.Estadisticas.Estadisticas;

import java.util.Random;

public class ManejoDeClima {

    private Integer MAX_DURACION = 3;
    private static ManejoDeClima terreno;
    private Climas clima;

    private Integer duracion;

    private ManejoDeClima(){
        clima = setClima();
        duracion = MAX_DURACION;
    }

    public Double ventajaDelTerreno(Double danioHipotetico, Estadisticas estadisticasPkmn){
        return clima.ventajaDeClima(danioHipotetico, estadisticasPkmn);
    }

    public void verificarFinalDeClima(){
        if ( duracion == 0 ){
            clima = setClima();
            duracion = MAX_DURACION;
        }
    }
    public static ManejoDeClima getTerreno(){
        if( terreno == null){
            terreno = new ManejoDeClima();
            return terreno;
        }
        return terreno;
    }

    public void aplicarDanioTerreno(Entrenador jugador, Entrenador oponente){
        String mensaje = "Daño causado por";
        clima.danioPasivo(jugador, oponente, mensaje);
        duracion -= 1;
        verificarFinalDeClima();
    }
    public void cambiarClima(Climas nuevoClima){
        clima = nuevoClima;
        duracion = MAX_DURACION;
    }
    private static Integer numeroAleatorio(Integer maximo){
        Random rand = new Random();
        return rand.nextInt(maximo) + 1;
    }
    private static Climas setClima() {
        int numeroRng = numeroAleatorio(3);
        if ( numeroRng == 3 ){
            numeroRng = numeroAleatorio(7);
            switch (numeroRng){
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

    public String getClima() {
        return clima.getNombre();
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
}
