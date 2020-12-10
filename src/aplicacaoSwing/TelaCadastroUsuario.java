package aplicacaoSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada.Fachada;

public class TelaCadastroUsuario {

	private JFrame frmCadastroDePessoa;
	private JLabel lb1Nome;
	private JLabel lb1Cpf;
	private JLabel lb1DataNas;
	private JLabel lb1Email;
	private JLabel lb1Senha;
	private JLabel lb1cidade;
	private JLabel lb1bairro;
	private JLabel lb1Rua;
	private JLabel lb1Numero;

	private JTextField NomeField;
	private JTextField CpfField;
	private JTextField FoneField;
	private JTextField EmailField;
	private JTextField SenhaField;
	private JTextField CidadeField;
	private JTextField bairroField;
	private JTextField ruaField;
	private JTextField numeroField;
	private JButton button2;
	private JLabel label2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastroPessoa window = new TelaCadastroPessoa();
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
	public TelaCadastroUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDePessoa = new JFrame();
		frmCadastroDePessoa.setTitle("Cadastro de Pessoa");
		frmCadastroDePessoa.setBounds(100, 100, 321, 330);
		frmCadastroDePessoa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDePessoa.getContentPane().setLayout(null);

		// NOME
		lb1Nome = new JLabel("Nome:");
		lb1Nome.setBounds(25, 34, 46, 14);
		frmCadastroDePessoa.getContentPane().add(lb1Nome);

		// CAMPO DO NOME
		NomeField = new JTextField();
		NomeField.setBounds(66, 31, 130, 20);
		frmCadastroDePessoa.getContentPane().add(NomeField);
		NomeField.setColumns(10);

		// CPF
		lb1Cpf = new JLabel("CPF:");
		lb1Cpf.setBounds(25, 50, 46, 30);
		frmCadastroDePessoa.getContentPane().add(lb1Cpf);
		
		// CAMPO CPF
		CpfField = new JTextField();
		CpfField.setBounds(62, 55, 130, 20);
		frmCadastroDePessoa.getContentPane().add(CpfField);
		CpfField.setColumns(10);

		// DADANASCI
		lb1DataNas = new JLabel("Nascimento:");
		lb1DataNas.setBounds(25, 66, 200, 46);
		frmCadastroDePessoa.getContentPane().add(lb1DataNas);

		// CAMPO DATANASCI
		FoneField = new JTextField();
		FoneField.setBounds(115, 79, 130, 20);
		frmCadastroDePessoa.getContentPane().add(FoneField);
		FoneField.setColumns(10);

		// EMAIL
		lb1Email = new JLabel("Email:");
		lb1Email.setBounds(25, 82, 46, 62);
		frmCadastroDePessoa.getContentPane().add(lb1Email);

		// CAMPO EMAIL
		EmailField = new JTextField();
		EmailField.setBounds(68, 103, 130, 20);
		frmCadastroDePessoa.getContentPane().add(EmailField);
		EmailField.setColumns(10);

		// SENHA
		lb1Senha = new JLabel("Senha:");
		lb1Senha.setBounds(25, 98, 70, 78);
		frmCadastroDePessoa.getContentPane().add(lb1Senha);

		// CAMPO SENHA
		SenhaField = new JTextField();
		SenhaField.setBounds(85, 127, 130, 20);
		frmCadastroDePessoa.getContentPane().add(SenhaField);
		SenhaField.setColumns(10);

		
		lb1cidade = new JLabel("Cidade:");
		lb1cidade.setBounds(25, 145, 90, 30);
		frmCadastroDePessoa.getContentPane().add(lb1cidade);

		CidadeField = new JTextField();
		CidadeField.setBounds(85, 151, 130, 20);
		frmCadastroDePessoa.getContentPane().add(CidadeField);
		CidadeField.setColumns(10);

		lb1bairro = new JLabel("Bairro:");
		lb1bairro.setBounds(25, 161, 70, 46);
		frmCadastroDePessoa.getContentPane().add(lb1bairro);

		bairroField = new JTextField();
		bairroField.setBounds(85, 175, 130, 20);
		frmCadastroDePessoa.getContentPane().add(bairroField);
		bairroField.setColumns(10);

		lb1Rua = new JLabel("Rua:");
		lb1Rua.setBounds(25, 177, 46, 62);
		frmCadastroDePessoa.getContentPane().add(lb1Rua);

		ruaField = new JTextField();
		ruaField.setBounds(68, 199, 130, 20);
		frmCadastroDePessoa.getContentPane().add(ruaField);
		ruaField.setColumns(10);

		lb1Numero = new JLabel("Número:");
		lb1Numero.setBounds(25, 193, 90, 78);
		frmCadastroDePessoa.getContentPane().add(lb1Numero);

		numeroField = new JTextField();
		numeroField.setBounds(85, 223, 130, 20);
		frmCadastroDePessoa.getContentPane().add(numeroField);
		numeroField.setColumns(10);

		label2 = new JLabel("");
		label2.setBounds(26, 284, 189, 14);
		frmCadastroDePessoa.getContentPane().add(label2);

		button2 = new JButton("Cadastrar");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(CpfField.getText().isEmpty() )
						label2.setText("campo vazio");
					else {
					String nome = NomeField.getText();
					String cpf = CpfField.getText();
					String fone = FoneField.getText();
					String email = EmailField.getText();
					String senha = SenhaField.getText();
					String cidade = CidadeField.getText();
					String bairro = bairroField.getText();
					String rua = ruaField.getText();
					String numero = numeroField.getText();
					Fachada.cadastrarUsuario(nome, cpf, fone, email, senha,cidade,bairro,rua,numero);
					label2.setText("Usuario cadastrado");
					}
				} catch (Exception e) {
					label2.setText(e.getMessage());
				}
			}
		});
		button2.setBounds(76, 260, 145, 23);
		frmCadastroDePessoa.getContentPane().add(button2);

		// mostrar a janela
		frmCadastroDePessoa.setVisible(true);
	}
}
