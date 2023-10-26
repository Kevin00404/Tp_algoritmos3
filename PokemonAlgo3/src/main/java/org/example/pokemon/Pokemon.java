package org.example.pokemon;


import org.example.Estadisticas.Estadisticas;
import org.example.Turno.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.estado.Estado;
import org.example.estado.EstadoDebilitado;
import org.example.estado.EstadoNormal;
import org.example.habilidad.Habilidad;
import org.example.items.*;
import org.example.Log.Log;

import java.util.Dictionary;
import java.util.Hashtable;


public class Pokemon {
    String nombre;
    String historia;
    Estado estado;
    Estadisticas estadisticas;
    Dictionary<Integer, Habilidad> habilidades;

    //Integer critico = 1; // hay que cambiarlo...que es esto?
    //Integer random = 1; // hay que cambiarlo..que es esto?



    public Pokemon(String nombre, String historia, Hashtable<Integer, Habilidad> habilidades, Estadisticas estadisticas) {
        this.nombre = nombre;
        this.historia = historia;
        this.estado = new EstadoNormal();
        this.habilidades = habilidades;
        this.estadisticas = estadisticas;
    }


    public boolean estaVivo(){
        return this.estadisticas.sigueVivo();
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

    public void modificarEstado(Estado estado){
        this.estado = estado;
    }

    public void aplicar(Pokemon pokemon /*pokemon a atacar*/, Integer habilidad_a_usar){
        Habilidad habilidad = this.habilidades.get(habilidad_a_usar);
        Comando comandoJugada = habilidad.armarComando(pokemon, this.estadisticas);
        comandoJugada = this.estado.condicionarComando(comandoJugada);
        Eventos.getEventos().agregarComando(comandoJugada);
    }

    public void aplicarPasivos(){

    }

    public void envenenar(){
        System.out.println("se esta envenenando por: " + (this.vida*5)/100);
        this.vida -= (this.vida*5)/100;
        this.chequeoDeVida();
    }

    public void recibirDanio(Double danio) {
        estadisticas.bajarVida(danio);
    }

    public boolean chequeoDeVida() {
        if (this.vida <= 0) {
            this.estado = new EstadoDebilitado();
            return false;
        }
        return true;
    }

    public void actualizarEstadisticas(Eventos eventos){
        this.vida+= eventos.getVarianteVida();
        this.ataque+= eventos.getVarianteAtaque();
        this.defensa+= eventos.getVarianteDefensa();
        this.velocidad+= eventos.getVarianteVelocidad();
    }

    //Uso de Items
    public void usarItem(Revivir revivir){
        this.estado = this.estado.revivir(this, revivir);
    }
    public void usarItem(Pocion pocion){
        this.estado = this.estado.curar(pocion, this);
    }
    public void usarItem(PocionAntiVeneno antiVeneno){
        this.estado = this.estado.curarEstado(antiVeneno);
    }
    public void usarItem(PocionDespertarDormido despertar) {
        this.estado = this.estado.curarEstado(despertar);
    }
    public void usarItem(PocionCurarParalisis curarParalisis) {
        this. estado = this.estado.curarEstado(curarParalisis);
    }
    public void usarItem(CuraTotal curarCualquierEstado){this.estado = this.estado.curarEstado(curarCualquierEstado);}
    public void usarItem(PocionDeAtaque itemDeAtaque){
        this.estado = this.estado.aumentarAtaque(this, itemDeAtaque);
    }
    public void usarItem(PocionDeDefensa itemDeDefensa){
        this.estado = this.estado.aumentarDefensa(this, itemDeDefensa);
    }
    public void aumentarAtaque(Double ataqueExtra){
        this.ataque += ataqueExtra;
    }
    public void aumentarDefensa(Double defensaExtra){
        this.defensa += defensaExtra;
    }
    public void curarVida(Pocion Curacion) {
        if ((VIDAMAXIMA - this.vida) < Curacion.getValor()){
            this.vida = VIDAMAXIMA;
        } else {
            this.vida += Curacion.getValor();
        }
    }
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

    public void aplicarEfectos() {
        this.estado = this.estado.pasivo(this);
    }

    public void mostrarHabilidades() {
        Log.getLog().log("Elige una habilidad:");
        Log.getLog().log("1. " + getPrimeraHabilidad() + "usos disponibles: " + this.habilidades.get(1).getCantidadDisponible());
        Log.getLog().log("2. " + getSegundaHabilidad() + "usos disponibles: " + this.habilidades.get(2).getCantidadDisponible());
        Log.getLog().log("3. " + getTerceraHabilidad() + "usos disponibles: " + this.habilidades.get(3).getCantidadDisponible());
        Log.getLog().log("4. " + getCuartaHabilidad() + "usos disponibles: " + this.habilidades.get(4).getCantidadDisponible());
        Log.getLog().log("5. volver atras");
    }

    public boolean sePuedeCurar() {
        return vida < VIDAMAXIMA;
    }

    public Estadisticas getEstadisticas() {
        return this.estadisticas;
    }

    public void curarEstado(Estado estadoACurar) {
        estado = estado.curarEstado(estadoACurar);
    }

    public Comando habilitarComandoSiVive(Comando comando) {
        return estado.permitirAplicarComando(comando);
    }
}
