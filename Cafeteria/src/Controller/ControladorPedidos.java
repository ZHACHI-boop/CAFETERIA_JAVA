package Controller;

import Model.GestorCatalogo;
import Model.GestorArchivo;
import Model.Producto;
import Model.Pedido;
import View.PanelPedidos;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorPedidos {
    private PanelPedidos vista;
    private GestorCatalogo modelo;
    private GestorArchivo gestorArchivo;
    private ArrayList<Pedido> carritoTemporal;

    public ControladorPedidos(PanelPedidos vista, GestorCatalogo modelo, GestorArchivo gestorArchivo) {
        this.vista = vista;
        this.modelo = modelo;
        this.gestorArchivo = gestorArchivo;
        this.carritoTemporal = new ArrayList<>();

        cargarProductosEnCombo();

        this.vista.getCmbProductos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarStockDisponible();
            }
        });

        this.vista.getBtnAgregarPedido().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarItemCarrito();
            }
        });

        this.vista.getBtnFinalizarVenta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarVenta();
            }
        });
    }

    private void cargarProductosEnCombo() {
        vista.getCmbProductos().removeAllItems();
        vista.getCmbProductos().addItem("-- Seleccione un producto --");
        for (Producto p : modelo.getListaProductos()) {
            vista.getCmbProductos().addItem(p.getCodeNombre());
        }
    }

    private void actualizarStockDisponible() {
        int index = vista.getCmbProductos().getSelectedIndex();
        if (index > 0) {
            Producto p = modelo.getListaProductos().get(index - 1);
            vista.getTxtStockDisp().setText(String.valueOf(p.getStock()));
        } else {
            vista.getTxtStockDisp().setText("");
        }
    }

    private void agregarItemCarrito() {
        try {
            int index = vista.getCmbProductos().getSelectedIndex();
            if (index <= 0) {
                JOptionPane.showMessageDialog(vista, "Por favor seleccione un producto valido.");
                return;
            }

            String cantidadStr = vista.getTxtCantPedida().getText().trim();
            if (cantidadStr.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Ingrese la cantidad solicitada.");
                return;
            }

            int cantidad = Integer.parseInt(cantidadStr);
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(vista, "La cantidad debe ser mayor a cero.");
                return;
            }

            Producto p = modelo.getListaProductos().get(index - 1);

            if (p.getStock() < cantidad) {
                JOptionPane.showMessageDialog(vista, "Stock insuficiente. Disponible actual: " + p.getStock());
                return;
            }

            // Calcular subtotal del item
            double subtotalItem = p.getPrecio() * cantidad;

            // Agregar al carrito temporal
            Pedido itemPedido = new Pedido(p.getCodigo(), p.getNombre(), cantidad, subtotalItem);
            carritoTemporal.add(itemPedido);

            // Actualizar JTable de resumen
            DefaultTableModel tModel = vista.getTableModel();
            tModel.addRow(new Object[]{
                cantidad,
                p.getNombre(),
                "$" + String.format("%.2f", p.getPrecio()),
                "$" + String.format("%.2f", subtotalItem)
            });

            recalcularTotalesFinancieros();
            vista.getTxtCantPedida().setText("");
            JOptionPane.showMessageDialog(vista, "Producto agregado al pedido actual.");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Error: Ingrese un valor numerico entero para la cantidad.");
        }
    }

    private void recalcularTotalesFinancieros() {
        double subtotalGlobal = 0;
        for (Pedido item : carritoTemporal) {
            subtotalGlobal += item.getSubtotal();
        }
        double iva = subtotalGlobal * 0.15;
        double total = subtotalGlobal + iva;

        vista.getLblSubtotalValor().setText("$" + String.format("%.2f", subtotalGlobal));
        vista.getLblIvaValor().setText("$" + String.format("%.2f", iva));
        vista.getLblTotalValor().setText("$" + String.format("%.2f", total));
    }

    private void finalizarVenta() {
        if (carritoTemporal.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "No hay productos en el pedido actual para cobrar.");
            return;
        }

        for (Pedido item : carritoTemporal) {
            Producto p = modelo.buscarProducto(item.getCodigoProducto());
            if (p != null) {
                p.descontarStock(item.getCantidad());
            }
            modelo.getListaVentas().add(item);
        }

        gestorArchivo.guardarDatos(modelo);

        JOptionPane.showMessageDialog(vista, "Venta cobrada y registrada con exito.");
        
        carritoTemporal.clear();
        vista.getTableModel().setRowCount(0);
        recalcularTotalesFinancieros();
        cargarProductosEnCombo();
        vista.getTxtStockDisp().setText("");
    }
}