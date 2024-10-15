package com.miempresa.integradorjava.servicio;

import java.util.List;

public class ReservarTurno {

    public void llenarMatrices (List<String> turnos, String[][] cronograma, String[][] reserva) {
        int cont = 0;
        int cont1 = 1;
        int numAzar = 0;

        //Completa los horarios de los turnos
        turnos.add("   09:00   ");
        turnos.add("   10:30   ");
        turnos.add("   12:00   ");
        turnos.add("   13:30   ");
        turnos.add("   15:00   ");
        turnos.add("   16:00   ");
        turnos.add("   18:00   ");

        for (int i = 0; i < 29; i++) {
            for (int j = 0; j < 6; j++) {
                //Se utiliza la función 'Math.random()' para llenar, aleatoreamente, algunas posiciones del cronograma, y
                //de la sensación de encontrarse con un sitio concurrido.
                numAzar = (int) (Math.random() * 2) + 1;

                //Condicional para indicar con 'Cerrado', los días sábados y domingos.
                if (i != cont && i != cont1) {
                    if (numAzar == 0) {
                        cronograma[i][j] = "       ";
                    } else {
                        cronograma[i][j] = "   R   ";
                    }
                } else {
                    cronograma[i][j] = "Cerrado";
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

        //Inicializamos todos los lugares de las reservas en "" para que no de error en la comprobación posterior.
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 2; j++) {
                reserva[i][j] = "";
            }
        }
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
}