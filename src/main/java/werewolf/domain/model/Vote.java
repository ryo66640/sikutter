package werewolf.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import werewolf.domain.model.agent.Agent;

@Data
@Entity
@Table(name = "votes")
public class Vote {
	private long id;
	private int day;
	private Agent subject;
	private Agent target;
}
