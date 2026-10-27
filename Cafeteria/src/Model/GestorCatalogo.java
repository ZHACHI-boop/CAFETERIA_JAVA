package Model;

import java.util.ArrayList;

public class GestorCatalogo {
    private ArrayList<Producto> listaProductos;
    private ArrayList<Pedido> listaVentas;

    public GestorCatalogo() {
        listaProductos = new ArrayList<>();
        listaVentas = new ArrayList<>();
    }

    public ArrayList<Producto> getListaProductos() { return listaProductos; }
    public ArrayList<Pedido> getListaVentas() { return listaVentas; }

    public boolean registrarProducto(Producto nuevo) {
        for (Producto p : listaProductos) {
            if (p.getCodigo().equalsIgnoreCase(nuevo.getCodigo())) {
                return false;
            }
        }
        listaProductos.add(nuevo);
        return true;
    }

    public Producto buscarProducto(String codigo) {
        for (Producto p : listaProductos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    public boolean reponerStock(String codigo, int cantidad) {
        Producto p = buscarProducto(codigo);
        if (p != null) {
            p.reponerStock(cantidad);
            return true;
        }
        return false;
    }

    public String registrarPedido(String codigo, int cantidad) {
        Producto p = buscarProducto(codigo);
        if (p == null) {
            return "Error: El producto no existe en el catálogo.";
        }
        if (p.getStock() < cantidad) {
            return "Stock insuficiente. Disponible actual: " + p.getStock();
        }

        p.descontarStock(cantidad);
        double subtotal = p.getPrecio() * cantidad;
        listaVentas.add(new Pedido(p.getCodigo(), p.getNombre(), cantidad, subtotal));

        return "Venta exitosa. Total a cobrar: $" + String.format("%.2f", subtotal);
    }

    public double calcularGananciaTotal() {
        double total = 0;
        for (Pedido v : listaVentas) {
            total += v.getSubtotal();
        }
        return total;
    }

    public String obtenerProductoMasVendido() {
        if (listaVentas.isEmpty()) return "No hay ventas registradas.";
        
        String masVendido = "";
        int maxCantidad = -1;
        
        for (Producto p : listaProductos) {
            int acumulado = 0;
            for (Pedido v : listaVentas) {
                if (v.getCodigoProducto().equalsIgnoreCase(p.getCodigo())) {
                    acumulado += v.getCantidad();
                }
            }
            if (acumulado > maxCantidad) {
                maxCantidad = acumulado;
                masVendido = p.getNombre() + " (" + maxCantidad + " unidades)";
            }
        }
        return masVendido.isEmpty() ? "Ninguno" : masVendido;
    }
}