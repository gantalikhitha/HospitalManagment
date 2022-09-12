package com.project.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.demo.Entity.UserEntity;
import com.project.demo.Repository.HospitalRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
    private HospitalRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity user = repo.findByemail(email);

        if (user==null) 
          {
           throw new UsernameNotFoundException("could not found user !!");
          }
        
           CustomUserDetails customUserDetails = new CustomUserDetails(user);
           return customUserDetails;
    }
	}
	
	
	


