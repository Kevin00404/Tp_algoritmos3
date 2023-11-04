package integradores;

import org.example.Clima.*;
import org.example.Elemento.Element;
import org.example.Elemento.Fuego;
import org.example.Estadisticas.EstadisticaFactory;
import org.example.Estadisticas.Estadisticas;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class climasTest {
    @Test
    public void testVentajaDeClima() {
        Granizo granizo = new Granizo();

        double danioHipotetico = 100.0;
        Element elemento =new Fuego();
        EstadisticaFactory estadisticasPkmn=new EstadisticaFactory(elemento);

        Estadisticas estadisticas=estadisticasPkmn.crearEstadisticas();

        double resultado = granizo.ventajaDeClima(danioHipotetico, estadisticas);
        System.out.println(resultado);

        assertEquals(100.0, resultado, 0.001);
    }

    @Test
    public void huracan() {
        Huracan clima = new Huracan();

        double danioHipotetico = 100.0;
        Element elemento =new Fuego();
        EstadisticaFactory estadisticasPkmn=new EstadisticaFactory(elemento);

        Estadisticas estadisticas=estadisticasPkmn.crearEstadisticas();

        double resultado = clima.ventajaDeClima(danioHipotetico, estadisticas);
        System.out.println(resultado);

        assertEquals(100.0, resultado, 0.001);
    }
    @Test
    public void lluvia() {
        Lluvia clima = new Lluvia();

        double danioHipotetico = 100.0;
        Element elemento =new Fuego();
        EstadisticaFactory estadisticasPkmn=new EstadisticaFactory(elemento);

        Estadisticas estadisticas=estadisticasPkmn.crearEstadisticas();

        double resultado = clima.ventajaDeClima(danioHipotetico, estadisticas);
        System.out.println(resultado);

        assertEquals(100.0, resultado, 0.001);
    }
    @Test
    public void niebla() {
        Niebla clima = new Niebla();

        double danioHipotetico = 100.0;
        Element elemento =new Fuego();
        EstadisticaFactory estadisticasPkmn=new EstadisticaFactory(elemento);

        Estadisticas estadisticas=estadisticasPkmn.crearEstadisticas();

        double resultado = clima.ventajaDeClima(danioHipotetico, estadisticas);
        System.out.println(resultado);

        assertEquals(100.0, resultado, 0.001);
    }

    @Test
    public void tormentaDeArena_TormentaDeRayo() {
        TormentaDeArena climaTormenta = new TormentaDeArena();
        assertNotNull(climaTormenta);

        TormentaDeRayo tormentaDeRayo=new TormentaDeRayo();
        assertNotNull(tormentaDeRayo);
    }

}
