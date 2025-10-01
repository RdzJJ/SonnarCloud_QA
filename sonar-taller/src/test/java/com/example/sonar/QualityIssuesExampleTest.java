package com.example.sonar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class QualityIssuesExampleTest {
    private static final String DEFAULT_WELCOME_MESSAGE = "Hola desconocido, bienvenido al sistema";
    private static final int EXPECTED_MULTIPLICATION = 24;
    private QualityIssuesExample example;

    @BeforeEach
    void setUp() {
        example = new QualityIssuesExample();
    }

    @Test
    @DisplayName("Test completo de procesamientoDeDatos")
    void testProcesamientoDeDatos() {
        // Test con array normal
        int[] datos = {1, 2, 3, 4, 15, 25};
        Stats resultado = example.procesamientoDeDatos(datos);
        
        assertEquals(50, resultado.getSuma());
        assertEquals(24, resultado.getMultiplicacion());
        assertEquals(8.33, resultado.getPromedio(), 0.01);
        assertTrue(resultado.getPares().contains(2));
        assertTrue(resultado.getPares().contains(4));
        assertTrue(resultado.getImpares().contains(1));
        assertTrue(resultado.getImpares().contains(3));
        assertTrue(resultado.getMayoresAlLimite().contains(15));
        assertTrue(resultado.getMayoresAlLimite().contains(25));

        // Test con array vacío
        Stats resultadoVacio = example.procesamientoDeDatos(new int[0]);
        assertEquals(0, resultadoVacio.getSuma());
        assertEquals(0, resultadoVacio.getPromedio(), 0.01);

        // Test con null
        Stats resultadoNull = example.procesamientoDeDatos(null);
        assertEquals(0, resultadoNull.getSuma());
        assertEquals(0, resultadoNull.getPromedio(), 0.01);
    }

    @Test
    @DisplayName("Test completo de calculoComplejo")
    void testCalculoComplejo() {
        // Operaciones básicas
        assertEquals(4, example.calculoComplejo(2, 2, "suma"));
        assertEquals(0, example.calculoComplejo(2, 2, "resta"));
        assertEquals(6, example.calculoComplejo(2, 3, "multiplicacion"));
        assertEquals(2, example.calculoComplejo(4, 2, "division"));
        assertEquals(8, example.calculoComplejo(2, 3, "potencia"));

        // Casos especiales y excepciones
        assertThrows(IllegalArgumentException.class, () -> example.calculoComplejo(2, 2, null));
        assertThrows(IllegalArgumentException.class, () -> example.calculoComplejo(2, 2, "operacion_invalida"));
        assertThrows(ArithmeticException.class, () -> example.calculoComplejo(4, 0, "division"));
        assertThrows(IllegalArgumentException.class, () -> example.calculoComplejo(2, -1, "potencia"));
    }

    @Test
    @DisplayName("Test completo de validarRango")
    void testValidarRango() {
        // Casos dentro del rango
        assertTrue(example.validarRango(5, 1, 10));
        assertTrue(example.validarRango(1, 1, 10)); // Valor mínimo
        assertTrue(example.validarRango(10, 1, 10)); // Valor máximo
        
        // Casos fuera del rango
        assertFalse(example.validarRango(0, 1, 10));
        assertFalse(example.validarRango(11, 1, 10));
        
        // Casos especiales
        assertTrue(example.validarRango(5, 5, 5)); // Rango de un solo número
        assertThrows(IllegalArgumentException.class, () -> example.validarRango(5, 10, 1)); // Min > Max
    }

    @Test
    @DisplayName("Test completo de generarMensajeBienvenida")
    void testGenerarMensajeBienvenida() {
        // Casos normales
        assertEquals("Hola Juan, bienvenido al sistema", example.generarMensajeBienvenida("Juan"));
        assertEquals("Hola María, bienvenido al sistema", example.generarMensajeBienvenida("María"));
        
        // Casos especiales
        assertEquals(DEFAULT_WELCOME_MESSAGE, example.generarMensajeBienvenida(null));
        assertEquals(DEFAULT_WELCOME_MESSAGE, example.generarMensajeBienvenida(""));
        assertEquals(DEFAULT_WELCOME_MESSAGE, example.generarMensajeBienvenida("   "));
        assertEquals("Hola Juan Carlos, bienvenido al sistema", example.generarMensajeBienvenida("  Juan Carlos  "));
    }

    @Test
    @DisplayName("Test completo de divisionSegura")
    void testDivisionSegura() {
        // Casos normales
        assertEquals(2.0, example.divisionSegura(4, 2), 0.01);
        assertEquals(0.5, example.divisionSegura(1, 2), 0.01);
        assertEquals(-2.0, example.divisionSegura(-4, 2), 0.01);
        
        // Caso división por cero
        assertEquals(0.0, example.divisionSegura(4, 0), 0.01);
    }

    @Test
    @DisplayName("Test completo de accederArray")
    void testAccederArray() {
        int[] array = {1, 2, 3, 4, 5};
        
        // Casos válidos
        assertEquals(1, example.accederArray(array, 0));
        assertEquals(3, example.accederArray(array, 2));
        assertEquals(5, example.accederArray(array, 4));
        
        // Casos de error
        assertThrows(IllegalArgumentException.class, () -> example.accederArray(null, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> example.accederArray(array, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> example.accederArray(array, 5));
    }

    @Test
    @DisplayName("Test completo de procesarTexto")
    void testProcesarTexto() {
        // Casos normales
        assertEquals("hola mundo", example.procesarTexto("HOLA MUNDO"));
        assertEquals("test123", example.procesarTexto("TEST123"));
        assertEquals("", example.procesarTexto("")); // Cadena vacía
        
        // Caso null
        assertEquals("", example.procesarTexto(null));
    }
}