package werewolf.domain.model.agent;

import werewolf.domain.model.Role;
import werewolf.domain.model.Talk;
import werewolf.domain.model.Vote;

public class Villager extends Agent{

	public Villager(String name, Role role) {
		super(name, role);
	}

	@Override
	public Talk buildTalk(Talk talk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vote buildVote(Vote vote) {
		// TODO Auto-generated method stub
		return null;
	}

}
