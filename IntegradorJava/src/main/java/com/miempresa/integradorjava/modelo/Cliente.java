package com.miempresa.integradorjava.modelo;

import java.util.Scanner;

public class Cliente {
  //Atributos
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

  public static Cliente pedirDatos(){
    Scanner entrada = new Scanner(System.in);

    System.out.print("Ingrese su nombre: ");
    String nombre = entrada.nextLine();
    System.out.print("Ingrese su apellido: ");
    String apellido = entrada.nextLine();
    System.out.print("Ingrese su teléfono: ");
//    int telefono = Integer.parseInt(entrada.nextLine());
    String telefono = entrada.nextLine();
    System.out.print("Ingrese su correo: ");
    String correo = entrada.nextLine();

    return new Cliente(nombre, apellido, correo, telefono);
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

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Cliente " + ID + ": \n");
    sb.append("\t Nombre: ").append(nombre);
    sb.append(", Apellido: ").append(apellido);
    sb.append(", Correo: ").append(correo);
    sb.append(", Telefono: ").append(telefono);
    sb.append(' ');
    return sb.toString();
  }
}
