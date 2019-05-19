package werewolf.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "votes")
public class Vote {
	@Id
	private long id;
	private int day;
	private String subject;
	private String target;
}
