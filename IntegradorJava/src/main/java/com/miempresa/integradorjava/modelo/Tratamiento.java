package com.miempresa.integradorjava.modelo;

import com.miempresa.integradorjava.servicio.ReservarTurno1;
import com.miempresa.integradorjava.util.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tratamiento {
  private String nombre;
  private int duracion;
  private double precio;
  private int index = 1;
  private static int contadorIndex;
  private static List<Tratamiento> tratamientos = new ArrayList<>();

  //En un bloque estático podremos inicializar instancias predefinidas que pertenezcan a la clase
  static {
    new Tratamiento("Masaje Relajante", 60, 7000);
    new Tratamiento("Terapia Facial", 60, 10000);
    new Tratamiento("Depilación Láser", 60, 23000);
  }

  //Constructor
  public Tratamiento(String nombre, int duracion, double precio) {
    this.nombre = nombre;
    this.duracion = duracion;
    this.precio = precio;
    this.index = ++Tratamiento.contadorIndex;
    //Esto significa que toda nueva instancia será a su vez agregada a la lista de tratamientos
    tratamientos.add(this);
  }
  //Getter
  public static List<Tratamiento> getTratamientos() {
    return tratamientos;
  }
  public static Tratamiento getTratamientos(int indice) {
    if (indice >= 0 && indice < tratamientos.size()) {
      return tratamientos.get(indice);
    } else {
      throw new IndexOutOfBoundsException("Índice fuera de rangoo.");
    }
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
    for (Tratamiento tratamiento: tratamientos) {
      System.out.println(tratamiento);
    }
    Scanner entrada = new Scanner(System.in);
    System.out.println("\n1. Hacer una reserva \n2. Volver al menú principal");
    int opcion;
    do {
      System.out.print("¿Cómo desea continuar? ");
      opcion = entrada.nextInt();
    } while (opcion != 1 && opcion != 2);
    if (opcion == 1){
      Tratamiento.reservarTurno();
//      ReservarTurno1.reservar(Servicios.getTratamientos());
    } else if (opcion == 2){
//      System.out.println("menu principal");
      Menu.menu();
    }
  }

  public static void main(String[] args) {
//    mostrarTratamientos();
//    System.out.println(Servicios.getTratamientos(2));
    Tratamiento.reservarTurno();
  }

  public static void reservarTurno() {
    Scanner entrada = new Scanner(System.in);

    System.out.println("Primero elegí uno de los siguientes tratamientos");
    //Iteramos la lista de tratamientos
    for (Tratamiento tratamiento : Tratamiento.getTratamientos()) {
      System.out.println(tratamiento);
    }
    int tratamientoIndice;
    do {
      System.out.print("> ");
      tratamientoIndice = Integer.parseInt(entrada.nextLine());
    } while (tratamientoIndice <= 0 || tratamientoIndice > Tratamiento.getTratamientos().size()); //Verificamos que el tratamiento esté en la lista
    //Si está dentro de la lista, se guarda.
    Tratamiento tratamientoElegido = Tratamiento.getTratamientos((tratamientoIndice) - 1);

    System.out.println();
    System.out.println("Ahora elegiremos la fecha\n¡Se le mostrarán los turnos disponibles!");
    String[][] cronograma = ReservarTurno1.llenarMatrices();
    List<String> turnos = ReservarTurno1.cargarTurnos();
    String seguirReservando;
    boolean continuaReservando = true;
    do {
      int i = 1, dia, turnoHora;
      ReservarTurno1.mostrarTurnos(turnos, cronograma);
      System.out.println();
      do {
        System.out.print("\nIngrese el día de su reserva: ");
        dia = Integer.parseInt(entrada.nextLine());
        for (String turno : turnos) {
          System.out.println(i + ": " + turno.trim());
          i++;
        }
        System.out.print("\nIngrese la hora de su reserva: ");
        turnoHora = Integer.parseInt(entrada.nextLine());

      } while (ReservarTurno1.comprobarFechaTurno(dia - 1, turnoHora - 1, cronograma));
      System.out.println("\nAhora deberá ingresar sus datos personales");
      Cliente nuevoCliente = Cliente.pedirDatos();
      Turno nuevoTurno = new Turno(nuevoCliente, dia, turnos.get(turnoHora), tratamientoElegido);
      System.out.println("\nReserva registrada:\n" + nuevoTurno);

      System.out.println("\nDesea reservar otro turno o servicio? S/N");
      do {
        System.out.print("> ");
        seguirReservando = entrada.nextLine();
      } while (!seguirReservando.equalsIgnoreCase("s") && !seguirReservando.equalsIgnoreCase("n"));
      if (seguirReservando.equalsIgnoreCase("n")){
        continuaReservando = false;
      }
    } while (continuaReservando);
    System.out.println("\nGracias por usar nuestros servicios");
  }
}

      //Mi idea era intentar hacerlo lo más conciso y ordenado posible, aprovechando la creación de instancias y
      //los atributos/métodos estáticos.
      //Claro, si es posible xD
      //Hay cosas que están mezcladas, y que debemos borrar.
