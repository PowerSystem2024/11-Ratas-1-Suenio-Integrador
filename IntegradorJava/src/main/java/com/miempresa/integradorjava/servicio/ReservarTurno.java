package com.miempresa.integradorjava.servicio;

import com.miempresa.integradorjava.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservarTurno {

    public List<String> cargarTurnos(){
        List<String> turnos = new ArrayList<>();

        //Completa los horarios de los turnos
        turnos.add("   09:00   ");
        turnos.add("   10:30   ");
        turnos.add("   12:00   ");
        turnos.add("   13:30   ");
        turnos.add("   15:00   ");
        turnos.add("   16:00   ");
        turnos.add("   18:00   ");

        return turnos;
    }

    public String[][] llenarMatrices () {
        String[][] cronograma = new String[29][6];
        int cont = 0;
        int cont1 = 1;
        int numAzar = 0;

        for (int i = 0; i < cronograma.length; i++) {
            for (int j = 0; j < cronograma[0].length; j++) {
                //Se utiliza la función 'Math.random()' para llenar, aleatoreamente, algunas posiciones del cronograma, y
                //de la sensación de encontrarse con un sitio concurrido.
                numAzar = (int) (Math.random() * 2) + 1;

                //Condicional para indicar con 'Cerrado', los días sábados y domingos.
                if (i != cont && i != cont1) {
                    if (numAzar == 0) {
                        cronograma[i][j] = "         ";
                    } else {
                        cronograma[i][j] = "Reservado";
                    }
                } else {
                    cronograma[i][j] = " Cerrado ";
                }
            }

            //Contador para que cada 7 dias se coloque "Cerrado", solo si la 'i' es igual a su contador.
            if  (i == cont) {
                cont += 7;
            }
            if  (i == cont1) {
                cont += 7;
            }
        }
        return cronograma;
    }

    public void mostrarTurnos(List<String> turnos, String[][] cronograma) {
        int numDias = 30;
        int numTurnos = 7;
        int cont = 0;

        System.out.println("");
        // Mostrar encabezados de horarios
        System.out.println("       | " + turnos.get(0) + " || " + turnos.get(1) + " || " + turnos.get(2) + " || " + turnos.get(3) + " || " + turnos.get(4) + " || " + turnos.get(5) + " || " + turnos.get(6) + " |");
        for (int i = 0; i < numDias; i++) {
            for (int j = 0; j < numTurnos; j++) {
                if (cont == 0) {
                    System.out.print("       ");
                }
                System.out.print("_________");
                cont++;
            }

            cont = 0;
            System.out.println("");

            if (i > 9) {
                System.out.print("Dia " + i + ":");
            } else {
                System.out.print("Dia " + i + ":");
            }

            for (int j = 0; j < numTurnos; j++) {
                if (cont == 0) {
                    System.out.print("");
                }

                if  (cronograma[i-1][j-1] != "") {
                    System.out.print("|   " + cronograma[i-1][j-1] + "   |");
                } else {
                    System.out.print("|       |");
                }
                cont++;
            }

            cont = 0;
            System.out.println("");

            if (i == 30) {
                for (int j = 0; j < numTurnos; j++) {
                    if (cont == 0) {
                        System.out.print("       ");
                    }
                    System.out.print("_______________");
                    cont++;
                }
            }

            cont = 0;
        }
    }

    public Cliente cargarCliente(){
        String nombre;
        String apellido;
        String correo;
        String telefono;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese su nombre");
        nombre = entrada.nextLine();
        System.out.println("Ingrese su apellido");
        apellido = entrada.nextLine();
        System.out.println("Ingrese su correo");
        correo = entrada.nextLine();
        System.out.println("Ingrese su telefono");
        telefono = entrada.nextLine();

        entrada.close();
        Cliente cliente = new Cliente(nombre, apellido, correo, telefono);

        return cliente;
    }

    public String[][] reservar(String[][] cronograma, List<String>turnos, List<Servicios> listServicios){
        Scanner entrada = new Scanner(System.in);
        String [][] reserva = new String[20][3];
        String otraReservaSoN;
        Cliente cliente = cargarCliente();
        int numFila = 0;
        int numCol = 0;
        int dia = 0;
        int turno = 0;
        Boolean isCorrectDate;
        Boolean otraReserva = true;

        do {
            reserva[numFila][numCol] = cliente.getNombre() + " " + cliente.getApellido();
            System.out.println("--------------------------------------------------------");
            int numServicios = 1;

            System.out.println("A continuación le mostraremos nuestros servicios disponibles");
            for (Servicios servicios : listServicios){
                System.out.println("Servicio N°" + numServicios);
                servicios.mostrarServicio();
                numServicios++;
            }
            System.out.println("Ingrese el número del servicio que desea reservar");
            reserva[numFila][numCol + 1] = entrada.nextLine();

            System.out.println("--------------------------------------------------------");
            System.out.println("A continuación le mostraremos nuestros días y turnos disponibles");
            mostrarTurnos(turnos, cronograma);


            do {
                isCorrectDate = true;
                System.out.println("Ingrese el día deseado");
                dia = Integer.parseInt(entrada.nextLine());

                System.out.println("De los siguientes turnos, ingrese el número deseado");
                for (int i = 0; i < turnos.stream().count(); i++) {
                    System.out.println("N°" + (i + 1) + " " + turnos.get(i));
                }
                turno = Integer.parseInt(entrada.nextLine());

                isCorrectDate = comprobarFechaTurno(dia - 1, turno - 1, cronograma);

                if (isCorrectDate){
                    System.out.println("El día y turno seleccionado ya estan reservado. Por favor ingrese otro día o turno");
                }
            }while (isCorrectDate);

            System.out.println("Desea reservar otro turno o servicio? S/N");
            otraReservaSoN = entrada.nextLine();
            if (otraReservaSoN.toLowerCase() == "n"){
                otraReserva = false;
            }

        }while(otraReserva);

        entrada.close();

        return reserva;
    }

    public boolean comprobarFechaTurno(int dia, int turno, String[][] cronograma){

        if(cronograma[dia][turno] == "Reservado"){
            return true;
        }

        return false;
    }
}