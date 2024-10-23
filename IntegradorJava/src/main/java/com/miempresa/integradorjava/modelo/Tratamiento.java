package com.miempresa.integradorjava.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tratamiento {
  private String nombre;
  private String descripcion;
  private int duracion;
  private double precio;
  private int index = 1;
  private static int contadorIndex;
  private static List<Tratamiento> tratamientos = new ArrayList<>();

  static {
    new Tratamiento("Reflexología","Terapia para tratar puntos dolorosos a través de masajes podales",60, 7000);
    new Tratamiento("Masaje descontracturante", "Ideal para relajar la musculatura y disolver contracturas",60, 10000);
    new Tratamiento("Pulido corporal e hidratación", "Tratamiento corporal hiper estimulante que elimina las células muertas",60, 23000);
  }

  //Constructor
  public Tratamiento(String nombre, String descripcion, int duracion, double precio) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.duracion = duracion;
    this.precio = precio;
    this.index = ++Tratamiento.contadorIndex;
    tratamientos.add(this);
  }

  //Getter
  public String getNombre() {
    return nombre;
  }
  public String getDescripcion() {
    return descripcion;
  }
  public int getDuracion() {
    return duracion;
  }
  public double getPrecio() {
    return precio;
  }
  public int getIndex() {
    return index;
  }
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

  //toString
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Tratamiento " + getIndex() + ": \n");
    sb.append("\tNombre: ").append(getNombre());
    sb.append("\n\tDescripción: ").append(getDescripcion());
    sb.append("\n\tDuración: ").append(getDuracion()).append(" minutos");
    sb.append("\n\tPrecio: $").append(getPrecio());
    sb.append("\n");
    return sb.toString();
  }
}