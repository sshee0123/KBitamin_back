package com.kb1.springbootback.security.services;

import com.kb1.springbootback.model.user.User;
import com.kb1.springbootback.repository.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with id: " + id));

		return UserDetailsImpl.build(user);
	}

}