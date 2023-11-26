package org.example.estado;

import org.example.Estadisticas.Estadisticas;
import org.example.Eventos.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.comando.DanioConfusoComando;

public class EstadoConfuso extends Estado {
    private Integer turnosConfuso;
    public EstadoConfuso(){
        this.nombre = "confunso";
        turnosConfuso = 0;
    }

    @Override
    public Estado pasivo(Estadisticas estadisticas, String nombre) {
        turnosConfuso++;
        if (turnosConfuso >= 3){
            if ( !puedeAtacar() ) {
                Estado nuevoEstado = new EstadoNormal();
                Comando comando = new ComandoMensaje("El pokemon dejo de estar confuso");
                Eventos.getEventos().agregarComando(comando);
                nuevoEstado.agregarEstado(proximoEstado);
                return nuevoEstado;
            }
        }
        return this;
    }

    public Estado copiar(){
        return new EstadoConfuso();
    }

    private Comando confundir(Estadisticas estadisticas){
        Comando danioConfuso = new DanioConfusoComando(estadisticas);
        Comando mensaje = new ComandoMensaje("esta confuso");
        mensaje.concatComands(danioConfuso);
        return mensaje;
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
        return estado.curarEstado(this);
    }

    @Override
    public Comando condicionarComando(Comando comando, Estadisticas estadisticas) {
        Comando comandoConfundir = confundir(estadisticas);
        return comandoConfundir;
    }

    @Override
    public boolean existeEstadoConfuso(){
        return true;
    }


}
