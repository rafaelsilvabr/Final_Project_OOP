package FinalProject;


import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
			
		Person person = new Person();
		
		person.readFile();
		person.writeFile();
	}

}
