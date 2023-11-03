package org.example.estado;

import org.example.Estadisticas.Estadisticas;
import org.example.Eventos.Eventos;
import org.example.Elemento.Element;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.habilidad.Habilidad;
import org.example.pokemon.Pokemon;

public abstract class Estado {
    public String nombre;
    Estado proximoEstado;
    public Estado atacar(Pokemon pokemon /*pokemon a atacar*/, Habilidad habilidad /*habilidad seleccionada por el usuario*/, Element element /*elemento del pokemon que está atacando*/, Eventos eventos_a_realizar)
    {
        habilidad.atacar(pokemon, element, eventos_a_realizar);
        return this;
    }
    public Estado pasivo(Estadisticas estadisticas, String nombre) {
        return this;
    }

    public Estado concatenarEstado(Estado estado){
        if (proximoEstado != null){
            this.proximoEstado.concatenarEstado(estado);
            return this;
        }
        this.proximoEstado = estado;
        return this;
    }

    public Comando mostrarEstado(){
        return new ComandoMensaje("Estado Actual: " + nombre);
    }
    public Estado curarEstado(EstadoParalizado estadoACurar){ return this; }
    public Estado curarEstado(EstadoEnvenenado estadoACurar) { return this; }
    public Estado curarEstado(EstadoDormido estadoACurar){ return this; }
    public Estado curarEstado(EstadoDebilitado estadoACurar){ return this; }
    public Estado curarEstado(EstadoConfuso estadoACurar){ return this; }
    public Estado curarEstado(EstadoNormal estadoACurar){
        return new EstadoNormal();
    }

    public Comando condicionarConSiguienteEstado(Comando comando){
        if (proximoEstado != null){
            comando = proximoEstado.condicionarConSiguienteEstado(comando);
        }
        return this.condicionarComando(comando);
    }
    public Estado aceptarSiguienteEstado(Estado estado){
        if (proximoEstado != null){
            this.proximoEstado = proximoEstado.aceptarSiguienteEstado(estado);
        }
        return this.aceptarEstado(estado);
    }
    public Estado condicionarConSiguienteEstadoPasivo(Estadisticas estadisticas){
        if (proximoEstado != null){
            this.proximoEstado = this.proximoEstado.condicionarConSiguienteEstadoPasivo(estadisticas);
        }
        return this.pasivo(estadisticas, "");
    }

    public boolean esDebilitado() {
        return false;
    }
    public boolean esNormal() {return false;}
    public String getNombre() {
        return this.nombre;
    }
    public void agregarEstado(Estado proximoEstado){
        this.proximoEstado = proximoEstado;
    }
    public Comando condicionarComando(Comando comando) {
        return comando;
    }
    public Comando permitirAplicarComando(Comando comando) {
        return comando;
    }

    public abstract Estado aceptarEstado(Estado estado);

    public Estado getProximoEstado(){
        return proximoEstado;
    }
    @Override
    public boolean equals (Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Estado)) return false;
        Estado otro = (Estado) obj;
        return this.nombre.equals (otro.nombre);
    }
}