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
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class PanelPedidos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnSistema, mnCatalogo, mnPedidos, mnReportes, mnAyuda;
	private JMenuItem mntmSalirSistema, mntmGestionCatalogo, mntmAtencionPedidos, mntmVerReportes, mntmAcercaDe;
	
	// Componentes del Panel Izquierdo (Registro de Pedido)
	private JPanel panelRegistro, panelResumen, panelTotales;
	private JLabel lblRegTitulo, lblSelecProducto, lblCantPedida, lblStockDisp;
	private JComboBox<String> cmbProductos;
	private JTextField txtCantPedida, txtStockDisp;
	private JButton btnAgregarPedido;
	
	// Componentes del Panel Derecho (Resumen y Tabla)
	private JLabel lblResumenTitulo;
	private JTable tableResumen;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	
	// Etiquetas de Totales Financieros
	private JLabel lblSubtotalTitulo, lblSubtotalValor;
	private JLabel lblIvaTitulo, lblIvaValor;
	private JLabel lblTotalTitulo, lblTotalValor;
	private JButton btnFinalizarVenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPedidos frame = new PanelPedidos();
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
	public PanelPedidos() {
		setTitle("AtencionPedidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 550);
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

		// --- PANEL IZQUIERDO: REGISTRAR NUEVO PEDIDO ---
		panelRegistro = new JPanel();
		panelRegistro.setBorder(new LineBorder(new Color(150, 150, 150), 1, true));
		panelRegistro.setBounds(15, 15, 340, 465);
		panelRegistro.setLayout(null);
		contentPane.add(panelRegistro);

		lblRegTitulo = new JLabel("REGISTRAR NUEVO PEDIDO");
		lblRegTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegTitulo.setBounds(15, 15, 250, 20);
		panelRegistro.add(lblRegTitulo);

		lblSelecProducto = new JLabel("Seleccionar Producto:");
		lblSelecProducto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSelecProducto.setBounds(15, 55, 200, 20);
		panelRegistro.add(lblSelecProducto);

		cmbProductos = new JComboBox<String>();
		cmbProductos.addItem("-- Seleccione un producto --");
		cmbProductos.setBounds(15, 80, 310, 28);
		panelRegistro.add(cmbProductos);

		lblCantPedida = new JLabel("Cantidad Pedida:");
		lblCantPedida.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCantPedida.setBounds(15, 140, 140, 20);
		panelRegistro.add(lblCantPedida);

		txtCantPedida = new JTextField();
		txtCantPedida.setBounds(15, 165, 140, 28);
		panelRegistro.add(txtCantPedida);
		txtCantPedida.setColumns(10);

		lblStockDisp = new JLabel("Stock Disponible:");
		lblStockDisp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblStockDisp.setBounds(175, 140, 150, 20);
		panelRegistro.add(lblStockDisp);

		txtStockDisp = new JTextField();
		txtStockDisp.setEditable(false);
		txtStockDisp.setBounds(175, 165, 150, 28);
		panelRegistro.add(txtStockDisp);
		txtStockDisp.setColumns(10);

		btnAgregarPedido = new JButton("Agregar al Pedido");
		btnAgregarPedido.setBackground(new Color(0, 120, 215));
		btnAgregarPedido.setForeground(Color.WHITE);
		btnAgregarPedido.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAgregarPedido.setBounds(15, 395, 310, 48);
		panelRegistro.add(btnAgregarPedido);

		// --- PANEL DERECHO: RESUMEN DE VENTA ACTUAL ---
		panelResumen = new JPanel();
		panelResumen.setBorder(new LineBorder(new Color(150, 150, 150), 1, true));
		panelResumen.setBounds(375, 15, 475, 465);
		panelResumen.setLayout(null);
		contentPane.add(panelResumen);

		lblResumenTitulo = new JLabel("RESUMEN DE VENTA ACTUAL");
		lblResumenTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblResumenTitulo.setBounds(15, 15, 250, 20);
		panelResumen.add(lblResumenTitulo);

		// Configuración de la Tabla de Resumen
		String[] columnas = {"Cant.", "Producto", "P. Unitario", "P. Total"};
		tableModel = new DefaultTableModel(columnas, 0);
		tableResumen = new JTable(tableModel);
		
		scrollPane = new JScrollPane(tableResumen);
		scrollPane.setBounds(15, 50, 445, 210);
		panelResumen.add(scrollPane);

		// --- PANEL INFERIOR DERECHO: TOTALES FINANCIEROS ---
		panelTotales = new JPanel();
		panelTotales.setBorder(new LineBorder(new Color(200, 200, 200), 1, true));
		panelTotales.setBounds(15, 275, 445, 105);
		panelTotales.setLayout(null);
		panelResumen.add(panelTotales);

		lblSubtotalTitulo = new JLabel("Subtotal:");
		lblSubtotalTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSubtotalTitulo.setBounds(15, 10, 120, 20);
		panelTotales.add(lblSubtotalTitulo);

		lblSubtotalValor = new JLabel("$0.00");
		lblSubtotalValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubtotalValor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubtotalValor.setBounds(300, 10, 130, 20);
		panelTotales.add(lblSubtotalValor);

		lblIvaTitulo = new JLabel("IVA (15%):");
		lblIvaTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIvaTitulo.setBounds(15, 38, 120, 20);
		panelTotales.add(lblIvaTitulo);

		lblIvaValor = new JLabel("$0.00");
		lblIvaValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIvaValor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIvaValor.setBounds(300, 38, 130, 20);
		panelTotales.add(lblIvaValor);

		lblTotalTitulo = new JLabel("TOTAL A COBRAR:");
		lblTotalTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalTitulo.setBounds(15, 68, 150, 20);
		panelTotales.add(lblTotalTitulo);

		lblTotalValor = new JLabel("$0.00");
		lblTotalValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalValor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalValor.setForeground(new Color(0, 100, 0));
		lblTotalValor.setBounds(280, 68, 150, 20);
		panelTotales.add(lblTotalValor);

		// Botón de Finalizar y Cobrar Venta
		btnFinalizarVenta = new JButton("Finalizar y Cobrar Venta");
		btnFinalizarVenta.setBackground(new Color(0, 120, 215));
		btnFinalizarVenta.setForeground(Color.WHITE);
		btnFinalizarVenta.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFinalizarVenta.setBounds(15, 395, 445, 48);
		panelResumen.add(btnFinalizarVenta);
	}

	// --- GETTERS PARA LOS CONTROLADORES ---
	public JComboBox<String> getCmbProductos() { return cmbProductos; }
	public JTextField getTxtCantPedida() { return txtCantPedida; }
	public JTextField getTxtStockDisp() { return txtStockDisp; }
	public JButton getBtnAgregarPedido() { return btnAgregarPedido; }
	public JTable getTableResumen() { return tableResumen; }
	public DefaultTableModel getTableModel() { return tableModel; }
	public JLabel getLblSubtotalValor() { return lblSubtotalValor; }
	public JLabel getLblIvaValor() { return lblIvaValor; }
	public JLabel getLblTotalValor() { return lblTotalValor; }
	public JButton getBtnFinalizarVenta() { return btnFinalizarVenta; }
	
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