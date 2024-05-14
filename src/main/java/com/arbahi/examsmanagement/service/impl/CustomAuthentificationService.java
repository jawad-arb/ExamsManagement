package com.arbahi.examsmanagement.service.impl;


import com.arbahi.examsmanagement.entity.User;
import com.arbahi.examsmanagement.repository.UsersRepository;
import com.arbahi.examsmanagement.utils.CustomUserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomAuthentificationService implements UserDetailsService {

	@Autowired
	private UsersRepository userRepository;

	Logger LOGGER = LoggerFactory.getLogger(getClass());

	public CustomAuthentificationService() {
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);

		if (user == null) {
			LOGGER.warn("User with email " + email + " not found");
			throw new UsernameNotFoundException("User with email " + email + " not found");
		}

		return new CustomUserPrincipal(user);
	}

}