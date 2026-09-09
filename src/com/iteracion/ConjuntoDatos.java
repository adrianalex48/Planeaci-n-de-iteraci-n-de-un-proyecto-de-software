package com.iteracion;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un conjunto de valores numéricos capturados manualmente.
 */
public class ConjuntoDatos {
    private final List<Double> valores;

    public ConjuntoDatos() {
        this.valores = new ArrayList<>();
    }

    /**
     * Agrega un valor numérico al conjunto.
     * @param valor número a agregar
     */
    public void agregarValor(double valor) {
        valores.add(valor);
    }

    /**
     * Obtiene la lista de valores almacenados.
     * @return lista inmutable de valores
     */
    public List<Double> getValores() {
        return List.copyOf(valores);
    }

    /**
     * Indica si el conjunto está vacío.
     * @return true si no hay valores
     */
    public boolean estaVacio() {
        return valores.isEmpty();
    }
}

// ... imports y clase

/**
 * Valida si una cadena representa un número decimal válido.
 * @param texto cadena a validar
 * @return true si es un número, false en caso contrario
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
 * Agrega un valor numérico al conjunto.
 * @param valor número a agregar
 * @throws IllegalArgumentException si el valor es NaN o infinito
 */
public void agregarValor(double valor) {
    if (Double.isNaN(valor) || Double.isInfinite(valor)) {
        throw new IllegalArgumentException("Valor inválido: no puede ser NaN o infinito");
    }
    valores.add(valor);
}