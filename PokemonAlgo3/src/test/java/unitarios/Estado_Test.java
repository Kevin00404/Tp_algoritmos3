package unitarios;

import org.example.Elemento.Normal;
import org.example.Estadisticas.Estadisticas;
import org.example.estado.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class Estado_Test {
    private Estado estado;

    @Test
    public void pasivo() {

    }

    @Test
    public void concatenarEstado() {
    }

    @Test
    public void mostrarEstado() {
    }

    @Test
    public void curarEstado() {
        Estado normal = new EstadoNormal();

        Estado estado1 =normal.curarEstado(new EstadoNormal());

        assertEquals(estado1.getClass(),normal.getClass());

        //3
        Estado estado3 =normal.curarEstado(new EstadoDebilitado());

        assertEquals(estado3.getClass(),normal.getClass());
        //4
        Estado estado4 =normal.curarEstado(new EstadoEnvenenado());

        assertEquals(estado4.getClass(),normal.getClass());

        //5
        Estado estado5 =normal.curarEstado(new EstadoParalizado());

        assertEquals(estado5.getClass(),normal.getClass());
        //6
        Estado estado6 =normal.curarEstado(new EstadoConfuso());

        assertEquals(estado6.getClass(),normal.getClass());

    }

    @Test
    public void testAceptarEstadoEstadoNormal() {
        EstadoNormal normal = new EstadoNormal();
        Estado estado=new EstadoNormal();

        assertEquals(normal,normal.aceptarEstado(estado));
    }

    @Test
    public void testAceptarEstadoEstadoEnvenenado() {
        EstadoEnvenenado envenenado = new EstadoEnvenenado();

        assertEquals(new EstadoNormal(),envenenado.aceptarEstado(new EstadoEnvenenado()));
    }

    @Test
    public void testAceptarEstadoEstadoDormido() {
        EstadoDormido dormido = new EstadoDormido();


        assertEquals(new EstadoNormal(),dormido.aceptarEstado(new EstadoDormido()));
    }

    @Test
    public void testAceptarEstadoEstadoParaliuzado() {
        EstadoParalizado paralizado = new EstadoParalizado();
        Estado estado=new EstadoNormal();

        assertEquals(estado,paralizado.aceptarEstado(estado));
    }

    @Test
    public void testAceptarEstadoEstadoConfuso() {
        EstadoConfuso confuso = new EstadoConfuso();
        Estado estado=new EstadoNormal();

        assertEquals(estado,confuso.aceptarEstado(estado));
    }
    @Test
    public void testAceptarEstadoEstadoDebilitado() {
        EstadoDebilitado debili = new EstadoDebilitado();
        Estado estado=new EstadoNormal();

        assertEquals(estado,debili.aceptarEstado(estado));
    }

    @Test
    public void curar_Estado() {
        EstadoEnvenenado envenenado = new EstadoEnvenenado();
        Estado estado=new EstadoEnvenenado();

        estado.curarEstado(envenenado);
        assertEquals(new EstadoNormal(),estado.curarEstado(envenenado));
    }

    @Test
    public void curar_dormido() {
        EstadoDormido dormido = new EstadoDormido();

        assertEquals(new EstadoNormal(),dormido.curarEstado(dormido));
    }

    @Test
    public void curar_Confuso() {
        EstadoConfuso estado = new EstadoConfuso();

        assertEquals(new EstadoNormal(),estado.curarEstado(estado));
    }

    @Test
    public void curar_Paralizado() {
        EstadoParalizado estado = new EstadoParalizado();

        assertEquals(new EstadoNormal(),estado.curarEstado(estado));
    }

    @Test
    public void curar_Debilitado() {
        EstadoDebilitado estado = new EstadoDebilitado();

        assertEquals(new EstadoNormal(),estado.curarEstado(estado));
    }
}