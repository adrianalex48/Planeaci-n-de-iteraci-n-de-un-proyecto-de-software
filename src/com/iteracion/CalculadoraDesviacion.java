package com.iteracion;

import java.util.List;

public class CalculadoraDesviacion {

    private static final String ERROR_CONJUNTO_VACIO =
            "El conjunto de datos no puede estar vacio.";
    private static final String ERROR_MUESTRA_INSUFICIENTE =
            "Una muestra requiere al menos dos observaciones.";
    private static final int MINIMO_OBSERVACIONES_MUESTRA = 2;

    public static double media(List<Double> datos) {
        validar(datos, false);
        double suma = 0.0;
        for (double valor : datos) {
            suma += valor;
        }
        return suma / datos.size();
    }

    public static double calcular(List<Double> datos, boolean esMuestra) {
        validar(datos, esMuestra);
        return Math.sqrt(varianza(datos, esMuestra));
    }

    private static double varianza(List<Double> datos, boolean esMuestra) {
        double promedio = media(datos);
        double sumaCuadrados = 0.0;
        for (double valor : datos) {
            sumaCuadrados += Math.pow(valor - promedio, 2);
        }
        int denominador = esMuestra ? datos.size() - 1 : datos.size();
        return sumaCuadrados / denominador;
    }

    private static void validar(List<Double> datos, boolean esMuestra) {
        if (datos == null || datos.isEmpty()) {
            throw new IllegalArgumentException(ERROR_CONJUNTO_VACIO);
        }
        if (esMuestra && datos.size() < MINIMO_OBSERVACIONES_MUESTRA) {
            throw new IllegalArgumentException(ERROR_MUESTRA_INSUFICIENTE);
        }
    }
}