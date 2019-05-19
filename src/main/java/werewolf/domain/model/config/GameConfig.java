package werewolf.domain.model.config;

import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Data;
import werewolf.domain.model.Role;
import werewolf.domain.model.UserType;

@Data
@Component
public class GameConfig {
	private Map<UserType, Integer> userTypeNumMap;
	private Map<Role, Integer> roleNumMap;	
}
