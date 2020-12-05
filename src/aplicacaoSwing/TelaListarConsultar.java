package aplicacaoSwing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import fachada.Fachada;
import modelo.Pessoa;
import modelo.Telefone;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class TelaListarConsultar {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton button_2;
	private JButton button_3;
	private JButton button;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					TelaListarConsultar window = new TelaListarConsultar();
	//					window.frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the application.
	 */
	public TelaListarConsultar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Listar e Consultar");
		frame.setBounds(100, 100, 505, 323);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 33, 409, 116);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setGridColor(Color.BLACK);
		table.setRequestFocusEnabled(false);
		table.setFocusable(false);
		table.setBackground(Color.YELLOW);
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"Telefone", "Nome"}
				));
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		button_2 = new JButton("Listar pessoas pelo nome");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Nome");
					model.addColumn("Telefone");
					//					table.getColumnModel().getColumn(0).setPreferredWidth(10);
					//					table.getColumnModel().getColumn(1).setPreferredWidth(10);

					List<Pessoa> lista = Fachada.consultarPessoas(textField.getText());
					for(Pessoa p : lista)
						for(Telefone t : p.getTelefones())
							model.addRow(new Object[]{ p.getNome(),t.getNumero() });

					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frame,erro.getMessage());
				}
			}
		});
		button_2.setBounds(44, 170, 237, 23);
		frame.getContentPane().add(button_2);

		button_3 = new JButton("Listar telefones pelo numero");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_3.setHorizontalAlignment(SwingConstants.LEFT);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Telefone");
					model.addColumn("Nome");
					//					table.getColumnModel().getColumn(0).setPreferredWidth(10);
					//					table.getColumnModel().getColumn(1).setPreferredWidth(10);

					List<Telefone> lista = Fachada.consultarTelefones(textField_1.getText());
					for(Telefone t : lista)
						model.addRow(new String[]{ t.getNumero(), t.getPessoa().getNome() });

					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frame,erro.getMessage());
				}
			}
		});
		button_3.setBounds(44, 204, 237, 23);
		frame.getContentPane().add(button_3);

		button = new JButton("Consultar pessoas com N telefones");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Nome");
					model.addColumn("Telefone");
					//					table.getColumnModel().getColumn(0).setPreferredWidth(10);
					//					table.getColumnModel().getColumn(1).setPreferredWidth(10);

					int n = Integer.parseInt(textField_2.getText());
					List<Pessoa> lista = Fachada.consultarPessoasNTelefones(n);
					for(Pessoa p : lista)
						for(Telefone t : p.getTelefones())
							model.addRow(new Object[]{ p.getNome(),t.getNumero() });

					table.setModel(model);
				}
				catch(NumberFormatException erro){
					JOptionPane.showMessageDialog(frame,"digite somente numero");
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frame,erro.getMessage());
				}
			}
		});
		button.setBounds(44, 238, 255, 23);
		frame.getContentPane().add(button);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(301, 172, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(301, 206, 86, 20);
		frame.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(311, 240, 35, 20);
		frame.getContentPane().add(textField_2);

		frame.setVisible(true);
	}
}
