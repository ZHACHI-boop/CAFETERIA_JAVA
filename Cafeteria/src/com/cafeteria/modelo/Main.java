package com.cafeteria.modelo;

import Model.GestorArchivo;
import Model.GestorCatalogo;
import View.VentanaPrincipal;
import Controller.ControladorPrincipal;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        //Inicializa el Modelo de Datos y el Gestor de Archivos
        GestorCatalogo modelo = new GestorCatalogo();
        GestorArchivo gestorArchivo = new GestorArchivo();

        //Cargar productos.txt y ventas.txt
        gestorArchivo.leerDatos(modelo);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                    new ControladorPrincipal(ventanaPrincipal, modelo, gestorArchivo);
                    
                    ventanaPrincipal.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}