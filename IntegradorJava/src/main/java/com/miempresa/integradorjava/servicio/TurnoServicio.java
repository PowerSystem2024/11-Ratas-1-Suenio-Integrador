package com.miempresa.integradorjava.servicio;

import com.miempresa.integradorjava.modelo.Cliente;
import com.miempresa.integradorjava.modelo.Tratamiento;
import com.miempresa.integradorjava.modelo.Turno;
import com.miempresa.integradorjava.util.Utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TurnoServicio {

    public static void mostrarTurnos(List<String> turnos, String[][] cronograma) {
        int numDias = 30;
        int numTurnos = 7;
        int cont = 0;
        int cont1 = 0;
        List<String> dias = new ArrayList<>();

        dias.add("Sab ");
        dias.add("Dom ");
        dias.add("Lun ");
        dias.add("Mar ");
        dias.add("Mie ");
        dias.add("Jue ");
        dias.add("Vie ");

        System.out.println("");
        System.out.println("                                                  ___________________");
        System.out.println("                                                 | Septiembre / 2024 |");
        System.out.println("       ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        // Mostrar encabezados de horarios
        System.out.println("Día\\Hs | " + turnos.get(0) + " || " + turnos.get(1) + " || " + turnos.get(2) + " || " + turnos.get(3) + " || " + turnos.get(4) + " || " + turnos.get(5) + " || " + turnos.get(6) + " |");//Controla las filas
        for (int i = 0; i < numDias; i++) {
            //Controla las columnas basado en la longitud de la lista 'dias'
            for (int k = cont1; k < dias.size(); k++) {
                //Controla la separación entre turno y turno
                for (int j = 0; j < numTurnos; j++) {
                    if (cont == 0) {
                        System.out.print("       ");
                    }
                    System.out.print("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                    cont++;
                }

                cont = 0;
                System.out.println("");

                //Le asigna los números a los día de la semana, y le agrega un espacio a los números de un dígito.
                if (i > 8) {
                    System.out.print(dias.get(k) + (i + 1) + ":");
                } else {
                    System.out.print(dias.get(k) + (i + 1) + ": ");
                }

                //Muestra por consola el turno actual, de existir en 'cronograma'
                for (int j = 0; j < numTurnos; j++) {
                    if (cont == 0) {
                        System.out.print("");
                    }
                    if (cronograma[i][j] != "") {
                        System.out.print("|" + cronograma[i][j] + "|");
                    } else {
                        System.out.print("|             |");
                    }
                    cont++;
                }

                cont = 0;
                System.out.println("");
                //Cierra la tabla
                if (i == 29) {
                    for (int j = 0; j < numTurnos; j++) {
                        if (cont == 0) {
                            System.out.print("       ");
                        }
                        System.out.print("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                        cont++;
                    }
                }

                cont = 0;
                cont1++;
                //Reinicia los días de la semana
                if (cont1 == 7) {
                    cont1 = 0;
                }
                break;
            }
        }
    }

    public static List<String> cargarTurnos() {
        List<String> turnos = new ArrayList<>();

        //Completa los horarios de los turnos
        turnos.add("   09:00   ");
        turnos.add("   10:30   ");
        turnos.add("   12:00   ");
        turnos.add("   13:30   ");
        turnos.add("   15:00   ");
        turnos.add("   16:30   ");
        turnos.add("   18:00   ");

        return turnos;
    }

    public static void reservarTurno() {
        Scanner entrada = new Scanner(System.in);
        boolean diaCerrado = false;

        boolean continuaReservando;
        do {

            int tratamientoIndice;
            continuaReservando = true;
            System.out.println("\n+ Es momento de poner tus datos personales");
            Cliente nuevoCliente = ClienteServicio.cargarCliente();
            do {
                Utilidades.encabezado("Reserva Online");
                System.out.println("+ Ingresa uno de los siguientes tratamientos\n");
                //Iteramos la lista de tratamientos
                for (Tratamiento tratamiento : Tratamiento.getTratamientos()) {
                    System.out.println(tratamiento);
                }

                System.out.print("> ");
                tratamientoIndice = Integer.parseInt(entrada.nextLine());
                if (tratamientoIndice <= 0 || tratamientoIndice > Tratamiento.getTratamientos().size()) {
                    try {
                        System.out.println("\n--- ¡¡Ingrese bien la opción!! ---\n");
                        Thread.sleep(500); //Esperar 1/2 segundo.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } while (tratamientoIndice <= 0 || tratamientoIndice > Tratamiento.getTratamientos().size());
            Tratamiento tratamientoElegido = Tratamiento.getTratamientos((tratamientoIndice) - 1);
            System.out.println();
            System.out.println("+ Ingresa la fecha\n¡A continuación se le mostrarán los turnos disponibles!");

            String[][] cronograma = llenarMatrices();
            List<String> turnos = cargarTurnos();
            String seguirReservando;

            int dia, turnoHora;

            do {
                do {
                    TurnoServicio.mostrarTurnos(turnos, cronograma);
                    System.out.println();
                    System.out.print("\nIngresa el día de tu reserva: ");
                    dia = Integer.parseInt(entrada.nextLine());
                    diaCerrado = validarDiaCerrado(dia - 1, cronograma);
                    if (diaCerrado) {
                        try {
                            System.out.println("\n--- El día '" + dia + "' el establecimiento está cerrado. Por favor ingrese otro día ---");
                            Thread.sleep(1500); //Esperar 1.5 segundos.
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } while (diaCerrado);
                System.out.println();
                int i = 1;
                for (String turno : turnos) {
                    System.out.println(i++ + ". " + turno.trim());
                }
                System.out.print("\nIngresa la hora de tu reserva (1-7): ");
                turnoHora = Integer.parseInt(entrada.nextLine());
            } while (comprobarFechaTurno(dia - 1, turnoHora - 1, cronograma));

            Turno nuevoTurno = new Turno(nuevoCliente, dia, turnos.get(turnoHora), tratamientoElegido);
            System.out.println("\n+ Reserva registrada\n");


            try {
                Thread.sleep(500); //Esperar 1/2 segundo.
                System.out.println(nuevoTurno);
                Thread.sleep(2000); //Esperar 2 segundos.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("¿Desea reservar otro turno o servicio? (S/N): ");
            do {
                System.out.print("> ");
                seguirReservando = entrada.nextLine();
            } while (!seguirReservando.equalsIgnoreCase("s") && !seguirReservando.equalsIgnoreCase("n"));
            if (seguirReservando.equalsIgnoreCase("n")) {
                continuaReservando = false;
            }
        } while (continuaReservando);
        System.out.println("\n¡Gracias por elegirnos!");
        try {
            Thread.sleep(1000);
            System.out.println("\nVolviendo al menú principal...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean validarDiaCerrado(int dia, String[][] cronograma) {
        boolean valid = false;
        for (int i = 0; i < 7; i++) {
            if (cronograma[dia][i] == "   Cerrado   ") {
                valid = true;
            }
        }
        return valid;
    }

    public static boolean comprobarFechaTurno(int dia, int turno, String[][] cronograma) {
        if (cronograma[dia][turno] == "  Reservado  ") {
            try {
                System.out.println("\n--- El día y turno seleccionado están reservado. Por favor ingrese otro día o turno ---");
                Thread.sleep(1500); //Esperar 1.5 segundos.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            cronograma[dia][turno] = "  Reservado  ";
        }
        return false;
    }

    public static String[][] llenarMatrices() {
        String[][] cronograma = new String[30][7];
        int cont = 0;
        int cont1 = 1;
        int numAzar = 0;

        for (int i = 0; i < cronograma.length; i++) {
            for (int j = 0; j < cronograma[0].length; j++) {
                //Se utiliza la función 'Math.random()' para llenar, aleatoreamente, algunas posiciones del cronograma, y
                //de la sensación de encontrarse con un sitio concurrido.
                numAzar = (int) (Math.random() * 2);

                //Condicional para indicar con 'Cerrado', los días sábados y domingos.
                if (i != cont && i != cont1) {
                    if (numAzar == 0) {
                        cronograma[i][j] = "             ";
                    } else {
                        cronograma[i][j] = "  Reservado  ";
                    }
                } else {
                    cronograma[i][j] = "   Cerrado   ";
                }
            }

            //Contador para que cada 7 dias se coloque "Cerrado", solo si la 'i' es igual a su contador.
            if (i == cont) {
                cont += 7;
            }
            if (i == cont1) {
                cont1 += 7;
            }
        }
        return cronograma;
    }
}