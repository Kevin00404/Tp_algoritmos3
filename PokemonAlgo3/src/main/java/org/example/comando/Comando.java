package org.example.comando;

public abstract class Comando implements ComandoManejable {
    ComandoManejable proximoComando;

    @Override
    public void ejecutar() {
        this.ejecutarEsteComando();
        this.proximoComando.ejecutar();
    }

    protected abstract void ejecutarEsteComando();

    public void setNextComando(ComandoManejable comando) {
        this.proximoComando = comando;
    }
}
