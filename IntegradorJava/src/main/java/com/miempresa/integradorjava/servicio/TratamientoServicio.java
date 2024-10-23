package com.miempresa.integradorjava.servicio;

import com.miempresa.integradorjava.modelo.Tratamiento;
import com.miempresa.integradorjava.util.Menu;
import com.miempresa.integradorjava.util.Utilidades;

import java.util.Scanner;

public class TratamientoServicio {
  public static void mostrarTratamientos() {
    Utilidades.encabezado("Tratamientos");
    for (Tratamiento tratamiento : Tratamiento.getTratamientos()) {
      System.out.println(tratamiento);
    }
    Scanner entrada = new Scanner(System.in);
    System.out.println("¿Cómo desea continuar? ");
    System.out.println("1. Hacer una reserva \n2. Volver al menú principal");

    int opcion;
    while (true) {
      System.out.print("> ");
      opcion = entrada.nextInt();
      if (opcion == 1 || opcion == 2) {
        break;
      } else {
        System.out.println("Opción no válida");
        }
      }
    switch (opcion) {
      case 1 -> TurnoServicio.reservarTurno();
      case 2 -> Menu.menu();
    }
  }
}


