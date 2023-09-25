package org.example.Elemento;

public class Planta extends Element {
    public Planta(){
        nombre_tipo = "Planta";
    }
    @Override
    public Double mixElement(Element element)
    {
        return element.multiplicador_danio_tipo(this);
    }
    public Double multiplicador_danio_tipo(Fuego fuego){
        return 2*1.0;
    }
    public Double multiplicador_danio_tipo(Agua agua){
        return 0.5*1.0;
    }
    public Double multiplicador_danio_tipo(Bicho bicho){
        return 2*1.0;
    }
    public Double multiplicador_danio_tipo(Dragon dragon){
        return 1.0;
    }
    public Double multiplicador_danio_tipo(Electrico electrico){
        return 0.5*1.0;
    }
    public Double multiplicador_danio_tipo(Fantasma fuego) {
        return 1.0;
    }
    public Double multiplicador_danio_tipo(Hielo hielo){
        return 2*1.0;
    }
    public Double multiplicador_danio_tipo(Lucha lucha){
        return 1.0;
    }
    public Double multiplicador_danio_tipo(Normal normal){
        return 1.0;
    }
    public Double multiplicador_danio_tipo(Planta planta){
        return 0.5*1.0;
    }
    public Double multiplicador_danio_tipo(Psiquico psiquico){
        return 1.0;
    }
    public Double multiplicador_danio_tipo(Roca roca){
        return 1.0;
    }
    public Double multiplicador_danio_tipo(Tierra tierra){
        return 0.5*1.0;
    }
    public Double multiplicador_danio_tipo(Veneno veneno){
        return 2*1.0;
    }
    public Double multiplicador_danio_tipo(Volador volador){
        return 2*1.0;
    }
}
