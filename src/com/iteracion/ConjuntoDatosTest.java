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

//AGREGAR PRUEBAS
@Test
void esNumeroValido_conNumeroEntero_devuelveTrue() {
    assertTrue(ConjuntoDatos.esNumeroValido("42"));
}

@Test
void esNumeroValido_conDecimal_devuelveTrue() {
    assertTrue(ConjuntoDatos.esNumeroValido("3.14"));
}

@Test
void esNumeroValido_conNegativo_devuelveTrue() {
    assertTrue(ConjuntoDatos.esNumeroValido("-7.5"));
}

@Test
void esNumeroValido_conTextoNoNumerico_devuelveFalse() {
    assertFalse(ConjuntoDatos.esNumeroValido("abc"));
}

@Test
void esNumeroValido_conCadenaVacia_devuelveFalse() {
    assertFalse(ConjuntoDatos.esNumeroValido(""));
}

@Test
void agregarValorInvalido_lanzaExcepcion() {
    ConjuntoDatos datos = new ConjuntoDatos();
    assertThrows(IllegalArgumentException.class, () -> datos.agregarValor(Double.NaN));
}