package org.example.estado;

import org.example.Eventos.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;

public class EstadoDebilitado extends Estado{
    public EstadoDebilitado(){
        this.nombre = "Debilitado";
    }
    @Override
    public boolean esDebilitado() {
        return true;
    }
    public Estado curarEstado(EstadoDebilitado estadoACurar) {
        Estado nuevoEstado = new EstadoNormal();
        Comando comando = new ComandoMensaje("Reviviendo Pokemon");
        Eventos.getEventos().agregarComando(comando);
        nuevoEstado.agregarEstado(estadoACurar.getProximoEstado());
        return nuevoEstado;
    }
    public Comando condicionarComando(Comando comando){
        return new ComandoMensaje("Este pokemon esta debilitado");
    }
    public Comando permitirAplicarComando(Comando comando) {
        return new ComandoMensaje("Este pokemon esta debilitado");
    }
    @Override
    public Estado aceptarEstado(Estado estado) {
        if(this.proximoEstado != null){
            this.proximoEstado = this.proximoEstado.aceptarEstado(estado);
        }
        return estado.curarEstado(this);
    }


}
