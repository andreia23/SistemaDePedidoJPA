package aplicacaoSwing;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fachada.Fachada;

public class TelaPrincipal {

	private JFrame frame;
	private JMenu mnConsulta;
	private JMenu mnTelefone;
	private JMenu mnPessoa;
	private JMenuItem mntmCadastrarPessoa;
	private JMenuItem mntmApagarPessoa;
	private JMenuItem mntmListarPessoa;
	private JMenuItem mntmCadastrarTelefone;
	private JMenuItem mntmApagarTelefone;
	private JMenuItem mntmListarTelefone;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				
				Fachada.inicializar();
				
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				JOptionPane.showMessageDialog(frame, "sistema inicializado !");
			}
			@Override
			public void windowClosing(WindowEvent e) {
				Fachada.finalizar();
				JOptionPane.showMessageDialog(frame, "sistema finalizado !");
			}
		});
		frame.setTitle("Agenda");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("");
		label.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		ImageIcon imagem = new ImageIcon(getClass().getResource("/imagens/imagem.jpg"));
		imagem = new ImageIcon(imagem.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(imagem);
		frame.getContentPane().add(label);
		frame.setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		mnPessoa = new JMenu("Pessoa");
		menuBar.add(mnPessoa);

		mntmCadastrarPessoa = new JMenuItem("Cadastrar");
		mntmCadastrarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrar tela = new TelaCadastrar();
			}
		});
		mnPessoa.add(mntmCadastrarPessoa);

		mntmApagarPessoa = new JMenuItem("Apagar");
		mntmApagarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaApagar tela = new TelaApagar();
			}
		});
		mnPessoa.add(mntmApagarPessoa);
		
		
		mntmListarPessoa = new JMenuItem("Listar");
		mntmListarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarConsultar tela = new TelaListarConsultar();
			}
		});
		mnPessoa.add(mntmListarPessoa);

		//-----------------------------------------------------------------
		mnTelefone = new JMenu("Telefone");
		menuBar.add(mnTelefone);
		
		mntmCadastrarTelefone = new JMenuItem("Cadastrar");
		mntmCadastrarTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrar tela = new TelaCadastrar();
			}
		});
		mnTelefone.add(mntmCadastrarTelefone);

		mntmApagarTelefone = new JMenuItem("Apagar");
		mntmApagarTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaApagar tela = new TelaApagar();
			}
		});
		mnTelefone.add(mntmApagarTelefone);
		
		
		mntmListarTelefone = new JMenuItem("Listar");
		mntmListarTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarConsultar tela = new TelaListarConsultar();
			}
		});
		mnTelefone.add(mntmListarTelefone);
	

		mnConsulta = new JMenu("Consultas");
		menuBar.add(mnConsulta);
		mnConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TelaListarConsultar tela = new TelaListarConsultar();
			}
		});
		
	}
}
