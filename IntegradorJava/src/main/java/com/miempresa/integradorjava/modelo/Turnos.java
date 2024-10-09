package com.miempresa.integradorjava.modelo;
import com.miempresa.integradorjava.modelo.Cliente;

public class Turnos {
  //Atributos
  private int dia;
  private int mes;
  private int anio;
  private int hora;
  private Cliente cliente;

  //Constructor
  public Turnos(int dia, int mes, int anio, int hora, Cliente cliente) {
    this.dia = dia;
    this.mes = mes;
    this.anio = anio;
    this.hora = hora;
    this.cliente = cliente;
  }

  //Getter & Setter
  public int getDia() {
    return dia;
  }
  public void setDia(int dia) {
    this.dia = dia;
  }
  public int getMes() {
    return mes;
  }
  public void setMes(int mes) {
    this.mes = mes;
  }
  public int getAnio() {
    return anio;
  }
  public void setAnio(int anio) {
    this.anio = anio;
  }
  public int getHora() {
    return hora;
  }
  public void setHora(int hora) {
    this.hora = hora;
  }
  public Cliente getCliente() {
    return cliente;
  }

  @Override
  public String toString() {
    return "Fecha: " + dia+"/"+mes+"/"+anio+ "\nTurno: " + hora + "\nCliente: " + cliente;
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


