package org.example;

public class Ataque {
    Double poder;
    Double critico;
    Double ataque;
    Double defensa;
    Double mismoTipo;
    Double tipo;
    Double random;
    Double nivel;

    public Ataque(){
        this.random = 1.0;
        this.critico = 1.0;
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
}
