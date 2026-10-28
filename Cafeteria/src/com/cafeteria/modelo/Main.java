package com.cafeteria.modelo;

import Model.GestorArchivo;
import Model.GestorCatalogo;
import View.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        // 1. Inicializar el Modelo de Datos y el Gestor de Archivos
        GestorCatalogo modelo = new GestorCatalogo();
        GestorArchivo gestorArchivo = new GestorArchivo();

        // 2. Cargar la persistencia previa desde productos.txt y ventas.txt
        gestorArchivo.leerDatos(modelo); // Asegúrate de que el método en GestorArchivo se llame leerDatos (o cargarDatos)

        // 3. Lanzar la Interfaz Gráfica (Ventana Principal) de forma segura en el hilo de Swing
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                    ventanaPrincipal.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}