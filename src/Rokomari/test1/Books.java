package Rokomari.test1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Books {
	private String[][] books=new String[100][3];
	private int book_ttl;
	Books() {
		this.readBookFile();
	}
	private void readBookFile() {
		try {
			//System.out.println("into the method");
			File book_file=new File("resource//books.txt");
			Scanner sc=new Scanner(book_file);
			String line;
			int count=0;
			while(sc.hasNext()) {
				line=sc.nextLine();
				StringTokenizer st=new StringTokenizer(line,",");
				int flag=0;
				String str;
				while(st.hasMoreTokens()) {
					str=st.nextToken();
					str=str.trim();
					if(str!=null&&str!="") {
						books[count][flag++]=str;
						//System.out.print(books[count][flag-1]+" "+flag);
					}
				}
				//System.out.println("");
				count++;
			}
			book_ttl=count;
			sc.close();
		}
		catch(IOException e) {
			
		}
	}
	public void browseBooks() {
		System.out.println("Book Id\t Name \t Price");
		for(int i=0;i<book_ttl;i++) {
			System.out.println(this.books[i][0]+"\t"+this.books[i][1]+"\t"+this.books[i][2]);
		}
	}
	public static void main(String a[]) {
		Books book=new Books();
		book.readBookFile();
		book.browseBooks();
	}

}
