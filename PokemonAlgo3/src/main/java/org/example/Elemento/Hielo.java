package org.example.Elemento;

public class Hielo extends Element {
    public Hielo(){
        String nombre_tipo = "Hielo";
    }
    @Override
    public Double mixElement(Element element)
    {
        return element.multiplicador_danio_tipo(this);
    }
    @Override
    public Double multiplicador_danio_tipo(Fuego fuego){
        return 2*1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Agua agua){
        return 1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Bicho bicho){
        return 1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Dragon dragon){
        return 1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Electrico electrico){
        return 1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Fantasma fuego) {
        return 1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Hielo hielo){
        return 0.5*1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Lucha lucha){
        return 2*1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Normal normal){
        return 1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Planta planta){
        return 1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Psiquico psiquico){
        return 1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Roca roca){
        return 2*1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Tierra tierra){
        return 1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Veneno veneno){
        return 1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Volador volador){
        return 1.0;
    }
}
