package com.example.sonar;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;

public class QualityIssuesExample {
    private static final Logger LOGGER = Logger.getLogger(QualityIssuesExample.class.getName());
    private static final int LIMITE_MAYOR = 10;
    private static final int LIMITE_MUY_MAYOR = 20;
    
    // Clase auxiliar para mantener estadísticas
    private static class Stats {
        int suma = 0;
        int multiplicacion = 1;
        double promedio = 0;
        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();
        List<Integer> mayoresAlLimite = new ArrayList<>();
        List<Integer> menoresAlLimite = new ArrayList<>();
    }

    // Método principal refactorizado
    public Stats procesamientoDeDatos(int[] datos) {
        if (datos == null || datos.length == 0) {
            LOGGER.warning("Array de datos vacío o nulo");
            return new Stats();
        }

        Stats stats = new Stats();
        for (int numero : datos) {
            procesarNumero(numero, stats);
        }
        
        stats.promedio = calcularPromedio(stats.suma, datos.length);
        imprimirResumen(stats);
        procesarListasNumeros(stats);
        
        return stats;
    }

    // Métodos auxiliares para reducir complejidad
    private void procesarNumero(int numero, Stats stats) {
        stats.suma += numero;
        stats.multiplicacion *= numero;
        
        if (esPar(numero)) {
            stats.pares.add(numero);
        } else {
            stats.impares.add(numero);
        }
        
        clasificarPorValor(numero, stats);
    }

    private boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    private void clasificarPorValor(int numero, Stats stats) {
        if (numero > LIMITE_MAYOR) {
            stats.mayoresAlLimite.add(numero);
        } else {
            stats.menoresAlLimite.add(numero);
        }
    }

    private double calcularPromedio(int suma, int cantidad) {
        return cantidad > 0 ? (double) suma / cantidad : 0.0;
    }

    private void imprimirResumen(Stats stats) {
        LOGGER.info("Suma: " + stats.suma);
        LOGGER.info("Multiplicación: " + stats.multiplicacion);
        LOGGER.info("Promedio: " + stats.promedio);
        LOGGER.info("Números pares: " + stats.pares);
        LOGGER.info("Números impares: " + stats.impares);
        LOGGER.info("Mayores a " + LIMITE_MAYOR + ": " + stats.mayoresAlLimite);
        LOGGER.info("Menores a " + LIMITE_MAYOR + ": " + stats.menoresAlLimite);
    }

    private void procesarListasNumeros(Stats stats) {
        procesarLista("par", stats.pares);
        procesarLista("impar", stats.impares);
    }

    private void procesarLista(String tipo, List<Integer> numeros) {
        for (int num : numeros) {
            LOGGER.info("Procesando " + tipo + ": " + num);
            clasificarNumero(num, tipo);
        }
    }

    private void clasificarNumero(int numero, String tipo) {
        String mensaje;
        if (numero > LIMITE_MUY_MAYOR) {
            mensaje = tipo + " mayor a " + LIMITE_MUY_MAYOR;
        } else if (numero > LIMITE_MAYOR) {
            mensaje = tipo + " mayor a " + LIMITE_MAYOR;
        } else {
            mensaje = tipo + " menor o igual a " + LIMITE_MAYOR;
        }
        LOGGER.info(mensaje);
    }

    // Método unificado para mensajes (eliminada duplicación)
    public String generarMensajeBienvenida(String nombre) {
        String nombreValidado = validarNombre(nombre);
        return "Hola " + nombreValidado + ", bienvenido al sistema";
    }

    private String validarNombre(String nombre) {
        return (nombre == null || nombre.trim().isEmpty()) ? "desconocido" : nombre.trim();
    }

    // Reliability Issues corregidos con validaciones
    public double divisionSegura(int numerador, int denominador) {
        if (denominador == 0) {
            LOGGER.warning("Intento de división por cero");
            return 0.0;
        }
        return (double) numerador / denominador;
    }

    public int accederArray(int[] array, int indice) {
        if (array == null) {
            throw new IllegalArgumentException("El array no puede ser nulo");
        }
        if (indice < 0 || indice >= array.length) {
            throw new IndexOutOfBoundsException("Índice " + indice + " fuera de rango");
        }
        return array[indice];
    }

    public String procesarTexto(String texto) {
        if (texto == null) {
            LOGGER.warning("Se recibió un texto nulo");
            return "";
        }
        return texto.toLowerCase();
    }

    // Métodos para coverage con validaciones
    public int calculoComplejo(int a, int b, String operacion) {
        if (operacion == null) {
            throw new IllegalArgumentException("La operación no puede ser nula");
        }

        return switch (operacion.toLowerCase()) {
            case "suma" -> a + b;
            case "resta" -> a - b;
            case "multiplicacion" -> a * b;
            case "division" -> validarYDividir(a, b);
            case "potencia" -> validarYCalcularPotencia(a, b);
            default -> throw new IllegalArgumentException("Operación no soportada: " + operacion);
        };
    }

    private int validarYDividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("División por cero no permitida");
        }
        return a / b;
    }

    private int validarYCalcularPotencia(int base, int exponente) {
        if (exponente < 0) {
            throw new IllegalArgumentException("Exponente negativo no soportado");
        }
        return (int) Math.pow(base, exponente);
    }

    public boolean validarRango(int numero, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("El mínimo no puede ser mayor que el máximo");
        }
        return numero >= min && numero <= max;
    }
}