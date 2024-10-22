package com.miempresa.integradorjava.util;
import com.miempresa.integradorjava.modelo.Tratamiento;
import com.miempresa.integradorjava.servicio.TratamientoServicio;
import com.miempresa.integradorjava.servicio.TurnoServicio;

import java.util.Scanner;

public class Menu {
  public static void menu() {
    int opcion = 0;
    Scanner entrada = new Scanner(System.in);
    while (opcion != 4) {
      System.out.println("------------------------------------------------");
      System.out.println("                 >>  MENÚ  <<");
      System.out.println("------------------------------------------------");
      System.out.println(" (1)  Nuestros servicios");
      System.out.println(" (2)  Reserva online");
      System.out.println(" (3)  Contacto\n");
      System.out.println(" (4)  Salir");
      System.out.println();
      System.out.print("Elija una opción para continuar: ");

      opcion = Integer.parseInt(entrada.nextLine());
      System.out.println();

      switch (opcion) {
        case 1 -> TratamientoServicio.mostrarTratamientos();
        case 2 -> TurnoServicio.reservarTurno();
        case 3 -> Contacto.contacto();
        case 4 -> System.out.println("¡Gracias por usar nuestros servicios!");
        default -> System.out.println("Opción no válida.");
      }
    }
    entrada.close();
  }
}

