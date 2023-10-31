package org.example.Estadisticas;

import org.example.Elemento.Element;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.estado.Estado;
import org.example.estado.EstadoDebilitado;

public abstract class Estadisticas implements EstadisticaModificable {
    Double maxVida;
    Double vida;
    Double nivel;
    Double velocidad;
    Double defensa;
    Double ataque;
    Element elemento;

    public boolean sigueVivo() {
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
        System.out.println("Hago " + danio + " de danio");
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
        return new ComandoMensaje("lvl: " + nivel + "\t vida: " + vida +" ataque: "+ ataque +"\ndefensa: " + defensa+ "\nvelocidad: " + velocidad);
    }

    public Estado envenenar() {
        this.vida -= 5.0;
        if (!sigueVivo()){
            vida = 0.0;
            return new EstadoDebilitado();
        }
        return null;
    }

    public Estado confundirse(){
        this.vida -= (this.vida * 15)/100;
        if (!sigueVivo()){
            vida = 0.0;
            return new EstadoDebilitado();
        }
        return null;
    }

    public Double getVida() {
        return vida;
    }
}
