package dao;

import model.User;

public interface UserDao {


	User getUser(String loginname, String loginpwd);

	boolean setUser(User user);

	boolean isUserExist(String loginname);

	boolean changePassword(int uid, String newpassword);

	User getUserById(int uid);
		
	

	
}
