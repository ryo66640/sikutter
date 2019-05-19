package werewolf.domain.model.agent;

import werewolf.domain.model.Role;
import werewolf.domain.model.Status;
import werewolf.domain.model.Talk;
import werewolf.domain.model.Vote;

public abstract class Agent {
	protected String name;
	protected Role role;
	protected Status status;
	
	public Agent(String name, Role role) {
		this.name = name;
		this.role = role;
		this.status = Status.ALIVE;
	}
	
	
	public abstract Talk buildTalk(Talk talk);
	public abstract Vote buildVote(Vote vote);
}
