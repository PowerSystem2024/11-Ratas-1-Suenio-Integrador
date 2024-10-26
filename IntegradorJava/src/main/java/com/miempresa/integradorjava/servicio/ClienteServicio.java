package com.miempresa.integradorjava.servicio;

import com.miempresa.integradorjava.modelo.Cliente;
import com.miempresa.integradorjava.util.Utilidades;

import java.util.Scanner;

public class ClienteServicio {
    public static Cliente cargarCliente() {
        String nombre, apellido, correo, telefono;
        boolean isCorrectCorreo, isCorrectTelefono;

        Scanner entrada = new Scanner(System.in);
        do {
            System.out.print("\nNombre: ");
            nombre = entrada.nextLine();
            if (nombre.length() <= 2) {
                System.out.println("\n-- Ingrese un nombre y apellido válido (más de 2 carácteres) --");
            }
        } while (nombre.length() <= 2);

        do {
            System.out.print("Apellido: ");
            apellido = entrada.nextLine();
            if (apellido.length() <= 2) {
                System.out.println("\n-- Ingrese un apellido válido (más de 2 carácteres) --\n");
            }
        } while (apellido.length() <= 2);

        do {
            System.out.print("Correo: ");
            correo = entrada.nextLine();
            isCorrectCorreo = Utilidades.validarCorreo(correo);
            if (!isCorrectCorreo) {
                System.out.println("\n-- El correo ingresado no es válido --\n");
            }
        } while (!isCorrectCorreo);

        do {
            System.out.print("Teléfono: ");
            telefono = entrada.nextLine();
            isCorrectTelefono = Utilidades.validarTelefono(telefono);
            if (!isCorrectTelefono) {
                System.out.println("\n-- El número de teléfono es invalido --\n");
            }
        } while (!isCorrectTelefono);

        Cliente cliente = new Cliente(nombre, apellido, correo, telefono);
        return cliente;
    }
}