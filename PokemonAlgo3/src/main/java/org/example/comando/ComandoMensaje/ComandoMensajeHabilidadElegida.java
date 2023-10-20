package org.example.comando.ComandoMensaje;

import org.example.comando.Comando;

public class ComandoMensajeHabilidadElegida extends ComandoMensaje {
    String nombreHabilidad;
    public ComandoMensajeHabilidadElegida(String nombre) {
        this.nombreHabilidad = nombre;
    }

    @Override
    public String armarMensaje() {
        return ("se ha elegido la habilidad: " + this.nombreHabilidad);
    }
}
