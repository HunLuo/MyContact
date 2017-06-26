package dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import dao.ContactDao;
import model.Contact;
import util.DBConnection;

public class ContactDaoImpl implements ContactDao {
	@Override
	public List<Contact> SelectAll(int uid) {
		List<Contact> contectlist = new ArrayList<Contact>();
		DBConnection db = new DBConnection();
		final String strSQL = "SELECT * FROM contacts WHERE uid=?";
		try {

			ResultSet rs = db.execQuery(strSQL, uid);
			
			while (rs.next()) {
				Contact contact = new Contact();
				
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setSex(rs.getString("sex"));
				contact.setPhone(rs.getString("phone"));
				contact.setTelphone(rs.getString("telphone"));
				contact.setEmail(rs.getString("email"));
				contact.setQq(rs.getString("qq"));
				contact.setCompany(rs.getString("company"));
				contact.setAdress(rs.getString("adress"));
				contact.setGid(rs.getInt("gid"));
				contectlist.add(contact);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return contectlist;
	}
	@Override
	public Contact FindContactByid(int id) {
		DBConnection db = new DBConnection();
		final String strSQL = "SELECT * FROM contacts WHERE id=?";
		try {

			ResultSet rs = db.execQuery(strSQL, id);
			
			if (rs.next()) {
				Contact contact = new Contact();
				
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setSex(rs.getString("sex"));
				contact.setPhone(rs.getString("phone"));
				contact.setTelphone(rs.getString("telphone"));
				contact.setEmail(rs.getString("email"));
				contact.setQq(rs.getString("qq"));
				contact.setCompany(rs.getString("company"));
				contact.setAdress(rs.getString("adress"));
				contact.setGid(rs.getInt("gid"));
				return contact;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
	}
	
	@Override
	public List<Contact> FindContactByname(String name,int uid) {
		List<Contact> contectlist = new ArrayList<Contact>();
		DBConnection db = new DBConnection();
		final String strSQL = "SELECT * FROM contacts where  name like ? AND uid=?";
		try {
			name = "%" + name + "%";
			ResultSet rs = db.execQuery(strSQL, name,uid);
			
			while (rs.next()) {
				Contact contact = new Contact();
				
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setSex(rs.getString("sex"));
				contact.setPhone(rs.getString("phone"));
				contact.setTelphone(rs.getString("telphone"));
				contact.setEmail(rs.getString("email"));
				contact.setQq(rs.getString("qq"));
				contact.setCompany(rs.getString("company"));
				contact.setAdress(rs.getString("adress"));
				contact.setGid(rs.getInt("gid"));
				contact.setUid(rs.getInt("uid"));
				
				contectlist.add(contact);
			}
			return contectlist;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
	}
	
	@Override
	public List<Contact> FindContactBysex(String sex,int uid) {
		List<Contact> contectlist = new ArrayList<Contact>();
		DBConnection db = new DBConnection();
		final String strSQL = "SELECT * FROM contacts where  sex=? AND uid=?";
		try {
			ResultSet rs = db.execQuery(strSQL, sex,uid);
			
			while (rs.next()) {
				Contact contact = new Contact();
				
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setSex(rs.getString("sex"));
				contact.setPhone(rs.getString("phone"));
				contact.setTelphone(rs.getString("telphone"));
				contact.setEmail(rs.getString("email"));
				contact.setQq(rs.getString("qq"));
				contact.setCompany(rs.getString("company"));
				contact.setAdress(rs.getString("adress"));
				contact.setGid(rs.getInt("gid"));
				contact.setUid(rs.getInt("uid"));
				
				contectlist.add(contact);
			}
			return contectlist;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
	}
	
	@Override
	public List<Contact> FindContactBygroup(String gid,int uid) {
		List<Contact> contectlist = new ArrayList<Contact>();
		DBConnection db = new DBConnection();
		final String strSQL = "SELECT * FROM contacts where  gid=? AND uid=?";
		try {
			ResultSet rs = db.execQuery(strSQL, gid,uid);
			
			while (rs.next()) {
				Contact contact = new Contact();
				
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setSex(rs.getString("sex"));
				contact.setPhone(rs.getString("phone"));
				contact.setTelphone(rs.getString("telphone"));
				contact.setEmail(rs.getString("email"));
				contact.setQq(rs.getString("qq"));
				contact.setCompany(rs.getString("company"));
				contact.setAdress(rs.getString("adress"));
				contact.setGid(rs.getInt("gid"));
				contact.setUid(rs.getInt("uid"));
				
				contectlist.add(contact);
			}
			return contectlist;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
	}
	
	
	
	
	@Override
	public Boolean UpdateContact(Contact contact) {
		DBConnection db = new DBConnection();
		int id = contact.getId();
		String name = contact.getName();
		String sex = contact.getSex();
		String phone = contact.getPhone();
		String telphone = contact.getTelphone();
		String email = contact.getEmail();
		String qq = contact.getQq();
		String company = contact.getCompany();
		String adress = contact.getAdress();
		int uid = contact.getUid();
		int gid = contact.getGid();
		final String strSQL = "UPDATE contacts SET name=?,sex=?,phone=?,telphone=?,email=?,qq=?,company=?,adress=?,uid=?,gid=? WHERE id=?";
		int AffectRows= db.execUpdate(strSQL, name,sex,phone,telphone,email,qq,company,adress,uid,gid,id);
		if(AffectRows!=0&&AffectRows!=-1)
			return true;
		else
		return false;
	}
	
	
	
	@Override
	public Boolean AddContect(Contact contact) {
		DBConnection db = new DBConnection();
		String name = contact.getName();
		String sex = contact.getSex();
		String phone = contact.getPhone();
		String telphone = contact.getTelphone();
		String email = contact.getEmail();
		String qq = contact.getQq();
		String company = contact.getCompany();
		String adress = contact.getAdress();
		int uid = contact.getUid();
		int gid = contact.getGid();
		
		
		final String strSQL = "INSERT INTO contacts(name,sex,phone,telphone,email,qq,company,adress,uid,gid) value(?,?,?,?,?,?,?,?,?,?)";
		try {

			int affectRows = db.execUpdate(strSQL, name,sex,phone,telphone,email,qq,company,adress,uid,gid);
			
			if(affectRows!=0&&affectRows!=-1)
				return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return false;
	}
	@Override
	public Boolean DeleteContect(int id) {
		DBConnection db = new DBConnection();
		final String strSQL = "DELETE FROM contacts WHERE id=?";
		int affectRows = db.execUpdate(strSQL,id);
		if(affectRows!=0&&affectRows!=-1)
			return true;
		else
			return false;
	}

}
