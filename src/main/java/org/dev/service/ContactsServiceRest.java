package org.dev.service;

import java.util.List;

import javax.websocket.server.PathParam;

import org.dev.dao.ContactRepository;
import org.dev.entites.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ContactsServiceRest {
	@Autowired
	ContactRepository contactRepository ;
	@RequestMapping(value="/tousContacts",method=RequestMethod.GET)
	public List<Contacts> getAllContacts(){
		return contactRepository.findAll() ;
	}
	@RequestMapping(value="/contact/{cin}", method=RequestMethod.GET)
	public Contacts getContact (@PathVariable(value="cin") long cin ){
		return contactRepository.findOne(cin);
	}
	@RequestMapping(value="/DeleteContacts/{cin}",method=RequestMethod.DELETE)
	public boolean deleteContact(@PathVariable(value="cin")long cin){
		contactRepository.delete(cin);
		return true;
	}
	@RequestMapping(value="/editContact/{cin}" ,method=RequestMethod.PUT)
	public Contacts updateContacts(@PathVariable long cin,@RequestBody Contacts c){
		c.setCin(cin);
		
		return contactRepository.save(c) ;
	}
	@RequestMapping(value="/contacts",method=RequestMethod.POST)
	public boolean ajouterContacts (@RequestBody Contacts c){
		contactRepository.save(c);
		return true ;
	}
	@RequestMapping(value="/chercher" ,method=RequestMethod.GET)
	public Page<Contacts> chercherContact(
			@RequestParam(name="mc" ,defaultValue="")String mc , 
			@RequestParam(name="page",defaultValue="0")int page ,
			@RequestParam(name="size",defaultValue="10")int size ){
		return contactRepository.chercherContact("%"+mc+"%", new PageRequest(page,size));
	}
}
