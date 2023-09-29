package org.example.Estadistica;

import org.example.Ataque;
    public class modVelocidad implements Estadistica{
        Double varVelocidad;
        public modVelocidad(Double varVelocidad) {
            this.varVelocidad=varVelocidad;
        }

        @Override
        public void modificarEstadistica(Ataque ataque) {
            ataque.setVarVelocidad(varVelocidad);
        }
    }

