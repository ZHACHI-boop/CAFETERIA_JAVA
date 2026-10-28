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
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PanelProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnSistema, mnCatalogo, mnPedidos, mnReportes, mnAyuda;
	private JMenuItem mntmSalirSistema, mntmGestionCatalogo, mntmAtencionPedidos, mntmVerReportes, mntmAcercaDe;
	
	// Componentes del Formulario
	private JPanel panelFormulario, panelInventario;
	private JLabel lblFormTitulo, lblCodigo, lblNombre, lblPrecio, lblStock;
	private JTextField txtCodigo, txtNombre, txtPrecio;
	private JSpinner spinnerStock;
	private JButton btnGuardar, btnReponerStock;
	
	// Componentes de la Tabla de Inventario
	private JLabel lblInventarioTitulo;
	private JTable tableInventario;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelProductos frame = new PanelProductos();
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
	public PanelProductos() {
		setTitle("GestionProductos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 520);
		setLocationRelativeTo(null);
		
		// --- BARRA DE MENU SUPERIOR ---
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

		// --- PANEL IZQUIERDO: FORMULARIO DE PRODUCTO ---
		panelFormulario = new JPanel();
		panelFormulario.setBorder(new LineBorder(new Color(150, 150, 150), 1, true));
		panelFormulario.setBounds(15, 15, 335, 430);
		panelFormulario.setLayout(null);
		contentPane.add(panelFormulario);

		lblFormTitulo = new JLabel("FORMULARIO DE PRODUCTO");
		lblFormTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFormTitulo.setBounds(15, 15, 250, 20);
		panelFormulario.add(lblFormTitulo);

		lblCodigo = new JLabel("Codigo / ID Producto:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCodigo.setBounds(15, 55, 200, 20);
		panelFormulario.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(15, 80, 300, 25);
		panelFormulario.add(txtCodigo);
		txtCodigo.setColumns(10);

		lblNombre = new JLabel("Nombre del Producto:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(15, 125, 200, 20);
		panelFormulario.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(15, 150, 300, 25);
		panelFormulario.add(txtNombre);
		txtNombre.setColumns(10);

		lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecio.setBounds(15, 195, 130, 20);
		panelFormulario.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(15, 220, 130, 25);
		panelFormulario.add(txtPrecio);
		txtPrecio.setColumns(10);

		lblStock = new JLabel("Stock Inicial / Anadir:");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblStock.setBounds(165, 195, 150, 20);
		panelFormulario.add(lblStock);

		spinnerStock = new JSpinner();
		spinnerStock.setBounds(165, 220, 150, 25);
		panelFormulario.add(spinnerStock);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(0, 120, 215));
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setBounds(15, 300, 135, 45);
		panelFormulario.add(btnGuardar);

		btnReponerStock = new JButton("Reponer Stock");
		btnReponerStock.setBackground(new Color(0, 120, 215));
		btnReponerStock.setForeground(Color.WHITE);
		btnReponerStock.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReponerStock.setBounds(165, 300, 150, 45);
		panelFormulario.add(btnReponerStock);

		// --- PANEL DERECHO: INVENTARIO ACTUAL ---
		panelInventario = new JPanel();
		panelInventario.setBorder(new LineBorder(new Color(150, 150, 150), 1, true));
		panelInventario.setBounds(365, 15, 455, 430);
		panelInventario.setLayout(null);
		contentPane.add(panelInventario);

		lblInventarioTitulo = new JLabel("INVENTARIO ACTUAL");
		lblInventarioTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInventarioTitulo.setBounds(15, 15, 200, 20);
		panelInventario.add(lblInventarioTitulo);

		// Columnas de la tabla
		String[] columnas = {"Codigo", "Nombre", "Precio", "Stock", "Estado"};
		tableModel = new DefaultTableModel(columnas, 0);
		tableInventario = new JTable(tableModel);
		
		scrollPane = new JScrollPane(tableInventario);
		scrollPane.setBounds(15, 50, 425, 355);
		panelInventario.add(scrollPane);
	}

	// --- GETTERS PARA LOS CONTROLADORES ---
	public JTextField getTxtCodigo() { return txtCodigo; }
	public JTextField getTxtNombre() { return txtNombre; }
	public JTextField getTxtPrecio() { return txtPrecio; }
	public JSpinner getSpinnerStock() { return spinnerStock; }
	public JButton getBtnGuardar() { return btnGuardar; }
	public JButton getBtnReponerStock() { return btnReponerStock; }
	public JTable getTableInventario() { return tableInventario; }
	public DefaultTableModel getTableModel() { return tableModel; }
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
}