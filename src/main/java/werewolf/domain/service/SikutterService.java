package werewolf.domain.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import werewolf.domain.model.Message;
import werewolf.domain.repository.MessageRepository;

@Service
@Transactional
public class SikutterService {
	
	private final MessageRepository messageRepository;

	@Autowired
	public SikutterService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
	
	public void insert(Message message) {
		this.messageRepository.save(message);
	}
	@Transactional(readOnly = true)
	public List<Message> findAllMessages(){
		return this.messageRepository.findAll();
	}
	
	
}
