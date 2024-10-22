package com.miempresa.integradorjava.modelo;

public class Cliente {
  private static int contador = 1;
  private String nombre;
  private String apellido;
  private final int ID;
  private String correo;
  private String telefono;

  //Constructor
  public Cliente(String nombre, String apellido, String correo, String telefono){
    this.ID = contador++;
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.telefono = telefono;
  }

  //Getter & Setter
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getApellido() {
    return apellido;
  }
  public void setApellido(String apellido) {
    this.apellido = apellido;
  }
  public String getCorreo() {
    return correo;
  }
  public void setCorreo(String correo) {
    this.correo = correo;
  }
  public int getID() {
    return ID;
  }
  public String getTelefono() {
    return telefono;
  }
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  //toString
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Cliente " + getID() + ": \n");
    sb.append("\t Nombre: ").append(getNombre());
    sb.append(", Apellido: ").append(getApellido());
    sb.append(", Correo: ").append(getCorreo());
    sb.append(", Telefono: ").append(getTelefono());
    sb.append(' ');
    return sb.toString();
  }
}
