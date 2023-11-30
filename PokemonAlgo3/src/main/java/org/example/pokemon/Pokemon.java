package org.example.pokemon;


import org.example.Estadisticas.Estadisticas;
import org.example.Eventos.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.estado.Estado;
import org.example.estado.EstadoDebilitado;
import org.example.estado.EstadoNormal;
import org.example.habilidad.Habilidad;
import org.example.Log.Log;

import java.util.*;


public class Pokemon {
    String nombre;
    String historia;
    Estado estado;
    Estadisticas estadisticas;
    Dictionary<Integer, Habilidad> habilidades;



    public Pokemon(String nombre, String historia, Hashtable<Integer, Habilidad> habilidades, Estadisticas estadisticas) {
        this.nombre = nombre;
        this.historia = historia;
        this.estado = new EstadoNormal();
        this.habilidades = habilidades;
        this.estadisticas = estadisticas;
    }

    //borrar, constructor hecho solo para hacer test
    public Pokemon(String nombre, String historia, Habilidad habilidad, String estadistica) {
        this.nombre=nombre;
    }


    public String getPrimeraHabilidad() {
        return habilidades.get(1).getNombre();
    }

    public String getSegundaHabilidad() {
        return habilidades.get(2).getNombre();
    }

    public String getTerceraHabilidad() {
        return habilidades.get(3).getNombre();
    }

    public String getCuartaHabilidad() {
        return habilidades.get(4).getNombre();
    }

    public Habilidad getHabilidadUno(){

        return habilidades.get(1);

    }

    public Habilidad getHabilidadDos(){

        return habilidades.get(2);

    }

    public Habilidad getHabilidadTres(){

        return habilidades.get(3);

    }

    public Habilidad getHabilidadCuatro(){

        return habilidades.get(4);

    }

    public void modificarEstado(Estado estado){
        this.estado.agregarEstado(estado);
    }

    public boolean aplicar(Pokemon pokemon /*pokemon a atacar*/, Integer habilidad_a_usar){
        Habilidad habilidad = this.habilidades.get(habilidad_a_usar);
        Comando comandoJugada = habilidad.armarComando(pokemon, this.estadisticas);

        comandoJugada = this.estado.condicionarConSiguienteEstado(comandoJugada, this.estadisticas);
       
      Eventos.getEventos().agregarComando(comandoJugada);
        return true;
    }

    public void aplicarPasivos(){
        if (!estadisticas.sigueVivo()){
            Log.getLog().log("El pokemon " + this.getNombre() + "ha muerto");
            this.estado = new EstadoDebilitado();
        } else {
            this.estado = this.estado.condicionarConSiguienteEstadoPasivo(estadisticas);
        }
    }

    public void recibirDanio(Double danio, String mensajeRecibido) {
        estadisticas.bajarVida(danio, mensajeRecibido);
        chequeoDeVida();
    }


    public boolean chequeoDeVida() {
        if (!estadisticas.sigueVivo()) {
            this.estado = new EstadoDebilitado();
            return false;
        }
        return true;
    }

    //Uso de Items
    public boolean estaDebilitado(){
        return estado.esDebilitado();
    }

    public void debilitar() {
        this.estado = new EstadoDebilitado();
    }

    public Comando datosDeBatalla() {
        Comando mensajeNombre = new ComandoMensaje("Nombre: " + nombre);
        Comando mostrarEstadisticas = estadisticas.mostrarEstadisticas();
        Comando mostrarEstado = estado.mostrarEstado();
        mostrarEstado.concatComands(mostrarEstadisticas);
        mostrarEstadisticas.concatComands(mensajeNombre);
        return mostrarEstado;
    }

    public Estadisticas getEstadisticas() {
        return this.estadisticas;
    }

    public void curarEstado(Estado estadoACurar) {
        this.estado.aceptarSiguienteEstado(estadoACurar);
    }

    public Comando habilitarComandoSiVive(Comando comando) {
        return estado.permitirAplicarComando(comando);
    }

    public String getNombre(){
        return nombre;
    }

    public Double vida(){
        return estadisticas.getVida();
    }

    public Estado getEstado() {
        return estado;
    }



}