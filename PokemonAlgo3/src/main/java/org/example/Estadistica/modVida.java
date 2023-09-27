package org.example.Estadistica;

import org.example.Ataque;
    public class modVida implements Estadistica{
        Double varVida;
        public modVida(Double varVida) {
            this.varVida=varVida;
        }

        @Override
        public void modificarEstadistica(Ataque ataque) {
            ataque.setVarVida(varVida);
        }
    }

