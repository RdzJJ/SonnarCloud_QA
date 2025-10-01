package com.example.sonar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QualityIssuesExampleTest {
    
    private QualityIssuesExample example = new QualityIssuesExample();

    // Test incompleto: solo prueba un caso básico
    @Test
    void testCalculoComplejo() {
        assertEquals(4, example.calculoComplejo(2, 2, "suma"));
        // No se prueban: resta, multiplicación, división, potencia, ni casos especiales
    }

    // Test incompleto: no cubre todos los casos límite
    @Test
    void testValidarRango() {
        assertTrue(example.validarRango(5, 1, 10));
        // No se prueban: valores límite, fuera de rango, iguales a los límites
    }

    // Test parcial de mensajes: solo prueba un caso
    @Test
    void testMensaje1() {
        assertEquals("Hola Juan, bienvenido al sistema", example.mensaje1("Juan"));
        // No se prueba: null, cadena vacía, otros casos
    }
}