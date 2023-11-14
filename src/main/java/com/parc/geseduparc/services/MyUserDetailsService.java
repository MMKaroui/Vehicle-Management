package com.parc.geseduparc.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.parc.geseduparc.repositories.UserRepository;
import com.parc.geseduparc.entities.User;
@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
 

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional <User> user = userRepository.findByLogin(login);
				user.orElseThrow(() -> new UsernameNotFoundException("User Not Found with login: " + login));

		return user.map(MyUserDetails::new).get();
	}


}
