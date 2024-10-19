package com.miempresa.integradorjava;

import com.miempresa.integradorjava.modelo.Cliente;
import com.miempresa.integradorjava.modelo.Turnos;
import com.miempresa.integradorjava.servicio.Servicios;

import static com.miempresa.integradorjava.servicio.Menu.menu;
//import static com.miempresa.integradorjava.servicio.Servicios.mostrarTratamientos;


public class Main {
  public static void main(String[] args) {
    System.out.println("================================================");
    System.out.println("        ********** 11 Sueños **********         ");
    System.out.println("================================================");

    menu();

    //El main principal solo tiene el título y la llamada a menú.

    //Descomentar para ver el ejemplo del turno.
//    Cliente cliente = new Cliente("Chris", "Bonilla", "chris@gmail.com", "23234422");
//    Turnos turno = new Turnos(2, 3, 2024, 18);
//    Servicios servicio = new Servicios("masaje", 20, 2000);
//    Turnos nuevoTurno = new Turnos(cliente, turno, servicio);

    //Tenía pensado que los turnos se mostraran así (nuevoTurno)
//    System.out.println(nuevoTurno);
  }
}


