package com.cafeteria.modelo;

import java.util.Scanner;

import Model.GestorArchivo;
import Model.GestorCatalogo;
import Model.Producto;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorCatalogo gestor = new GestorCatalogo();
        GestorArchivo archivo = new GestorArchivo();

        archivo.cargarDatos(gestor);
        int opcion = 0;

        do {
            System.out.println("\n========================================");
            System.out.println("  CAFETERIA UNIVERSITARIA «EL BUEN SABOR» ");
            System.out.println("========================================");
            System.out.println("1. Registrar Nuevo Producto");
            System.out.println("2. Consultar Catálogo / Inventario");
            System.out.println("3. Reponer Stock");
            System.out.println("4. Atender y Registrar Pedido");
            System.out.println("5. Reporte Global de Ganancias y Ventas");
            System.out.println("6. Salir (Guardar y Cerrar)");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                System.out.println();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese Código/ID: ");
                        String cod = scanner.nextLine();
                        System.out.print("Ingrese Nombre del producto: ");
                        String nom = scanner.nextLine();
                        System.out.print("Ingrese Precio unitario ($): ");
                        double precio = Double.parseDouble(scanner.nextLine());
                        System.out.print("Ingrese Stock inicial: ");
                        int stock = Integer.parseInt(scanner.nextLine());

                        Producto nuevo = new Producto(cod, nom, precio, stock);
                        if (gestor.registrarProducto(nuevo)) {
                            System.out.println("Producto registrado exitosamente.");
                        } else {
                            System.out.println("Error: Ya existe un producto con ese código.");
                        }
                        break;

                    case 2:
                        System.out.println("--- LISTADO DE PRODUCTOS ---");
                        System.out.printf("%-10s | %-20s | %-10s | %-10s\n", "CÓDIGO", "NOMBRE", "PRECIO", "STOCK");
                        System.out.println("--------------------------------------------------");
                        for (Producto p : gestor.getListaProductos()) {
                            System.out.printf("%-10s | %-20s | $%-9.2f | %-10d\n", p.getCodigo(), p.getNombre(), p.getPrecio(), p.getStock());
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese el Código del producto a reponer: ");
                        String codRep = scanner.nextLine();
                        System.out.print("Ingrese la cantidad a sumar al stock: ");
                        int cantRep = Integer.parseInt(scanner.nextLine());

                        if (gestor.reponerStock(codRep, cantRep)) {
                            System.out.println("Stock repuesto correctamente.");
                        } else {
                            System.out.println("Error: Producto no encontrado.");
                        }
                        break;

                    case 4:
                        System.out.print("Ingrese el Código del producto solicitado: ");
                        String codPed = scanner.nextLine();
                        System.out.print("Ingrese la cantidad deseada: ");
                        int cantPed = Integer.parseInt(scanner.nextLine());

                        String resultadoVenta = gestor.registrarPedido(codPed, cantPed);
                        System.out.println(resultadoVenta);
                        break;

                    case 5:
                        System.out.println("--- REPORTE GLOBAL DE GANANCIAS Y VENTAS ---");
                        System.out.printf("Ganancia Total Acumulada: $%.2f\n", gestor.calcularGananciaTotal());
                        System.out.println("Producto de Mayor Demanda: " + gestor.obtenerProductoMasVendido());
                        break;

                    case 6:
                        archivo.guardarDatos(gestor);
                        System.out.println("Datos guardados correctamente. ¡Hasta luego!");
                        break;

                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error de entrada: Por favor, ingrese un valor numérico válido.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}