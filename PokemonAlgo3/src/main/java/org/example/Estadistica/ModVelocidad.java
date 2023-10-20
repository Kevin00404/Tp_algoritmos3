package org.example.Estadistica;

import org.example.Estadisticas.Estadisticas;

public class ModVelocidad implements ModificacionEstadistica {
        String nombre;
        Double varVelocidad;
        public ModVelocidad(Double varVelocidad) {
            this.varVelocidad=varVelocidad;
            this.nombre = "velocidad";
        }

        @Override
        public void modificarEstadistica(Estadisticas estadisticas) {
            estadisticas.variarVelocidad(varVelocidad);
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

