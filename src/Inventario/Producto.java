package Inventario;
import java.util.ArrayList;
import java.util.Scanner;

class Producto {
    private String nombre;
    private int cantidadInicial;
    private int cantidadVendida;
    private double precio;

    public Producto(String nombre, int cantidadInicial, double precio) {
        this.nombre = nombre;
        this.cantidadInicial = cantidadInicial;
        this.cantidadVendida = 0;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadDisponible() {
        return cantidadInicial - cantidadVendida;
    }

    public double getPrecio() {
        return precio;
    }

    public void vender(int cantidad) {
        if (cantidad <= getCantidadDisponible()) {
            cantidadVendida += cantidad;
            System.out.println("Venta realizada: " + cantidad + " unidades de " + nombre);
        } else {
            System.out.println("No hay suficiente stock disponible para realizar esta venta.");
        }
    }

    public void duplicarInventario() {
        cantidadInicial *= 2;
        System.out.println("Inventario duplicado para el producto: " + nombre);
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Cantidad disponible: " + getCantidadDisponible());
        System.out.println("Precio: $" + precio);
    }
}