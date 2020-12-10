package aplicacaoTempo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import fachada.Fachada;
import fachada.Fachada;
import modelo.Usuario;

public class MedirTempo {

	public static void main(String[] args) {
		LocalDateTime hinicial, hfinal;
		String nome, cpf,fone, email,senha,cidade,bairro,rua,numero;

		Fachada.inicializar();
		try{
//			FileWriter arquivo = new FileWriter("tempo.txt", true); //append
//			arquivo.write("\n teste:");

			hinicial = LocalDateTime.now();
			System.out.println("\ninicio da grava��o " + hinicial);
			
			for (int i = 1; i<=1000; i++){
				nome = "seu nome"+i;
				cpf ="cpf"+ i;
				fone ="fone"+i;
				email = "email"+i;
				senha="senha"+i;
				cidade="cidade"+i;
				bairro="bairro"+i;
				rua="rua"+i;
				numero="numero"+i;
				Fachada.cadastrarUsuario(nome, cpf,fone, email,senha,cidade,bairro,rua,numero);
			}
			System.out.println("fim da grava��o    " + LocalDateTime.now());			

			System.out.println("\n\ninicio da consulta =  " +  LocalDateTime.now());	
			List<Usuario> s = Fachada.listarUsuarios();
			System.out.println(s.size());
			hfinal = LocalDateTime.now();
			System.out.println("fim da consulta =     " + hfinal);

			//---- Tempo Total----------
			String resumo= 
					"\n Hora inicial= " +hinicial +
					"\n Hora final=   "+ hfinal +
					"\n Total (seg)=  "+Duration.between(hinicial, hfinal).getSeconds();
			
			System.out.println(resumo);
//			arquivo.write(resumo);
//			arquivo.close();
			Fachada.finalizar();
		}
		catch(Exception e){
			System.out.println("erro:"+ e.getMessage());
		}
	}

}


