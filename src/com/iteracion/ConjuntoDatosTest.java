package com.iteracion;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ConjuntoDatosTest {

    @Test
    void agregarVariosValores_almacenaEnOrden() {
        ConjuntoDatos datos = new ConjuntoDatos();
        datos.agregarValor(4);
        datos.agregarValor(8);
        datos.agregarValor(15);
        datos.agregarValor(16);

        List<Double> valores = datos.getValores();
        assertEquals(4, valores.size());
        assertEquals(List.of(4.0, 8.0, 15.0, 16.0), valores);
    }

    @Test
    void agregarDecimal_seAlmacenaCorrectamente() {
        ConjuntoDatos datos = new ConjuntoDatos();
        datos.agregarValor(3.75);
        assertEquals(List.of(3.75), datos.getValores());
    }

    @Test
    void agregarNegativo_seAcepta() {
        ConjuntoDatos datos = new ConjuntoDatos();
        datos.agregarValor(-2.5);
        assertEquals(List.of(-2.5), datos.getValores());
    }

    @Test
    void sinAgregarValores_estaVacio() {
        ConjuntoDatos datos = new ConjuntoDatos();
        assertTrue(datos.estaVacio());
        assertEquals(0, datos.getValores().size());
    }
}