package org.rafshun.contact.service;

import java.util.List;
import org.rafshun.contact.model.Contact;

public interface ContactService {
	
	public boolean saveContact(Contact save);
	public List<Contact> getAllContact();
	public Contact getContactById(Integer gid);
	public boolean deleteContactbyId(Integer did);

}
