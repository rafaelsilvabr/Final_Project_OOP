package FinalProject;

import java.io.File;
import java.io.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
			
		File diretorio = new File ("C:\\Git\\Final_Project_OOP");
		File arquivo = new File (diretorio,"teste.txt");
		FileWriter f= new FileWriter(arquivo);
		f.close();
		
		InputStream is= new FileInputStream("authors.txt");
		InputStreamReader isr= new InputStreamReader(is);
		BufferedReader br= new BufferedReader(isr);
		String s = br.readLine();

		OutputStream os= new FileOutputStream("authors.txt");
		OutputStreamWriter osw= new OutputStreamWriter(os);
		BufferedWriter bw= new BufferedWriter(osw);
		bw.write("test");		
		
		
		while(s != null) {
			String name=s;
			s=br.readLine();
			
			int c=1;
			int year_birth=0;
			for(int i=s.length()-1;i>=0;i--) {
				year_birth+=((s.charAt(i)-'0')*c);
				c*=10;
			}
			s=br.readLine();
			
			String institution=s;
			s=br.readLine();
			
			
			
			///try read id of articles of each author
		//	for(int i=0;i<s.length();i++) {
				
		//	}
		}


		br.close();
		bw.close();
	}

}
