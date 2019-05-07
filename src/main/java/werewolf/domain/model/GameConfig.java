package werewolf.domain.model;

import java.util.Map;

import lombok.Data;

@Data
public class GameConfig {
	private Map<UserType, Integer> userTypeNumMap;
	private Map<Role, Integer> roleNumMap;	
}
