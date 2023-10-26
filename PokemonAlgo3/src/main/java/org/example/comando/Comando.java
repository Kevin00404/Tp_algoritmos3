package org.example.comando;

public abstract class Comando implements ComandoManejable {
    ComandoManejable anteriorComando = null;

    @Override
    public void ejecutar() {
        if (this.anteriorComando != null){
            this.anteriorComando.ejecutar();
        }
        this.ejecutarEsteComando();
    }

    protected abstract void ejecutarEsteComando();

    public void concatComands(ComandoManejable comando){
        if (this.anteriorComando != null){
            this.anteriorComando.concatComands(comando);
        } else {
            this.anteriorComando = comando;
        }
    }
}
