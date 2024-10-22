package com.miempresa.integradorjava.modelo;
//import com.miempresa.integradorjava.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Turno {
  //Atributos
  private int dia;
//  private int mes;
//  private int anio;
  private String hora;
  private Cliente cliente;
  private Turno turno;
  private Tratamiento tratamiento;
  private static List<Turno> turnos = new ArrayList<>();


  //Constructor
//  public Turnos(int dia, int mes, int anio, int hora, Cliente cliente) {
//    this.dia = dia;
//    this.mes = mes;
//    this.anio = anio;
//    this.hora = hora;
//    this.cliente = cliente;
//  }
//  public Turnos(int dia, int mes, int anio, int hora) {
//    this.dia = dia;
//    this.mes = mes;
//    this.anio = anio;
//    this.hora = hora;
//  }
  public Turno(int dia, String hora) {
    this.dia = dia;
    this.hora = hora;
  }

  public Turno(Cliente cliente, int dia, String hora, Tratamiento tratamiento){
    this.cliente = cliente;
//    this.hora = turno.hora;
//    this.dia = turno.dia;
    this.hora = hora;
    this.dia = dia;
//    this.mes = turno.mes;
//    this.anio = turno.anio;
    this.tratamiento = tratamiento;
    turnos.add(this);
  }


  public static Turno elegirFecha(){
    Scanner entrada = new Scanner(System.in);

    System.out.println("Introduce el día del turno");
    int dia = Integer.parseInt(entrada.nextLine());
    System.out.println("Introduce el mes del turno");
    int mes = Integer.parseInt(entrada.nextLine());
    System.out.println("Introduce el año del turno");
    int anio = Integer.parseInt(entrada.nextLine());
    System.out.println("Introduce la hora del turno");
    String hora = entrada.nextLine();

//    return new Turnos(dia, mes, anio, hora);
    return new Turno(dia, hora);
  }

  public static List<Turno> getTurnos() {
    return turnos;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Turno: \n");
    sb.append("\t Fecha: ").append(dia).append('/').append("10").append('/').append("2024").append(" Hora: ").append(hora.trim());
    sb.append("\n").append(cliente);
    sb.append("\n").append(tratamiento);
    sb.append(' ');
    return sb.toString();
  }

  private static String[][] horarios = {
          {"Lun", "09:00 - 19:30"},
          {"Mar", "09:00 - 19:30"},
          {"Mie", "09:00 - 19:30"},
          {"Jue", "09:00 - 19:30"},
          {"Vie", "09:00 - 19:30"},
          {"Sab", "CERRADO"},
          {"Dom", "CERRADO"}
  };

  public static void mostrarHorarios() {
    for (int i = 0; i < horarios.length; i++) {
      System.out.println(horarios[i][0] + " " + horarios[i][1]);
    }
  }
}