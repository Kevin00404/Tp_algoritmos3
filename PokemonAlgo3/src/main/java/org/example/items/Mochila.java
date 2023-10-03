package org.example.items;

import org.example.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Mochila {
    List<Items> mochila = new ArrayList<>();
    public void getMochila() {
        for (Items item : mochila) {
            System.out.println(item.getNombre());
        }
    }
    public void agregarObjeto(Pocion pocion){ mochila.add(pocion); }
    public void agregarObjeto(Revivir revivir){ mochila.add(revivir); }
    public void agregarObjeto(PocionAntiVeneno antiVeneno){ mochila.add(antiVeneno); }
    public void agregarObjeto(PocionCurarParalisis curarParalisis){mochila.add(curarParalisis);}
    public void agregarObjeto(PocionDespertarDormido despertarDormido){mochila.add(despertarDormido);}
    public void agregarObjeto(CuraTotal curaTotal){mochila.add(curaTotal);}
    public void agregarObjeto(PocionDeDefensa soporteDeDefensa){ mochila.add(soporteDeDefensa); }
    public void agregarObjeto(PocionDeAtaque soporteDeAtaque){ mochila.add(soporteDeAtaque); }
    public boolean esElItem(String item){
        return mochila.get(1).getNombre()
    }
    public void usarItem(Pokemon pokemon){

    }
}
