package org.example.Estadisticas;

import org.example.Elemento.Element;

public abstract class Estadisticas implements EstadisticaModificable {
    Double maxVida;
    Double vida;
    Double nivel;
    Double velocidad;
    Double defensa;
    Double ataque;
    Element elemento;

    public boolean sigueVivo(Double vida) {
        return this.vida > 0.0;
    }

    public abstract Double getNivel();


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

    public void bajarVida(Double danio) {
        this.vida -= danio;
    }

    public void variarDefensa(Double varDefensa) {
        this.defensa += varDefensa;
    }

    public void variarVelocidad(Double varVelocidad) {
        this.velocidad += varVelocidad;
    }
}
