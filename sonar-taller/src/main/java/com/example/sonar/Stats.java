package com.example.sonar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stats {
    private int suma;
    private int multiplicacion;
    private double promedio;
    private final List<Integer> pares;
    private final List<Integer> impares;
    private final List<Integer> mayoresAlLimite;
    private final List<Integer> menoresAlLimite;

    public Stats() {
        this.suma = 0;
        this.multiplicacion = 1;
        this.promedio = 0.0;
        this.pares = new ArrayList<>();
        this.impares = new ArrayList<>();
        this.mayoresAlLimite = new ArrayList<>();
        this.menoresAlLimite = new ArrayList<>();
    }

    public void agregarSuma(int valor) {
        this.suma += valor;
    }

    public void agregarMultiplicacion(int valor) {
        this.multiplicacion *= valor;
    }

    public void setPares(int valor) {
        this.pares.add(valor);
    }

    public void setImpares(int valor) {
        this.impares.add(valor);
    }

    public void setMayoresAlLimite(int valor) {
        this.mayoresAlLimite.add(valor);
    }

    public void setMenoresAlLimite(int valor) {
        this.menoresAlLimite.add(valor);
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public int getSuma() {
        return suma;
    }

    public int getMultiplicacion() {
        return multiplicacion;
    }

    public double getPromedio() {
        return promedio;
    }

    public List<Integer> getPares() {
        return Collections.unmodifiableList(pares);
    }

    public List<Integer> getImpares() {
        return Collections.unmodifiableList(impares);
    }

    public List<Integer> getMayoresAlLimite() {
        return Collections.unmodifiableList(mayoresAlLimite);
    }

    public List<Integer> getMenoresAlLimite() {
        return Collections.unmodifiableList(menoresAlLimite);
    }

    @Override
    public String toString() {
        return String.format(
            "Stats{suma=%d, multiplicacion=%d, promedio=%.2f, pares=%s, impares=%s, mayoresAlLimite=%s, menoresAlLimite=%s}",
            suma, multiplicacion, promedio, pares, impares, mayoresAlLimite, menoresAlLimite
        );
    }
}