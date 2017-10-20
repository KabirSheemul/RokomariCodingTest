package Rokomari.test1;

import java.util.Scanner;

public class Index {
	static Users user;
	static Scanner sc;
	public static void main(String a[]) {
		user=new Users();
		Index index=new Index();
		int attempt=5;
		String user_name,pass;
		 sc=new Scanner(System.in);
		while(attempt!=0) {
			System.out.println("Please Log In. \nYou have "+attempt+" more attempt to log in.");
			System.out.print("User Name: ");
			user_name=sc.nextLine();
			System.out.print("Password: ");
			pass=sc.nextLine();
			user.logIn(user_name, pass);
			if(user.IsLoggedIn) break;
			attempt--;
		}
		//sc.close();
		if(user.IsLoggedIn) index.mainMenu();
	}
	private void mainMenu() {
		Books books_list=new Books();
		//Scanner sc=new Scanner(System.in);
		String chs;  //holds choice letter
		while(user.IsLoggedIn) {
			System.out.println("Choose your Action:");
			System.out.println("To browse book list: 'b' or 'B'\nTo Buy a book: 's' or 'S'\nTo Log Out: 'q' or 'Q'.");
			System.out.print("Enter your Choice: ");
			chs=sc.nextLine();
			if(chs!=null&&chs!="") {
				//chs=sc.nextLine();
				chs.toUpperCase();
				if(chs.equals("B")||chs.equals("b")) {
					//System.out.println(x);
					books_list.browseBooks();
				}
				else if(chs.equals("S")) {
					Calculations cal=new Calculations();
					cal.buyBook(books_list.getBookList(), user, books_list.numberOfBooks());
				}
				else if(chs.equals("Q")) {
					user.IsLoggedIn=false;
				}
				else System.out.println("Wrong entry, Try again.");
				}
		}
	}
	
}
