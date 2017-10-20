package Rokomari.test1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Calculations {
	public void buyBook(String[][] books,Users user,int book_ttl) {
		String book_id,book_name=null;
		int price=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the book id: ");
		book_id=sc.nextLine();
		boolean id_flag=false,buy_flag=false;
		for(int i=0;i<book_ttl;i++) {
			if(book_id.equals(books[i][0])) {
				id_flag=true;
				book_name=books[i][1];
				price=Integer.parseInt(books[i][2]);
			}
		}
		if(!id_flag) {
			return;
		}
		else {
			System.out.println("Do you want to buy this book? Type yes/no:");
			String buy=sc.nextLine();
			if(buy.equals("yes")) buy_flag=true;
		}
		
		if(buy_flag) {
			if(user.getBalance()<price) {
				System.out.println("Out of Balance.");
				return;
			}
			else 
			this.buyCalculations(user,book_name, price);
		}
	}
	private void buyCalculations(Users user, String book_name, int price) {
		try {
			File file_user=new File("resource//"+user.getUserName()+".txt");
			FileOutputStream fos=new FileOutputStream(file_user);
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fos));
			bw.write(book_name+" "+price);
			bw.close();
		}
		catch(IOException e) {
			
		}
		user.updateUserFile(price);
		
		
	}
	

}
