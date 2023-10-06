package org.example.pokemon;


import org.example.Ataque;
import org.example.Elemento.*;
import org.example.estado.Estado;
import org.example.estado.EstadoDebilitado;
import org.example.estado.EstadoNormal;
import org.example.habilidad.Habilidad;
import org.example.items.*;

import java.util.Dictionary;
import java.util.Hashtable;


public class Pokemon {
    String nombre;
    Double vida;
    Double nivel;
    Double velocidad;
    Double defensa;
    Double ataque;
    String historia;
    Estado estado;
    Element elemento;
    Dictionary<Integer, Habilidad> habilidades;

    //Integer critico = 1; // hay que cambiarlo...que es esto?
    //Integer random = 1; // hay que cambiarlo..que es esto?

    final Double NIVEL_INICIO = 1.0;
    final Double VIDAMAXIMA=100.0;


    public Pokemon(String nombre, Element elemento, String historia, Habilidad primeraHabilidad, Habilidad segundaHabilidad, Habilidad terceraHabilidad, Habilidad cuartaHabilidad) {
        this.nombre = nombre;
        this.elemento = elemento;
        this.historia = historia;
        this.ataque = 10.0;
        this.defensa = 10.0;
        this.velocidad = 5.0;
        nivel = NIVEL_INICIO;
        vida = VIDAMAXIMA;
        estado = new EstadoNormal();
        this.habilidades = new Hashtable<Integer, Habilidad>();
        this.habilidades.put(1, primeraHabilidad);
        this.habilidades.put(2, segundaHabilidad);
        this.habilidades.put(3, terceraHabilidad);
        this.habilidades.put(4, cuartaHabilidad);
    }

    public Double getVida() {
        return vida;
    }

    public void setVida(Double vida) {
        this.vida = vida;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    public void setDefensa(Double defensa) {
        this.defensa = defensa;
    }

    public void setAtaque(Double ataque) {
        this.ataque = ataque;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public Double getDefensa() {
        return defensa;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getAtaque() {
        return ataque;
    }

    public boolean estaVivo(){
        return vida > 0;
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

    public void modificarEstado(Ataque ataque){
        this.estado=ataque.cambiarEstado(this.estado);
    }

    public boolean atacar(Pokemon pokemon /*pokemon a atacar*/, Integer habilidad_a_usar){
        Habilidad habilidad = this.habilidades.get(habilidad_a_usar);
        if(!habilidad.sePuedeUsar()){
            System.out.println("la habilidad no se puede usar");
            return false;
        }
        Ataque ataque_a_realizar = new Ataque();
        ataque_a_realizar.setAtaque(this.ataque);
        ataque_a_realizar.setNivel(this.nivel);
        this.estado = this.estado.pasivo(this);
        this.estado.atacar(habilidad.getObjetivo(this, pokemon) /*pokemon al cuál se va a atacar*/, habilidad /*La habilidad que se usa*/, this.elemento /* elemento del pokemon que está atacando*/, ataque_a_realizar);
        return true;
    }

    public void envenenar(){
        System.out.println("se esta envenenando por: " + (this.vida*5)/100);
        this.vida -= (this.vida*5)/100;
        this.chequeoDeVida();
    }

    public void recibirDanio(Ataque ataque_a_realizar, Element element) {
        ataque_a_realizar.setTipo(element.mixElement(this.elemento));
        ataque_a_realizar.setDefensa(this.defensa);
        Double damage = ataque_a_realizar.calcular_danio();
        System.out.println("Danio que le afecta: " + damage);
        this.vida -= damage;
        System.out.println("vida restante: " + this.vida + " daño realizado: " + damage);
        /* SI ESTÁ MUERTO QUITAR EL POKEMON DE LA POKEBOLA (DICCIONARIO) */
        this.chequeoDeVida();
    }

    public boolean chequeoDeVida() {
        if (this.vida <= 0) {
            this.estado = new EstadoDebilitado();
            return false;
        }
        return true;
    }

    public void actualizarEstadisticas(Ataque ataque){
        this.vida+=ataque.getVarianteVida();
        this.ataque+=ataque.getVarianteAtaque();
        this.defensa+=ataque.getVarianteDefensa();
        this.velocidad+=ataque.getVarianteVelocidad();
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

    public void datosDeBatalla() {
        if(estado.esNormal()){
            System.out.println(nombre + "\t lvl: " + nivel + "\t vida: " + vida +" "+ ataque +"\n" + defensa+ "\n" + velocidad);
        } else {
            System.out.println(nombre + "lvl: " + nivel + "\t vida: " + vida + "\t" + estado.getNombre());
        }
    }

    public void aplicarEfectos() {
        this.estado = this.estado.pasivo(this);
    }

    public void mostrarHabilidades() {
        System.out.println("Elige una habilidad:");
        System.out.println("1. " + getPrimeraHabilidad() + "usos disponibles: " + this.habilidades.get(1).getCantidadDisponible());
        System.out.println("2. " + getSegundaHabilidad() + "usos disponibles: " + this.habilidades.get(2).getCantidadDisponible());
        System.out.println("3. " + getTerceraHabilidad() + "usos disponibles: " + this.habilidades.get(3).getCantidadDisponible());
        System.out.println("4. " + getCuartaHabilidad() + "usos disponibles: " + this.habilidades.get(4).getCantidadDisponible());
        System.out.println("5. volver atras");
    }

    public boolean sePuedeCurar() {
        return vida < VIDAMAXIMA;
    }
}
