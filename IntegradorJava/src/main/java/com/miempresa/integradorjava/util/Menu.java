package com.miempresa.integradorjava.util;
import com.miempresa.integradorjava.modelo.Tratamiento;

import static com.miempresa.integradorjava.modelo.Tratamiento.mostrarTratamientos;
import java.util.Scanner;

public class Menu {

  public static void menu() {
    int opcion = 0;
    Scanner entrada = new Scanner(System.in);
    while (opcion != 4) {
      System.out.println("\n¡Hola! Bienvenido a nuestro menú de servicio\n ¿Cómo podemos ayudarte?\n");
      System.out.println("                 >>  MENÚ  <<");
      System.out.println("------------------------------------------------");
      System.out.println(" (1)  Nuestros servicios");
      System.out.println(" (2)  Reserva online");
      System.out.println(" (3)  Contacto\n");
      System.out.println(" (4)  Salir");
      System.out.println("------------------------------------------------");
      System.out.println();
      System.out.print("Elija una opción para continuar: ");

      opcion = Integer.parseInt(entrada.nextLine());

      switch (opcion) {
        case 1 -> {
          System.out.println();
          mostrarTratamientos();
        }
        case 2 ->
          // Reserva online
//              System.out.println("2");
                Tratamiento.reservarTurno();
//                ReservarTurno1.reservar(Servicios.getTratamientos());
        case 3 ->
          // Contacto
                Contacto.contacto();
        case 4 ->
                System.out.println("Gracias por usar nuestros servicios");
        default ->
                System.out.println("Opción no válida. Inténtalo de nuevo.");
      }
    }
    entrada.close();
  }
}

// La idea de que menu() tenga el switch y el while dentro, es para que su referencia en otros contextos no dependa de nada más.