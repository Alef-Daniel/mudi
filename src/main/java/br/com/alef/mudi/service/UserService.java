package br.com.alef.mudi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alef.mudi.model.User;
import br.com.alef.mudi.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User buscaTodosUsers(String username){
		return userRepository.findByUsername(username);
	}
	
	
	
	
	
	
}
