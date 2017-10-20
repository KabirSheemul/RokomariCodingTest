/*
 * This class is for maintain Userinfo 
 */

package Rokomari.test1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Users {
	private String[][] users=new String[100][3];
	private int user_ttl;
	public boolean IsLoggedIn=false;
	private String user_name;
	private int balance;
	private int user_index;
	//private ArrayList<String[]> user
	Users() {
		this.readUserFile();
	}
	private void readUserFile() {
		try {
			//System.out.println("into the method");
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
						//System.out.print(users[count][flag-1]+" "+flag);
					}
				}
				//System.out.println("");
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
			if(user_name.equals(users[i][0])&&pass.equals(users[i][1])) {
				this.IsLoggedIn=true;
				this.user_name=user_name;
				this.user_index=i;
				this.balance=Integer.parseInt(users[i][2]);
				return true;
			}
		}
		return false;
	}
	public String getUserName() {
		return this.user_name;
	}
	public int numberOfUsers() {
		return this.user_ttl;
	}
	public int getBalance() {
		return this.balance;
	}
	public void updateUserFile(int price) {
		this.balance-=price;
		users[user_index][2]=Integer.toString(this.balance);
		try {
			File new_user=new File("resource//newfile.txt");
			FileOutputStream fos=new FileOutputStream(new_user);
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fos));
			for(int i=0;i<this.user_ttl;i++) {
				String line= users[i][0]+"  "+users[i][1]+"  "+users[i][2];
				bw.write(line);
				bw.newLine();
			}
			bw.close();
			
			//deleting and renaming file name;
			File old=new File("resource//users.txt");
			old.delete();
			new_user.renameTo(old);
		}
		catch(IOException e) {
			
		}
	}
	public static void main(String a[]) {
		Users user=new Users();
		//user.readUserFile();
		if(user.logIn("james", "java")) System.out.println("logged in");
	}

}
