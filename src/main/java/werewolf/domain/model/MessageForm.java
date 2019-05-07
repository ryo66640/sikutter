package werewolf.domain.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MessageForm {
	
	@NotNull
	@Size(max = 200)
	private String text;	
}
