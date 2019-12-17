package FinalProject;

import java.io.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
			
		InputStream is= new FileInputStream("authors.txt");
		InputStreamReader isr= new InputStreamReader(is);
		BufferedReader br= new BufferedReader(isr);
		String s = br.readLine();

		int qtd_person=0;
		int c=1;
		for(int i=s.length()-1;i>=0;i--) {
			qtd_person+=((s.charAt(i)-'0')*c);
			c*=10;
		}
		ArrayList<Person> authors = null;
		for(int i=0;i<qtd_person;i++) {
			Person person = null;
			person.readFile();
			authors.add(person);
		}
		br.close();
		
		
		
		
		
	}

}
