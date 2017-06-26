package dao;

import java.util.List;

import model.Contact;

public interface ContactDao {


	List<Contact> SelectAll(int uid);

	Boolean AddContect(Contact contect);

	Boolean DeleteContect(int id);

	Contact FindContactByid(int id);

	Boolean UpdateContact(Contact contact);


	List<Contact> FindContactByname(String name, int uid);

	List<Contact> FindContactBysex(String sex, int uid);

	List<Contact> FindContactBygroup(String gid, int uid);



}
