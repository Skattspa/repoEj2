package com.project.controlaccesoparque;

import java.util.concurrent.Semaphore;

public class Puerta {
    private final int id;
    private final Semaphore semaphore;

    public Puerta(int id) {
        this.id = id;
        this.semaphore = new Semaphore(1); // Solo una persona puede acceder a la vez
    }

    public boolean acceder(Visitante visitante) {
        if (semaphore.tryAcquire()) {
            try {
                System.out.println("Visitante " + visitante.getId() + " accediendo a través de la puerta " + id);
                // Simular tiempo de acceso
                Thread.sleep(1000);
                System.out.println("Visitante " + visitante.getId() + " ha accedido a la puerta " + id);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                semaphore.release();
            }
            return true;
        }
        return false;
    }
}
