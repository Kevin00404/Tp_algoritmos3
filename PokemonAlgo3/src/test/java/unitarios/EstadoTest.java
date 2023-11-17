package unitarios;

import org.example.estado.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EstadoTest {
    @Test
    public void testConcatenarEstado() {
        Estado estado1 = new EstadoConcreto("Estado1");
        Estado estado2 = new EstadoConcreto("Estado2");
        Estado estado3 = new EstadoConcreto("Estado3");

        estado1.concatenarEstado(estado2);
        estado2.concatenarEstado(estado3);

        assertEquals(estado1.getProximoEstado(), estado2);
        assertEquals(estado2.getProximoEstado(), estado3);
        assertEquals(estado3.getProximoEstado(), null);
    }

    private class EstadoConcreto extends Estado {
        public EstadoConcreto(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public Estado aceptarEstado(Estado estado) {
            return this;
        }
    }

    @Test
    public void curarEstado() {
        Estado estado = new EstadoDebilitado();
        Estado estadoACurar = new EstadoDebilitado();
        Estado estadoCure = estado.curarEstado((EstadoDebilitado) estadoACurar);

        assertEquals(EstadoNormal.class, estadoCure.getClass());
    }
}
