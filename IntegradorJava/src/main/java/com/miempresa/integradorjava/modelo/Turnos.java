package com.miempresa.integradorjava.modelo;
//import com.miempresa.integradorjava.modelo.Cliente;

import com.miempresa.integradorjava.servicio.Servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Turnos {
  //Atributos
  private int dia;
  private int mes;
  private int anio;
  private int hora;
  private Cliente cliente;
  private Turnos turno;
  private Servicios tratamiento;
  private static List<Turnos> turnos = new ArrayList<>();


  //Constructor
//  public Turnos(int dia, int mes, int anio, int hora, Cliente cliente) {
//    this.dia = dia;
//    this.mes = mes;
//    this.anio = anio;
//    this.hora = hora;
//    this.cliente = cliente;
//  }
  public Turnos(int dia, int mes, int anio, int hora) {
    this.dia = dia;
    this.mes = mes;
    this.anio = anio;
    this.hora = hora;
  }

  public Turnos(Cliente cliente, Turnos turno, Servicios tratamiento){
    this.cliente = cliente;
    this.hora = turno.hora;
    this.dia = turno.dia;
    this.mes = turno.mes;
    this.anio = turno.anio;
    this.tratamiento = tratamiento;
    turnos.add(this);
  }


  public static Turnos elegirFecha(){
    Scanner entrada = new Scanner(System.in);

    System.out.println("Introduce el día del turno");
    int dia = Integer.parseInt(entrada.nextLine());
    System.out.println("Introduce el mes del turno");
    int mes = Integer.parseInt(entrada.nextLine());
    System.out.println("Introduce el año del turno");
    int anio = Integer.parseInt(entrada.nextLine());
    System.out.println("Introduce la hora del turno");
    int hora = Integer.parseInt(entrada.nextLine());

    return new Turnos(dia, mes, anio, hora);
  }

  public static List<Turnos> getTurnos() {
    return turnos;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Turno: \n");
    sb.append("\t Fecha: ").append(dia).append('/').append(mes).append('/').append(anio).append(" Hora: ").append(hora);
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