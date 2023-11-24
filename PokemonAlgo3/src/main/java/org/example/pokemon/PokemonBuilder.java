package org.example.pokemon;

import org.example.Elemento.Agua;
import org.example.Elemento.*;
import org.example.Estadisticas.EstadisticaFactoryI;
import org.example.Estadisticas.Estadisticas;
import org.example.Estadisticas.EstadisticaFactory;
import org.example.JSON.LeerArchivoJson;
import org.example.estado.Estado;
import org.example.estado.EstadoNormal;
import org.example.habilidad.Habilidad;
import org.example.habilidad.HabilidadesFactoryI;
import org.example.habilidad.HabilidadesFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Hashtable;
import java.util.List;
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

    JSONArray arrayPkmns;

    public PokemonBuilder(){
        bibliotecaElemento = new Hashtable<Integer, Element>();
        armarElementoDiccionario();
        elemento = getElementoRandom();
        habilidadesFactory = new HabilidadesFactory();
        estadisticasFactory = new EstadisticaFactory(elemento);
        estadisticas = estadisticasFactory.crearEstadisticas();
        habilidades = habilidadesFactory.habilidades();
        nombre = "???";
        historia = "???";
        estado = new EstadoNormal();
        arrayPkmns = crearPokemonesConJSON("Pokemones.json");
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
        estadisticasFactory = new EstadisticaFactory(elemento);
        estadisticas = estadisticasFactory.crearEstadisticas();
        return this;
    }

    public PokemonBuilder setElemento(Element elemento, JSONObject pokemonObjeto){
        this.elemento = elemento;
        estadisticasFactory = new EstadisticaFactory(elemento);
        estadisticas = estadisticasFactory.crearEstadisticasEspecificas(pokemonObjeto);
        habilidades = habilidadesFactory.crearHabilidadesEspecificas(pokemonObjeto);
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
        Random rand = new Random(10);
        return bibliotecaElemento.get(rand.nextInt(14)+1);
    }

    public JSONArray crearPokemonesConJSON(String path){
        LeerArchivoJson json = new LeerArchivoJson();
        JSONArray pokemones = json.obtenerArrayJSON(path);
        return pokemones;
    }

    private Integer obtenerIdRandom(Integer total) {
        Random rng = new Random();
        Integer id = rng.nextInt(total) + 1;
        return id;
    }

    public Pokemon generarPokemon(List<Integer> ids) {
        Integer id = obtenerIdRandom(arrayPkmns.size());
        while (ids.contains(id)){
            id = obtenerIdRandom(arrayPkmns.size());
        }
        ids.add(id);
        JSONObject pkmnEspecifico = encontrarPokemon(id);
        return setNombre((String) pkmnEspecifico.get("nombre")).setElemento(getElemento((String) pkmnEspecifico.get("tipo")), pkmnEspecifico).setHistoria((String) pkmnEspecifico.get("historia")).crearPokemon();
    }

    private Element getElemento(String elemento) {
        if (elemento.equals("fuego")){
            return new Fuego();
        } else if (elemento.equals("agua")){
            return new Agua();
        } else if (elemento.equals("bicho")){
            return new Bicho();
        } else if (elemento.equals("dragon")){
            return new Dragon();
        } else if (elemento.equals("electrico")){
            return new Electrico();
        } else if (elemento.equals("fantasma")){
            return new Fantasma();
        } else if (elemento.equals("hielo")){
            return new Hielo();
        } else if (elemento.equals("lucha")){
            return new Lucha();
        } else if (elemento.equals("normal")){
            return new Normal();
        } else if (elemento.equals("planta")){
            return new Planta();
        } else if (elemento.equals("psiquico")){
            return new Psiquico();
        } else if (elemento.equals("roca")){
            return new Roca();
        } else if (elemento.equals("Tierra")){
            return new Tierra();
        } else if (elemento.equals("veneno")){
            return new Veneno();
        } else {
            return new Volador();
        }
    }

    private org.json.simple.JSONObject encontrarPokemon(Integer id) {
        Boolean flag = true;
        org.json.simple.JSONObject pkmn = null;
        Integer i = 0;
        while (flag){
            pkmn = (org.json.simple.JSONObject) arrayPkmns.get(i);
            if (id == ((Long) pkmn.get("id")).intValue()){
                flag = false;
            } else {
                i++;
            }
        }
        return pkmn;
    }
}
