package com.miempresa.integradorjava;

import com.miempresa.integradorjava.modelo.Cliente;
import com.miempresa.integradorjava.modelo.Turnos;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("================================================");
    System.out.println("        ********** 11 Sueños **********         ");
    System.out.println("================================================");

    Cliente cliente1 = new Cliente("Christian", "Bonilla","chris@gmail.com", "2234422333");
    Turnos turno1 = new Turnos(23,9,2024,14, cliente1);
//    System.out.println("cliente1 = " + cliente1);
    System.out.println(turno1);
//    Turnos.mostrarHorarios();

//    menu();
}

//  public static void menu() {
//    int opcion = 0;
//    Scanner entrada = new Scanner(System.in);
//    while (opcion != 4) {
//      System.out.println("\n¡Hola! Bienvenido a nuestro menú de servicio\n ¿Cómo podemos ayudarte?\n");
//      System.out.println("                 >>  MENÚ  <<");
//      System.out.println("------------------------------------------------");
//      System.out.println(" (1)  Nuestros servicios");
//      System.out.println(" (2)  Reserva online");
//      System.out.println(" (3)  Contacto\n\n");
//      System.out.println(" (4)  Salir");
//      System.out.println("------------------------------------------------");
//      System.out.println();
//      System.out.print("Elija una opción para continuar: ");
//
//      opcion = Integer.parseInt(entrada.nextLine());
//
//      switch (opcion) {
//        case 1:
//          // Nuestros servicios
//          System.out.println("1");
//          break;
//        case 2:
//          // Reserva online
//          System.out.println("2");
//          break;
//        case 3:
//          // Contacto
//          System.out.println("3");
//          break;
//        case 4:
//          // Mensaje de despedida
//          System.out.println("4");
//          break;
//        default:
//          System.out.println("Opción no válida. Inténtalo de nuevo.");
//      }
//    }
//      entrada.close();
//  }
}


