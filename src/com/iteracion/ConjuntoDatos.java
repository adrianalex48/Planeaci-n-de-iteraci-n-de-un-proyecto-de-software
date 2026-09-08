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