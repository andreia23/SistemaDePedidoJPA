package aplicacaoTempo;

import java.io.FileWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import fachada.Fachada;
import modelo.Pessoa;

public class MedirTempo {

	public static void main(String[] args) {
		LocalDateTime hinicial, hfinal;
		String nome, telefone;

		Fachada.inicializar();
		try{
//			FileWriter arquivo = new FileWriter("tempo.txt", true); //append
//			arquivo.write("\n teste:");

			hinicial = LocalDateTime.now();
			System.out.println("\ninicio da gravação " + hinicial);
			
			for (int i = 1; i<=1000; i++){
				nome = "seu nome"+i;
				telefone = "numero da matricula"+i;
				Fachada.cadastrarPessoa(nome,telefone);
			}
			System.out.println("fim da gravação    " + LocalDateTime.now());			

			System.out.println("\n\ninicio da consulta =  " +  LocalDateTime.now());	
			List<Pessoa> s = Fachada.listarPessoas();
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


