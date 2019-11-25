package FinalProject;

import java.util.ArrayList;

public class Person {
	private String name;
	private int year_birth;
	private String institution;
	private ArrayList<Article> articles;

	public Person(String name, int year_birth, String institution, ArrayList<Article> articles) {
		super();
		this.name = name;
		this.year_birth = year_birth;
		this.institution = institution;
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

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(Article article) {
		this.articles.add(article);
	}
	
}
