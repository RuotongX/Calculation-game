package lab4;

import java.util.ArrayList;

public class UserList {
	ArrayList<User> userlist = new ArrayList<User>();
	public void add(User user) {
		userlist.add(user);
	}
	public User[] getuserlist() {
		User[] list = new User[userlist.size()];
		for(int i = 0;i<userlist.size();i++) {
			list[i] = userlist.get(i);
		}
		return list;
	}
	public void remove(int index) {
		userlist.remove(index);
	}
}
