package com.miempresa.integradorjava.servicio;

import com.miempresa.integradorjava.modelo.Cliente;
import com.miempresa.integradorjava.util.Utilidades;

import java.util.Scanner;

public class ClienteServicio {
  public static Cliente cargarCliente() {
    String nombre, apellido, correo, telefono;
    boolean isCorrectCorreo, isCorrectTelefono;

    Scanner entrada = new Scanner(System.in);
    System.out.print("\nNombre: ");
    nombre = entrada.nextLine();
    System.out.print("Apellido: ");
    apellido = entrada.nextLine();

    do {
      System.out.print("Correo: ");
      correo = entrada.nextLine();
      isCorrectCorreo = Utilidades.validarCorreo(correo);
      if (!isCorrectCorreo){
        System.out.println("El correo ingresado no es válido");
      }
    }while(!isCorrectCorreo);

    do {
      System.out.print("Teléfono: ");
      telefono = entrada.nextLine();
      isCorrectTelefono = Utilidades.validarTelefono(telefono);
      if (!isCorrectTelefono){
        System.out.println("El número de teléfono es invalido");
      }
    }while (!isCorrectTelefono);

    Cliente cliente = new Cliente(nombre, apellido, correo, telefono);
    return cliente;
  }
}
