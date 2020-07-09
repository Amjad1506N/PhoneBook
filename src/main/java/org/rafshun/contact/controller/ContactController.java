package org.rafshun.contact.controller;


import java.util.List;

import org.rafshun.contact.model.Contact;
import org.rafshun.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class ContactController {
	
	@Autowired
	private ContactService service;
	@GetMapping(value = { "/", "addContact" })
	public String handleForm(Model model) {
		Contact c = new Contact();
		model.addAttribute("contact", c);
		return "contact_form";
	}

	@PostMapping(value = "/saveContact")
	public String handleSubmitButton(@ModelAttribute("contact") Contact c, RedirectAttributes att) {

		boolean isSaved = service.saveContact(c);

		if (isSaved) { 
			//model.addAttribute("successMsg", "Contact Saved");
			att.addFlashAttribute("successMsg", "Contact Saved");
		}else {
			//model.addAttribute("errorMsg", "Contact not Saved");
			att.addFlashAttribute("errorMsg", "Contact not Saved");
		}
		return "redirect:/userSuccess";
	}
	
	@GetMapping("/userSuccess")
	public String userSucess(Model model) {
		Contact c = new Contact();
		model.addAttribute("contact", c);
		return "contact_form";
	}
	
	@GetMapping("/viewContacts")
	public String viewAllContacts(Model model) {
		List<Contact> con=service.getAllContact();
		model.addAttribute("contacts",con);
		return "view_contacts";
	}
	
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
	
     

}
