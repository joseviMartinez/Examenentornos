import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaPrincipal extends JFrame {

	//Componentes visuales
	private JPanel contentPane;
	private JTextField Matricula;
	private JTextField HoraEntrada;
	private JTextField HoraSalida;
	private JTextField PrecioPagar;
	private JOptionPane error;
	private Coche coxe;
	private JComboBox<Coche> listadoCoche;
	
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
		setTitle("Control de Parking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		listadoCoche = new JComboBox<Coche>();
		listadoCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		//JComboBox listadoCoches = new JComboBox();
		listadoCoche.setBounds(10, 29, 414, 20);
		contentPane.add(listadoCoche);
		
		JLabel lblListadoDeCoches = new JLabel("Listado de coches");
		lblListadoDeCoches.setBounds(10, 4, 151, 14);
		contentPane.add(lblListadoDeCoches);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula");
		lblMatrcula.setBounds(10, 67, 89, 14);
		contentPane.add(lblMatrcula);
		
		JLabel lblHoraDeEntrada = new JLabel("Hora de entrada");
		lblHoraDeEntrada.setBounds(10, 100, 101, 14);
		contentPane.add(lblHoraDeEntrada);
		
		JLabel lblHoraDeSalida = new JLabel("Hora de salida");
		lblHoraDeSalida.setBounds(10, 136, 101, 14);
		contentPane.add(lblHoraDeSalida);
		
		JLabel lblPrecioAPagar = new JLabel("Precio a pagar");
		lblPrecioAPagar.setBounds(10, 172, 101, 14);
		contentPane.add(lblPrecioAPagar);
		
		Matricula = new JTextField();
		Matricula.setBounds(119, 60, 86, 20);
		contentPane.add(Matricula);
		Matricula.setColumns(10);
		
		HoraEntrada = new JTextField();
		HoraEntrada.setColumns(10);
		HoraEntrada.setBounds(119, 97, 86, 20);
		contentPane.add(HoraEntrada);
		
		HoraSalida = new JTextField();
		HoraSalida.setColumns(10);
		HoraSalida.setBounds(119, 133, 86, 20);
		contentPane.add(HoraSalida);
		
		PrecioPagar = new JTextField();
		PrecioPagar.setEditable(false);
		PrecioPagar.setColumns(10);
		PrecioPagar.setBounds(119, 169, 86, 20);
		contentPane.add(PrecioPagar);
		
		JButton Apagar = new JButton("A PAGAR");
		Apagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Matricula.getText().equals(""))
				error.showMessageDialog(null, "campo vacio");	
				else if (Integer.parseInt(HoraEntrada.getText())<0)
					error.showMessageDialog(null,"campo vacio");
				 if (Integer.parseInt(HoraEntrada.getText())>23)
					 error.showMessageDialog(null,"campo vacio");
				 else if(Integer.parseInt(HoraSalida.getText())<0) 
					error.showMessageDialog(null,"campo vacio");
				 if (Integer.parseInt(HoraSalida.getText())>23)
					 error.showMessageDialog(null,"campo vacio");
				 if (Integer.parseInt(HoraEntrada.getText())>Integer.parseInt(HoraSalida.getText()))
					 error.showMessageDialog(null,"campo vacio");
				else{
					Coche coxe=new Coche();
					coxe.guardarmatricula(Matricula.getText());
					coxe.guardarhoraentrada(Integer.parseInt(HoraEntrada.getText()));
					coxe.guardarhorasalida(Integer.parseInt(HoraSalida.getText()));
					listadoCoche.addItem(coxe);
				}
				
			}
		});
		Apagar.setBounds(230, 58, 194, 128);
		contentPane.add(Apagar);
		
		listadoCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				coxe=listadoCoche.getItemAt(listadoCoche.getSelectedIndex());
				Matricula.setText(String.valueOf(coxe.cogermatricula()));
				HoraEntrada.setText(String.valueOf(coxe.cogerhoraentrada()));
				HoraSalida.setText(String.valueOf(coxe.cogerhorasalida()));
				PrecioPagar.setText(String.valueOf(coxe.cogerprecio()));
				
			}
		});
	}
}
