package FinalProject;

import java.io.IOException;
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
	
	public Person readFile() throws IOException {
		
		InputStream is= new FileInputStream("authors.txt");
		InputStreamReader isr= new InputStreamReader(is);
		BufferedReader br= new BufferedReader(isr);
		
		String s = br.readLine();
		String name=s; //read name
		
		s=br.readLine(); //read year_birth and change String to int
		int c=1;
		int year_birth=0; 
		for(int i=s.length()-1;i>=0;i--) {
			year_birth+=((s.charAt(i)-'0')*c);
			c*=10;
		}
		
		s=br.readLine(); //read institution
		String institution=s;
		
		s=br.readLine(); //read qtd_articles
		int qtd_articles=0;
		c=1;
		for(int i=s.length()-1;i>=0;i--) {
			qtd_articles+=((s.charAt(i)-'0')*c);
			c*=10;
		}
		
		s=br.readLine(); //read articles
		String[]articles=s.split(":");
		
		Person person=new Person (name,year_birth,institution,qtd_articles,articles);
		br.close();
		
		return person;
		
	}

	public void writeFile() throws IOException {
		
		OutputStream os= new FileOutputStream("authors.txt");
		OutputStreamWriter osw= new OutputStreamWriter(os);
		BufferedWriter bw= new BufferedWriter(osw);
		
		bw.write(name);
		bw.write(year_birth);
		bw.write(institution);
		bw.write(qtd_articles);
			
		String str="";
		for(int i=0;i<qtd_articles;i++) {
			str=str+articles[i];
			if(i<qtd_articles-1) str=str+":";
		}
		bw.write(str);
		bw.close();		
	}
	
	
	
}
