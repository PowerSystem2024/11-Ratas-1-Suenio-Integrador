package com.miempresa.integradorjava.servicio;

import com.miempresa.integradorjava.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservarTurno {

    public List<String> cargarTurnos() {
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

    public String[][] llenarMatrices() {
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

    public void mostrarTurnos(List<String> turnos, String[][] cronograma) {
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
        System.out.println("Día\\Hs | " + turnos.get(0) + " || " + turnos.get(1) + " || " + turnos.get(2) + " || " + turnos.get(3) + " || " + turnos.get(4) + " || " + turnos.get(5) + " || " + turnos.get(6) + " |");
        for (int i = 0; i < numDias; i++) {
            for (int k = cont1; k < dias.size(); k++) {
                for (int j = 0; j < numTurnos; j++) {
                    if (cont == 0) {
                        System.out.print("       ");
                    }
                    System.out.print("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                    cont++;
                }

                cont = 0;
                System.out.println("");

                if (i > 8) {
                    System.out.print(dias.get(k) + (i + 1) + ":");
                } else {
                    System.out.print(dias.get(k) + (i + 1) + ": ");
                }

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
                if (cont1 == 7) {
                    cont1 = 0;
                }
                break;
            }
        }
    }

    public Cliente cargarCliente() {
        String nombre;
        String apellido;
        String correo;
        String telefono;
        boolean isCorrectCorreo;
        boolean isCorrectTelefono;

        Scanner entrada = new Scanner(System.in);
        System.out.println("--------------------------------------------------------");
        System.out.println("Menú >> Reserva Online");
        System.out.println("\nIngrese su nombre: ");
        System.out.print("> ");
        nombre = entrada.next();

        System.out.println("Ingrese su apellido: ");
        System.out.print("> ");
        apellido = entrada.next();

        do {
            System.out.println("Ingrese su correo: ");
            System.out.print("> ");
            correo = entrada.next();
            isCorrectCorreo = validarCorreo(correo);
        } while (!isCorrectCorreo);

        do {
            System.out.println("Ingrese su telefono: ");
            System.out.print("> ");
            telefono = entrada.next();
            isCorrectTelefono = validarTelefono(telefono);
        } while (!isCorrectTelefono);

        System.out.println("--------------------------------------------------------");

        Cliente cliente = new Cliente(nombre, apellido, correo, telefono);

        return cliente;
    }

    public static boolean validarCorreo(String correo) {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!correo.matches(EMAIL_REGEX)) {
            try {
                System.out.println("\n-- El correo ingresado no es valido --\n");
                Thread.sleep(1000); //Esperar 1 segundo.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return correo.matches(EMAIL_REGEX);
    }

    public static boolean validarTelefono(String telefono) {
        String PHONE_REGEX = "^\\+?[0-9 ]{7,15}$";

        if (!telefono.matches(PHONE_REGEX)) {
            try {
                System.out.println("\n-- El número de teléfono es invalido --\n");
                Thread.sleep(1000); //Esperar 1 segundo.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return telefono.matches(PHONE_REGEX);
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

    public String[][] reservar(List<Servicios> listServices) {
        Scanner entrada = new Scanner(System.in);
        String[][] reserva = new String[20][3];
        String[][] cronograma = llenarMatrices();
        List<String> turnos = cargarTurnos();

        String otraReservaSoN;
        Cliente cliente = cargarCliente();

        int numFila = 0;
        int numCol = 0;
        int dia = 0;
        int turno = 0;

        Boolean isCorrectDate;
        Boolean otraReserva = true;
        Boolean diaCerrado = false;

        do {
            reserva[numFila][numCol] = cliente.getNombre() + " " + cliente.getApellido();
            System.out.println("\n--------------------------------------------------------");
            int numServicios = 1;

            do {
                System.out.println("A continuación le mostraremos nuestros servicios disponibles:\n");
                for (Servicios servicios : listServices) {
                    System.out.println("Servicio N°" + numServicios);
                    servicios.mostrarServicio();
                    numServicios++;
                }
                System.out.println("Ingrese el número del servicio que desea reservar");
                System.out.print("> ");
                reserva[numFila][numCol + 1] = entrada.next();
                if (!reserva[numFila][numCol + 1].equals("1") && !reserva[numFila][numCol + 1].equals("2") && !reserva[numFila][numCol + 1].equals("3")) {
                    try {
                        System.out.println("\n--- ¡¡Ingrese bien la opción!! ---\n");
                        Thread.sleep(1000); //Esperar 1 segundo.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                numServicios = 1;
            } while (!reserva[numFila][numCol + 1].equals("1") && !reserva[numFila][numCol + 1].equals("2") && !reserva[numFila][numCol + 1].equals("3"));

            System.out.println("--------------------------------------------------------");
            System.out.println("A continuación le mostraremos nuestros días y turnos disponibles");

            do {
                do {
                    mostrarTurnos(turnos, cronograma);
                    isCorrectDate = true;
                    System.out.println("\nIngrese el número de día deseado");
                    System.out.print("> ");
                    dia = Integer.parseInt(entrada.next());
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

                System.out.println("\nDe los siguientes turnos, ingrese el número deseado:");
                for (int i = 0; i < turnos.stream().count(); i++) {
                    System.out.println("N°" + (i + 1) + " " + turnos.get(i));
                }
                System.out.print("> ");
                turno = Integer.parseInt(entrada.next());

                isCorrectDate = comprobarFechaTurno(dia - 1, turno - 1, cronograma);
            } while (isCorrectDate);

            System.out.println("\nDesea reservar otro turno o servicio? S/N");
            System.out.print("> ");
            otraReservaSoN = entrada.next();
            System.out.println(otraReservaSoN);
            if (otraReservaSoN.toLowerCase().equals("n")) {
                otraReserva = false;
            }

        } while (otraReserva);

        try {
            Thread.sleep(1000); //Esperar 1 segundo.
            System.out.println("\nSu reserva ya fue recibida!!");
            Thread.sleep(500); //Esperar 1/2 segundo.
            System.out.println("\n- Datos de la reserva realizada:");
            System.out.println("\n  > A nombre de: '" + cliente.getApellido() + " " + cliente.getNombre() + "'");
            System.out.println("\n  > Día y turno: '" + dia + "', " + turnos.get(turno - 1).replace(" ", ""));
            System.out.println("\n- Datos de contactos del cliente:");
            System.out.println("\n  > Teléfono: '" + cliente.getTelefono() + "'");
            System.out.println("\n  > Correo: '" + cliente.getCorreo() + "'");
            Thread.sleep(2000); //Esperar 2 segundos.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return reserva;
    }

    public boolean comprobarFechaTurno(int dia, int turno, String[][] cronograma) {

        if (cronograma[dia][turno] == "  Reservado  ") {
            try {
                System.out.println("\n--- El día y turno seleccionado ya estan reservado. Por favor ingrese otro día o turno ---");
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
}