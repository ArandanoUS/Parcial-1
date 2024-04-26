package Inventario;
import java.util.*;
public class inventario {
    public static class GestionInventario {
        private static Scanner scanner = new Scanner(System.in);
        private static List<Producto> inventario = new ArrayList<>();

        public static void SysInv() {
            boolean salir = false;
            while (!salir) {
                System.out.println("1. Ingresar nuevo producto");
                System.out.println("2. Vender producto");
                System.out.println("3. Duplicar inventario de un producto");
                System.out.println("4. Mostrar inventario");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        ingresarNuevoProducto();
                        break;
                    case 2:
                        venderProducto();
                        break;
                    case 3:
                        duplicarInventario();
                        break;
                    case 4:
                        mostrarInventario();
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            }
        }

        private static void ingresarNuevoProducto() {
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la cantidad inicial: ");
            int cantidadInicial = scanner.nextInt();
            System.out.print("Ingrese el precio: ");
            double precio = scanner.nextDouble();
            inventario.add(new Producto(nombre, cantidadInicial, precio));
            System.out.println("Producto ingresado correctamente.");
        }

        private static void venderProducto() {
            System.out.print("Ingrese el nombre del producto a vender: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la cantidad a vender: ");
            int cantidad = scanner.nextInt();
            for (Producto producto : inventario) {
                if (producto.getNombre().equals(nombre)) {
                    producto.vender(cantidad);
                    return;
                }
            }
            System.out.println("Producto no encontrado en el inventario.");
        }

        private static void duplicarInventario() {
            System.out.print("Ingrese el nombre del producto a duplicar el inventario: ");
            String nombre = scanner.nextLine();
            for (Producto producto : inventario) {
                if (producto.getNombre().equals(nombre)) {
                    producto.duplicarInventario();
                    return;
                }
            }
            System.out.println("Producto no encontrado en el inventario.");
        }

        private static void mostrarInventario() {
            System.out.println("Inventario:");
            for (Producto producto : inventario) {
                producto.mostrarInformacion();
                System.out.println();
            }
        }
    }
}
