package com.miempresa.integradorjava.servicio;

public class Servicios {
    private String nombre;
    private String descripcion;
    private int duracion;  // en minutos
    private double precio;  // en pesos

    // Constructor para inicializar los atributos
    public Servicios(String nombre, String descripcion, int duracion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.precio = precio;
    }

    // Método para mostrar los detalles del servicio
    public void mostrarServicio() {
        System.out.println("Nombre del servicio: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Duración: " + duracion + " minutos");
        System.out.println("Precio: $" + precio);
        System.out.println("-------------------------------------------");
    }

    // Ejemplos de Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}