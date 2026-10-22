package com.cafeteria.modelo;

public class Pedido {
    private String codigoProducto;
    private String nombreProducto;
    private int cantidad;
    private double subtotal;

    public Pedido(String codigoProducto, String nombreProducto, int cantidad, double subtotal) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public String getCodigoProducto() { return codigoProducto; }
    public int getCantidad() { return cantidad; }
    public double getSubtotal() { return subtotal; }

    @Override
    public String toString() {
        return codigoProducto + "," + nombreProducto + "," + cantidad + "," + subtotal;
    }
}