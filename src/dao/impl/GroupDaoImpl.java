package dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.GroupDao;
import model.Group;
import util.DBConnection;

public class GroupDaoImpl implements GroupDao {
	@Override
	public String GetGroupName(int gid, int uid) {
		DBConnection db = new DBConnection();

		final String strSQL = "SELECT * FROM groups WHERE gid=? AND uid=?";
		String groupname = "";
		try {

			ResultSet rs = db.execQuery(strSQL, gid, uid);

			if (rs.next()) {
				groupname = rs.getString("gname");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return groupname;
	}
	@Override
	public List<Group> GetAllGroup(int uid) {
		
		List<Group> grouplist = new ArrayList<Group>();
		DBConnection db = new DBConnection();
		final String strSQL = "SELECT * FROM groups where uid=?";
		try {

			ResultSet rs = db.execQuery(strSQL,uid);
			
			while (rs.next()) {
				Group group = new Group();
				group.setGid(rs.getInt("gid"));
				group.setGname(rs.getString("gname"));
				group.setUid(rs.getInt("uid"));
				grouplist.add(group);
			}
			return grouplist;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	
	
	
	
	@Override
	public Group FindGroupByid(int gid) {
		DBConnection db = new DBConnection();
		final String strSQL = "SELECT * FROM groups WHERE gid=?";
		try {

			ResultSet rs = db.execQuery(strSQL, gid);
			Group group = new Group();
			if (rs.next()) {
				
				group.setGid(rs.getInt("gid"));
				group.setGname(rs.getString("gname"));
				group.setUid(rs.getInt("uid"));
		
				
			}
			return group;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
	}
	
	
	
	
	
	@Override
	public Boolean UpdateGroup(Group group) {
		DBConnection db = new DBConnection();
		int gid = group.getGid();
		String gname = group.getGname();
		int uid = group.getUid();
		final String strSQL = "UPDATE groups SET gname=? WHERE gid=? AND uid=?";
		int AffectRows= db.execUpdate(strSQL,gname ,gid,uid);
		if(AffectRows!=0&&AffectRows!=-1)
			return true;
		else
		return false;
	}
	
	
	@Override
	public Boolean AddGroup(String gname,int uid) {
		DBConnection db = new DBConnection();
		
		
		final String strSQL = "INSERT INTO groups(gname,uid) value(?,?)";
		try {

			int affectRows = db.execUpdate(strSQL,gname,uid);
			
			if(affectRows!=0&&affectRows!=-1)
				return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return false;
	}
	@Override
	public Boolean DeleteGroup(int gid) {
		DBConnection db = new DBConnection();
		final String strSQL = "DELETE FROM groups WHERE gid=?";
		int affectRows = db.execUpdate(strSQL,gid);
		if(affectRows!=0&&affectRows!=-1)
			return true;
		else
			return false;
	}

	
	
}
