package org.example.items;

import org.example.Estadistica.ModVida;
import org.example.Turno.Eventos;
import org.example.comando.Comando;
import org.example.comando.ComandoCurarEstado;
import org.example.comando.ComandoMensaje;
import org.example.comando.ComandoModificarEstadistica;
import org.example.estado.EstadoDebilitado;
import org.example.pokemon.Pokemon;

public class Revivir extends ItemDeCuracion{
    public Revivir(Double valor, String nombre , Integer disponible){
        super(disponible);
        this.valor = valor;
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public Double getValor() {
        return super.getValor();
    }
    @Override
    public boolean usarItem(Pokemon pokemon) {
        Comando comando = new ComandoCurarEstado(new EstadoDebilitado(), pokemon);
        Comando comandoMensaje = new ComandoMensaje("Pocion de resurreccion aplicada");
        Comando agregarMinimoDeVida = new ComandoModificarEstadistica(new ModVida(1.0), pokemon.getEstadisticas());
        comandoMensaje.concatComands(comando);
        agregarMinimoDeVida.concatComands(comandoMensaje);
        Eventos.getEventos().agregarComando(agregarMinimoDeVida);
        this.disponibles -= 1;
        return true;
    }

    @Override
    public boolean quedanDisponibles() {
        return super.quedanDisponibles();
    }

    @Override
    public boolean sePuedeUsar(Pokemon pokemon) {
        return pokemon.getEstado().getNombre().equals("Debilitado");
    }
}
