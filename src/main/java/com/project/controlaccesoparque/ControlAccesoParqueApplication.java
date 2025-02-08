package com.project.controlaccesoparque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControlAccesoParqueApplication {

    // Método main
    public static void main(String[] args) {
        Parque parque = new Parque(3); // 3 puertas de acceso
        parque.iniciarSimulacion();
        SpringApplication.run(ControlAccesoParqueApplication.class, args);
    }

}
