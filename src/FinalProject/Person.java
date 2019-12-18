package FinalProject;

import java.io.IOException;
import java.util.ArrayList;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.*;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;



public class Person implements File_person {
	private String name;
	private int year_birth;
	private String institution;
	int qtd_articles;
	String[] articles;
	
	private ArrayList<Person> authors=null;
	
	public Person() {
		authors=new ArrayList<Person>();
	}
	
	public Person(String name, int year_birth, String institution, int qtd_articles, String[] articles) {
		super();
		this.name = name;
		this.year_birth = year_birth;
		this.institution = institution;
		this.qtd_articles = qtd_articles;
		this.articles = articles;
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

	public int getQtd_articles() {
		return qtd_articles;
	}

	public void setQtd_articles(int qtd_articles) {
		this.qtd_articles = qtd_articles;
	}

	public String[] getArticles() {
		return articles;
	}

	public void setArticles(String[] articles) {
		this.articles = articles;
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
			br.readLine();
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
			
			s=br.readLine(); //read qtd_articles
			int qtd_articles=0;
			c=1;
			for(int i1=s.length()-1;i1>=0;i1--) {
				qtd_articles+=((s.charAt(i1)-'0')*c);
				c*=10;
			}
			
			s=br.readLine(); //read articles
			String[]articles=s.split(":");
			
			Person person=new Person (name,year_birth,institution,qtd_articles,articles);
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
			bw.write(aux.getQtd_articles()+ "\n");			
			String str="";
			int qtd_art=aux.getQtd_articles();
			for(int i1=0;i1<qtd_art;i1++) {
				str=str+aux.articles[i1];
				if(i1<qtd_articles-1) str=str+":";
			}
			bw.write(str+ "\n");
		}
		bw.close();		
	}
}
