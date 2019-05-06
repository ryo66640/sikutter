package sikutter.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sikutter.domain.model.User;
import sikutter.domain.model.UserInfoForm;
import sikutter.domain.service.UserAccountService;

@Controller
public class LoginController {

	private final UserAccountService service;
	
	@Autowired
	public LoginController(UserAccountService service) {
		this.service = service;
	}
	
	@ModelAttribute
	public UserInfoForm setupUserInfoForm() {
		return new UserInfoForm();
	}
	
	@GetMapping("/login")
	public String initLoginForm() {
		return "/login";
	}
	
	@GetMapping("/login-error")
	public String login() {
		return "/error";
	}
	
	@GetMapping("/new")
	public String createAccount() {
		return "/new";
	}
	
	@PostMapping("/new")
	public String registerAccount(@Validated UserInfoForm form, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "/error";
		}
		String username = form.getUsername();
		String rawPassword = form.getPassword();
		service.registerUser(username, rawPassword);
		model.addAttribute("username", username);
		model.addAttribute("password", rawPassword);
		return "/result";
	}

	@GetMapping("/userlist")
	public String showUserList(Model model) {
		List<User> users = service.findAll();
		model.addAttribute("users", users);
		return "/userlist";
	}


	
}
