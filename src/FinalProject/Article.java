package FinalProject;

import java.util.ArrayList;

public class Article {
	private static int static_ID;
	private int id;
	private Person author;
	private String title;
	private ArrayList <String> keyWords;
	private Event publishingEvent;
	private int publishing_year;
	private ArrayList <String> coments;
	
	public Article(Person author, String title, ArrayList<String> keyWords, Event publishingEvent, int publishing_year,
			ArrayList<String> coments) {
		this.id=setID();
		this.author = author;
		this.title = title;
		this.keyWords = keyWords;
		this.publishingEvent = publishingEvent;
		this.publishing_year = publishing_year;
		this.coments = coments;
	}
	
	public int getid() {
		return id;
	}

	private int setID() {
		static_ID++;
		return static_ID;
	}

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<String> getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWord) {
		this.keyWords.add(keyWord);
	}

	public Event getPublishingEvent() {
		return publishingEvent;
	}

	public void setPublishingEvent(Event publishingEvent) {
		this.publishingEvent = publishingEvent;
	}

	public int getPublishing_year() {
		return publishing_year;
	}

	public void setPublishing_year(int publishing_year) {
		this.publishing_year = publishing_year;
	}

	public ArrayList<String> getComents() {
		return coments;
	}

	public void setComents(String coments) {
		this.coments.add(coments);
	}
	
}
