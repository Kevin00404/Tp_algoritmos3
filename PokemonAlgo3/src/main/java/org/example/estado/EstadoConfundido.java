package org.example.estado;

import org.example.Estadisticas.Estadisticas;
import org.example.Turno.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoMensaje;
import org.example.comando.HacerDañoConfundidoComando;

import java.util.Random;

public class EstadoConfundido extends Estado{
    public Integer turnosConfundido;
    public EstadoConfundido(){
        turnosConfundido = 0;
        this.nombre = "Confuso";
    }

    public void ponerseCuerdo(){
        Random rand = new Random();
        double probabilidadGolpearse = rand.nextDouble();
        if (probabilidadGolpearse < 1.0 / 3.0) {
            System.out.println("¡El Pokémon se hirió a sí mismo!");
        } else {
            System.out.println("¡El Pokémon hirió al enemigo!");
        }
    }
    @Override
    public Estado pasivo(Estadisticas estadisticas) {
        turnosConfundido++;
        if (turnosConfundido == 3) {
            Estado nuevoEstado = new EstadoNormal();
            Comando comando = new ComandoMensaje("El pokemon ya no está confundido");
            nuevoEstado.agregarEstado(proximoEstado);
            Eventos.getEventos().agregarComando(comando);
            return nuevoEstado;
        }
        return this;
    }
    public Comando atacarConfuso(Comando comando, Estadisticas estadisticas) {
        Random rand = new Random();
        double probabilidadGolpearse = rand.nextDouble();
        if (probabilidadGolpearse < 1.0 / 3.0){
            Comando nuevoComando = new HacerDañoConfundidoComando(estadisticas);
            Comando comandoMensaje = new ComandoMensaje("El pokemon está confundido, se hace daño a sí mismo");
            comandoMensaje.concatComands(nuevoComando);
            return comandoMensaje;
        }
        Comando comandoMensaje = new ComandoMensaje("Tu pokemon está confuso pero pudo herir al rival");
        comandoMensaje.concatComands(comando);
        return comandoMensaje;
    }
    @Override
    public Comando condicionarComando(Comando comando, Estadisticas estadisticas) {
        return atacarConfuso(comando, estadisticas);
    }

    @Override
    public Estado curarEstado(EstadoConfundido estadoACurar) {
        Estado nuevoEstado = new EstadoNormal();
        Comando comando = new ComandoMensaje("El pokemon ya no está confuso");
        Eventos.getEventos().agregarComando(comando);
        nuevoEstado.agregarEstado(estadoACurar.getProximoEstado());
        return nuevoEstado;
    }
    public Estado aceptarEstado(Estado estado) {
        estado.curarEstado(this);
        return estado;
    }
}
