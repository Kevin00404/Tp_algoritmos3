package org.example.Estadistica;

import org.example.Turno.Turno;
    public class modVida implements ModificacionEstadistica {
        String nombre;
        Double varVida;
        public modVida(Double varVida) {
            this.varVida=varVida;
            this.nombre = "vida";
        }

        @Override
        public void modificarEstadistica(Turno turno) {
            turno.setVarVida(varVida);
        }

        @Override
        public String getNombre() {
            return nombre;
        }

        @Override
        public boolean danina() {
            return this.varVida <= 0;
        }
    }

