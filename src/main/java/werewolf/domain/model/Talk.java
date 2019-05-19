package werewolf.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "talks")
public class Talk {
	private long id;
	private int day;
	private String talker;
	private TalkType talkType;
	private String targetName;
	private Role role;
	private Judge result;
}
