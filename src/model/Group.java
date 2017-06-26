package model;

public class Group {
	private int gid;
	private	String gname;
	private int uid;
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
	public Group() {
		super();
	}
	public Group(String gname, int uid) {
		super();
		this.gname = gname;
		this.uid = uid;
	}
	public Group(int gid, String gname, int uid) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.uid = uid;
	}
	
}
