package com.example.sonar;

import java.util.List;
import java.util.ArrayList;

public class QualityIssuesExample {
    
    // 1. Maintainability Issue: Método muy largo y complejo
    public void procesamientoDeDatos(int[] datos) {
        // Método intencionalmente largo y complejo para generar issues de mantenibilidad
        int suma = 0;
        int multiplicacion = 1;
        double promedio = 0;
        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();
        List<Integer> mayoresA10 = new ArrayList<>();
        List<Integer> menoresA10 = new ArrayList<>();
        
        // Procesamiento innecesariamente complejo
        for (int i = 0; i < datos.length; i++) {
            int numero = datos[i];
            suma += numero;
            multiplicacion *= numero;
            
            if (numero % 2 == 0) {
                pares.add(numero);
                if (numero > 10) {
                    mayoresA10.add(numero);
                } else {
                    menoresA10.add(numero);
                }
            } else {
                impares.add(numero);
                if (numero > 10) {
                    mayoresA10.add(numero);
                } else {
                    menoresA10.add(numero);
                }
            }
        }
        
        // Más procesamiento innecesario
        promedio = suma / datos.length;
        
        System.out.println("Suma: " + suma);
        System.out.println("Multiplicación: " + multiplicacion);
        System.out.println("Promedio: " + promedio);
        System.out.println("Números pares: " + pares);
        System.out.println("Números impares: " + impares);
        System.out.println("Mayores a 10: " + mayoresA10);
        System.out.println("Menores a 10: " + menoresA10);
        
        // Más código repetitivo
        for (int par : pares) {
            System.out.println("Procesando par: " + par);
            if (par > 20) {
                System.out.println("Par mayor a 20");
            } else if (par > 10) {
                System.out.println("Par mayor a 10");
            } else {
                System.out.println("Par menor o igual a 10");
            }
        }
        
        for (int impar : impares) {
            System.out.println("Procesando impar: " + impar);
            if (impar > 20) {
                System.out.println("Impar mayor a 20");
            } else if (impar > 10) {
                System.out.println("Impar mayor a 10");
            } else {
                System.out.println("Impar menor o igual a 10");
            }
        }
    }

    // 2. Duplications Issue: Métodos con código duplicado
    public String mensaje1(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return "Hola desconocido";
        }
        return "Hola " + nombre + ", bienvenido al sistema";
    }

    public String mensaje2(String usuario) {
        if (usuario == null || usuario.trim().isEmpty()) {
            return "Hola desconocido";
        }
        return "Hola " + usuario + ", bienvenido al sistema";
    }

    public String mensaje3(String visitante) {
        if (visitante == null || visitante.trim().isEmpty()) {
            return "Hola desconocido";
        }
        return "Hola " + visitante + ", bienvenido al sistema";
    }

    // 3. Reliability Issues: Posibles errores en tiempo de ejecución
    public int divisionPeligrosa(int numerador, int denominador) {
        // División por cero potencial
        return numerador / denominador;  // Sin validación del denominador
    }

    public int accesoPeligrosoArray(int[] array, int indice) {
        // Acceso a índice sin validar
        return array[indice];  // Sin validación del índice
    }

    public String longitudString(String texto) {
        // Null pointer potencial
        return texto.toLowerCase();  // Sin validación de null
    }

    // 4. Coverage Issue: Métodos sin tests o con tests incompletos
    public int calculoComplejo(int a, int b, String operacion) {
        switch (operacion.toLowerCase()) {
            case "suma":
                return a + b;
            case "resta":
                return a - b;
            case "multiplicacion":
                return a * b;
            case "division":
                if (b != 0) {
                    return a / b;
                }
                return 0;
            case "potencia":
                return (int) Math.pow(a, b);
            default:
                return 0;
        }
    }

    public boolean validarRango(int numero, int min, int max) {
        if (numero < min) {
            return false;
        }
        if (numero > max) {
            return false;
        }
        return true;
    }
}