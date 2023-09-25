package org.example.Elemento;

public class Roca extends Element {
    public Roca(){
        nombre_tipo = "Roca";
    }
    @Override
    public Double mixElement(Element element)
    {
        return element.multiplicador_danio_tipo(this);
    }
    public Double multiplicador_danio_tipo(Fuego fuego){
        return 0.5*1.0;
    }
    public Double multiplicador_danio_tipo(Agua agua){
        return 2*1.0;
    }
    public Double multiplicador_danio_tipo(Bicho bicho){
        return 1.0;
    }
    public Double multiplicador_danio_tipo(Dragon dragon){
        return 1.0;
    }
    public Double multiplicador_danio_tipo(Electrico electrico){
        return 1.0;
    }
    public Double multiplicador_danio_tipo(Fantasma fuego) {
        return 1.0;
    }
    public Double multiplicador_danio_tipo(Hielo hielo){
        return 1.0;
    }
    public Double multiplicador_danio_tipo(Lucha lucha){
        return 2*1.0;
    }
    public Double multiplicador_danio_tipo(Normal normal){
        return 0.5*1.0;
    }
    public Double multiplicador_danio_tipo(Planta planta){
        return 2*1.0;
    }
    public Double multiplicador_danio_tipo(Psiquico psiquico){
        return 1.0;
    }
    public Double multiplicador_danio_tipo(Roca roca){
        return 1.0;
    }
    public Double multiplicador_danio_tipo(Tierra tierra){
        return 2*1.0;
    }
    public Double multiplicador_danio_tipo(Veneno veneno){
        return 0.5*1.0;
    }
    public Double multiplicador_danio_tipo(Volador volador){
        return 0.5*1.0;
    }
}
