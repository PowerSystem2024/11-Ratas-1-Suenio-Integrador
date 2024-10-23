package com.miempresa.integradorjava.util;

public class Utilidades {

  //Encabezado a usar en cada sección
  public static void encabezado(String encabezado){
    System.out.println("\n------------------------------------------------");
    System.out.println("Menú   >>  " + encabezado);
    System.out.println("------------------------------------------------");
    System.out.println();
  }
  //Encabezado para la sección de contacto
  public static void encabezadoContacto(String encabezado, String encabezado2){
    System.out.println("\n------------------------------------------------");
    System.out.println("Menú   >>  " + encabezado + "  >>  " + encabezado2);
    System.out.println("------------------------------------------------");
    System.out.println();
  }

  //Validaciones
  public static boolean validarCorreo(String correo){
    String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    return correo.matches(EMAIL_REGEX);
  }
  public static boolean validarTelefono(String telefono){
    String PHONE_REGEX = "^\\+?[0-9 ]{7,15}$";
    return telefono.matches(PHONE_REGEX);
  }
}
