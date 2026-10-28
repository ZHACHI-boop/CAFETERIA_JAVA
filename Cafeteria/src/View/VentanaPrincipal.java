package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnSistema, mnCatalogo, mnPedidos, mnReportes, mnAyuda;
	private JMenuItem mntmSalirSistema, mntmGestionCatalogo, mntmAtencionPedidos, mntmVerReportes, mntmAcercaDe;
	private JPanel panelEstadoSistema, panelProductosActivos, panelCajero;
	private JLabel lblEstadoSistemaTitulo, lblEstadoSistemaValor;
	private JLabel lblProductosActivosTitulo, lblProductosActivosValor;
	private JLabel lblCajeroTitulo, lblCajeroValor;
	private JPanel panelNavegacionRapida;
	private JLabel lblNavRapidaTitulo;
	private JButton btnModCatalogo, btnModPedidos, btnModReportes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("MenuPrincipal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		setLocationRelativeTo(null);
		
		// --- BARRA DE MENU SUPERIOR REAL (JMenuBar / JMenu) ---
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);
		mntmSalirSistema = new JMenuItem("Salir");
		mnSistema.add(mntmSalirSistema);

		mnCatalogo = new JMenu("Catalogo");
		menuBar.add(mnCatalogo);
		mntmGestionCatalogo = new JMenuItem("Gestionar Productos");
		mnCatalogo.add(mntmGestionCatalogo);

		mnPedidos = new JMenu("Pedidos");
		menuBar.add(mnPedidos);
		mntmAtencionPedidos = new JMenuItem("Registrar Pedido");
		mnPedidos.add(mntmAtencionPedidos);

		mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		mntmVerReportes = new JMenuItem("Ver Reporte Global");
		mnReportes.add(mntmVerReportes);

		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		mntmAcercaDe = new JMenuItem("Acerca de");
		mnAyuda.add(mntmAcercaDe);

		// --- PANEL CONTENEDOR PRINCIPAL ---
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// --- SECCION DE TARJETAS DE METRICAS ---
		int panelY = 15;
		int panelH = 80;

		// 1. Estado Sistema
		panelEstadoSistema = new JPanel();
		panelEstadoSistema.setBorder(new LineBorder(new Color(150, 150, 150), 1, true));
		panelEstadoSistema.setBounds(20, panelY, 220, panelH);
		panelEstadoSistema.setLayout(null);
		contentPane.add(panelEstadoSistema);

		lblEstadoSistemaTitulo = new JLabel("ESTADO SISTEMA");
		lblEstadoSistemaTitulo.setOpaque(true);
		lblEstadoSistemaTitulo.setBackground(new Color(0, 120, 215));
		lblEstadoSistemaTitulo.setForeground(Color.WHITE);
		lblEstadoSistemaTitulo.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEstadoSistemaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadoSistemaTitulo.setBounds(10, 10, 120, 20);
		panelEstadoSistema.add(lblEstadoSistemaTitulo);

		lblEstadoSistemaValor = new JLabel("Activo / Sincronizado");
		lblEstadoSistemaValor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEstadoSistemaValor.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadoSistemaValor.setBounds(10, 40, 200, 25);
		panelEstadoSistema.add(lblEstadoSistemaValor);

		// 2. Productos Activos
		panelProductosActivos = new JPanel();
		panelProductosActivos.setBorder(new LineBorder(new Color(150, 150, 150), 1, true));
		panelProductosActivos.setBounds(255, panelY, 220, panelH);
		panelProductosActivos.setLayout(null);
		contentPane.add(panelProductosActivos);

		lblProductosActivosTitulo = new JLabel("PRODUCTOS ACTIVOS");
		lblProductosActivosTitulo.setOpaque(true);
		lblProductosActivosTitulo.setBackground(new Color(0, 120, 215));
		lblProductosActivosTitulo.setForeground(Color.WHITE);
		lblProductosActivosTitulo.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblProductosActivosTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductosActivosTitulo.setBounds(10, 10, 135, 20);
		panelProductosActivos.add(lblProductosActivosTitulo);

		lblProductosActivosValor = new JLabel("Inventario Cargado");
		lblProductosActivosValor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProductosActivosValor.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductosActivosValor.setBounds(10, 40, 200, 25);
		panelProductosActivos.add(lblProductosActivosValor);

		// 3. Cajero en Turno
		panelCajero = new JPanel();
		panelCajero.setBorder(new LineBorder(new Color(150, 150, 150), 1, true));
		panelCajero.setBounds(490, panelY, 220, panelH);
		panelCajero.setLayout(null);
		contentPane.add(panelCajero);

		lblCajeroTitulo = new JLabel("CAJERO EN TURNO");
		lblCajeroTitulo.setOpaque(true);
		lblCajeroTitulo.setBackground(new Color(0, 120, 215));
		lblCajeroTitulo.setForeground(Color.WHITE);
		lblCajeroTitulo.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCajeroTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCajeroTitulo.setBounds(10, 10, 120, 20);
		panelCajero.add(lblCajeroTitulo);

		lblCajeroValor = new JLabel("Operador de Caja");
		lblCajeroValor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCajeroValor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCajeroValor.setBounds(10, 40, 200, 25);
		panelCajero.add(lblCajeroValor);

		// --- SECCION DE NAVEGACION RAPIDA ---
		panelNavegacionRapida = new JPanel();
		panelNavegacionRapida.setBorder(new LineBorder(new Color(150, 150, 150), 1, true));
		panelNavegacionRapida.setBounds(20, 115, 690, 305);
		panelNavegacionRapida.setLayout(null);
		contentPane.add(panelNavegacionRapida);

		lblNavRapidaTitulo = new JLabel("NAVEGACION RAPIDA");
		lblNavRapidaTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNavRapidaTitulo.setBounds(15, 15, 200, 20);
		panelNavegacionRapida.add(lblNavRapidaTitulo);

		// Botones principales de navegacion rapida dentro del panel
		btnModCatalogo = new JButton("Modulo de Catalogo y Stock");
		btnModCatalogo.setBackground(new Color(0, 51, 255));
		btnModCatalogo.setForeground(Color.WHITE);
		btnModCatalogo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModCatalogo.setBounds(60, 60, 570, 55);
		panelNavegacionRapida.add(btnModCatalogo);

		btnModPedidos = new JButton("Modulo de Atencion de Pedidos");
		btnModPedidos.setBackground(new Color(0, 120, 215));
		btnModPedidos.setForeground(Color.WHITE);
		btnModPedidos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModPedidos.setBounds(60, 135, 570, 55);
		panelNavegacionRapida.add(btnModPedidos);

		btnModReportes = new JButton("Reportes Globales y Ganancias");
		btnModReportes.setBackground(new Color(0, 120, 215));
		btnModReportes.setForeground(Color.WHITE);
		btnModReportes.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModReportes.setBounds(60, 210, 570, 55);
		panelNavegacionRapida.add(btnModReportes);
	}

	// --- GETTERS PARA LOS CONTROLADORES ---
	public JMenu getMnSistema() { return mnSistema; }
	public JMenu getMnCatalogo() { return mnCatalogo; }
	public JMenu getMnPedidos() { return mnPedidos; }
	public JMenu getMnReportes() { return mnReportes; }
	public JMenu getMnAyuda() { return mnAyuda; }
	public JMenuItem getMntmSalirSistema() { return mntmSalirSistema; }
	public JMenuItem getMntmGestionCatalogo() { return mntmGestionCatalogo; }
	public JMenuItem getMntmAtencionPedidos() { return mntmAtencionPedidos; }
	public JMenuItem getMntmVerReportes() { return mntmVerReportes; }
	public JMenuItem getMntmAcercaDe() { return mntmAcercaDe; }
	public JButton getBtnModCatalogo() { return btnModCatalogo; }
	public JButton getBtnModPedidos() { return btnModPedidos; }
	public JButton getBtnModReportes() { return btnModReportes; }
}