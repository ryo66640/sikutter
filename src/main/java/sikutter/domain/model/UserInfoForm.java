package sikutter.domain.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserInfoForm {

	@NotNull
	private String username;
	
	@NotNull
	@Size(min = 8)
	private String password;
}
