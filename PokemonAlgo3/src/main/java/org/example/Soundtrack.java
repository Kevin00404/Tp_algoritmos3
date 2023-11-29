package org.example;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Random;

public class Soundtrack {

    private static Soundtrack manejoDeSonido;
    private MediaPlayer fondo;
    private  MediaPlayer click;
    private MediaPlayer golpe;

    Soundtrack(){

        fondo = new MediaPlayer(MusicaDeFondo());
        fondo.setVolume(0.4);
        golpe = new MediaPlayer(sonidoGolpe());
        click = new MediaPlayer(sonidoClick());
    }
    public static Soundtrack getSonido(){
        if( manejoDeSonido == null){
            manejoDeSonido = new Soundtrack();
            return manejoDeSonido;
        }
        return manejoDeSonido;
    }

    public void reproducirTitulo(){
        fondo.play();
    }

    public void reproducirVictoria(){

        fondo.stop();

        Media victoria = new Media(new File("audio/Victory Screen.wav").toURI().toString());
        fondo = new MediaPlayer(victoria);

        fondo.setOnEndOfMedia(() -> {
            System.out.println("paro la musica");
            fondo.stop();
        });

        fondo.setVolume(0.4);
        fondo.play();

    }

    public Media MusicaDeFondo() {

        Media musicaDeFondo = new Media(new File(cancionTitulo()).toURI().toString());

       return  musicaDeFondo;

    }

    private String cancionTitulo(){
        return "audio/Title.wav";
    }

    private  Media sonidoClick(){
        Media click = new Media(new File("audio/clickBoton.mp3").toURI().toString());
        return click;
    }

    public void reproducirClick(){
        click.setOnEndOfMedia(() ->{
            click.stop();
        });
        click.play();
    }

    private Media sonidoGolpe(){
        Media golpe = new Media(new File("audio/ataquePokemon.mp3").toURI().toString());
        return golpe;
    }

    public void reproducirGolpe(){
        golpe.setOnEndOfMedia(() ->{
            golpe.stop();
        });
        golpe.play();
    }

    public void reproducirAudioBatalla() {

        fondo.stop();

        Media musicaDeBatalla = new Media(new File(elegirCancion()).toURI().toString());

        fondo = new MediaPlayer(musicaDeBatalla);

        fondo.setOnEndOfMedia(() -> {
            // Esto se ejecuta cuando el audio llega al final
            System.out.println("paro la musica");
            fondo.stop();
        });

        fondo.setVolume(0.4);
        fondo.play();
    }

    public void pausarAudio(){
        fondo.pause();
    }

    public void resumirAudio(){
        fondo.play();
    }


    private String elegirCancion(){
        Random random = new Random();
        Integer numeroAleatorio = random.nextInt(8) + 1;
        switch (numeroAleatorio){
            case 1:
                return "audio/Track 1.wav";
            case 2:
                return "audio/Track 2.wav";
            case 3:
                return "audio/Track 3.wav";
            case 4:
                return "audio/Track 4.wav";
            case 5:
                return "audio/Track 5.wav";
            case 6:
                return "audio/Track 6.wav";
            case 7:
                return "audio/Track 7.wav";
            default:
                return "audio/Track 8.wav";
        }
    }

}
