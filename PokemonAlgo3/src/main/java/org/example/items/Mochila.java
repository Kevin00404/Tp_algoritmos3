package org.example.items;

import org.example.Log.Log;
import org.example.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Mochila {
    List<Items> mochila = new ArrayList<>();
    public void mostrarItems() {
        for (int i = 0; i < mochila.size(); i++) {
            Log.getLog().log((i+1) + "-" + mochila.get(i).getNombre() + "\t disponibles: " + mochila.get(i).getDisponibles());
        }
        System.out.println("0 - volver atras");
    }
    public void agregarObjeto(Items item){ mochila.add(item); }
    public boolean usarItem(Pokemon pokemon , int itemSeleccionado){
        boolean itemSeUso = mochila.get((itemSeleccionado-1)).usarItem(pokemon);
        gastarUsosDeItem(itemSeleccionado);
        return itemSeUso;
    }
    protected void gastarUsosDeItem(int item){
        if (!mochila.get(item-1).quedanDisponibles()){
            mochila.remove((item-1));
        }
    }
}
