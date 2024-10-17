package com.miempresa.integradorjava.servicio;

import java.util.Scanner;

public class Contacto {
    
    
    public static void contacto() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Mostrar menú de contacto
        System.out.println("===================================================");
        System.out.println("                 >>  MENÚ DE CONTACTO  <<");
        System.out.println("===================================================");
        System.out.println("¡Estaremos encantados de atenderte!");

        System.out.println();
        System.out.println(" - Teléfono: +54 3492 30-2771");
        System.out.println(" - Email: Beautyesteticarafaela@gmail.com");
        System.out.println(" - Dirección: Urquiza 275, Rafaela. Santa Fé, Argentina.");
        System.out.println();
        System.out.println(" ¿Contáctanos!");
        System.out.println("   1. Llamar");
        System.out.println("   2. Enviar un correo");
        System.out.println("   3. Volver al menú principal");
        System.out.println();

        System.out.print("¿Cómo deseas continuar? ");
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Se realizara una llamada");
                break;
            case 2:
                System.out.println("Se enviara un correo electrónico");
                break;
            case 3:
                System.out.println("Se volvera al menú principal");
                break;
            default:
                System.out.println("Opción inválida.");
    }
}

//Llamar
public static void llamar() {
    // Simulación de llamada
    System.out.print("Llamando...");
    for (int i = 0; i < 3; i++) {
        System.out.print(".");
        try {
            Thread.sleep(1000); // Esperar 1 segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    System.out.println("\nLlamada finalizada.");
}

//Enviar correo
public static void enviarCorreo(String nombre) {
    pedirDatos(nombre);
    System.out.println("¡Mensaje enviado con éxito!");
    menu(1, nombre);
}

public static void pedirDatos(String nombre) {
    Scanner scanner = new Scanner(System.in);
    String tel, correo, mensaje;

    System.out.println("Déjanos tus datos");

    // Validar nombre
    do {
        System.out.print("Nombre completo: ");
        nombre = scanner.nextLine();
    } while (nombre.length() <= 5);

    System.out.print("Teléfono: ");
    tel = scanner.nextLine();
    System.out.print("Email: ");
    correo = scanner.nextLine();
    System.out.print("Mensaje: ");
    mensaje = scanner.nextLine();
    
    // Simular envío de correo
    System.out.println("¡Mensaje enviado con éxito!");
    // Agregar la lógica para enviar el correo
    // Por ejemplo, utilizando una biblioteca como JavaMail
}

//Menu
public static void menu() {

        System.out.println("\n¡Hola! Bienvenido a nuestro menú de servicio\n¿Cómo podemos ayudarte?\n");
        System.out.println("                 >>  MENÚ  <<");
        System.out.println("------------------------------------------------");
        System.out.println(" (1)  Nuestros servicios");
        System.out.println(" (2)  Reserva online");
        System.out.println(" (3)  Contacto");
        System.out.println(" (4)  Salir");
   
    }
//Horario
public static void horario() {
    String[][] horarios = {
            {"Lun", "09:00 - 19:30"},
            {"Mar", "09:00 - 19:30"},
            {"Mié", "09:00 - 19:30"},
            {"Jue", "09:00 - 19:30"},
            {"Vie", "09:00 - 19:30"},
            {"Sáb", "      CERRADO"},
            {"Dom", "      CERRADO"}
    };

    System.out.println("  Horarios - Julio 2024");
    for (String[] diaHorario : horarios) {
        System.out.printf(" | %s: %s |\n", diaHorario[0], diaHorario[1]);
    }
}
}
