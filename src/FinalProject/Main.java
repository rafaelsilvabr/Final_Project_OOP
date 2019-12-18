package FinalProject;


import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
			
		Person person = new Person();
		person.readFile();
		
		Event event = new Event();		
		event.readFile();
		
		Article article = new Article();
		article.readFile(person, event);
		
		
		article.writeFile();
		event.writeFile();
		person.writeFile();
		
	}

}
