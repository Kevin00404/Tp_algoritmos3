package org.example.habilidad;

import org.example.Clima.*;
import org.example.Elemento.*;
import org.example.Estadistica.ModAtaque;
import org.example.Estadistica.ModDefensa;
import org.example.Estadistica.ModVelocidad;
import org.example.JSON.LeerArchivoJson;
import org.example.Log.Log;
import org.example.estado.EstadoConfuso;
import org.example.estado.EstadoDormido;
import org.example.estado.EstadoEnvenenado;
import org.example.estado.EstadoParalizado;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Random;
import java.util.Hashtable;

public class HabilidadesFactory implements HabilidadesFactoryI{
    private Hashtable<Integer, Habilidad> habilidades;
    private Hashtable<Integer, Habilidad> bibliotecaHabilidades;
    public HabilidadesFactory(){
        bibliotecaHabilidades = new Hashtable<Integer, Habilidad>();
        habilidades = new Hashtable<Integer, Habilidad>();
        crearBibliotecaConJSON("HabilidadesAtaque.json");
        crearBibliotecaConJSON("HabilidadesEstadistica.json");
        crearBibliotecaConJSON("HabilidadesEstado.json");
        crearBibliotecaConJSON("HabilidadesTerreno.json");
        //generadorHabilidadesRandom();
        generarHabilidadesEspecificas();
    }

    private void generadorHabilidadesRandom() {
        habilidades.put(1, bibliotecaHabilidades.get(randBiblioRango()));
        habilidades.put(2, bibliotecaHabilidades.get(randBiblioRango()));
        habilidades.put(3, bibliotecaHabilidades.get(randBiblioRango()));
        habilidades.put(4, bibliotecaHabilidades.get(randBiblioRango()));
    }

    private void generarHabilidadesEspecificas(){
        habilidades.put(1, bibliotecaHabilidades.get(1));
        habilidades.put(2, bibliotecaHabilidades.get(31));
        habilidades.put(3, bibliotecaHabilidades.get(71));
        habilidades.put(4, bibliotecaHabilidades.get(72));
    }

    public void agregarHabilidad(Habilidad habilidad, Integer num){
        if (num < 1 || num > 4){
            Log.getLog().log("El pokemon no tiene mas de 4 habilidades");
            return;
        }
        habilidades.put(num, habilidad);
    }

    @Override
    public Hashtable<Integer, Habilidad> habilidades() {
        return habilidades;
    }

    public Integer randBiblioRango(){
        Random rand = new Random();
        Integer num = rand.nextInt(71);
        return num + 1;
    }

    private void crearBiblioteca() {
        bibliotecaHabilidades.put(1, new HabilidadAtaque("ascuas", 25, new Fuego(), 40.0));
        bibliotecaHabilidades.put(2, new HabilidadAtaque("lanzallamas", 25, new Fuego(), 90.0));
        bibliotecaHabilidades.put(3, new HabilidadAtaque("hidroCanion", 25, new Agua(), 150.0));
        bibliotecaHabilidades.put(4, new HabilidadAtaque("rayoBurbuja", 25, new Agua(), 65.0));
        bibliotecaHabilidades.put(5, new HabilidadAtaque("corteFuria", 25, new Bicho(), 40.0));
        bibliotecaHabilidades.put(6, new HabilidadAtaque("picadura", 25, new Bicho(), 60.0));
        bibliotecaHabilidades.put(7, new HabilidadAtaque("cargaDragon", 25, new Dragon(), 100.0));
        bibliotecaHabilidades.put(8, new HabilidadAtaque("pulsoDragon", 25, new Dragon(), 80.0));
        bibliotecaHabilidades.put(9, new HabilidadAtaque("impactrueno", 25, new Electrico(), 40.0));
        bibliotecaHabilidades.put(10, new HabilidadAtaque("electrocanion", 1, new Electrico(), 120.0));
        bibliotecaHabilidades.put(11, new HabilidadAtaque("bolaSombra", 25, new Fantasma(), 80.0));
        bibliotecaHabilidades.put(12, new HabilidadAtaque("poltergeist", 25, new Fantasma(), 110.0));
        bibliotecaHabilidades.put(13, new HabilidadAtaque("rayoHielo", 25, new Hielo(), 90.0));
        bibliotecaHabilidades.put(14, new HabilidadAtaque("ventisca", 25, new Hielo(), 110.0));
        bibliotecaHabilidades.put(15, new HabilidadAtaque("demolicion", 25, new Lucha(), 75.0));
        bibliotecaHabilidades.put(16, new HabilidadAtaque("doblePatada", 25, new Lucha(), 60.0));
        bibliotecaHabilidades.put(17, new HabilidadAtaque("placaje", 25, new Normal(), 40.0));
        bibliotecaHabilidades.put(18, new HabilidadAtaque("corte", 25, new Normal(), 50.0));
        bibliotecaHabilidades.put(19, new HabilidadAtaque("latigoCepa", 25, new Planta(), 45.0));
        bibliotecaHabilidades.put(20, new HabilidadAtaque("clorofilaser", 25, new Planta(), 120.0));
        bibliotecaHabilidades.put(21, new HabilidadAtaque("comeSuenios", 25, new Psiquico(), 100.0));
        bibliotecaHabilidades.put(22, new HabilidadAtaque("psicoRayo", 25, new Psiquico(), 65.0));
        bibliotecaHabilidades.put(23, new HabilidadAtaque("avalancha", 25, new Roca(), 75.0));
        bibliotecaHabilidades.put(24, new HabilidadAtaque("lanzaRocas", 25, new Roca(), 50.0));
        bibliotecaHabilidades.put(25, new HabilidadAtaque("disparoLodo", 25, new Tierra(), 55.0));
        bibliotecaHabilidades.put(26, new HabilidadAtaque("terremoto", 25, new Tierra(), 100.0));
        bibliotecaHabilidades.put(27, new HabilidadAtaque("acido", 25, new Veneno(), 40.0));
        bibliotecaHabilidades.put(28, new HabilidadAtaque("residuos", 25, new Veneno(), 65.0));
        bibliotecaHabilidades.put(29, new HabilidadAtaque("picoteo", 25, new Volador(), 60.0));
        bibliotecaHabilidades.put(30, new HabilidadAtaque("tornado", 25, new Volador(), 40.0));
        bibliotecaHabilidades.put(31, new HabilidadModificacionEstadistica("domador" , 25, new ModDefensa(20.0)));
        bibliotecaHabilidades.put(32, new HabilidadModificacionEstadistica("descarga" , 25, new ModDefensa(20.0)));
        bibliotecaHabilidades.put(33, new HabilidadModificacionEstadistica("ignicion" , 25, new ModDefensa(20.0)));
        bibliotecaHabilidades.put(34, new HabilidadModificacionEstadistica("mantoFrondoso" , 25, new ModDefensa(20.0)));
        bibliotecaHabilidades.put(35, new HabilidadModificacionEstadistica("escamaEspecial" , 25, new ModDefensa(20.0)));
        bibliotecaHabilidades.put(36, new HabilidadModificacionEstadistica("rociador" , 25, new ModDefensa(20.0)));
        bibliotecaHabilidades.put(37, new HabilidadModificacionEstadistica("defensaLodo" , 25, new ModDefensa(20.0)));
        bibliotecaHabilidades.put(38, new HabilidadModificacionEstadistica("domado",25, new ModDefensa(-20.0)));
        bibliotecaHabilidades.put(39, new HabilidadModificacionEstadistica("voltaje",25, new ModDefensa(-20.0)));
        bibliotecaHabilidades.put(40, new HabilidadModificacionEstadistica("mareoIgneo",25, new ModDefensa(-20.0)));
        bibliotecaHabilidades.put(41, new HabilidadModificacionEstadistica("enredadera",25, new ModDefensa(-20.0)));
        bibliotecaHabilidades.put(42, new HabilidadModificacionEstadistica("mareoEscamoso",25, new ModDefensa(-20.0)));
        bibliotecaHabilidades.put(43, new HabilidadModificacionEstadistica("chapotear",25, new ModDefensa(-20.0)));
        bibliotecaHabilidades.put(44, new HabilidadModificacionEstadistica("lanzaLodo",25, new ModDefensa(-20.0)));
        bibliotecaHabilidades.put(45, new HabilidadModificacionEstadistica("ojoCompuesto", 25, new ModAtaque(20.0)));
        bibliotecaHabilidades.put(46, new HabilidadModificacionEstadistica("torrente", 25, new ModAtaque(20.0)));
        bibliotecaHabilidades.put(47, new HabilidadModificacionEstadistica("paraRayos", 25, new ModAtaque(20.0)));
        bibliotecaHabilidades.put(48, new HabilidadModificacionEstadistica("intimidacion", 25, new ModAtaque(-5.0)));
        bibliotecaHabilidades.put(49, new HabilidadModificacionEstadistica("sumergido", 25, new ModAtaque(-5.0)));
        bibliotecaHabilidades.put(50, new HabilidadModificacionEstadistica("enterrado", 25, new ModAtaque(-5.0)));
        bibliotecaHabilidades.put(51, new HabilidadModificacionEstadistica("impulso", 25, new ModVelocidad(20.0)));
        bibliotecaHabilidades.put(52, new HabilidadModificacionEstadistica("nadoRapido", 25, new ModVelocidad(20.0)));
        bibliotecaHabilidades.put(53, new HabilidadModificacionEstadistica("clorofila", 25, new ModVelocidad(20.0)));
        bibliotecaHabilidades.put(54, new HabilidadModificacionEstadistica("coabrdia", 25, new ModVelocidad(-20.0)));
        bibliotecaHabilidades.put(55, new HabilidadModificacionEstadistica("colaSurf", 25, new ModVelocidad(-20.0)));
        bibliotecaHabilidades.put(56, new HabilidadModificacionEstadistica("impetuArena", 25, new ModVelocidad(-20.0)));
        bibliotecaHabilidades.put(57, new HabilidadModificacionEstado("chispa", 25, new EstadoParalizado()));
        bibliotecaHabilidades.put(58, new HabilidadModificacionEstado("dragonAliento", 25, new EstadoParalizado()));
        bibliotecaHabilidades.put(59, new HabilidadModificacionEstado("salpikaSurf", 25, new EstadoParalizado()));
        bibliotecaHabilidades.put(60, new HabilidadModificacionEstado("paralizador", 25, new EstadoParalizado()));
        bibliotecaHabilidades.put(61, new HabilidadModificacionEstado("palmeo", 25, new EstadoParalizado()));
        bibliotecaHabilidades.put(62, new HabilidadModificacionEstado("bostezo", 25, new EstadoDormido()));
        bibliotecaHabilidades.put(63, new HabilidadModificacionEstado("espora", 25, new EstadoDormido()));
        bibliotecaHabilidades.put(64, new HabilidadModificacionEstado("gigasopor", 25, new EstadoDormido()));
        bibliotecaHabilidades.put(65, new HabilidadModificacionEstado("hipnosis", 25, new EstadoDormido()));
        bibliotecaHabilidades.put(66, new HabilidadModificacionEstado("besoAmoroso", 25, new EstadoDormido()));
        bibliotecaHabilidades.put(67, new HabilidadModificacionEstado("bombaLodo", 25, new EstadoEnvenenado()));
        bibliotecaHabilidades.put(68, new HabilidadModificacionEstado("gasVenenoso", 25, new EstadoEnvenenado()));
        bibliotecaHabilidades.put(69, new HabilidadModificacionEstado("gigaDescarga", 25, new EstadoEnvenenado()));
        bibliotecaHabilidades.put(70, new HabilidadModificacionEstado("gigaEstupor", 25, new EstadoEnvenenado()));
        bibliotecaHabilidades.put(71, new HabilidadModificacionEstado("picotazoVeneno", 25, new EstadoEnvenenado()));
        bibliotecaHabilidades.put(72, new HabilidadModificacionEstado("psiquico", 25, new EstadoConfuso()));
        bibliotecaHabilidades.put(73, new HabilidadModificacionTerreno("dia soleado", 25, new Soleado()));
        bibliotecaHabilidades.put(74, new HabilidadModificacionTerreno("lluvia", 25, new Lluvia()));
        bibliotecaHabilidades.put(75, new HabilidadModificacionTerreno("granizo", 25, new Granizo()));
        bibliotecaHabilidades.put(76, new HabilidadModificacionTerreno("tormenta rayo", 25, new TormentaDeRayo()));
        bibliotecaHabilidades.put(77, new HabilidadModificacionTerreno("tormenta de arena", 25, new TormentaDeArena()));
        bibliotecaHabilidades.put(78, new HabilidadModificacionTerreno("neblina", 25, new Niebla()));
        bibliotecaHabilidades.put(79, new HabilidadModificacionTerreno("huracan", 25, new Huracan()));
    }

    public void crearBibliotecaConJSON(String path) {
        LeerArchivoJson json = new LeerArchivoJson();
        JSONArray habilidades = json.obtenerArrayJSON(path);
        for (int i = 0; i < habilidades.size(); i++){
            crearHabilidad((JSONObject) habilidades.get(i));
        }
    }

    private void crearHabilidad(JSONObject habilidad) {
        if (habilidad.get("tipo").equals("")) {
            Long potencia = (Long) habilidad.get("potencia");
            bibliotecaHabilidades.put(Math.toIntExact((Long) habilidad.get("id")), new HabilidadAtaque((String) habilidad.get("nombre"), Math.toIntExact((Long) habilidad.get("disponibles")), obtenerElemento((String) habilidad.get("elemento")), potencia.doubleValue()));
        } else if (((habilidad.get("tipo")).equals("defensa"))) {
            Long valor = (Long) habilidad.get("valor");
            bibliotecaHabilidades.put(Math.toIntExact((Long) habilidad.get("id")), new HabilidadModificacionEstadistica((String) habilidad.get("nombre"), Math.toIntExact((Long) habilidad.get("disponibles")), new ModDefensa(valor.doubleValue())));
        } else if (((habilidad.get("tipo")).equals("ataque"))) {
            Long valor = (Long) habilidad.get("valor");
            bibliotecaHabilidades.put(Math.toIntExact((Long) habilidad.get("id")), new HabilidadModificacionEstadistica((String) habilidad.get("nombre"), Math.toIntExact((Long) habilidad.get("disponibles")), new ModAtaque(valor.doubleValue())));
        } else if (((habilidad.get("tipo")).equals("velocidad"))) {
            Long valor = (Long) habilidad.get("valor");
            bibliotecaHabilidades.put(Math.toIntExact((Long) habilidad.get("id")), new HabilidadModificacionEstadistica((String) habilidad.get("nombre"), Math.toIntExact((Long) habilidad.get("disponibles")), new ModVelocidad(valor.doubleValue())));
        } else if (((habilidad.get("tipo")).equals("dormido"))) {
            bibliotecaHabilidades.put(Math.toIntExact((Long) habilidad.get("id")), new HabilidadModificacionEstado((String) habilidad.get("nombre"), Math.toIntExact((Long) habilidad.get("disponibles")), new EstadoDormido()));
        } else if (((habilidad.get("tipo")).equals("envenenado"))) {
            bibliotecaHabilidades.put(Math.toIntExact((Long) habilidad.get("id")), new HabilidadModificacionEstado((String) habilidad.get("nombre"), Math.toIntExact((Long) habilidad.get("disponibles")), new EstadoEnvenenado()));
        } else if (((habilidad.get("tipo")).equals("paralizado"))) {
            bibliotecaHabilidades.put(Math.toIntExact((Long) habilidad.get("id")), new HabilidadModificacionEstado((String) habilidad.get("nombre"), Math.toIntExact((Long) habilidad.get("disponibles")), new EstadoParalizado()));
        } else if (((habilidad.get("tipo")).equals("confuso"))) {
            bibliotecaHabilidades.put(Math.toIntExact((Long) habilidad.get("id")), new HabilidadModificacionEstado((String) habilidad.get("nombre"), Math.toIntExact((Long) habilidad.get("disponibles")), new EstadoConfuso()));
        } else if (((habilidad.get("tipo")).equals("soleado"))) {
            bibliotecaHabilidades.put(Math.toIntExact((Long) habilidad.get("id")), new HabilidadModificacionTerreno((String) habilidad.get("nombre"), Math.toIntExact((Long) habilidad.get("disponibles")), new Soleado()));
        } else if (((habilidad.get("tipo")).equals("lluvia"))) {
            bibliotecaHabilidades.put(Math.toIntExact((Long) habilidad.get("id")), new HabilidadModificacionTerreno((String) habilidad.get("nombre"), Math.toIntExact((Long) habilidad.get("disponibles")), new Lluvia()));
        } else if (((habilidad.get("tipo")).equals("granizo"))) {
            bibliotecaHabilidades.put(Math.toIntExact((Long) habilidad.get("id")), new HabilidadModificacionTerreno((String) habilidad.get("nombre"), Math.toIntExact((Long) habilidad.get("disponibles")), new Granizo()));
        } else if (((habilidad.get("tipo")).equals("tormentaDeRayo"))) {
            bibliotecaHabilidades.put(Math.toIntExact((Long) habilidad.get("id")), new HabilidadModificacionTerreno((String) habilidad.get("nombre"), Math.toIntExact((Long) habilidad.get("disponibles")), new TormentaDeRayo()));
        } else if (((habilidad.get("tipo")).equals("tormentaDeArena"))) {
            bibliotecaHabilidades.put(Math.toIntExact((Long) habilidad.get("id")), new HabilidadModificacionTerreno((String) habilidad.get("nombre"), Math.toIntExact((Long) habilidad.get("disponibles")), new TormentaDeArena()));
        } else if (((habilidad.get("tipo")).equals("niebla"))) {
            bibliotecaHabilidades.put(Math.toIntExact((Long) habilidad.get("id")), new HabilidadModificacionTerreno((String) habilidad.get("nombre"), Math.toIntExact((Long) habilidad.get("disponibles")), new Niebla()));
        } else if (((habilidad.get("tipo")).equals("huracan"))) {
            bibliotecaHabilidades.put(Math.toIntExact((Long) habilidad.get("id")), new HabilidadModificacionTerreno((String) habilidad.get("nombre"), Math.toIntExact((Long) habilidad.get("disponibles")), new Huracan()));
        }
    }

    private Element obtenerElemento(String elemento) {
        if (elemento.equals("agua")){
            return new Agua();
        }else if (elemento.equals("bicho")){
            return new Bicho();
        } else if (elemento.equals("dragon")) {
            return new Dragon();
        } else if (elemento.equals("electrico")) {
            return new Electrico();
        } else if (elemento.equals("fantasma")) {
            return new Fantasma();
        } else if (elemento.equals("fuego")) {
            return new Fuego();
        } else if (elemento.equals("hielo")) {
            return new Hielo();
        } else if (elemento.equals("lucha")) {
            return new Lucha();
        } else if (elemento.equals("normal")) {
            return new Normal();
        } else if (elemento.equals("planta")) {
            return new Planta();
        } else if (elemento.equals("psiquico")) {
            return new Psiquico();
        } else if (elemento.equals("roca")) {
            return new Roca();
        } else if (elemento.equals("tierra")){
            return new Tierra();
        } else if (elemento.equals("veneno")) {
            return new Veneno();
        } else if (elemento.equals("volador")) {
            return new Volador();
        }
        return null;
    }
}
