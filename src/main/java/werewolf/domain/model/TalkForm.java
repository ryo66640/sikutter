package werewolf.domain.model;

import lombok.Data;

@Data
public class TalkForm {
	private TalkType talkType;
	private String targetName;
	private Role role;
}
