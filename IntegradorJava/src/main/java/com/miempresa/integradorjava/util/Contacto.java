package com.miempresa.integradorjava.util;

import java.util.Scanner;

public class Contacto {
  public static void contacto() {
    Scanner scanner = new Scanner(System.in);
    int opcion;

    Utilidades.encabezado("Contacto");
    System.out.println("¡Estaremos encantados de atenderte!\n");
    horario();
    System.out.println();
    System.out.println(" - Teléfono: +54 3492 30-2771");
    System.out.println(" - Email: Beautyesteticarafaela@gmail.com");
    System.out.println(" - Dirección: Urquiza 275, Rafaela. Santa Fé, Argentina.\n");
    System.out.println(" ¡Contáctanos!");
    System.out.println("  1. Llamar");
    System.out.println("  2. Enviar un correo");
    System.out.println("  3. Volver al menú principal\n");

    System.out.println("¿Cómo deseas continuar? ");
    while (true){
      System.out.print("> ");
      opcion = scanner.nextInt();
      if (opcion >= 1 && opcion <= 3){
        break;
      }
    }
    switch (opcion) {
      case 1 -> llamar();
      case 2 -> enviarCorreo();
      case 3 -> Menu.menu();
      default -> System.out.println("Opción inválida.");
    }
  }

  public static void llamar() {
    Utilidades.encabezadoContacto("Contacto", "Llamando");
    // Simulación de llamada
    System.out.print("Llamando");
    for (int i = 0; i < 3; i++) {
      System.out.print(".");
      try {
        Thread.sleep(1000); // Esperar 1 segundo
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("\nLlamada finalizada.");
    contacto();
  }

  public static void enviarCorreo() {
    Utilidades.encabezadoContacto("Contacto", "Enviar correo");
    pedirDatos();
    contacto();
  }

  public static void pedirDatos() {
    Scanner scanner = new Scanner(System.in);
    String tel, correo, mensaje, nombre;

    System.out.println("Déjanos tus datos");

    // Validaciones
    do {
      System.out.print("Nombre completo: ");
      nombre = scanner.nextLine();
    } while (nombre.length() <= 4);

    do {
      System.out.print("Teléfono: ");
      tel = scanner.nextLine();
    } while (!Utilidades.validarTelefono(tel));

    do {
      System.out.print("Email: ");
      correo = scanner.nextLine();
    }while (!Utilidades.validarCorreo(correo));
    do {
      System.out.print("Mensaje: ");
      mensaje = scanner.nextLine();
    }while (mensaje.length() <=  5);

    // Simular envío de correo
    try {
      Thread.sleep(1000); //Esperar 1 segundo.
      System.out.println("\nMensaje enviado con éxito!");
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void horario() {
    String[][] horarios = {
            {"Lun", "09:00 - 19:30"},
            {"Mar", "09:00 - 19:30"},
            {"Mié", "09:00 - 19:30"},
            {"Jue", "09:00 - 19:30"},
            {"Vie", "09:00 - 19:30"},
            {"Sáb", "      CERRADO"},
            {"Dom", "      CERRADO"}
    };

    System.out.println(" Horarios - Octubre 2024");
    for (String[] diaHorario : horarios) {
      System.out.printf(" | %s: %s |\n", diaHorario[0], diaHorario[1]);
    }
  }
}
