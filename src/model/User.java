package model;

public class User {
	private int uid;
	private String username;
	private String userpwd;
	private String nickname;

	public User() {
		super();
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public User(String username, String userpwd) {
		super();
		this.username = username;
		this.userpwd = userpwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public User(String username, String userpwd, String nickname) {
		super();
		this.username = username;
		this.userpwd = userpwd;
		this.nickname = nickname;
	}

	public User(int uid, String username, String userpwd, String nickname) {
		super();
		this.uid = uid;
		this.username = username;
		this.userpwd = userpwd;
		this.nickname = nickname;
	}

}
