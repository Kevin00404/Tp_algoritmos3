package org.example.estado;

import org.example.Eventos.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;

public class EstadoParalizado extends Estado{
    public EstadoParalizado(){
        this.nombre = "Paralizado";
    }
    @Override
    public Comando condicionarComando(Comando comando){
        if (Math.random() < 0.5) {
            return new ComandoMensaje("El Pokémon está PARALIZADO y no pudo realizar la habilidad.");
        } else {
            Comando nuevoComando = new ComandoMensaje("El Pokémon esta Paralizado pero puedo lanzar la habilidad.");
            nuevoComando.concatComands(comando);
            return nuevoComando;
        }
    }
    @Override
    public Estado curarEstado(EstadoParalizado estadoACurar) {
        Estado nuevoEstado = new EstadoNormal();
        Comando comando = new ComandoMensaje("Curando paralisis");
        Eventos.getEventos().agregarComando(comando);
        nuevoEstado.agregarEstado(estadoACurar.getProximoEstado());
        return nuevoEstado;
    }
    public Estado aceptarEstado(Estado estado) {
        estado.curarEstado(this);
        return estado;
    }
}
