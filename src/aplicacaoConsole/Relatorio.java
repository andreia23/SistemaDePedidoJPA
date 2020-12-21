//
///**
// * IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
// *	
// * Aplica��o JasperReport 6.14
// */
//
//package aplicacaoConsole;
//import fachada.Fachada;
//import fachada.Fachada;
//
//public class Relatorio {
//	
//	public Relatorio() {
//		Fachada.inicializar();		
//		relatorio(); 		
//		Fachada.finalizar();
//	}
//
//	/************************/
//	public void relatorio(){
//		/************************/
//		try {
//			Fachada.gerarRelatorioJasper("produto.jrxml");
//		} catch (Exception e) {
//			System.out.println("-->"+e.getMessage());
//		}
//	}
//	
//	//=================================================
//		public static void main(String[] args) {
//			new Relatorio();
//		}
//		//=================================================
//
//}
