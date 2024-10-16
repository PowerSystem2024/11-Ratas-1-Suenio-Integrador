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
        // Mostrar encabezados de horarios
        System.out.println("       | " + turnos.get(0) + " || " + turnos.get(1) + " || " + turnos.get(2) + " || " + turnos.get(3) + " || " + turnos.get(4) + " || " + turnos.get(5) + " || " + turnos.get(6) + " |");
        for (int i = 0; i < numDias; i++) {
            for (int k = cont1; k < dias.size(); k++) {
                for (int j = 0; j < numTurnos; j++) {
                    if (cont == 0) {
                        System.out.print("       ");
                    }
                    System.out.print("_______________");
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
                        System.out.print("_______________");
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
            if (!isCorrectCorreo){
                System.out.println("El correo ingresado no es valido");
            }
        }while(!isCorrectCorreo);

        do {
            System.out.println("Ingrese su telefono: ");
            System.out.print("> ");
            telefono = entrada.next();
            isCorrectTelefono = validarTelefono(telefono);
            if (!isCorrectTelefono){
                System.out.println("El número de teléfono es invalido");
            }
        }while (!isCorrectTelefono);

        System.out.println("--------------------------------------------------------");

        Cliente cliente = new Cliente(nombre, apellido, correo, telefono);

        return cliente;
    }

    public boolean validarCorreo(String correo){
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return correo.matches(EMAIL_REGEX);
    }

    public boolean validarTelefono(String telefono){
        String PHONE_REGEX = "^\\+?[0-9 ]{7,15}$";
        return telefono.matches(PHONE_REGEX);
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
        int numServicio = 0;

        Boolean isCorrectDate;
        Boolean otraReserva = true;

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
                    System.out.println("\n--- ¡¡Ingrese bien la opción!! ---\n");
                }
                numServicios = 1;
            } while (!reserva[numFila][numCol + 1].equals("1") && !reserva[numFila][numCol + 1].equals("2") && !reserva[numFila][numCol + 1].equals("3"));

            System.out.println("--------------------------------------------------------");
            System.out.println("A continuación le mostraremos nuestros días y turnos disponibles");

            do {
                mostrarTurnos(turnos, cronograma);
                isCorrectDate = true;
                System.out.println("\nIngrese el número de día deseado");
                System.out.print("> ");
                dia = Integer.parseInt(entrada.next());

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
        System.out.println("\nSu reserva ya fue recibida!!");

        return reserva;
    }

    public boolean comprobarFechaTurno(int dia, int turno, String[][] cronograma) {

        if (cronograma[dia][turno] == "  Reservado  ") {
            System.out.println("\n--- El día y turno seleccionado ya estan reservado. Por favor ingrese otro día o turno ---");
            return true;
        } else if (cronograma[dia][turno] == "   Cerrado   ") {
            System.out.println("\n--- El día seleccionado el establecimiento está cerrado. Por favor ingrese otro día ---");
            return true;
        } else {
            cronograma[dia][turno] = "  Reservado  ";
        }

        return false;
    }
}