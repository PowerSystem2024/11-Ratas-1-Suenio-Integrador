package com.miempresa.integradorjava;

public class Ejemplos {
  public static void main(String[] args) {

    String[][] horarios = new String[7][2];

    horarios[0][0] = " Lun";
    horarios[1][0] = " Mar";
    horarios[2][0] = " Mie";
    horarios[3][0] = " Jue";
    horarios[4][0] = " Vie";
    horarios[5][0] = " Sab";
    horarios[6][0] = " Dom";
    horarios[0][1] = "09:00 - 19:30";
    horarios[1][1] = "09:00 - 19:30";
    horarios[2][1] = "09:00 - 19:30";
    horarios[3][1] = "09:00 - 19:30";
    horarios[4][1] = "09:00 - 19:30";
    horarios[5][1] = "      CERRADO";
    horarios[6][1] = "      CERRADO";


    for (int i = 0; i < horarios.length; i++) {
      System.out.println(horarios[i][0] + " " + horarios[i][1]);
    }
  }
}



