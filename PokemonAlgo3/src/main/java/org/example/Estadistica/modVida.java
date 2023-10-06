package org.example.Estadistica;

import org.example.Ataque;
    public class modVida implements Estadistica{
        String nombre;
        Double varVida;
        public modVida(Double varVida) {
            this.varVida=varVida;
            this.nombre = "vida";
        }

        @Override
        public void modificarEstadistica(Ataque ataque) {
            ataque.setVarVida(varVida);
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

