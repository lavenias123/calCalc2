package com.stewartlavenia.tally2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stewartlavenia.tally2.entity.Users;

@Controller
public class Tally2Controller {
	
	@Autowired
	private CalCalcDao dao;
	
//	@ResponseBody
	@GetMapping(value = {"/", "index"})
	public String viewUserList(Model model) {
		List<Users> listUsers = dao.list();
		model.addAttribute("listUsers", listUsers);
		return "index";
		//System.out.println("This is from viewUserList method.");
		//return "This is mapping working";
	}
	
	@GetMapping(value= "/newUserAdded.html")
	public String showNewUser(Model model) {
		//Users users = new Users();
		Users user = new Users();
		//Users users = new Users(0, null, null, null, null);
		//Users user = new Users(0, String a, b, c, d);
//	public String showNewUser(Model model, String firstName, String lastName, String email, String phone) {
//		Users user = new Users(0, firstName, lastName, email, phone);
		model.addAttribute("users", user);
		
		return "newUserAdded";
	}
	
	@RequestMapping(value= "/save", method = RequestMethod.POST)
	//@PostMapping(value= "/save")
	public String save(@ModelAttribute("user") Users user) {
		dao.save(user);
		return "redirect:/index";
	}
}
