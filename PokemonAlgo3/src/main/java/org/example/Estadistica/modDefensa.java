package org.example.Estadistica;

import org.example.Ataque;

public class modDefensa implements Estadistica{
    String nombre;
    Double varDefensa;
    public modDefensa(Double varDefensa) {
            this.varDefensa=varDefensa;
            this.nombre = "defensa";
        }

        @Override
    public void modificarEstadistica(Ataque ataque) {
            ataque.setVarDefensa(varDefensa);
        }

    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public boolean danina() {
        return this.varDefensa <= 0;
    }
}
