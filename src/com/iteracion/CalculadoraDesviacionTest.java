package com.iteracion;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDesviacionTest {

    // Conjunto de referencia: media = 5, sigma poblacional = 2.0, s muestral = 2.13809
    private static final List<Double> DATOS =
            Arrays.asList(2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0);

    @Test
    void calculaLaMediaDelConjunto() {
        assertEquals(5.0, CalculadoraDesviacion.media(DATOS), 0.0001);
    }

    @Test
    void calculaDesviacionPoblacional() {
        assertEquals(2.0, CalculadoraDesviacion.calcular(DATOS, false), 0.0001);
    }

    @Test
    void calculaDesviacionMuestral() {
        assertEquals(2.1380899, CalculadoraDesviacion.calcular(DATOS, true), 0.0001);
    }

    @Test
    void desviacionEsCeroSiTodosLosValoresSonIguales() {
        List<Double> iguales = Arrays.asList(7.0, 7.0, 7.0, 7.0);
        assertEquals(0.0, CalculadoraDesviacion.calcular(iguales, false), 0.0001);
    }

    @Test
    void rechazaConjuntoVacio() {
        assertThrows(IllegalArgumentException.class,
                () -> CalculadoraDesviacion.calcular(List.of(), false));
    }

    @Test
    void rechazaMuestraDeUnSoloDato() {
        assertThrows(IllegalArgumentException.class,
                () -> CalculadoraDesviacion.calcular(List.of(5.0), true));
    }

    @Test
    void aceptaPoblacionDeUnSoloDato() {
        assertEquals(0.0, CalculadoraDesviacion.calcular(List.of(5.0), false), 0.0001);
    }
}