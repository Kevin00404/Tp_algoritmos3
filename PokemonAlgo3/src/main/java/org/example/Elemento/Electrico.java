package org.example.Elemento;

public class Electrico extends Element {
    public Electrico(){
        nombre_tipo = "Electrico";
    }
    @Override
    public Double bonus_mismo_tipo(Element element)
    {
        System.out.println("Elemento de ataque: " + this.get_tipo() + "     Elemento de pokemon: " + element.get_tipo());
        if (this.nombre_tipo == element.get_tipo()){
            return MATCH_TIPO_ATAQUE_Y_POKEMON;
        }
        return NO_MATCH_TIPO_ATAQUE_Y_POKEMON;
    }
    @Override
    public Double mixElement(Element element)
    {
        return element.multiplicador_danio_tipo(this);
    }
    @Override
    public Double multiplicador_danio_tipo(Fuego fuego){
        return 1.0;
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
        return 0.5*1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Fantasma fuego) {
        return 1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Hielo hielo){
        return 1.0;
    }
    @Override

    public Double multiplicador_danio_tipo(Lucha lucha){
        return 1.0;
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
        return 1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Tierra tierra){
        return 2*1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Veneno veneno){
        return 1.0;
    }
    @Override
    public Double multiplicador_danio_tipo(Volador volador){
        return 0.5*1.0;
    }
}
