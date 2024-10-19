package com.miempresa.integradorjava.servicio;

import java.util.Scanner;

public class Contacto {

    public static void contacto() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Mostrar menú de contacto
        System.out.println("===================================================");
        System.out.println("             >>  MENÚ DE CONTACTO  <<");
        System.out.println("===================================================");
        System.out.println("¡Estaremos encantados de atenderte!");
        horario();
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
                llamar();
                break;
            case 2:
                enviarCorreo();
                break;
            case 3:
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    //Llamar
    public static void llamar() {
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
    }

    //Enviar correo
    public static void enviarCorreo() {
        Scanner scanner = new Scanner(System.in);
        String tel, correo, mensaje, nombre;

        System.out.println("\n- Déjanos tus datos\n");

        // Validaciones
        do {
            System.out.print("   Nombre completo: ");
            nombre = scanner.nextLine();
            if (nombre.length() <= 4) {
                try {
                    System.out.println("\n-- Ingrese un nombre válido (de más de 4 carácteres)--\n");
                    Thread.sleep(1000); //Esperar 1 segundo.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while (nombre.length() <= 4);

        do {
            System.out.print("   Teléfono: ");
            tel = scanner.nextLine();
        } while (!ReservarTurno.validarTelefono(tel));

        do {
            System.out.print("   Email: ");
            correo = scanner.nextLine();
        } while (!ReservarTurno.validarCorreo(correo));

        do {
            System.out.print("   Mensaje: ");
            mensaje = scanner.nextLine();
            if (mensaje.length() <= 5) {
                try {
                    System.out.println("\n-- Ingrese un mensaje válido (de más de 5 carácteres) --\n");
                    Thread.sleep(1000); //Esperar 1 segundo.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while (mensaje.length() <= 5);

        try {
            Thread.sleep(1000); //Esperar 1 segundo.
            System.out.println("\n¡Mensaje enviado con éxito!");
            Thread.sleep(500); //Esperar 1/2 segundo.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Horario
    public static void horario() {
        String[][] horarios = {
                {" Lun", "09:00 - 18:00"},
                {" Mar", "09:00 - 18:00"},
                {" Mié", "09:00 - 18:00"},
                {" Jue", "09:00 - 18:00"},
                {" Vie", "09:00 - 18:00"},
                {" Sáb", "   CERRADO   "},
                {" Dom", "   CERRADO   "}
        };

        System.out.println("Horarios - Septiembre 2024");
        for (String[] diaHorario : horarios) {
            System.out.printf(" | %s: %s |\n", diaHorario[0], diaHorario[1]);
        }
    }
}