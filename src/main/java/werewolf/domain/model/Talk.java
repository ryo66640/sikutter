package werewolf.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "talks")
public class Talk {
	@Id
	private long id;
	
	private int day;
	
	private String talker;

	@Enumerated(EnumType.STRING)
	private TalkType talkType;

	private String targetName;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Enumerated(EnumType.STRING)
	private Judge result;
}
