package org.example.Estadistica;

import org.example.Ataque;
    public class modVelocidad implements Estadistica{
        String nombre;
        Double varVelocidad;
        public modVelocidad(Double varVelocidad) {
            this.varVelocidad=varVelocidad;
            this.nombre = "velocidad";
        }

        @Override
        public void modificarEstadistica(Ataque ataque) {
            ataque.setVarVelocidad(varVelocidad);
        }

        @Override
        public String getNombre() {
            return nombre;
        }
        @Override
        public boolean danina() {
            return this.varVelocidad <= 0;
        }
    }

