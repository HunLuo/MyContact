package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserDao;
import model.User;
import util.DBConnection;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUser(String loginname, String loginpwd) {

		DBConnection db = new DBConnection();

		final String strSQL = "select * from user where username=? and userpwd=?";
		try {

			ResultSet rs = db.execQuery(strSQL, loginname, loginpwd);
			if (rs.next()) {
				User user = new User(rs.getInt("uid"), loginname, loginpwd, rs.getString("nickname"));
				return user;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	@Override
	public User getUserById(int uid) {

		DBConnection db = new DBConnection();

		final String strSQL = "select * from user where uid=?";
		try {

			ResultSet rs = db.execQuery(strSQL, uid);
			if (rs.next()) {
				User user = new User(rs.getInt("uid"), rs.getString("username"), rs.getString("userpwd"), rs.getString("nickname"));
				return user;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public boolean isUserExist(String loginname) {

		DBConnection db = new DBConnection();

		String strSQL = "select * from user where username=?";
		try {

			ResultSet rs = db.execQuery(strSQL, loginname);
			if (rs.next()) {

				return true;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean setUser(User user) {
		String nickname = user.getNickname();
		String name = user.getUsername();
		String password = user.getUserpwd();
		String strSQL = "INSERT INTO user(username,userpwd,nickname) value(?,?,?)";
		DBConnection db = new DBConnection();
		int affectRow = db.execUpdate(strSQL, name, password, nickname);
		if (affectRow != 0 && affectRow != -1)
			return true;
		else
			return false;
	}
	@Override
	public boolean changePassword(int uid,String newpassword) {
		final String strSQL = "UPDATE user SET userpwd=? WHERE uid=?";
		DBConnection db = new DBConnection();
		int affectRow = db.execUpdate(strSQL,newpassword,uid);
		if (affectRow != 0 && affectRow != -1)
			return true;
		else
		
		return false;
		
	}

}
