package werewolf.domain.model.config;

import lombok.Data;

@Data
public class GameConfigForm {
	
	private int playerNum;
	private int computerNum;

	private int villager;
	private int seer;
	private int werewolf;
}
