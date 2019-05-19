package werewolf.domain.model.config;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Data;
import werewolf.domain.model.Role;
import werewolf.domain.model.Status;
import werewolf.domain.model.User;
import werewolf.domain.model.UserType;
import werewolf.domain.model.agent.Agent;

/**
 * ゲームの情報を保存するためのクラス
 * @author ryo
 *
 */
@Data
@Component
public class GameInfo {
	private int day;
	
	private List<Agent> allAgentList;
	private List<Agent> aliveAgentList;
	private List<Agent> killedAgentList;
	private List<Agent> executedAgentList;
	private List<Agent> werewolfAgentList;
	
	private Map<Agent, Role> agentRoleMap; 
	private Map<Agent, Status> agentStatusMap;

	private Map<User, UserType> userTypeMap;
	

}
