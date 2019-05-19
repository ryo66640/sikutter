package werewolf.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import werewolf.domain.model.Talk;

@Repository
public interface TalkRepository extends JpaRepository<Talk, Long>{
	
}
