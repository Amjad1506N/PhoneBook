/*package org.rafshun.contact.controller;

import org.rafshun.contact.model.Contact;
import org.rafshun.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
	
	@Autowired
	private ContactService service;
	
	@RequestMapping("/editContact")
	public String editContact(@RequestParam("cid")Integer contactId,Model model) {
		Contact c=service.getContactById(contactId);
		model.addAttribute("contact",c);
		return "contact_form";
	}
	
	@RequestMapping("/deleteContact")
	public String deleteContactRecord(@RequestParam("cid")Integer id) {
		boolean isDeleted=service.deleteContactbyId(id);
		if(isDeleted) {
			return "redirect:/viewContacts";
		}
		return null;
	}

}*/
