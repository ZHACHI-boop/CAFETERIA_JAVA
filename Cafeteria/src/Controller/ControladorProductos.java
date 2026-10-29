package Controller;

import Model.GestorCatalogo;
import Model.GestorArchivo;
import Model.Producto;
import View.PanelProductos;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorProductos {
    private PanelProductos vista;
    private GestorCatalogo modelo;
    private GestorArchivo gestorArchivo;

    public ControladorProductos(PanelProductos vista, GestorCatalogo modelo, GestorArchivo gestorArchivo) {
        this.vista = vista;
        this.modelo = modelo;
        this.gestorArchivo = gestorArchivo;

        actualizarTabla();

        this.vista.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarNuevoProducto();
            }
        });

        this.vista.getBtnReponerStock().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reponerStockProducto();
            }
        });
    }

    private void guardarNuevoProducto() {
        try {
            String codigo = vista.getTxtCodigo().getText().trim();
            String nombre = vista.getTxtNombre().getText().trim();
            double precio = Double.parseDouble(vista.getTxtPrecio().getText().trim());
            int stock = (int) vista.getSpinnerStock().getValue();

            if (codigo.isEmpty() || nombre.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Por favor complete todos los campos de texto.");
                return;
            }

            Producto nuevo = new Producto(codigo, nombre, precio, stock);
            boolean registrado = modelo.registrarProducto(nuevo);

            if (registrado) {
                gestorArchivo.guardarDatos(modelo); // Persistencia en archivo
                actualizarTabla();
                JOptionPane.showMessageDialog(vista, "Producto guardado con exito.");
                limpiarFormulario();
            } else {
                JOptionPane.showMessageDialog(vista, "Error: El codigo de producto ya existe.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Error: Ingrese valores numericos validos en precio y stock.");
        }
    }

    private void reponerStockProducto() {
        try {
            String codigo = vista.getTxtCodigo().getText().trim();
            int cantidad = (int) vista.getSpinnerStock().getValue();

            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Ingrese el codigo del producto a reponer.");
                return;
            }

            boolean exito = modelo.reponerStock(codigo, cantidad);
            if (exito) {
                gestorArchivo.guardarDatos(modelo);
                actualizarTabla();
                JOptionPane.showMessageDialog(vista, "Stock repuesto con exito.");
                limpiarFormulario();
            } else {
                JOptionPane.showMessageDialog(vista, "Error: El producto no existe en el catalogo.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al reponer el stock.");
        }
    }

    private void actualizarTabla() {
        DefaultTableModel tModel = vista.getTableModel();
        tModel.setRowCount(0);
        for (Producto p : modelo.getListaProductos()) {
            String estado = p.getStock() < 5 ? "Bajo" : "Normal";
            tModel.addRow(new Object[]{
                p.getCodigo(),
                p.getNombre(),
                "$" + String.format("%.2f", p.getPrecio()),
                p.getStock(),
                estado
            });
        }
    }

    private void limpiarFormulario() {
        vista.getTxtCodigo().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtPrecio().setText("");
        vista.getSpinnerStock().setValue(0);
    }
}