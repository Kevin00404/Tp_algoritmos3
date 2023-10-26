package org.example.Estadistica;

import org.example.Estadisticas.Estadisticas;

public class ModVida extends ModEstadistica implements ModificacionEstadistica {

        public ModVida(Double varVida) {
            this.varEstadistica=varVida;
            this.nombre = "vida";
        }

        @Override
        public void modificarEstadistica(Estadisticas estadisticas) {
            estadisticas.variarVida(varEstadistica);
        }

    }

