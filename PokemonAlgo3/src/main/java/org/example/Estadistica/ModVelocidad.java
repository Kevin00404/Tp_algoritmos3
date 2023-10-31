package org.example.Estadistica;

import org.example.Estadisticas.Estadisticas;

public class ModVelocidad extends ModEstadistica implements ModificacionEstadistica {

        public ModVelocidad(Double varVelocidad) {
            this.varEstadistica=varVelocidad;
            this.nombre = "velocidad";
        }

        @Override
        public void modificarEstadistica(Estadisticas estadisticas) {
            estadisticas.variarVelocidad(varEstadistica);
        }

    }

