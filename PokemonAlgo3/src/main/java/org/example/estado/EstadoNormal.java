package org.example.estado;

public class EstadoNormal extends Estado{
    public EstadoNormal(){
        this.nombre = "Normal";
    }

    public Estado aceptarEstado(Estado estado) {
        estado.curarEstado(this);
        return estado;
    }
}
