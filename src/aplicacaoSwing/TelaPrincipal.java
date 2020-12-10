package aplicacaoSwing;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programa��o Orientada a Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fachada.Fachada2;
import modelo.Pedido;
import modelo.Usuario;

public class TelaPrincipal {

	private JFrame frame;
	private JLabel label; // imagem de fundo
	private JMenuItem itemLogin;
	private JMenuItem itemLogff;
	private JMenuItem listarUsuarios;
	private JMenuItem listarPedidos;
	private JMenuItem mntmCadastrar;
	private JMenuItem mntmCriar;
	private JMenu mnListagem;
	private JMenu mnPessoa;

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
				Fachada2.inicializar();
				JOptionPane.showMessageDialog(null, "sistema inicializado !");
			}

			@Override
			public void windowClosing(WindowEvent e) {
				Fachada2.finalizar();
				JOptionPane.showMessageDialog(null, "sistema finalizado !");
			}
		});
		frame.setTitle("Restaurante");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		label = new JLabel("");
		label.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		ImageIcon imagem = new ImageIcon(getClass().getResource("/imagens/POB.jpg"));
		imagem = new ImageIcon(
				imagem.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(imagem);
		frame.getContentPane().add(label);
		frame.setResizable(true);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		mnPessoa = new JMenu("Usuario");
		menuBar.add(mnPessoa);

		itemLogin = new JMenuItem("Login");
		itemLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login e = new Login();
				e.setVisible(true);
			}
		});
		mnPessoa.add(itemLogin);

		itemLogff = new JMenuItem("Logoff");
		itemLogff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Fachada2.logoff();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		mnPessoa.add(itemLogff);

		mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroUsuario j = new TelaCadastroUsuario();
			}

		});
		mnPessoa.add(mntmCadastrar);

		mnListagem = new JMenu("Listagem");
		menuBar.add(mnListagem);

		listarUsuarios = new JMenuItem("Usuários");
		listarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Usuario> lista = Fachada2.listarUsuarios();
				String texto = "Listagem de Usuários: \n";
				if (lista.isEmpty())
					texto += "n�o tem usuários cadastrado\n";
				else
					for (Usuario p : lista)
						texto += p + "\n";

				TelaListagem j = new TelaListagem(texto);
				j.setVisible(true);
			}
		});
		mnListagem.add(listarUsuarios);

		listarPedidos = new JMenuItem("Pedidos");
		listarPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Pedido> lista = Fachada2.listarPedidos();
				String texto = "Listagem de Pedidos: \n";
				if (lista.isEmpty())
					texto += "n�o tem Pedidos cadastrado\n";
				else
					for (Pedido p : lista)
						texto += p + "\n";

				TelaListagem j = new TelaListagem(texto);
				j.setVisible(true);
			}
		});
		mnListagem.add(listarPedidos);
//		mnConsulta.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				TelaConsulta j = new TelaConsulta();
//				j.setVisible(true);
//
//			
//			}
//		});

	}
}
