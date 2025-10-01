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
        stats.setSuma(100);
        stats.setMultiplicacion(1000);
        stats.setPromedio(20.0);
        stats.setPares(Arrays.asList(2, 4, 6));
        stats.setImpares(Arrays.asList(1, 3, 5));
        stats.setMayoresAlLimite(Arrays.asList(15, 20, 25));
    }

    @Test
    @DisplayName("Test getters y setters básicos")
    void testBasicGettersAndSetters() {
        assertEquals(100, stats.getSuma());
        assertEquals(1000, stats.getMultiplicacion());
        assertEquals(20.0, stats.getPromedio());
    }

    @Test
    @DisplayName("Test getters y setters de listas")
    void testListGettersAndSetters() {
        List<Integer> pares = stats.getPares();
        List<Integer> impares = stats.getImpares();
        List<Integer> mayores = stats.getMayoresAlLimite();

        assertTrue(pares.containsAll(Arrays.asList(2, 4, 6)));
        assertTrue(impares.containsAll(Arrays.asList(1, 3, 5)));
        assertTrue(mayores.containsAll(Arrays.asList(15, 20, 25)));

        // Probar setters con nuevas listas
        List<Integer> nuevosPares = Arrays.asList(8, 10, 12);
        List<Integer> nuevosImpares = Arrays.asList(7, 9, 11);
        List<Integer> nuevosMayores = Arrays.asList(30, 35, 40);

        stats.setPares(nuevosPares);
        stats.setImpares(nuevosImpares);
        stats.setMayoresAlLimite(nuevosMayores);

        assertEquals(nuevosPares, stats.getPares());
        assertEquals(nuevosImpares, stats.getImpares());
        assertEquals(nuevosMayores, stats.getMayoresAlLimite());
    }

    @Test
    @DisplayName("Test valores extremos")
    void testExtremeValues() {
        stats.setSuma(Integer.MAX_VALUE);
        stats.setMultiplicacion(Long.MAX_VALUE);
        stats.setPromedio(Double.MAX_VALUE);

        assertEquals(Integer.MAX_VALUE, stats.getSuma());
        assertEquals(Long.MAX_VALUE, stats.getMultiplicacion());
        assertEquals(Double.MAX_VALUE, stats.getPromedio());
    }

    @Test
    @DisplayName("Test listas vacías")
    void testEmptyLists() {
        stats.setPares(List.of());
        stats.setImpares(List.of());
        stats.setMayoresAlLimite(List.of());

        assertTrue(stats.getPares().isEmpty());
        assertTrue(stats.getImpares().isEmpty());
        assertTrue(stats.getMayoresAlLimite().isEmpty());
    }

    @Test
    @DisplayName("Test null en listas")
    void testNullLists() {
        stats.setPares(null);
        stats.setImpares(null);
        stats.setMayoresAlLimite(null);

        assertNull(stats.getPares());
        assertNull(stats.getImpares());
        assertNull(stats.getMayoresAlLimite());
    }
}