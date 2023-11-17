package org.example.estado;

<<<<<<< HEAD
import org.example.Estadisticas.Estadisticas;
import org.example.Turno.Eventos;
=======
import org.example.Eventos.Eventos;
>>>>>>> 93348b1bfc4796b06fce42ef2ac06323731ae9c9
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
    public Comando condicionarComando(Comando comando, Estadisticas estadisticas){
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
