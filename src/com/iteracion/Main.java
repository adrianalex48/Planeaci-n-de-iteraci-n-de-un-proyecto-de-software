package com.iteracion;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static final String PALABRA_FIN = "fin";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.println("=== Calculadora de desviacion estandar ===");
        System.out.println("Capture los valores uno por uno.");
        System.out.println("Escriba '" + PALABRA_FIN + "' para terminar la captura.");
        System.out.println();

        ConjuntoDatos conjunto = new ConjuntoDatos();

        while (true) {
            System.out.print("Valor: ");
            String entrada = sc.next();

            if (entrada.equalsIgnoreCase(PALABRA_FIN)) {
                break;
            }
            if (!ConjuntoDatos.esNumeroValido(entrada)) {
                System.out.println("  Entrada no numerica. Intente de nuevo.");
                continue;
            }
            conjunto.agregarValor(Double.parseDouble(entrada));
        }

        if (conjunto.estaVacio()) {
            System.out.println("\nNo se capturaron datos. Fin del programa.");
            sc.close();
            return;
        }

        System.out.print("\n¿Los datos son una muestra? (s/n): ");
        boolean esMuestra = sc.next().equalsIgnoreCase("s");

        try {
            double desviacion = CalculadoraDesviacion.calcular(conjunto.getValores(), esMuestra);
            double promedio = CalculadoraDesviacion.media(conjunto.getValores());

            System.out.println("\n--- Resultados ---");
            System.out.printf("Observaciones (N):    %d%n", conjunto.tamanio());
            System.out.printf("Media:                %.4f%n", promedio);
            System.out.printf("Tipo de conjunto:     %s%n", esMuestra ? "Muestra" : "Poblacion");
            System.out.printf("Desviacion estandar:  %.4f%n", desviacion);
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        }

        sc.close();
    }
}