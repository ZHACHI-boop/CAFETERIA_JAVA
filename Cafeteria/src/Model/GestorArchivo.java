package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class GestorArchivo {
    private final String ARCHIVO_PRODUCTOS = "productos.txt";
    private final String ARCHIVO_VENTAS = "ventas.txt";

    public void cargarDatos(GestorCatalogo gestor) {

        try {
            File archivoP = new File(ARCHIVO_PRODUCTOS);
            if (archivoP.exists()) {
                Scanner lector = new Scanner(archivoP);
                while (lector.hasNextLine()) {
                    String linea = lector.nextLine();
                    String[] partes = linea.split(",");
                    if (partes.length == 4) {
                        Producto p = new Producto(partes[0], partes[1], Double.parseDouble(partes[2]), Integer.parseInt(partes[3]));
                        gestor.getListaProductos().add(p);
                    }
                }
                lector.close();
            }
        } catch (Exception e) {
            System.out.println("Error al cargar productos: " + e.getMessage());
        }

        try {
            File archivoV = new File(ARCHIVO_VENTAS);
            if (archivoV.exists()) {
                Scanner lector = new Scanner(archivoV);
                while (lector.hasNextLine()) {
                    String linea = lector.nextLine();
                    String[] partes = linea.split(",");
                    if (partes.length == 4) {
                        Pedido v = new Pedido(partes[0], partes[1], Integer.parseInt(partes[2]), Double.parseDouble(partes[3]));
                        gestor.getListaVentas().add(v);
                    }
                }
                lector.close();
            }
        } catch (Exception e) {
            System.out.println("Error al cargar ventas: " + e.getMessage());
        }
    }

    public void guardarDatos(GestorCatalogo gestor) {

        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO_PRODUCTOS))) {
            for (Producto p : gestor.getListaProductos()) {
                pw.println(p.toString());
            }
        } catch (Exception e) {
            System.out.println("Error al guardar productos: " + e.getMessage());
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO_VENTAS))) {
            for (Pedido v : gestor.getListaVentas()) {
                pw.println(v.toString());
            }
        } catch (Exception e) {
            System.out.println("Error al guardar ventas: " + e.getMessage());
        }
    }
}