package org.example.Elemento;

public abstract class Element {

    final  double MATCH_TIPO_ATAQUE_Y_POKEMON=1.5;
    final double NO_MATCH_TIPO_ATAQUE_Y_POKEMON=1.0;
    String nombre_tipo;
    public String get_tipo()
    {
        return this.nombre_tipo;
    }
    public Double bonus_mismo_tipo(Element element)
    {
        System.out.println("Elemento de ataque: " + this.get_tipo() + "     Elemento de pokemon: " + element.get_tipo());
        if (this.nombre_tipo == element.get_tipo()){
            return MATCH_TIPO_ATAQUE_Y_POKEMON;
        }
        return NO_MATCH_TIPO_ATAQUE_Y_POKEMON;
    }
    public abstract Double multiplicador_danio_tipo(Fuego fuego);
    public abstract Double multiplicador_danio_tipo(Agua agua);
    public abstract Double multiplicador_danio_tipo(Bicho bicho);
    public abstract Double multiplicador_danio_tipo(Dragon dragon);
    public abstract Double multiplicador_danio_tipo(Electrico electrico);
    public abstract Double multiplicador_danio_tipo(Fantasma fuego);
    public abstract Double multiplicador_danio_tipo(Hielo hielo);
    public abstract Double multiplicador_danio_tipo(Lucha lucha);
    public abstract Double multiplicador_danio_tipo(Normal normal);
    public abstract Double multiplicador_danio_tipo(Planta planta);
    public abstract Double multiplicador_danio_tipo(Psiquico psiquico);
    public abstract Double multiplicador_danio_tipo(Roca roca);
    public abstract Double multiplicador_danio_tipo(Tierra tierra);
    public abstract Double multiplicador_danio_tipo(Veneno veneno);
    public abstract Double multiplicador_danio_tipo(Volador volador);
    public Double multiplicador_danio_tipo(Element element) {
        System.out.println("ERROR, Madre efectua calculo que deberia efectuar hijo");
        return 0.0;
    }

    public Double mixElement(Element element)
    {
        return element.multiplicador_danio_tipo(this);
    }
}
