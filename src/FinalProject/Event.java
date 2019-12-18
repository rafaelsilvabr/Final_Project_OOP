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

public class Event implements File{
	private String name;
	private int start_month,start_year;
	private int end_month,end_year;
	private String institutionName;
	private int type; //  0 = National | 1 = International
	
	public ArrayList<Event> events;
	
	public Event() {
		events = new ArrayList<Event>();
	}

	public Event(String name, int start_month, int start_year, int end_month, int end_year, String institutionName,
			int type) {
		this.name = name;
		this.start_month = start_month;
		this.start_year = start_year;
		this.end_month = end_month;
		this.end_year = end_year;
		this.institutionName = institutionName;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStart_month() {
		return start_month;
	}

	public void setStart_month(int start_month) {
		this.start_month = start_month;
	}

	public int getStart_year() {
		return start_year;
	}

	public void setStart_year(int start_year) {
		this.start_year = start_year;
	}

	public int getEnd_month() {
		return end_month;
	}

	public void setEnd_month(int end_month) {
		this.end_month = end_month;
	}

	public int getEnd_year() {
		return end_year;
	}

	public void setEnd_year(int end_year) {
		this.end_year = end_year;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public int readFile()throws IOException{
		InputStream is= new FileInputStream("events.txt");
		InputStreamReader isr= new InputStreamReader(is);
		BufferedReader br= new BufferedReader(isr);
		
		String s = br.readLine();
		int qtd_events=0;
		int c=1;
		for(int i=(s.length()-1);i>=0;i--) {
			qtd_events+=((s.charAt(i)-'0')*c);
			c*=10;
		}
		
		for(int i=0;i<qtd_events;i++) {
			s=br.readLine();
			String name=s; //read name
			
			s=br.readLine(); //read start_montht
			int start_month=0;
			c=1;
			for(int i1=(s.length()-1);i1>=0;i1--) {
				start_month=((s.charAt(i1)-'0')*c);
				c*=10;
			}
			
			s=br.readLine(); //read start_year
			int start_year=0;
			c=1;
			for(int i1=(s.length()-1);i1>=0;i1--) {
				start_year=((s.charAt(i1)-'0')*c);
				c*=10;
			}
			
			s=br.readLine(); //read end_montht
			int end_month=0;
			c=1;
			for(int i1=(s.length()-1);i1>=0;i1--) {
				end_month=((s.charAt(i1)-'0')*c);
				c*=10;
			}
			
			s=br.readLine(); //read end_year
			int end_year=0;
			c=1;
			for(int i1=(s.length()-1);i1>=0;i1--) {
				end_year=((s.charAt(i1)-'0')*c);
				c*=10;
			}			
			
			s=br.readLine();
			String institution = s;
			
			s=br.readLine(); //read type of event
			int type=0;
			c=1;
			for(int i1=(s.length()-1);i1>=0;i1--) {
				type=((s.charAt(i1)-'0')*c);
				c*=10;
			}			
			
			Event aux = new Event(name,start_month,start_year,end_month,end_year,institution,type);
			events.add(aux);
		}
		br.close();
		return 0;
	}

	public int writeFile() throws IOException {
		OutputStream os= new FileOutputStream("events.txt");
		OutputStreamWriter osw= new OutputStreamWriter(os);
		BufferedWriter bw= new BufferedWriter(osw);
		
		bw.write(events.size()+"\n");
		for(int i=0;i<events.size();i++) {
			Event aux = events.get(i);
			bw.write(aux.getName()+"\n");
			bw.write(aux.getStart_month()+"\n");
			bw.write(aux.getStart_year()+"\n");
			bw.write(aux.getEnd_month()+"\n");
			bw.write(aux.getEnd_year()+"\n");
			bw.write(aux.getInstitutionName()+"\n");
			bw.write(aux.getType()+"\n");
		}
		bw.close();
		return 0;
	}
	
	
}

