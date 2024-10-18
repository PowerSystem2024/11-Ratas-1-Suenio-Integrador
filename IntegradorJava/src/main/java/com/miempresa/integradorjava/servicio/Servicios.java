package com.miempresa.integradorjava.servicio;

import com.miempresa.integradorjava.modelo.Cliente;
import com.miempresa.integradorjava.modelo.Turnos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Servicios {
  private String nombre;
  private int duracion;
  private double precio;
  private int index = 1;
  private static int contadorIndex;
  private static List<Servicios> tratamientos = new ArrayList<>();

  //En un bloque estático podremos inicializar instancias predefinidas que pertenezcan a la clase
  static {
    new Servicios("Masaje Relajante", 60, 7000);
    new Servicios("Terapia Facial", 60, 10000);
    new Servicios("Depilación Láser", 60, 23000);
  }

  //Constructor
  public Servicios(String nombre, int duracion, double precio) {
    this.nombre = nombre;
    this.duracion = duracion;
    this.precio = precio;
    this.index = ++Servicios.contadorIndex;
    //Esto significa que toda nueva instancia será a su vez agregada a la lista de tratamientos
    tratamientos.add(this);
  }
  //Getter
  public static List<Servicios> getTratamientos() {
    return tratamientos;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Tratamiento " + index + ": \n");
    sb.append("\tNombre: ").append(nombre);
    sb.append(", Duracion: ").append(duracion);
    sb.append(", Precio: ").append(precio);
    sb.append(' ');
    return sb.toString();
  }

  //Métodos
  public static void mostrarTratamientos(){
    for (Servicios tratamiento: tratamientos) {
      System.out.println(tratamiento);
    }
    Scanner entrada = new Scanner(System.in);
    System.out.println("\n1. Hacer una reserva \n2. Volver al menú principal");
    System.out.print("¿Cómo desea continuar? ");
    int opcion;
    do {
      opcion = entrada.nextInt();
    } while (opcion != 1 || opcion != 2);
    if (opcion == 1){
      Servicios.reservarTurno();
    } else if (opcion == 2){
      System.out.println("menu principal");
    }
  }

  public static void reservarTurno(){
    System.out.println("Nuestros horarios");
    Turnos.mostrarHorarios();
    System.out.println();
    Scanner entrada = new Scanner(System.in);
    int opcion;
    System.out.print("Elige el tratamiento deseado: ");
    opcion = Integer.parseInt(entrada.nextLine());

    if (opcion >= 0 && opcion < tratamientos.size()){
      //Se puede mostrar un calendario e ir seleccionando las fechas
      Servicios tratamientoElegido = tratamientos.get(opcion);
      //Crear nuevo Turno
      System.out.println("¡Ahora deberá ingresar sus datos!");
      Cliente nuevoCliente = Cliente.pedirDatos();
      System.out.println("¡Ahora deberá ingresar los datos de la reserva!");
      Turnos fechaTurno = Turnos.elegirFecha();
      Turnos nuevoTurno = new Turnos(nuevoCliente, fechaTurno, tratamientoElegido);
      System.out.println(nuevoTurno);
      System.out.println("----------");
      System.out.println(Turnos.getTurnos());
      //Después agregar el nuevo turno a la lista
    }
  }
}
