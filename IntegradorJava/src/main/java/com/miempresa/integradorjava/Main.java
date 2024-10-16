package com.miempresa.integradorjava;

import com.miempresa.integradorjava.servicio.ReservarTurno;
import com.miempresa.integradorjava.servicio.Servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println("        ********** 11 Sueños **********         ");
        System.out.println("================================================");

        menu();
    }

    public static void menu() {
        int opcion = 0;
        List<Servicios> listServices = new ArrayList<>();
        ReservarTurno reservarTurno = new ReservarTurno();
        Scanner entrada = new Scanner(System.in);

        // Crear instancias de la clase Servicios
        Servicios reflexologia = new Servicios(
                "Reflexología",
                "Terapia para tratar puntos dolorosos a través de masajes podales.",
                60,
                11500
        );
        listServices.add(reflexologia);

        Servicios masajeDescontracturante = new Servicios(
                "Masaje descontracturante",
                "Ideal para relajar la musculatura y disolver contracturas.",
                60,
                21900
        );
        listServices.add(masajeDescontracturante);

        Servicios pulidoCorporal = new Servicios(
                "Pulido corporal e hidratación",
                "Tratamiento corporal hiper estimulante que elimina las células muertas.",
                60,
                21900
        );
        listServices.add(pulidoCorporal);

        // Imprimir el menú al inicio
        mostrarMenu();

        while (opcion != 4) {
            System.out.println("\nElija una opción para continuar: ");
            System.out.print("> ");
            opcion = Integer.parseInt(entrada.next());

            switch (opcion) {
                case 1:
                    // Mostrar los servicios disponibles
                    System.out.println("\nNuestros Servicios:");
                    System.out.println("-------------------------------------------");
                    reflexologia.mostrarServicio();
                    masajeDescontracturante.mostrarServicio();
                    pulidoCorporal.mostrarServicio();

                    // Pausa para que el usuario vea los servicios
                    System.out.println("\nPresione Enter para volver al menú...");
                    entrada.nextLine();  // Esperar que el usuario presione Enter
                    break;


                case 2:
                    // Reserva online
                    reservarTurno.reservar(listServices);
                    break;
                case 3:
                    // Contacto
                    System.out.println("\nContacto:");
                    break;
                case 4:
                    // Mensaje de despedida
                    System.out.println("\nGracias por su visita. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("\nOpción no válida. Inténtalo de nuevo.");
            }

            // Solo mostramos el menú otra vez si no se selecciona "Salir"
            if (opcion != 4) {
                System.out.println();
                mostrarMenu();
            }
        }

        entrada.close();
    }

    // Método para mostrar el menú principal
    public static void mostrarMenu() {
        System.out.println("\n¡Hola! Bienvenido a nuestro menú de servicio\n¿Cómo podemos ayudarte?\n");
        System.out.println("                 >>  MENÚ  <<");
        System.out.println("------------------------------------------------");
        System.out.println(" (1)  Nuestros servicios");
        System.out.println(" (2)  Reserva online");
        System.out.println(" (3)  Contacto");
        System.out.println(" (4)  Salir");
    }
}