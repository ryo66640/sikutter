package werewolf.app.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import werewolf.domain.model.Message;
import werewolf.domain.model.MessageForm;
import werewolf.domain.service.SikutterService;

@Controller
public class SikutterController {
	
	private final SikutterService service;
	
	@Autowired
	public SikutterController(SikutterService service) {
		this.service = service;
	}
		
	@ModelAttribute
	public MessageForm setupMessageForm() {
		return new MessageForm();
	}
	
	@GetMapping("/sikutter")
	public String sikutter() {
		return "/sikutter";
	}
	
	@PostMapping("/sikutter")
	public String talk(@Validated MessageForm form, BindingResult result, Model model, Principal principal) {
		if(result.hasErrors()) {
			return "/error";
		}
		Message message = new Message();
		message.setText(form.getText());
		message.setTalker(principal.getName());

		service.insert(message);
		List<Message> messages = service.findAllMessages();
		model.addAttribute("messages", messages);
		return "/messagelist";
	}	
}
