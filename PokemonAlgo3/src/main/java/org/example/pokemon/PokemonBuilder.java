package org.example.pokemon;

import org.example.Elemento.Agua;
import org.example.Elemento.*;
import org.example.Estadisticas.EstadisticaFactoryI;
import org.example.Estadisticas.Estadisticas;
import org.example.Estadisticas.EstadisticaFactory;
import org.example.estado.Estado;
import org.example.estado.EstadoNormal;
import org.example.habilidad.Habilidad;
import org.example.habilidad.HabilidadesFactoryI;
import org.example.habilidad.HabilidadesFactory;

import java.util.Hashtable;
import java.util.Random;

public class PokemonBuilder implements PokemonBuilderI{
    EstadisticaFactoryI estadisticasFactory;
    HabilidadesFactoryI habilidadesFactory;
    Element elemento;
    String nombre;
    String historia;
    Estado estado;
    Estadisticas estadisticas;
    Hashtable<Integer, Habilidad> habilidades;
    Hashtable<Integer, Element> bibliotecaElemento;

    public PokemonBuilder(){
        bibliotecaElemento = new Hashtable<Integer, Element>();
        armarElementoDiccionario();
        elemento = getElementoRandom();
        habilidadesFactory = new HabilidadesFactory();
        estadisticasFactory = new EstadisticaFactory(elemento);
        estadisticas = estadisticasFactory.crearEstadisticas();
        nombre = "???";
        historia = "???";
        estado = new EstadoNormal();
    }

    private void armarElementoDiccionario() {
        bibliotecaElemento.put(1, new Agua());
        bibliotecaElemento.put(2, new Bicho());
        bibliotecaElemento.put(3, new Dragon());
        bibliotecaElemento.put(4, new Electrico());
        bibliotecaElemento.put(5, new Fantasma());
        bibliotecaElemento.put(6, new Fuego());
        bibliotecaElemento.put(7, new Hielo());
        bibliotecaElemento.put(8, new Lucha());
        bibliotecaElemento.put(9, new Normal());
        bibliotecaElemento.put(10, new Planta());
        bibliotecaElemento.put(11, new Psiquico());
        bibliotecaElemento.put(12, new Roca());
        bibliotecaElemento.put(13, new Tierra());
        bibliotecaElemento.put(14, new Veneno());
        bibliotecaElemento.put(15, new Volador());
    }

    public Pokemon crearPokemon(){
        return new Pokemon(nombre, historia, habilidades, estadisticas);
    }
    public PokemonBuilder setElemento(Element elemento){
        this.elemento = elemento;
        return this;
    }
    public PokemonBuilder setNombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    public PokemonBuilder setHistoria(String historia){
        this.historia = historia;
        return this;
    }
    public PokemonBuilder setHabilidadesFactory(HabilidadesFactory habilidadesFactory){
        this.habilidadesFactory = habilidadesFactory;
        return this;
    }

    public PokemonBuilder setEstadisticaFactory(EstadisticaFactory estadisticaFactory){
        this.estadisticasFactory = estadisticaFactory;
        return this;
    }

    private Element getElementoRandom(){
        Random rand = new Random(15);
        return bibliotecaElemento.get(rand.nextInt(14)+1);
    }
}
