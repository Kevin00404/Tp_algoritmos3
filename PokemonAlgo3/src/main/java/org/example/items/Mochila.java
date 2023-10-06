package org.example.items;

import org.example.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Mochila {
    List<Items> mochila = new ArrayList<>();
    public void mostrarItems() {
        for (int i = 0; i < mochila.size(); i++) {
            System.out.println((i+1) + "-" + mochila.get(i).getNombre() + "\t disponibles: " + mochila.get(i).getDisponibles());
        }
        System.out.println("0 - volver atras");
    }
    public void agregarObjeto(Pocion pocion){ mochila.add(pocion); }
    public void agregarObjeto(Revivir revivir){ mochila.add(revivir); }
    public void agregarObjeto(PocionAntiVeneno antiVeneno){ mochila.add(antiVeneno); }
    public void agregarObjeto(PocionCurarParalisis curarParalisis){mochila.add(curarParalisis);}
    public void agregarObjeto(PocionDespertarDormido despertarDormido){mochila.add(despertarDormido);}
    public void agregarObjeto(CuraTotal curaTotal){mochila.add(curaTotal);}
    public void agregarObjeto(PocionDeDefensa soporteDeDefensa){ mochila.add(soporteDeDefensa); }
    public void agregarObjeto(PocionDeAtaque soporteDeAtaque){ mochila.add(soporteDeAtaque); }
    public boolean usarItem(Pokemon pokemon , int itemSeleccionado){
        if (mochila.get((itemSeleccionado-1)).sePuedeUsar(pokemon)){
            mochila.get((itemSeleccionado-1)).usarItem(pokemon);
            gastarUsosDeItem(itemSeleccionado);
            return true;
        } else {
            System.out.println("no se puede usar el item en este pokemon");
            return false;
        }
    }
    protected void gastarUsosDeItem(int item){
        if (!mochila.get(item-1).quedanDisponibles()){
            mochila.remove((item-1));
        }
    }
}
