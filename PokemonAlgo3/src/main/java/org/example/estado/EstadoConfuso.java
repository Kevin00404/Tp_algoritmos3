package org.example.estado;

import org.example.Estadisticas.Estadisticas;
import org.example.Eventos.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;

public class EstadoConfuso extends Estado {
    private Integer turnosConfuso;
    public EstadoConfuso(){
        this.nombre = "confunso";
        turnosConfuso = 0;
    }

    @Override
    public Estado pasivo(Estadisticas estadisticas, String nombre) {
        turnosConfuso++;
        if (turnosConfuso <= 3){
            if ( !puedeAtacar() ){
                return confundir(estadisticas);
            }
            return this;
        } else{
            Estado nuevoEstado = new EstadoNormal();
            Comando comando = new ComandoMensaje("El pokemon dejo de estar confuso");
            Eventos.getEventos().agregarComando(comando);
            nuevoEstado.agregarEstado(proximoEstado);
            return nuevoEstado;
        }
    }

    private Estado confundir(Estadisticas estadisticas){
        Estado estadoNuevo = estadisticas.confundir();
        if (estadoNuevo == null){
            return this;
        }
        return estadoNuevo;
    }

    private boolean puedeAtacar() {
        Double probabilidad = Math.random();
        return probabilidad < (1.0/3.0);
    }

    @Override
    public Estado curarEstado(EstadoConfuso estadoACurar) {
        Estado nuevoEstado = new EstadoNormal();
        Comando comando = new ComandoMensaje("curando confusion");
        Eventos.getEventos().agregarComando(comando);
        nuevoEstado.agregarEstado(estadoACurar.getProximoEstado());
        return nuevoEstado;
    }

    public Estado aceptarEstado(Estado estado) {
        estado.curarEstado(this);
        return estado;
    }
}
