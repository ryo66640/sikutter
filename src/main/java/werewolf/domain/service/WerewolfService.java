package werewolf.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import werewolf.domain.model.Talk;
import werewolf.domain.model.Vote;
import werewolf.domain.repository.TalkRepository;
import werewolf.domain.repository.VoteRepository;

@Service
@Transactional
public class WerewolfService {

	private final TalkRepository talkRepository;
	private final VoteRepository voteRepository;
	
	@Autowired
	public WerewolfService(TalkRepository talkRepository, VoteRepository voteRepository) {
		this.talkRepository = talkRepository;
		this.voteRepository = voteRepository;
	}
	
	/**
	 * database talksに発言を保存
	 * @param talk
	 */
	public void insert(Talk talk) {
		talkRepository.save(talk);
	}
	
	/**
	 * database votesに投票を保存
	 * @param vote
	 */
	public void insert(Vote vote) {
		voteRepository.save(vote);
	}
	
	
}
