package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controller.ProductoController;
//import Controller.ReporteController;
import Controller.CategoriaController;
import Model.Producto;
//import Model.Reporte;
//import Model.ReporteExcel;
import Model.Categoria;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ifrm_GestionarProducto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtDescripcion;	
	private JComboBox <String> cboCategoria;
	DefaultTableModel modelo;
	private JTable tblProducto;
	private CategoriaController categoriaController;
	private ProductoController productoController;
	private JSpinner spinnerStock;
	private JSpinner spinnerVenta;
	private JSpinner spinnerCompra;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_GestionarProducto frame = new ifrm_GestionarProducto();
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
	public ifrm_GestionarProducto() {
		setBounds(0, 0, 1280, 589);
		getContentPane().setLayout(null);

		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		
		
		categoriaController = new CategoriaController();
		productoController = new ProductoController();

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(939, 24, 303, 511);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Ingreso de Productos");
		lblNewLabel.setBounds(33, 23, 242, 39);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion:");
		lblNewLabel_1.setBounds(24, 85, 82, 26);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Stock:");
		lblNewLabel_1_1_1.setBounds(50, 135, 42, 26);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("P. Compra:");
		lblNewLabel_1_1_1_1.setBounds(24, 185, 82, 26);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("P. Venta:");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_2.setBounds(33, 235, 80, 26);
		panel_1.add(lblNewLabel_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Categoria:");
		lblNewLabel_1_1_1_1_1.setBounds(33, 284, 80, 26);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(132, 91, 132, 20);
		txtDescripcion.setColumns(10);
		panel_1.add(txtDescripcion);
		
		cboCategoria = new JComboBox();
		cboCategoria.setBackground(new Color(255, 255, 255));
		cboCategoria.setBounds(132, 289, 132, 21);
		cboCategoria.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Categoria"}));
		actualizarComboBoxCategoria();		
		panel_1.add(cboCategoria);
		
		JButton btnGuardar = new JButton("Guardar");	
		btnGuardar.setForeground(new Color(245, 245, 245));
		btnGuardar.setBackground(new Color(78, 156, 54));
		btnGuardar.setBounds(50, 342, 195, 23);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.add(btnGuardar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(144, 8, 9));
		btnEliminar.setBounds(50, 409, 195, 23);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.add(btnEliminar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLimpiar.setBackground(new Color(252, 187, 33));
		btnLimpiar.setBounds(50, 375, 195, 23);
		panel_1.add(btnLimpiar);
		
		JSpinner spinnerVenta = new JSpinner();
		spinnerVenta.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
		spinnerVenta.setBounds(132, 241, 132, 20);
		panel_1.add(spinnerVenta);
		
		JSpinner spinnerCompra = new JSpinner();
		spinnerCompra.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
		spinnerCompra.setBounds(132, 191, 132, 20);
		panel_1.add(spinnerCompra);
		
		JSpinner spinnerStock = new JSpinner();
		spinnerStock.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerStock.setBounds(132, 141, 132, 20);
		panel_1.add(spinnerStock);
		
		
		
		JButton btnPDF = new JButton("PDF");
		panel_1.add(btnPDF);
		btnPDF.setForeground(new Color(245, 245, 245));
		btnPDF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPDF.setBounds(156, 454, 89, 25);
		btnPDF.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/pdficono.png")));
		btnPDF.setBackground(new Color(173, 8, 8));
		
		JButton btnExcel = new JButton("Excel");
		btnExcel.setForeground(new Color(245, 245, 245));
		btnExcel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcel.setBounds(49, 454, 97, 25);
		btnExcel.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/excelicono.png")));
		btnExcel.setBackground(new Color(33, 114, 69));
		panel_1.add(btnExcel);
		
		
		
		modelo = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "ID", "Descripcion", "Stock", "P. Compra", "P. Venta", "Categoria"
	            }
	        );

		tblProducto = new JTable(modelo);
		tblProducto.getColumnModel().getColumn(0).setPreferredWidth(20); // ID
		tblProducto.getColumnModel().getColumn(1).setPreferredWidth(180); // Descripcion
		tblProducto.getColumnModel().getColumn(2).setPreferredWidth(20); // Stock
		tblProducto.getColumnModel().getColumn(3).setPreferredWidth(20); // Compra
		tblProducto.getColumnModel().getColumn(4).setPreferredWidth(20); // Venta
		tblProducto.getColumnModel().getColumn(5).setPreferredWidth(20); // Categoria
		mostrarTabla();
	 // Crear un JScrollPane y agregar la JTable a él
	 JScrollPane scrollPane = new JScrollPane(tblProducto);
	 scrollPane.setBounds(27, 24, 878, 511);
	 getContentPane().add(scrollPane);

	 /*
	 btnExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ReporteController controller = new ReporteController();
	        	 List<Reporte> listarReporte = controller.listarReporte();
	        	 ReporteExcel.reporteprod();
			}
		});
		
		*/
	 
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
	            String nombreCategoria = cboCategoria.getSelectedItem().toString();
	            int categoriaId = categoriaController.obtenerIdCategoriaPorNombre(nombreCategoria);
				
				Producto producto = new Producto();
				producto.setDescripcion(txtDescripcion.getText());
				producto.setStock((int) spinnerStock.getValue());
				producto.setPrecio_venta((double) spinnerVenta.getValue());
				producto.setPrecio_compra((double) spinnerCompra.getValue());
	            producto.setId_subcategoria(categoriaId);
	            	            
	            productoController.agregarProducto(producto);
	            mostrarTabla();
	            //limpiar();
	            JOptionPane.showMessageDialog(ifrm_GestionarProducto.this, "Producto agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		       
		    } catch (Exception ex) {
		        JOptionPane.showMessageDialog(ifrm_GestionarProducto.this, "Ocurrió un error al registrar el alumno", "Error", JOptionPane.ERROR_MESSAGE);
		    }
			}
			});
		
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    int filaSeleccionada = tblProducto.getSelectedRow();
			    
			    if (filaSeleccionada >= 0) {
			        try {
			            Object idObject = tblProducto.getValueAt(filaSeleccionada, 0);
			            int idProducto = Integer.parseInt(idObject.toString()); // Intenta la conversión

			            int confirmacion = JOptionPane.showConfirmDialog(ifrm_GestionarProducto.this, "¿Está seguro de que desea eliminar este Producto?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

			            if (confirmacion == JOptionPane.YES_OPTION) {
			                productoController.eliminarProducto(idProducto); // Llama al método del controlador para eliminar el alumno
			                mostrarTabla();
			            }
			        } catch (NumberFormatException ex) {
			            JOptionPane.showMessageDialog(ifrm_GestionarProducto.this, "Error de conversión: El valor no es un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			    } else {
			        JOptionPane.showMessageDialog(ifrm_GestionarProducto.this, "Por favor, seleccione un Usuario para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			    }   
			}
		});
	 
}	
	
	public void actualizarComboBoxCategoria() {

        List<Categoria> listarCategoria = categoriaController.listarCategoria();

        // Limpia el ComboBox
        cboCategoria.removeAllItems();

        for (Categoria categoria : listarCategoria) {
        	cboCategoria.addItem(categoria.getDescripcion());
        }
    }
	
	private void mostrarTabla() {
	    modelo.setRowCount(0); // Limpiar la tabla antes de agregar datos
	    List<Producto> listarproducto = productoController.listarProducto();
	    
	    for (Producto producto : listarproducto) {
	        Object[] fila = {
	        		producto.getId(),
	        		producto.getDescripcion(),
	        		producto.getStock(),
	        		producto.getPrecio_compra(),
	        		producto.getPrecio_venta(),
	        		producto.getId_subcategoria()
	        };
	        modelo.addRow(fila);
	    }
	}
	
	public void limpiar() {
		txtDescripcion.setText("");
		spinnerStock.setValue(0);
		spinnerVenta.setValue(0);
		spinnerCompra.setValue(0);
		cboCategoria.setSelectedIndex(0);
		
	}
	
}


