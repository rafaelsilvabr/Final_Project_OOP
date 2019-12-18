package FinalProject;


import java.io.IOException;

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
			String teste="";
			while(!(teste.equals("S"))){
				teste = JOptionPane.showInputDialog("Escolha a operação\n I -Inclusão\n E - Exclusão\n A-Alteração\n C-Consulta\n L-Lista\n S-Sair");							
				if(teste.equals("I")) {
					
				}
				if(teste.equals("E")) {
					
				}
				if(teste.equals("A")) {
					
				}
				if(teste.equals("C")) {
					
				}
				if(teste.equals("L")) {
					
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
