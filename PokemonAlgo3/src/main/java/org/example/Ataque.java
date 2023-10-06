package org.example;

import org.example.estado.Estado;

public class Ataque {
    Double poder;
    Double critico;
    Double ataque;
    Double defensa;
    Double mismoTipo;
    Double tipo;
    Double random;
    Double nivel;
    Estado estadoACambiar;
    Double varianteAtaque;
    Double varianteDefensa;
    Double varianteVelocidad;
    Double varianteVida;



    public Ataque(){
        this.random = 1.0;
        this.critico = 1.0;
        this.varianteAtaque = 0.0;
        this.varianteDefensa = 0.0;
        this.varianteVelocidad = 0.0;
        this.varianteVida = 0.0;
    }

    public void setEstado(Estado estadoACambiar) {
        this.estadoACambiar = estadoACambiar;
    }
    public Estado cambiarEstado(Estado estado){

        return estado.setEstadoActual(this.estadoACambiar);
    }


public void setVarAtaque(Double varAtaque){
    System.out.println("se modifica la ataque por: " + varAtaque);
    this.varianteAtaque=varAtaque;
}
    public void setVarVida(Double varVida){
        System.out.println("se modifica la vida por: " + varVida);
        this.varianteVida=varVida;
    }
    public void setVarDefensa(Double varDefensa){
        System.out.println("se modifica la defensa por: " + varDefensa);
        this.varianteDefensa=varDefensa;
    }
    public void setVarVelocidad(Double varVelocidad){
        System.out.println("se modifica la velocidad por: " + varVelocidad);
        this.varianteVelocidad=varVelocidad;
    }

    public void setAtaque(Double ataque){
        this.ataque = ataque;
    }
    public void setDefensa(Double defensa){
        this.defensa = defensa;
    }
    public void setPoder(Double poder){
        this.poder = poder;
    }
    public void setMismoTipo(Double mismoTipo){
        this.mismoTipo = mismoTipo;
    }
    public void setTipo(Double tipo){
        this.tipo = tipo;
    }

    public void setNivel(Double nivel){
        this.nivel = nivel;
    }


    public Double calcular_danio() {
        return (((2 * nivel * critico * poder * (ataque/defensa))/5 + 2)/50)* mismoTipo * tipo * random;
    }

    public Double getVarianteVida() {
        return this.varianteVida;
    }
    public Double getVarianteVelocidad() {
        return this.varianteVelocidad;
    }

    public Double getVarianteDefensa() {
        return this.varianteDefensa;
    }

    public Double getVarianteAtaque() {
        return this.varianteAtaque;
    }
}
