package org.example.Estadisticas;

import org.example.Elemento.Element;
import org.example.Log.Log;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.estado.Estado;
import org.example.estado.EstadoDebilitado;

public abstract class Estadisticas implements EstadisticaModificable {
    Double maxVida;
    Double vida;
    Integer nivel;
    Double velocidad;
    Double defensa;
    Double ataque;
    Element elemento;

    public boolean sigueVivo() {
        return this.vida > 0.0;
    }

    public abstract Integer getNivel();


    public Double getAtaque(){
        return this.ataque;
    }


    public Double getDefensa() {
        return this.defensa;
    }

    public Double bufeoReaccionElemento(Element elementoDeAtaque) {
        return elementoDeAtaque.bonus_mismo_tipo(this.elemento);
    }

    public Double debufeoReaccionElemento(Element elementoDeAtaque){
        return elementoDeAtaque.mixElement(this.elemento);
    }

    public Element getElemento() {
        return this.elemento;
    }

    public void bajarVida(Double danio, String mensajeRecibido) {
        this.vida -= danio;
        Log.getLog().log(mensajeRecibido + String.format("%.2f", danio) + " de danio");
    }

    public void variarDefensa(Double varDefensa) {
        this.defensa += varDefensa;
    }

    public void variarVelocidad(Double varVelocidad) {
        this.velocidad += varVelocidad;
    }

    public void variarVida(Double varVida) {
        vida += varVida;
        if (vida > maxVida){
            vida = maxVida;
        }
    }

    public void variarAtaque(Double varAtaque) {
        this.ataque += varAtaque;
    }

    public Comando mostrarEstadisticas() {
        return new ComandoMensaje(
                        "lvl: " + nivel +
                        "\t vida: " + String.format("%.2f", vida) +
                        " ataque: "+ String.format("%.2f", ataque) +
                        "\ndefensa: " + String.format("%.2f", defensa)+
                        "\nvelocidad: " + String.format("%.2f", velocidad)
        );
    }

    public Estado envenenar(String nombrePokemon) {
        Log.getLog().log(nombrePokemon + " esta envenenado, recibio " + 5 +" de danio");
        this.vida -= 5.0;
        if (!sigueVivo()){
            vida = 0.0;
            return new EstadoDebilitado();
        }
        return null;
    }

    public Estado confundir(){
        this.vida -= (maxVida * 0.15);
        if (!sigueVivo()){
            vida = 0.0;
            return new EstadoDebilitado();
        }
        return null;
    }

    public Double getVida() {
        return vida;
    }

    public Double getMaxVida() {
        return maxVida;
    }
}
