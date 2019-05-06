package sikutter.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sikutter.domain.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
	

}
