package werewolf.domain.model;

import lombok.Data;

@Data
public class Talk {
	private String talker;
	private TalkType talkType;
	private String targetName;
	private Role role;
	private Judge result;

}
