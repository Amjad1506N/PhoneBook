package org.rafshun.contact.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.rafshun.contact.entity.ContactEntity;
import org.rafshun.contact.model.Contact;
import org.rafshun.contact.repo.ContactRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepo repos;

	@Override
	public boolean saveContact(Contact saves) {
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(saves, entity);
		ContactEntity saveEntity = repos.save(entity);
		return saveEntity.getContactId()!= null;
		
	}

	@Override
	public List<Contact> getAllContact() {
		List<ContactEntity> cEntity = repos.findAll();
		return cEntity.stream().map(entities -> {
			Contact con = new Contact();
			BeanUtils.copyProperties(entities, con);
			return con;
		}).collect(Collectors.toList());

	}

	@Override
	public Contact getContactById(Integer gid) {
		Optional<ContactEntity> findById=repos.findById(gid);
		if(findById.isPresent()) {
			ContactEntity entity=findById.get();
			Contact c = new Contact();
			BeanUtils.copyProperties(entity,c);
			return c;
		}
		return null;
	}

	@Override
	public boolean deleteContactbyId(Integer did) {
		repos.deleteById(did);
		return true;
	}
}
