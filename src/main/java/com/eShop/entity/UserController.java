package com.eShop.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.eShop.repositories.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("user/new")
	public String initUserForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "/user/createOrUpdateForm";
	}
	@PostMapping("user/create")
	public String createUser(@ModelAttribute User user) {
		userRepo.save(user);
		return"redirect:/userProfile/"+user.getId();
	}
	@PostMapping("user/delet/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		userRepo.deleteById(id);
		return"redirect:/";
	}

}
