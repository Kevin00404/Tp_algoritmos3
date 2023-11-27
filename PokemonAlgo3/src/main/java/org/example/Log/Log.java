package org.example.Log;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.LinkedList;
import java.util.Queue;


public class Log {
    private static Log log;
    private Queue<String> colaDeMensajes = new LinkedList<>();
    private Timeline timeline;

    private Text fuente;

    private Log() {
    }

    public static Log getLog() {
        if (log == null) {
            log = new Log();
            return log;
        }
        return log;
    }

    public void setFuente(Text t) {
        fuente = t;
    }

    public void log(String mensaje) {
        colaDeMensajes.add(mensaje);

        if (timeline == null || timeline.getStatus() != Timeline.Status.RUNNING) {
            // If no message is currently being displayed, start displaying the next message
            displayNextMessage();
        }

            /*if (timeline != null) {
                // Another message is already in progress, wait until it finishes
                timeline.setOnFinished(
                        event -> { timeline= new Timeline(
                                new KeyFrame(Duration.seconds(0), evento -> fuente.setText(mensaje)),
                                new KeyFrame(Duration.seconds(1.6), evento -> timeline = null)
                        );
                        }
                ); // Remove previous onFinished event
                timeline.playFromStart();
            } else {
                // Start a new timeline for the current message
                timeline = new Timeline(
                        new KeyFrame(Duration.seconds(0), event -> fuente.setText(mensaje)),
                        new KeyFrame(Duration.seconds(1.6), event -> timeline = null)
                );
                timeline.play();
            }*/
            if (timeline != null && timeline.getStatus() == Timeline.Status.RUNNING) {
                // Another message is already in progress, wait until it finishes
                timeline.setOnFinished(null); // Remove previous onFinished event
                timeline.playFromStart();
            } else {
                // Start a new timeline for the current message
                fuente.setText(mensaje);
                timeline = new Timeline(
                        new KeyFrame(Duration.seconds(0), event -> {}),
                        new KeyFrame(Duration.seconds(1.6), event -> timeline = null)
                );
                timeline.play();
            }
    }

    private void displayNextMessage() {
        String nextMessage = colaDeMensajes.poll();

        if (nextMessage != null) {
            fuente.setText(nextMessage);

            // Start a new timeline for the current message
            timeline = new Timeline(
                    new KeyFrame(Duration.seconds(0), event -> {}),
                    new KeyFrame(Duration.seconds(1.0), event -> displayNextMessage())
            );
            timeline.play();
        }
    }
