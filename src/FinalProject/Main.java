package FinalProject;


import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws IOException {
			
		Person person = new Person();
		person.readFile();
		
		Event event = new Event();		
		event.readFile();
		
		Article article = new Article();
		article.readFile(person, event);
		
		String login_type = JOptionPane.showInputDialog("User or Admin ?");
		
		if(login_type.equals("Admin")) {
			String operation="";
			while(!(operation.equals("S"))){
				operation = JOptionPane.showInputDialog("Escolha a operação\n I -Inclusão\n E - Exclusão\n A-Alteração\n C-Consulta \n S-Sair");							
				if(operation.equals("I")) {
					String op = JOptionPane.showInputDialog("Inclusão\n A-Autor\n B-Article\n C-Event");
					if(op.equals("A")) {
						String name = JOptionPane.showInputDialog("Insira o Nome:");
						String aux = JOptionPane.showInputDialog("Insira o Ano Aniversario:");
						int year_birth=0;
						int c=1;
						for(int i1=(aux.length()-1);i1>=0;i1--) {
							year_birth=((aux.charAt(i1)-'0')*c);
							c*=10;
						}
						String institution = JOptionPane.showInputDialog("Insira a Instituição:");
						Person p_aux=new Person (name,year_birth,institution);
						person.authors.add(p_aux);						
					}
					if(op.equals("B")) {
						String title = JOptionPane.showInputDialog("Insira o Título do Artigo");
						String aux = JOptionPane.showInputDialog("Insira o Nome do Autor:");
						Person author = null;
						for(int i=0;i<person.authors.size();i++) {
							if(aux.equals(person.authors.get(i).getName())) {
								author=person.authors.get(i);
							}
						}
						aux = JOptionPane.showInputDialog("Insira o nome do Evento que foi publicado:");
						Event pub_event = null;
						for(int i=0;i<event.events.size();i++) {
							if(aux.equals(event.events.get(i).getName())) {
								pub_event=event.events.get(i);
							}
						}
						aux = JOptionPane.showInputDialog("Insira o ano de publicação:");
						int year_pub=0;
						int c=1;
						for(int i1=(aux.length()-1);i1>=0;i1--) {
							year_pub=((aux.charAt(i1)-'0')*c);
							c*=10;
						}
						ArrayList<String> kw = new ArrayList<String>();
						aux = JOptionPane.showInputDialog("Insira a quantidade de KeyWords:");
						int qtd_kw=0;
						c=1;
						for(int i1=(aux.length()-1);i1>=0;i1--) {
							qtd_kw=((aux.charAt(i1)-'0')*c);
							c*=10;
						}
						for(int i=0; i< qtd_kw ; i++) {
							aux = JOptionPane.showInputDialog("Insira a " + i+1 + "° keyword");
							kw.add(aux);
						}
						ArrayList<String> coments = new ArrayList<String>();
						aux = JOptionPane.showInputDialog("Insira a quantidade de Coments:");
						int qtd_com=0;
						c=1;
						for(int i1=(aux.length()-1);i1>=0;i1--) {
							qtd_com=((aux.charAt(i1)-'0')*c);
							c*=10;
						}
						for(int i=0; i< qtd_com ; i++) {
							aux = JOptionPane.showInputDialog("Insira o " + i+1 + "° comentario");
							coments.add(aux);
						}
						Article art = new Article (author,title,kw,pub_event,year_pub,coments);
						article.articles.add(art);
					}	
					if(op.equals("C")) {
						String name = JOptionPane.showInputDialog("Insira o Nome do Evento");
						String aux = JOptionPane.showInputDialog("Insira o mes de inicio");
						int ini_month =0;
						int c=1;
						for(int i1=(aux.length()-1);i1>=0;i1--) {
							ini_month=((aux.charAt(i1)-'0')*c);
							c*=10;
						}
						aux = JOptionPane.showInputDialog("Insira o ano de inicio");
						int ini_year =0;
						c=1;
						for(int i1=(aux.length()-1);i1>=0;i1--) {
							ini_year=((aux.charAt(i1)-'0')*c);
							c*=10;
						}
						aux = JOptionPane.showInputDialog("Insira o mes final");
						int end_month =0;
						c=1;
						for(int i1=(aux.length()-1);i1>=0;i1--) {
							end_month=((aux.charAt(i1)-'0')*c);
							c*=10;
						}
						aux = JOptionPane.showInputDialog("Insira o ano final");
						int end_year =0;
						c=1;
						for(int i1=(aux.length()-1);i1>=0;i1--) {
							end_year=((aux.charAt(i1)-'0')*c);
							c*=10;
						}
						String institution = JOptionPane.showInputDialog("Insira a Instituição");
						
						aux = JOptionPane.showInputDialog("Insira: 1-Evento Internacional | 0 - Nacional");
						int type =0;
						c=1;
						for(int i1=(aux.length()-1);i1>=0;i1--) {
							type=((aux.charAt(i1)-'0')*c);
							c*=10;
						}
						Event eve = new Event(name,ini_month,ini_year,end_month,end_year,institution,type);
						event.events.add(eve);
					}
				}
				if(operation.equals("E")) {
					String op = JOptionPane.showInputDialog("Exclusão\n A-Autor\n B-Article\n C-Event");
					if(op.equals("A")) {
						String aux = JOptionPane.showInputDialog("Insira o nome a ser removido");
						for(int i=0;i<person.authors.size();i++) {
							if(aux.equals(person.authors.get(i).getName())) {
								person.authors.remove(i);
							}
						}
					}
					if(op.equals("B")) {
						String aux = JOptionPane.showInputDialog("Insira o nome do artigo a ser removido");
						for(int i=0;i<article.articles.size();i++) {
							if(aux.equals(article.articles.get(i).getTitle())) {
								article.articles.remove(i);
							}
						}
					}
					if(op.equals("C")) {
						String aux = JOptionPane.showInputDialog("Insira o nome do evento a ser removido");
						for(int i=0;i<event.events.size();i++) {
							if(aux.equals(event.events.get(i).getName())) {
								event.events.remove(i);
							}
						}
					}
				}
				if(operation.equals("A")) {
					String op = JOptionPane.showInputDialog("Alteração\n A-Autor\n B-Article\n C-Event");
					if(op.equals("A")) {
						String name = JOptionPane.showInputDialog("Insira o nome da pessoa para atualizar os dados");
						for(int i=0;i<person.authors.size();i++) {
							if(name.equals(person.authors.get(i).getName())) {
								String aux = JOptionPane.showInputDialog("Instituição:" + person.authors.get(i).getInstitution() + "\nAno Aniversario:" + person.authors.get(i).getYear_birth() + "\n Deseja Alterar? (S/N)");
								if(aux.equals("S")) {
									aux=JOptionPane.showInputDialog("Insira a Instituição");
									person.authors.get(i).setInstitution(aux);
									aux=JOptionPane.showInputDialog("Insira o Ano de Aniversario");
									int y_b=0;
									int c=1;
									for(int i1=(aux.length()-1);i1>=0;i1--) {
										y_b=((aux.charAt(i1)-'0')*c);
										c*=10;
									}
									person.authors.get(i).setYear_birth(y_b);
								}
								
							}
						}
					}
					if(op.equals("B")) {
						String name = JOptionPane.showInputDialog("Insira o nome do Artigo a ser alterado");
						for(int i=0;i<article.articles.size();i++) {
							if(name.equals(article.articles.get(i).getTitle())){
								String aux = JOptionPane.showInputDialog("Pub Year:" + article.articles.get(i).getPublishing_year() + "Deseja alterar? (S/N)");
								if(aux.equals("S")) {
									String aux2 = JOptionPane.showInputDialog("Insira o ano de publicacao");
									int year_birth=0;
									int c=1;
									for(int i1=(aux2.length()-1);i1>=0;i1--) {
										year_birth=((aux2.charAt(i1)-'0')*c);
										c*=10;
									}
									article.articles.get(i).setPublishing_year(year_birth);
								}
							}
						}
					}
					if(op.equals("C")) {
						String name = JOptionPane.showInputDialog("Insira o nome do Evento a ser alterado");
						for(int i=0;i<event.events.size();i++) {
							if(name.equals(event.events.get(i).getName())) {
								int mes_ini = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o mes de Inicio"));
								event.events.get(i).setStart_month(mes_ini);
								int ano_ini = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o ano de Inicio"));
								event.events.get(i).setStart_year(ano_ini);
								int mes_end = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o mes Final"));
								event.events.get(i).setEnd_month(mes_end);
								int ano_end = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o ano Final"));
								event.events.get(i).setEnd_year(ano_end);
								String institution = JOptionPane.showInputDialog("Insira o nome da instituição");
								event.events.get(i).setInstitutionName(institution);
								int type = Integer.parseInt(JOptionPane.showInputDialog("Informe o tipo : 0-Nacional | 1-Internacional"));
								event.events.get(i).setType(type);
							}
						}
						
					}
				}
				if(operation.equals("C")) {
					
				}
			}
			
		}
		if(login_type.equals("User")){
		
			
		}
		
		article.writeFile();
		event.writeFile();
		person.writeFile();
		
	}

}
