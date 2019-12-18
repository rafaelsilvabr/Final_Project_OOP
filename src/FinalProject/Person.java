package FinalProject;

import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

public class Person implements File {
	private String name;
	private int year_birth;
	private String institution;
	
	public ArrayList<Person> authors=null;
	
	public Person() {
		authors=new ArrayList<Person>();
	}
	
	public Person(String name, int year_birth, String institution) {
		super();
		this.name = name;
		this.year_birth = year_birth;
		this.institution = institution;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear_birth() {
		return year_birth;
	}

	public void setYear_birth(int year_birth) {
		this.year_birth = year_birth;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
	public void readFile() throws IOException {
		
		InputStream is= new FileInputStream("authors.txt");
		InputStreamReader isr= new InputStreamReader(is);
		BufferedReader br= new BufferedReader(isr);
		
		String s = br.readLine();
		int qtd_person=0;
		int c=1;
		for(int i=(s.length()-1);i>=0;i--) {
			qtd_person+=((s.charAt(i)-'0')*c);
			c*=10;
		}
		
		
		for(int i=0;i<qtd_person;i++) {
			s=br.readLine();
			String name=s; //read name
			
			s=br.readLine(); //read year_birth and change String to int
			c=1;
			int year_birth=0; 
			for(int i1=s.length()-1;i1>=0;i1--) {
				year_birth+=((s.charAt(i1)-'0')*c);
				c*=10;
			}
			
			s=br.readLine(); //read institution
			String institution=s;
			
			Person person=new Person (name,year_birth,institution);
			authors.add(person);
		}
		br.close();
	}

	public void writeFile() throws IOException {
		
		OutputStream os= new FileOutputStream("authors.txt");
		OutputStreamWriter osw= new OutputStreamWriter(os);
		BufferedWriter bw= new BufferedWriter(osw);
		
		int tam=authors.size();
		bw.write(tam + "\n");
		for(int i=0;i<tam;i++) {
			Person aux = authors.get(i);
			bw.write(aux.getName()+ "\n");
			bw.write(aux.getYear_birth()+ "\n");
			bw.write(aux.getInstitution()+ "\n");			
		}
		bw.close();		
	}
}
