package unitarios;

import org.example.Clima.Climas;
import org.example.Clima.Despejado;
import org.example.Clima.ManejoDeClima;
import org.example.Clima.Soleado;
import org.example.Elemento.Fuego;
import org.example.Estadisticas.EstadisticaPokemon;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

public class ClimaTest {

    @Test
    public void seCreaTerrenoAlObtenerTerreno(){
        //assert
        assertNotEquals(ManejoDeClima.getTerreno(), null);
    }
    @Test
    public void hayClimaAlObtenerTerreno(){
        //assert
        assertNotEquals(ManejoDeClima.getTerreno().getClima(), null);
    }
    @Test
    public void duracionReiniciadaAlCambiarClima(){
        //Arrange
        ManejoDeClima.getTerreno();
        //act
        ManejoDeClima.getTerreno().setDuracion(1);
        Despejado clima = new Despejado();
        ManejoDeClima.getTerreno().cambiarClima(clima);
        //assert
        assertEquals(ManejoDeClima.getTerreno().getDuracion(), 5);
    }
    @Test
    public void climaCambiaCuandoDuracionEs0(){
        //arrange
        ManejoDeClima.getTerreno();
        //act
        ManejoDeClima.getTerreno().setDuracion(0);
        Integer duracionFinal = ManejoDeClima.getTerreno().getDuracion();
        ManejoDeClima.getTerreno().verificarFinalDeClima();
        //assert
        assertNotEquals(ManejoDeClima.getTerreno().getDuracion(), 0);
    }
    @Test
    public void danioHipoteticoAumentaConClimaFavorable(){
        //arrange
        ManejoDeClima.getTerreno();
        Double danioHipotetico = 100.0;
        Fuego fuego = new Fuego();
        EstadisticaPokemon estadisticas = new EstadisticaPokemon(100.0,10.0,10.0, 10.0, fuego);
        //act
        ManejoDeClima.getTerreno().cambiarClima(new Soleado());
        Double danioEsperado = danioHipotetico + (danioHipotetico*0.1);
        Double danioObtenido = ManejoDeClima.getTerreno().ventajaDelTerreno(danioHipotetico,estadisticas);
        //assert
        assertEquals(danioEsperado,danioObtenido);
    }
}
