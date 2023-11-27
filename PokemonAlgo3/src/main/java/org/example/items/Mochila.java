package org.example.items;

import org.example.Log.Log;
import org.example.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Mochila {
    List<Items> mochila = new ArrayList<>();
    public void mostrarItems() {
        for (int i = 0; i < mochila.size(); i++) {
        }
    }
    public void agregarObjeto(Items item){ mochila.add(item); }
    public boolean usarItem(Pokemon pokemon , int itemSeleccionado) throws InterruptedException {
        System.out.println(mochila.get(itemSeleccionado-1).getNombre());
        boolean itemSeUso = mochila.get((itemSeleccionado-1)).usarItem(pokemon);
        seQuedoSinUsos(itemSeleccionado);
        return itemSeUso;
    }
    protected void seQuedoSinUsos(int item){
        if (!mochila.get(item-1).quedanDisponibles()){
            mochila.remove((item-1));
        }
    }

    public Integer getUsosItem(Integer indice) {
       return mochila.get(indice-1).getDisponibles();
    }

    public Integer getCantidadItems() {
        Integer i = 0;
        for (Items item: mochila) {
            i++;
        }
        return i;
    }

    public List<Items> getItems() {
        return mochila;
    }
}
