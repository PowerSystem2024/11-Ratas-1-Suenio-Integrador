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
  public static Servicios getTratamientos(int indice) {
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
    for (Servicios tratamiento: tratamientos) {
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
      Servicios.reservarTurno();
//      ReservarTurno1.reservar(Servicios.getTratamientos());
    } else if (opcion == 2){
//      System.out.println("menu principal");
      Menu.menu();
    }
  }

  public static void main(String[] args) {
//    mostrarTratamientos();
//    System.out.println(Servicios.getTratamientos(2));
    Servicios.reservarTurno();
  }

  public static void reservarTurno() {
    Scanner entrada = new Scanner(System.in);

    System.out.println("Primero elegí uno de los siguientes tratamientos");
    //Iteramos la lista de tratamientos
    for (Servicios tratamiento : Servicios.getTratamientos()) {
      System.out.println(tratamiento);
    }
    int tratamientoIndice;
    do {
      System.out.print("> ");
      tratamientoIndice = Integer.parseInt(entrada.nextLine());
    } while (tratamientoIndice <= 0 || tratamientoIndice > Servicios.getTratamientos().size()); //Verificamos que el tratamiento esté en la lista
    //Si está dentro de la lista, se guarda.
    Servicios tratamientoElegido = Servicios.getTratamientos((tratamientoIndice) - 1);

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
      Turnos nuevoTurno = new Turnos(nuevoCliente, dia, turnos.get(turnoHora), tratamientoElegido);
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

