package FinalProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Article implements File_Article {
	private static int static_ID=0;
	private int id;
	private Person author;
	private String title;
	public ArrayList <String> keyWords;
	private Event publishingEvent;
	private int publishing_year;
	public ArrayList <String> coments;
	
	public ArrayList <Article> articles;
	
	public Article() {
		articles = new ArrayList<Article>();
	}
	
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
	public Article(int id,Person author, String title, ArrayList<String> keyWords, Event publishingEvent, int publishing_year,
			ArrayList<String> coments) {
		this.id=id;
		this.author = author;
		this.title = title;
		this.keyWords = keyWords;
		this.publishingEvent = publishingEvent;
		this.publishing_year = publishing_year;
		this.coments = coments;
	}
	
	public void setid(int id) {
		this.id=id;
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

	public void readFile(Person person, Event event) throws IOException {
		InputStream is= new FileInputStream("articles.txt");
		InputStreamReader isr= new InputStreamReader(is);
		BufferedReader br= new BufferedReader(isr);
		
		String s = br.readLine();
		int qtd_articles=0;
		int c=1;
		for(int i=(s.length()-1);i>=0;i--) {
			qtd_articles+=((s.charAt(i)-'0')*c);
			c*=10;
		}
		static_ID=qtd_articles;
		for(int i=0;i<qtd_articles;i++) {
			s=br.readLine();
			int id=0;
			c=1;
			for(int i1=s.length()-1;i1>=0;i1--) {
				id+=((s.charAt(i1)-'0')*c);
				c*=10;
			}
			
			s=br.readLine();
			Person author = null;
			for(int i1=0;i1<person.authors.size();i1++) {
				Person aux=person.authors.get(i1);
				if(s.equals(aux.getName())){
					author=aux;
					break;
				}
			}
			
			s=br.readLine();
			String title=s;
			
			s=br.readLine();
			int qtd_key_words=0;
			c=1;
			for(int i1=s.length()-1;i1>=0;i1--) {
				qtd_key_words+=((s.charAt(i1)-'0')*c);
				c*=10;
			}	
			keyWords=new ArrayList<String>();
			for(int i1=0;i1<qtd_key_words;i1++) {
				s=br.readLine();
				keyWords.add(s);
			}
			
			s=br.readLine();
			Event eve=null;
			for(int i1=0;i1<event.events.size();i1++) {
				Event aux=event.events.get(i1);
				if(s.equals(aux.getName())){
					eve = aux;
					break;
				}
			}			
			
			s = br.readLine();
			int publishing_year=0;
			c=1;
			for(int i1=(s.length()-1);i1>=0;i1--) {
				publishing_year+=((s.charAt(i)-'0')*c);
				c*=10;
			}
			
			s=br.readLine();
			int qtd_coments=0;
			c=1;
			for(int i1=s.length()-1;i1>=0;i1--) {
				qtd_coments+=((s.charAt(i1)-'0')*c);
				c*=10;
			}	
			coments=new ArrayList<String>();
			for(int i1=0;i1<qtd_coments;i1++) {
				s=br.readLine();
				coments.add(s);
			}
			
			Article article = new Article (id,author,title,keyWords,eve,publishing_year,coments);
			articles.add(article);
		}
		br.close();
	}
	public void writeFile() throws IOException {
		OutputStream os= new FileOutputStream("articles.txt");
		OutputStreamWriter osw= new OutputStreamWriter(os);
		BufferedWriter bw= new BufferedWriter(osw);
		
		bw.write(articles.size() + "\n");
		for(int i=0;i<articles.size();i++) {
			Article aux = articles.get(i);
			bw.write(aux.getid() + "\n");
			bw.write(aux.author.getName() + "\n");
			bw.write(aux.getTitle()+ "\n");
			bw.write(aux.keyWords.size() + "\n");
			for(int i1=0;i1<aux.keyWords.size();i1++) {
				bw.write(aux.keyWords.get(i)+"\n");
			}
			bw.write(aux.publishingEvent.getName()+ "\n");
			bw.write(aux.getPublishing_year()+"\n");
			bw.write(aux.coments.size() + "\n");
			for(int i1=0;i1<aux.coments.size();i1++) {
				bw.write(aux.coments.get(i)+"\n");
			}
		}
		bw.close();
	}
	
}
