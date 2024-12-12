package com.demo.bootmysqlcrud.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.bootmysqlcrud.entity.DAOUser;
import com.demo.bootmysqlcrud.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("in looadByUser");
		
		DAOUser daoUser = userRepository.findByUsername(username);
		if (daoUser == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new org.springframework.security.core.userdetails.User(daoUser.getUsername(), daoUser.getPassword(),
				new ArrayList<>());
	}

}