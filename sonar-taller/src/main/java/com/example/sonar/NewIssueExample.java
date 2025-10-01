package com.example.sonar;

public class NewIssueExample {
    public int compute(int a) {
        // Usar long para evitar overflow en la multiplicación
        long result = (long) a * 2;
        // Verificar si el resultado excede los límites de int
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
}
