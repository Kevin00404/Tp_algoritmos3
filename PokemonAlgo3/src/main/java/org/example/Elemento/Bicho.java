package org.example.Elemento;

public class Bicho extends Element{
    String nombre_tipo = "Bicho";
    public Bicho(){

    }
    public String get_tipo()
    {
        return nombre_tipo;
    }
    public Double bonus_mismo_tipo(Element elemento) {
        if (this.nombre_tipo == elemento.get_tipo()){
            return 1.5;
        }
        return 1.0;
    }
    @Override
    public Double danio_final(Fuego fuego, Double danio_base){
        return 2*danio_base;
    }
    @Override
    public Double danio_final(Agua agua, Double danio_base){
        return danio_base;
    }/*
    @Override
    public Double danio_final(Bicho bicho, Double danio_base){
        return danio_base;
    }
    @Override
    public Double danio_final(Dragon dragon, Double danio_base){
        return danio_base;
    }
    @Override
    public Double danio_final(Electrico electrico, Double danio_base){
        return danio_base;
    }
    @Override
    public Double danio_final(Fantasma fuego, Double danio_base) {
        return danio_base;
    }
    @Override
    public Double danio_final(Hielo hielo, Double danio_base){
        return danio_base;
    }
    @Override
    public Double danio_final(Lucha lucha, Double danio_base){
        return 0.5*danio_base;
    }
    @Override
    public Double danio_final(Normal normal, Double danio_base){
        return danio_base;
    }
    @Override
    public Double danio_final(Planta planta, Double danio_base){
        return 0.5*danio_base;
    }
    @Override
    public Double danio_final(Psiquico psiquico, Double danio_base){
        return danio_base;
    }
    @Override
    public Double danio_final(Roca roca, Double danio_base){
        return 2*danio_base;
    }
    @Override
    public Double danio_final(Tierra tierra, Double danio_base){
        return 0.5*danio_base;
    }
    @Override
    public Double danio_final(Veneno veneno, Double danio_base){
        return 2*danio_base;
    }
    @Override
    public Double danio_final(Volador volador, Double danio_base){
        return 2*danio_base;
    }*/
}
