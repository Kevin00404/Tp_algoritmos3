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
    }

    public void setEstado(Estado estadoACambiar) {
        this.estadoACambiar = estadoACambiar;
    }
public Estado cambiarEstado(Estado estado){
        estado.setEstadoActual(this.estadoACambiar);
        System.out.println("El estado del pokemon ahora es " + this.estadoACambiar);
        return estado.setEstadoActual(this.estadoACambiar);
}


public void setVarAtaque(Double varAtaque){
        this.varianteAtaque=varAtaque;
}
    public void setVarVida(Double varVida){
        this.varianteAtaque=varVida;
    }
    public void setVarDefensa(Double varDefensa){
        this.varianteAtaque=varDefensa;
    }
    public void setVarVelocidad(Double varVelocidad){
        this.varianteAtaque=varVelocidad;
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
        System.out.println("nivel: " + nivel + "    critico: " + critico + "    poder: " + poder + "    ataque: " + ataque + "  defensa: " + defensa + "    mismoTipo: " + mismoTipo + "    tipo: " + tipo + "  random: " + random);
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
