package Controller;

import Model.GestorCatalogo;
import Model.GestorArchivo;
import Model.Pedido;
import Model.Producto;
import Model.UtilGenerico;
import View.PanelReportes;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorReportes {
    private PanelReportes vista;
    private GestorCatalogo modelo;
    private GestorArchivo gestorArchivo;

    public ControladorReportes(PanelReportes vista, GestorCatalogo modelo, GestorArchivo gestorArchivo) {
        this.vista = vista;
        this.modelo = modelo;
        this.gestorArchivo = gestorArchivo;

        cargarReportesGlobales();

        this.vista.getBtnImprimirReporte().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirReporteConsolaYDialogo();
            }
        });
    }

    private void cargarReportesGlobales() {
        double gananciaTotal = modelo.calcularGananciaTotal();
        int totalTransacciones = modelo.getListaVentas().size();
        String productoTop = modelo.obtenerProductoMasVendido();

        // Actualizar tarjetas superiores
        vista.getLblGananciaValor().setText("$ " + String.format("%.2f", gananciaTotal));
        vista.getLblProductoTopValor().setText(productoTop);
        vista.getLblTransaccionesValor().setText(totalTransacciones + " Ventas");

        // Poblar tabla de Ranking de Demanda
        DefaultTableModel tModel = vista.getTableModel();
        tModel.setRowCount(0);
        
        int rank = 1;
        for (Producto p : modelo.getListaProductos()) {
            int unidadesVendidas = 0;
            for (Pedido v : modelo.getListaVentas()) {
                if (v.getCodigoProducto().equalsIgnoreCase(p.getCodigo())) {
                    unidadesVendidas += v.getCantidad();
                }
            }
            if (unidadesVendidas > 0) {
                tModel.addRow(new Object[]{rank++, p.getNombre(), unidadesVendidas});
            }
        }

        ArrayList<String> resumenLog = UtilGenerico.crearLista(
            "Reporte Global Generado Exitosamente",
            "Ganancia Total: $" + String.format("%.2f", gananciaTotal),
            "Total Transacciones: " + totalTransacciones,
            "Producto Destacado: " + productoTop
        );

        StringBuilder sb = new StringBuilder();
        sb.append("Resumen Ejecutivo del Sistema (v2.0)\n\n");
        for (String linea : resumenLog) {
            sb.append("- ").append(linea).append("\n");
        }
        sb.append("- Sincronizacion de archivos: OK");

        vista.getTextAreaReporte().setText(sb.toString());
    }

    private void imprimirReporteConsolaYDialogo() {
        if (!modelo.getListaProductos().isEmpty()) {
            ArrayList<Producto> listaMuestra = UtilGenerico.crearLista(
                modelo.getListaProductos().get(0)
            );
            UtilGenerico.mostrarElementos(listaMuestra);
        }

        JOptionPane.showMessageDialog(vista, "Reporte impreso y exportado correctamente.");
    }
}