package model;

public class Contact {
	private int id;
	private int gid;
	private int uid;
	
	private String name;
	private String sex;
	private String phone;
	private String telphone;
	private String email;
	private String qq;
	private String company;
	private String adress;
	private String gname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Contact() {
		super();
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Contact(String name, String sex, String phone, String telphone, String email, String qq,
			String company, String adress, int uid,int gid) {
		super();
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.telphone = telphone;
		this.email = email;
		this.qq = qq;
		this.company = company;
		this.adress = adress;
		this.gid = gid;
		this.uid = uid;
	}

	public Contact(int id, String name, String sex, String phone, String telphone, String email, String qq,
			String company, String adress, int uid,int gid) {
		super();
		this.id = id;
		this.gid = gid;
		this.uid = uid;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.telphone = telphone;
		this.email = email;
		this.qq = qq;
		this.company = company;
		this.adress = adress;
	}
}
