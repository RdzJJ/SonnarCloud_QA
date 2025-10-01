package com.example.sonar;

import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class QualityIssuesExample {
    private static final Logger LOGGER = Logger.getLogger(QualityIssuesExample.class.getName());
    private static final int LIMITE_MAYOR = 10;
    private static final int LIMITE_MUY_MAYOR = 20;

    // Método principal refactorizado
    public Stats procesamientoDeDatos(int[] datos) {
        if (datos == null || datos.length == 0) {
            if (LOGGER.isLoggable(Level.WARNING)) {
                LOGGER.warning("Array de datos vacío o nulo");
            }
            return new Stats();
        }

        Stats stats = new Stats();
        for (int numero : datos) {
            procesarNumero(numero, stats);
        }
        
        stats.setPromedio(calcularPromedio(stats.getSuma(), datos.length));
        imprimirResumen(stats);
        procesarListasNumeros(stats);
        
        return stats;
    }

    // Métodos auxiliares para reducir complejidad
    private void procesarNumero(int numero, Stats stats) {
        stats.agregarSuma(numero);
        stats.agregarMultiplicacion(numero);
        
        if (esPar(numero)) {
            stats.setPares(numero);
        } else {
            stats.setImpares(numero);
        }
        
        clasificarPorValor(numero, stats);
    }

    private boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    private void clasificarPorValor(int numero, Stats stats) {
        if (numero > LIMITE_MAYOR) {
            stats.setMayoresAlLimite(numero);
        } else {
            stats.setMenoresAlLimite(numero);
        }
    }

    private double calcularPromedio(int suma, int cantidad) {
        return cantidad > 0 ? (double) suma / cantidad : 0.0;
    }

    private void imprimirResumen(Stats stats) {
        if (LOGGER.isLoggable(java.util.logging.Level.INFO)) {
            String[] mensajes = {
                String.format("Suma: %d", stats.getSuma()),
                String.format("Multiplicación: %d", stats.getMultiplicacion()),
                String.format("Promedio: %.2f", stats.getPromedio()),
                String.format("Números pares: %s", stats.getPares()),
                String.format("Números impares: %s", stats.getImpares()),
                String.format("Mayores a %d: %s", LIMITE_MAYOR, stats.getMayoresAlLimite()),
                String.format("Menores a %d: %s", LIMITE_MAYOR, stats.getMenoresAlLimite())
            };
            
            for (String mensaje : mensajes) {
                LOGGER.info(mensaje);
            }
        }
    }

    private void procesarListasNumeros(Stats stats) {
        procesarLista("par", stats.getPares());
        procesarLista("impar", stats.getImpares());
    }

    private void procesarLista(String tipo, List<Integer> numeros) {
        if (tipo == null || numeros == null) {
            if (LOGGER.isLoggable(Level.WARNING)) {
                LOGGER.warning("Tipo o lista de números es nula");
            }
            return;
        }
        
        for (int num : numeros) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info(String.format("Procesando %s: %d", tipo, num));
            }
            clasificarNumero(num, tipo);
        }
    }

    private String determinarMensajeClasificacion(int numero, String tipo) {
        if (numero > LIMITE_MUY_MAYOR) {
            return String.format("%s mayor a %d", tipo, LIMITE_MUY_MAYOR);
        } else if (numero > LIMITE_MAYOR) {
            return String.format("%s mayor a %d", tipo, LIMITE_MAYOR);
        } else {
            return String.format("%s menor o igual a %d", tipo, LIMITE_MAYOR);
        }
    }

    private void clasificarNumero(int numero, String tipo) {
        String mensaje = determinarMensajeClasificacion(numero, tipo);
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info(mensaje);
        }
    }

    // Método unificado para mensajes (eliminada duplicación)
    public String generarMensajeBienvenida(String nombre) {
        String nombreValidado = validarNombre(nombre);
        return String.format("Hola %s, bienvenido al sistema", nombreValidado);
    }

    private String validarNombre(String nombre) {
        return (nombre == null || nombre.trim().isEmpty()) ? "desconocido" : nombre.trim();
    }

    // Reliability Issues corregidos con validaciones
    public double divisionSegura(int numerador, int denominador) {
        if (denominador == 0) {
            if (LOGGER.isLoggable(Level.WARNING)) {
                LOGGER.warning(String.format("Intento de división por cero en %d/%d", numerador, denominador));
            }
            return 0.0;
        }
        return (double) numerador / denominador;
    }

    public int accederArray(int[] array, int indice) {
        if (array == null) {
            throw new IllegalArgumentException("El array no puede ser nulo");
        }
        if (indice < 0 || indice >= array.length) {
            throw new IndexOutOfBoundsException(String.format("Índice %d fuera de rango [0-%d]", indice, array.length - 1));
        }
        return array[indice];
    }

    public String procesarTexto(String texto) {
        if (texto == null) {
            if (LOGGER.isLoggable(Level.WARNING)) {
                LOGGER.warning("Se recibió un texto nulo");
            }
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