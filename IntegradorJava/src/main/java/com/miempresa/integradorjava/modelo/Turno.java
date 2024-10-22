package com.miempresa.integradorjava.modelo;

import java.util.ArrayList;
import java.util.List;

public class Turno {
  private int dia;
  private String hora;
  private Cliente cliente;
  private Tratamiento tratamiento;
  private static List<Turno> turnos = new ArrayList<>();

  //Constructor
  public Turno(int dia, String hora) {
    this.dia = dia;
    this.hora = hora;
  }
  public Turno(Cliente cliente, int dia, String hora, Tratamiento tratamiento) {
    this.cliente = cliente;
    this.hora = hora;
    this.dia = dia;
    this.tratamiento = tratamiento;
    turnos.add(this);
  }

  //Getter
  public Tratamiento getTratamiento() {
    return tratamiento;
  }
  public Cliente getCliente() {
    return cliente;
  }
  public int getDia() {
    return dia;
  }
  public String getHora() {
    return hora;
  }
  public static List<Turno> getTurnos() {
    return turnos;
  }

  //toString
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Turno: \n");
    sb.append("\t Fecha: ").append(getDia()).append("/10/24 ").append(" Hora: ").append(getHora().trim());
    sb.append("\n").append(getCliente());
    sb.append("\n").append(getTratamiento());
    sb.append(' ');
    return sb.toString();
  }
}

