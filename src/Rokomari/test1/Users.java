package Rokomari.test1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Users {
	private String[][] users=new String[100][3];
	private int user_ttl;
	//private ArrayList<String[]> user
	Users() {
		this.readUserFile();
	}
	private void readUserFile() {
		try {
			System.out.println("into the method");
			File user_file=new File("resource//users.txt");
			Scanner sc=new Scanner(user_file);
			String line;
			int count=0;
			while(sc.hasNext()) {
				line=sc.nextLine();
				StringTokenizer st=new StringTokenizer(line," ");
				int flag=0;
				String str;
				while(st.hasMoreTokens()) {
					str=st.nextToken();
					str=str.trim();
					if(str!=null&&str!="") {
						users[count][flag++]=str;
						System.out.print(users[count][flag-1]+" "+flag);
					}
				}
				System.out.println("");
				count++;
			}
			user_ttl=count;
			sc.close();
		}
		catch(IOException e) {
			
		}
	}
	public boolean logIn(String user_name, String pass) {
		for(int i=0;i<this.user_ttl;i++) {
			if(user_name.equals(users[i][0])&&pass.equals(users[i][1])) return true;
		}
		return false;
	}
	public static void main(String a[]) {
		Users user=new Users();
		//user.readUserFile();
		if(user.logIn("james", "java")) System.out.println("logged in");
	}

}
