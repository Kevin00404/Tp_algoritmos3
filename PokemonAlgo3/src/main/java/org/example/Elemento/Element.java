package org.example.Elemento;

public interface Element {
    public String get_tipo();
    public Double bonus_mismo_tipo(Element element);
    public Double danio_final(Fuego fuego, Double danio_base);
    public Double danio_final(Agua agua, Double danio_base);
    public Double danio_final(Bicho bicho, Double danio_base);
    public Double danio_final(Dragon dragon, Double danio_base);
    public Double danio_final(Electrico electrico, Double danio_base);
    public Double danio_final(Fantasma fuego, Double danio_base);
    public Double danio_final(Hielo hielo, Double danio_base);
    public Double danio_final(Lucha lucha, Double danio_base);
    public Double danio_final(Normal normal, Double danio_base);
    public Double danio_final(Planta planta, Double danio_base);
    public Double danio_final(Psiquico psiquico, Double danio_base);
    public Double danio_final(Roca roca, Double danio_base);
    public Double danio_final(Tierra tierra, Double danio_base);
    public Double danio_final(Veneno veneno, Double danio_base);
    public Double danio_final(Volador volador, Double danio_base);
}
