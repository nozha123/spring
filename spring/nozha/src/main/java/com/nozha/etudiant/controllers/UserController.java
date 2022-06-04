package com.nozha.etudiant.controllers;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import com.nozha.etudiant.entities.User;
import com.nozha.etudiant.security.SecurityConfig;
import com.nozha.etudiant.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	
	
	@RequestMapping("/showCreate2")
	public String showCreate(ModelMap modelMap) {
				
		User use = new User();
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("user", use);
		return "formUser";
	}
	
	

	
	
	@RequestMapping("/ListeUsers")
	public String listeUsers(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<User> use = userService.getAllUsersParPage(page, size);
		
		
		modelMap.addAttribute("users", use);
		modelMap.addAttribute("pages", new int[use.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeUsers";
	}
	
	
	@RequestMapping("/saveUser")
	public String saveUser(@Valid User user,
			 BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors()) return "formUser";
		SecurityConfig sec = new SecurityConfig();
		PasswordEncoder passwordEncoder = sec.passwordEncoder();
      	user.setPassword(passwordEncoder.encode("123"));
     	user.setEnabled(true);

    
		userService.saveUser(user);
	 return "redirect:/ListeUsers";
	}
	
	@RequestMapping("/supprimerUser")
	public String supprimerUser(@RequestParam("id") Long id, ModelMap modelMap,

		@RequestParam(name = "page", defaultValue = "0") int page,
		@RequestParam(name = "size", defaultValue = "2") int size) {

		userService.deleteUserById(id);
		Page<User> use = userService.getAllUsersParPage(page,
				size);
		modelMap.addAttribute("users", use);
		modelMap.addAttribute("pages", new int[use.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeUsers";
	}
	
	
	@RequestMapping("/modifierUser")
	public String editerUser(@RequestParam("id") Long id, ModelMap modelMap) {
		
		User u = userService.getUser(id);
		modelMap.addAttribute("user", u);
		modelMap.addAttribute("mode", "edit");


		return "formUser";
	}

	@RequestMapping("/updateUser")
	public String updateUser(@ModelAttribute("user") User user, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		SecurityConfig sec = new SecurityConfig();
		 PasswordEncoder passwordEncoder = sec.passwordEncoder();
     	user.setPassword(passwordEncoder.encode("123"));
     	user.setEnabled(true);
		userService.updateUser(user);
		List<User> use = userService.findAll();
		modelMap.addAttribute("users", use);
		return "listeUsers";
	}
	
	
	 
	
	


}
