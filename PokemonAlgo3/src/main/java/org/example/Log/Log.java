package org.example.Log;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class Log {
    private static Log log;
    private Timeline timeline;

    private Text fuente;
    private Log(){
    }

    public static Log getLog(){
        if (log == null){
            log = new Log();
            return log;
        }
        return log;
    }

    public void setFuente(Text t){
        fuente = t;
    }

    public void log(String mensaje) {
        if(fuente == null){
            System.out.println(mensaje);
        } else {
            /*if (timeline != null) {
                // Another message is already in progress, wait until it finishes
                timeline.setOnFinished(null); // Remove previous onFinished event
                timeline.playFromStart();
            } else {
                // Start a new timeline for the current message*/
                fuente.setText(mensaje);
                /*timeline = new Timeline(new KeyFrame(Duration.seconds(1.5), event -> {
                    // Message has been displayed for at least 1.5 seconds
                    timeline = null; // Reset timeline for the next message
                }));
                timeline.play();*/
            }
        }
    }
}
