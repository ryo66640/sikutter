package werewolf.app.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import werewolf.domain.model.GameConfig;
import werewolf.domain.model.GameConfigForm;
import werewolf.domain.model.Message;
import werewolf.domain.model.MessageForm;
import werewolf.domain.model.Role;
import werewolf.domain.model.Talk;
import werewolf.domain.model.TalkForm;
import werewolf.domain.model.UserType;
import werewolf.domain.service.SikutterService;

@Controller
public class WerewolfController {
	
	private final SikutterService service;
	
	@Autowired
	public WerewolfController(SikutterService service) {
		this.service = service;
	}
		
	@ModelAttribute
	public TalkForm setupTalkForm() {
		return new TalkForm();
	}
	
	@ModelAttribute
	public GameConfigForm setupGameInfoForm() {
		return new GameConfigForm();
	}
	
	@GetMapping("/game-config")
	public String gameConfig() {
		return "/game-config";
	}
	
	@PostMapping("/game")
	public String game(@Validated GameConfigForm form, BindingResult result, Model model) {
		
		Map<UserType, Integer> userTypeNumMap = new HashMap<UserType, Integer>();
		userTypeNumMap.put(UserType.PLAYER, form.getPlayerNum());
		userTypeNumMap.put(UserType.COMPUTER, form.getComputerNum());

		Map<Role, Integer> roleNumMap = new HashMap<Role, Integer>();
		roleNumMap.put(Role.VILLAGER, form.getVillager());
		roleNumMap.put(Role.SEER, form.getSeer());
		roleNumMap.put(Role.WEREWOLF, form.getWerewolf());

		GameConfig gameInfo = new GameConfig();
		gameInfo.setUserTypeNumMap(userTypeNumMap);
		gameInfo.setRoleNumMap(roleNumMap);
		
		//TODO:この辺でgameinfoをサーバ側に渡して設定を保持させたい
		System.out.println(gameInfo.getRoleNumMap());
		System.out.println(gameInfo.getUserTypeNumMap());
		
		return "/game";
	}
	
	@GetMapping("/sikutter")
	public String sikutter() {
		return "/sikutter";
	}
	
	@PostMapping("/talk")
	public void talk(@Validated TalkForm form, BindingResult result, Model model, Principal principal) {
		Talk talk = new Talk();
		
		//TODO:この辺でサーバ側に発言を処理させたい
		//戻り値ないんだけどこの時model返しても意味ないのでは？
		
	}	
}
