package org.example.Estadistica;

import org.example.Ataque;

public class modDefensa implements Estadistica{
        Double varDefensa;
        public modDefensa(Double varDefensa) {
            this.varDefensa=varDefensa;
        }

        @Override
        public void modificarEstadistica(Ataque ataque) {
            ataque.setVarDefensa(varDefensa);
        }
}
