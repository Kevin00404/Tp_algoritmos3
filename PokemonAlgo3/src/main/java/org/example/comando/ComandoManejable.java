package org.example.comando;

public interface ComandoManejable {
    void ejecutar();

    void concatComands(ComandoManejable comando);
}
