package com.iteracion;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un conjunto de valores numericos capturados manualmente.
 */
public class ConjuntoDatos {

    private static final String ERROR_VALOR_INVALIDO =
            "Valor invalido: no puede ser NaN ni infinito.";

    private final List<Double> valores;

    public ConjuntoDatos() {
        this.valores = new ArrayList<>();
    }

    /**
     * Indica si una cadena representa un numero decimal valido.
     */
    public static boolean esNumeroValido(String texto) {
        if (texto == null || texto.isBlank()) {
            return false;
        }
        try {
            double valor = Double.parseDouble(texto);
            return !Double.isNaN(valor) && !Double.isInfinite(valor);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Agrega un valor numerico al conjunto.
     */
    public void agregarValor(double valor) {
        if (Double.isNaN(valor) || Double.isInfinite(valor)) {
            throw new IllegalArgumentException(ERROR_VALOR_INVALIDO);
        }
        valores.add(valor);
    }

    public List<Double> getValores() {
        return List.copyOf(valores);
    }

    public boolean estaVacio() {
        return valores.isEmpty();
    }

    public int tamanio() {
        return valores.size();
    }
}