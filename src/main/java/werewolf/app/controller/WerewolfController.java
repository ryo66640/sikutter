package werewolf.app.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import werewolf.domain.model.Role;
import werewolf.domain.model.Talk;
import werewolf.domain.model.TalkForm;
import werewolf.domain.model.UserType;
import werewolf.domain.model.agent.Villager;
import werewolf.domain.model.config.GameConfig;
import werewolf.domain.model.config.GameConfigForm;
import werewolf.domain.model.config.GameInfo;
import werewolf.domain.service.WerewolfService;

@Controller
public class WerewolfController {
	
	private final WerewolfService service;
	private final GameConfig gameConfig;
	private final GameInfo gameInfo;
	
	@Autowired
	public WerewolfController(WerewolfService service, GameConfig gameConfig, GameInfo gameInfo) {
		this.service = service;
		this.gameConfig = gameConfig;
		this.gameInfo = gameInfo;
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

		gameConfig.setUserTypeNumMap(userTypeNumMap);
		gameConfig.setRoleNumMap(roleNumMap);
				
		//TODO:この辺でgameinfoをサーバ側に渡して設定を保持させたい
		
		
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
