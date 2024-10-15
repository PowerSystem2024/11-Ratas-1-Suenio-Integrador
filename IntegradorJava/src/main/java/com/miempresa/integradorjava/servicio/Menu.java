package com.miempresa.integradorjava.servicio;
import static com.miempresa.integradorjava.servicio.Servicios.mostrarTratamientos;
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
      System.out.println(" (3)  Contacto\n\n");
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
                System.out.println("2");
        case 3 ->
          // Contacto
                System.out.println("3");
        case 4 ->
          // Mensaje de despedida
                System.out.println("4");
        default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
      }
    }
    entrada.close();
  }
}
