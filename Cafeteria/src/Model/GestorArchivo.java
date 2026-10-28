package Model;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class GestorArchivo {
    private File archivoProd;
    private File archivoVentas;

    public GestorArchivo() {
        archivoProd = new File("productos.txt");
        archivoVentas = new File("ventas.txt");
    }

    public void guardarDatos(GestorCatalogo gestor) {
        // Guardar productos
        try (PrintWriter pw = new PrintWriter(archivoProd)) {
            for (Producto p : gestor.getListaProductos()) {
                pw.println(p.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Guardar ventas
        try (PrintWriter pw = new PrintWriter(archivoVentas)) {
            for (Pedido v : gestor.getListaVentas()) {
                pw.println(v.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void leerDatos(GestorCatalogo gestor) {
        // Leer productos
        if (archivoProd.exists()) {
            try (Scanner scanner = new Scanner(archivoProd)) {
                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    String[] p = linea.split(",");
                    if (p.length == 4) {
                        gestor.getListaProductos().add(new Producto(p[0], p[1], Double.parseDouble(p[2]), Integer.parseInt(p[3])));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Leer ventas
        if (archivoVentas.exists()) {
            try (Scanner scanner = new Scanner(archivoVentas)) {
                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    String[] v = linea.split(",");
                    if (v.length == 4) {
                        gestor.getListaVentas().add(new Pedido(v[0], v[1], Integer.parseInt(v[2]), Double.parseDouble(v[3])));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}