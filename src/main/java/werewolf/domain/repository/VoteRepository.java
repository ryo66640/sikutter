package werewolf.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import werewolf.domain.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long>{

}
