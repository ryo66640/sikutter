package werewolf.domain.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import werewolf.domain.model.User;
import werewolf.domain.model.UserAccount;
import werewolf.domain.repository.UserRepository;

@Service
@Transactional
public class UserAccountService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username == "null" || "".equals(username)) {
			throw new UsernameNotFoundException("Username is empty.");
		}
		
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Username " + username + " is not found.");
		}
		
		UserAccount userAccount = new UserAccount(user, getAuthorities(user));
		return userAccount;
	}
	
	private Collection<GrantedAuthority> getAuthorities(User user){
		if(user.isAdmin()) {
			return AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");
		}
		else {
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}
	}
	
	public void registerAdmin(String username, String password) {
		User user = new User(username, passwordEncoder.encode(password), true);
		userRepository.save(user);
	}
	
	public void registerUser(String username, String password) {
		User user = new User(username, passwordEncoder.encode(password), false);
		userRepository.save(user);
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
}
