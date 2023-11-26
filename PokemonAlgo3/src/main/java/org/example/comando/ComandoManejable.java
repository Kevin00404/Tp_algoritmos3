package org.example.comando;

public interface ComandoManejable {
    void ejecutar() throws InterruptedException;

    void concatComands(ComandoManejable comando);
}
