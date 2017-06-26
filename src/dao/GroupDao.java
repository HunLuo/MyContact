package dao;

import java.util.List;

import model.Group;

public interface GroupDao {

	String GetGroupName(int gid, int uid);


	List<Group> GetAllGroup(int uid);


	Boolean UpdateGroup(Group group);


	Boolean AddGroup(String gname,int uid);


	Group FindGroupByid(int gid);


	Boolean DeleteGroup(int gid);

}
