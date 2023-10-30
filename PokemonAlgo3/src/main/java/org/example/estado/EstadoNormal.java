package org.example.estado;

public class EstadoNormal extends Estado{
    public EstadoNormal(){
        this.nombre = "Normal";
    }
    @Override
    public Estado setEstadoActual(Estado estado) {
        System.out.println("el estado se cambia a: " + estado.getNombre());
        return estado;
    }

    public Estado aceptarEstado(Estado estado) {
        estado.curarEstado(this);
        return estado;
    }
}
