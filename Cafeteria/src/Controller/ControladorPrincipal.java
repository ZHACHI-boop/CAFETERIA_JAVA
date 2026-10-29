package Controller;

import Model.GestorCatalogo;
import Model.GestorArchivo;
import View.VentanaPrincipal;
import View.PanelProductos;
import View.PanelPedidos;
import View.PanelReportes;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrincipal {
    private VentanaPrincipal vista;
    private GestorCatalogo modelo;
    private GestorArchivo gestorArchivo;

    public ControladorPrincipal(VentanaPrincipal vista, GestorCatalogo modelo, GestorArchivo gestorArchivo) {
        this.vista = vista;
        this.modelo = modelo;
        this.gestorArchivo = gestorArchivo;

        // Botones de Navegacion Rapida en el Dashboard
        this.vista.getBtnModCatalogo().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { abrirModuloProductos(); }
        });
        this.vista.getBtnModPedidos().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { abrirModuloPedidos(); }
        });
        this.vista.getBtnModReportes().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { abrirModuloReportes(); }
        });

        conectarMenuSuperior(vista);
    }

    public void abrirModuloProductos() {
        PanelProductos panelProd = new PanelProductos();
        new ControladorProductos(panelProd, modelo, gestorArchivo);
        conectarMenuSuperior(panelProd);
        panelProd.setVisible(true);
        vista.dispose();
    }

    public void abrirModuloPedidos() {
        PanelPedidos panelPed = new PanelPedidos();
        new ControladorPedidos(panelPed, modelo, gestorArchivo);
        conectarMenuSuperior(panelPed);
        panelPed.setVisible(true);
        vista.dispose();
    }

    public void abrirModuloReportes() {
        PanelReportes panelRep = new PanelReportes();
        new ControladorReportes(panelRep, modelo, gestorArchivo);
        conectarMenuSuperior(panelRep);
        panelRep.setVisible(true);
        vista.dispose();
    }

    private void conectarMenuSuperior(javax.swing.JFrame frameActual) {
        JMenuItem mntmSalir = null;
        JMenuItem mntmCat = null;
        JMenuItem mntmPed = null;
        JMenuItem mntmRep = null;

        if (frameActual instanceof VentanaPrincipal) {
            VentanaPrincipal f = (VentanaPrincipal) frameActual;
            mntmSalir = f.getMntmSalirSistema();
            mntmCat = f.getMntmGestionCatalogo();
            mntmPed = f.getMntmAtencionPedidos();
            mntmRep = f.getMntmVerReportes();
        } else if (frameActual instanceof PanelProductos) {
            PanelProductos f = (PanelProductos) frameActual;
            mntmSalir = f.getMntmSalirSistema();
            mntmCat = f.getMntmGestionCatalogo();
            mntmPed = f.getMntmAtencionPedidos();
            mntmRep = f.getMntmVerReportes();
        } else if (frameActual instanceof PanelPedidos) {
            PanelPedidos f = (PanelPedidos) frameActual;
            mntmSalir = f.getMntmSalirSistema();
            mntmCat = f.getMntmGestionCatalogo();
            mntmPed = f.getMntmAtencionPedidos();
            mntmRep = f.getMntmVerReportes();
        } else if (frameActual instanceof PanelReportes) {
            PanelReportes f = (PanelReportes) frameActual;
            mntmSalir = f.getMntmSalirSistema();
            mntmCat = f.getMntmGestionCatalogo();
            mntmPed = f.getMntmAtencionPedidos();
            mntmRep = f.getMntmVerReportes();
        }

        if (mntmSalir != null) {
            for (ActionListener al : mntmSalir.getActionListeners()) mntmSalir.removeActionListener(al);
            mntmSalir.addActionListener(e -> System.exit(0));
        }
        if (mntmCat != null) {
            for (ActionListener al : mntmCat.getActionListeners()) mntmCat.removeActionListener(al);
            mntmCat.addActionListener(e -> {
                frameActual.dispose();
                abrirModuloProductos();
            });
        }
        if (mntmPed != null) {
            for (ActionListener al : mntmPed.getActionListeners()) mntmPed.removeActionListener(al);
            mntmPed.addActionListener(e -> {
                frameActual.dispose();
                abrirModuloPedidos();
            });
        }
        if (mntmRep != null) {
            for (ActionListener al : mntmRep.getActionListeners()) mntmRep.removeActionListener(al);
            mntmRep.addActionListener(e -> {
                frameActual.dispose();
                abrirModuloReportes();
            });
        }
    }
}