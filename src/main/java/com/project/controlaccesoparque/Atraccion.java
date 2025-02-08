package com.project.controlaccesoparque;

import java.util.concurrent.Semaphore;

public class Atraccion {
    private final String nombre;
    private final Semaphore semaphore;

    public Atraccion(String nombre, int capacidad) {
        this.nombre = nombre;
        this.semaphore = new Semaphore(capacidad); // Capacidad de la atracción
    }

    public void acceder(Visitante visitante) {
        try {
            semaphore.acquire();
            System.out.println("Visitante " + visitante.getId() + " accediendo a la atracción " + nombre);
            // Simular tiempo en la atracción
            Thread.sleep(2000);
            System.out.println("Visitante " + visitante.getId() + " ha salido de la atracción " + nombre);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }
}

