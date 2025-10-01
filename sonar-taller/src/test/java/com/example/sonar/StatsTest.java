package com.example.sonar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

class StatsTest {
    private Stats stats;

    @BeforeEach
    void setUp() {
        stats = new Stats();
        // Inicializar suma y multiplicación
        stats.agregarSuma(50);
        stats.agregarSuma(50);
        stats.agregarMultiplicacion(100);
        stats.agregarMultiplicacion(10);
        stats.setPromedio(20.0);
        
        // Agregar números pares
        stats.setPares(2);
        stats.setPares(4);
        stats.setPares(6);
        
        // Agregar números impares
        stats.setImpares(1);
        stats.setImpares(3);
        stats.setImpares(5);
        
        // Agregar números mayores al límite
        stats.setMayoresAlLimite(15);
        stats.setMayoresAlLimite(20);
        stats.setMayoresAlLimite(25);
    }

    @Test
    @DisplayName("Test operaciones básicas")
    void testBasicOperations() {
        assertEquals(100, stats.getSuma());
        assertEquals(1000, stats.getMultiplicacion());
        assertEquals(20.0, stats.getPromedio());
    }

    @Test
    @DisplayName("Test operaciones con listas")
    void testListOperations() {
        List<Integer> pares = stats.getPares();
        List<Integer> impares = stats.getImpares();
        List<Integer> mayores = stats.getMayoresAlLimite();

        assertTrue(pares.containsAll(Arrays.asList(2, 4, 6)));
        assertTrue(impares.containsAll(Arrays.asList(1, 3, 5)));
        assertTrue(mayores.containsAll(Arrays.asList(15, 20, 25)));
    }

    @Test
    @DisplayName("Test acumulación de valores")
    void testAccumulation() {
        Stats newStats = new Stats();
        
        // Probar suma acumulativa
        newStats.agregarSuma(5);
        assertEquals(5, newStats.getSuma());
        newStats.agregarSuma(10);
        assertEquals(15, newStats.getSuma());
        
        // Probar multiplicación acumulativa
        newStats.agregarMultiplicacion(2);
        assertEquals(2, newStats.getMultiplicacion());
        newStats.agregarMultiplicacion(3);
        assertEquals(6, newStats.getMultiplicacion());
    }

    @Test
    @DisplayName("Test inmutabilidad de listas")
    void testListImmutability() {
        List<Integer> pares = stats.getPares();
        List<Integer> impares = stats.getImpares();
        List<Integer> mayores = stats.getMayoresAlLimite();
        
        assertThrows(UnsupportedOperationException.class, () -> pares.add(8));
        assertThrows(UnsupportedOperationException.class, () -> impares.add(7));
        assertThrows(UnsupportedOperationException.class, () -> mayores.add(30));
    }

    @Test
    @DisplayName("Test toString")
    void testToString() {
        String result = stats.toString();
        assertTrue(result.contains("suma=100"));
        assertTrue(result.contains("multiplicacion=1000"));
        assertTrue(result.contains("promedio=20.0"));
        assertTrue(result.contains("pares=[2, 4, 6]"));
        assertTrue(result.contains("impares=[1, 3, 5]"));
        assertTrue(result.contains("mayoresAlLimite=[15, 20, 25]"));
    }

    @Test
    @DisplayName("Test constructor por defecto")
    void testDefaultConstructor() {
        Stats newStats = new Stats();
        assertEquals(0, newStats.getSuma());
        assertEquals(1, newStats.getMultiplicacion()); // Multiplicación inicia en 1
        assertEquals(0.0, newStats.getPromedio());
        assertTrue(newStats.getPares().isEmpty());
        assertTrue(newStats.getImpares().isEmpty());
        assertTrue(newStats.getMayoresAlLimite().isEmpty());
        assertTrue(newStats.getMenoresAlLimite().isEmpty());
    }
}