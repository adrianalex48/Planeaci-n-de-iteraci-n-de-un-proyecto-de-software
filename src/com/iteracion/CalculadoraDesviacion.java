package com.iteracion;

import java.util.List;

public class CalculadoraDesviacion {

    public static double media(List<Double> datos) {
        double suma = 0.0;
        for (double valor : datos) {
            suma += valor;
        }
        return suma / datos.size();
    }

    public static double calcular(List<Double> datos, boolean esMuestra) {
        if (datos == null || datos.isEmpty()) {
            throw new IllegalArgumentException("El conjunto no puede estar vacio.");
        }
        if (esMuestra && datos.size() < 2) {
            throw new IllegalArgumentException("Una muestra requiere al menos dos observaciones.");
        }

        double promedio = media(datos);
        double sumaCuadrados = 0.0;
        for (double valor : datos) {
            sumaCuadrados += (valor - promedio) * (valor - promedio);
        }
        int denominador = esMuestra ? datos.size() - 1 : datos.size();
        return Math.sqrt(sumaCuadrados / denominador);
    }
}