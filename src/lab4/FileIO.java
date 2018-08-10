package lab4;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIO {
	static UserList ul = new UserList();
	public static void loaduserdata(UserList userlist){
		try {
			Scanner fileScan = new Scanner(new File("txtdata/userdata.txt"));
			String name;
		    int score = 0;
		    
		    int limit = fileScan.nextInt();
		    for(int i = 0;i<limit;i++) {
		    	
		    	User user = new User();
				fileScan.nextLine();
				name =fileScan.nextLine();
				score = fileScan.nextInt();
				user.setName(name);
				user.setScore(score);
				userlist.add(user);
				
			}
		    fileScan.close();
		} catch(Exception e) {
			System.out.println("fuck you");
		}
	}
	public static void saveuserdata(UserList userlist) {
		try{
			PrintWriter fileWriter = new PrintWriter(new File("txtdata/userdata.txt"));
			int num = userlist.getuserlist().length;
			System.out.println(num);
			fileWriter.println(num);
			for(int i =0;i<num;i++) {
				fileWriter.println(userlist.getuserlist()[i].getName());
				fileWriter.println(userlist.getuserlist()[i].getScore());
			}
			fileWriter.close();
		}catch(Exception e) {
			
		}
	}
}
