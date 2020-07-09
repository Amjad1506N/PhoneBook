package org.rafshun.contact.repo;

import java.io.Serializable;

import org.rafshun.contact.entity.ContactEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<ContactEntity,Serializable> {



}
