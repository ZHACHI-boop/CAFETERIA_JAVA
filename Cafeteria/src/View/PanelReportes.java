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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PanelReportes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnSistema, mnCatalogo, mnPedidos, mnReportes, mnAyuda;
	private JMenuItem mntmSalirSistema, mntmGestionCatalogo, mntmAtencionPedidos, mntmVerReportes, mntmAcercaDe;
	
	private JPanel panelGanancia, panelProductoTop, panelTransacciones;
	private JLabel lblGananciaEtiqueta, lblGananciaValor;
	private JLabel lblProductoTopEtiqueta, lblProductoTopValor;
	private JLabel lblTransaccionesEtiqueta, lblTransaccionesValor;
	
	private JPanel panelRanking, panelReporteDerecho;
	private JLabel lblRankingTitulo, lblReporteTitulo;
	private JTable tableRanking;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPaneRanking;
	private JTextArea txtAreaReporte;
	private JScrollPane scrollPaneReporte;
	private JButton btnImprimirReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelReportes frame = new PanelReportes();
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
	public PanelReportes() {
		setTitle("ReporteGanancias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 560);
		setLocationRelativeTo(null);
		
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

		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 249, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		int cardY = 15;
		int cardH = 95;
		int cardW = 275;

		panelGanancia = new JPanel();
		panelGanancia.setBackground(Color.WHITE);
		panelGanancia.setBorder(new LineBorder(new Color(220, 224, 230), 1, true));
		panelGanancia.setBounds(15, cardY, cardW, cardH);
		panelGanancia.setLayout(null);
		contentPane.add(panelGanancia);

		lblGananciaEtiqueta = new JLabel("GANANCIA TOTAL");
		lblGananciaEtiqueta.setOpaque(true);
		lblGananciaEtiqueta.setBackground(new Color(0, 123, 255));
		lblGananciaEtiqueta.setForeground(Color.WHITE);
		lblGananciaEtiqueta.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblGananciaEtiqueta.setHorizontalAlignment(JLabel.CENTER);
		lblGananciaEtiqueta.setBounds(15, 12, 130, 22);
		panelGanancia.add(lblGananciaEtiqueta);

		lblGananciaValor = new JLabel("$ 485.50");
		lblGananciaValor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGananciaValor.setForeground(new Color(40, 167, 69));
		lblGananciaValor.setBounds(15, 45, 240, 30);
		panelGanancia.add(lblGananciaValor);

		panelProductoTop = new JPanel();
		panelProductoTop.setBackground(Color.WHITE);
		panelProductoTop.setBorder(new LineBorder(new Color(220, 224, 230), 1, true));
		panelProductoTop.setBounds(305, cardY, cardW, cardH);
		panelProductoTop.setLayout(null);
		contentPane.add(panelProductoTop);

		lblProductoTopEtiqueta = new JLabel("PRODUCTO MAS VENDIDO");
		lblProductoTopEtiqueta.setOpaque(true);
		lblProductoTopEtiqueta.setBackground(new Color(0, 123, 255));
		lblProductoTopEtiqueta.setForeground(Color.WHITE);
		lblProductoTopEtiqueta.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblProductoTopEtiqueta.setHorizontalAlignment(JLabel.CENTER);
		lblProductoTopEtiqueta.setBounds(15, 12, 175, 22);
		panelProductoTop.add(lblProductoTopEtiqueta);

		lblProductoTopValor = new JLabel("Cafe Americano (64 unid.)");
		lblProductoTopValor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProductoTopValor.setForeground(new Color(33, 37, 41));
		lblProductoTopValor.setBounds(15, 48, 240, 25);
		panelProductoTop.add(lblProductoTopValor);

		panelTransacciones = new JPanel();
		panelTransacciones.setBackground(Color.WHITE);
		panelTransacciones.setBorder(new LineBorder(new Color(220, 224, 230), 1, true));
		panelTransacciones.setBounds(595, cardY, cardW, cardH);
		panelTransacciones.setLayout(null);
		contentPane.add(panelTransacciones);

		lblTransaccionesEtiqueta = new JLabel("TOTAL DE TRANSACCIONES");
		lblTransaccionesEtiqueta.setOpaque(true);
		lblTransaccionesEtiqueta.setBackground(new Color(0, 123, 255));
		lblTransaccionesEtiqueta.setForeground(Color.WHITE);
		lblTransaccionesEtiqueta.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTransaccionesEtiqueta.setHorizontalAlignment(JLabel.CENTER);
		lblTransaccionesEtiqueta.setBounds(15, 12, 175, 22);
		panelTransacciones.add(lblTransaccionesEtiqueta);

		lblTransaccionesValor = new JLabel("38 Ventas");
		lblTransaccionesValor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTransaccionesValor.setForeground(new Color(33, 37, 41));
		lblTransaccionesValor.setBounds(15, 45, 240, 30);
		panelTransacciones.add(lblTransaccionesValor);

		panelRanking = new JPanel();
		panelRanking.setBackground(Color.WHITE);
		panelRanking.setBorder(new LineBorder(new Color(220, 224, 230), 1, true));
		panelRanking.setBounds(15, 125, 415, 365);
		panelRanking.setLayout(null);
		contentPane.add(panelRanking);

		lblRankingTitulo = new JLabel("RANKING DE DEMANDA");
		lblRankingTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRankingTitulo.setForeground(new Color(194, 59, 34));
		lblRankingTitulo.setBounds(15, 15, 250, 20);
		panelRanking.add(lblRankingTitulo);

		String[] columnasRanking = {"#", "Producto", "Unid. Vendidas"};
		tableModel = new DefaultTableModel(columnasRanking, 0);
		tableRanking = new JTable(tableModel);
		tableRanking.setRowHeight(24);
		
		tableModel.addRow(new Object[]{"1", "Cafe Americano", "64"});
		tableModel.addRow(new Object[]{"2", "Empanada Queso", "42"});
		tableModel.addRow(new Object[]{"3", "Sandwich Jamon", "31"});

		scrollPaneRanking = new JScrollPane(tableRanking);
		scrollPaneRanking.setBounds(15, 50, 385, 295);
		panelRanking.add(scrollPaneRanking);

		panelReporteDerecho = new JPanel();
		panelReporteDerecho.setBackground(Color.WHITE);
		panelReporteDerecho.setBorder(new LineBorder(new Color(220, 224, 230), 1, true));
		panelReporteDerecho.setBounds(445, 125, 425, 365);
		panelReporteDerecho.setLayout(null);
		contentPane.add(panelReporteDerecho);

		lblReporteTitulo = new JLabel("REPORTE");
		lblReporteTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReporteTitulo.setForeground(new Color(194, 59, 34));
		lblReporteTitulo.setBounds(15, 15, 200, 20);
		panelReporteDerecho.add(lblReporteTitulo);

		txtAreaReporte = new JTextArea();
		txtAreaReporte.setText(
			"Resumen Ejecutivo del Sistema (v2.0)\n\n" +
			"- Total Recaudado: $485.50\n" +
			"- Producto con mayor salida: Cafe Americano\n" +
			"- Transacciones completadas: 38\n" +
			"- Sincronizacion de archivos: OK"
		);
		txtAreaReporte.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAreaReporte.setBackground(new Color(245, 247, 250));
		txtAreaReporte.setMargin(new java.awt.Insets(8, 8, 8, 8));
		txtAreaReporte.setEditable(false);

		scrollPaneReporte = new JScrollPane(txtAreaReporte);
		scrollPaneReporte.setBounds(15, 50, 395, 225);
		panelReporteDerecho.add(scrollPaneReporte);

		btnImprimirReporte = new JButton("Imprimir Reporte");
		btnImprimirReporte.setBackground(new Color(0, 123, 255));
		btnImprimirReporte.setForeground(Color.WHITE);
		btnImprimirReporte.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnImprimirReporte.setBounds(15, 292, 395, 48);
		panelReporteDerecho.add(btnImprimirReporte);
	}

	public JLabel getLblGananciaValor() { return lblGananciaValor; }
	public JLabel getLblProductoTopValor() { return lblProductoTopValor; }
	public JLabel getLblTransaccionesValor() { return lblTransaccionesValor; }
	public JTable getTableRanking() { return tableRanking; }
	public DefaultTableModel getTableModel() { return tableModel; }
	public JTextArea getTextAreaReporte() { return txtAreaReporte; }
	public JButton getBtnImprimirReporte() { return btnImprimirReporte; }
	
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