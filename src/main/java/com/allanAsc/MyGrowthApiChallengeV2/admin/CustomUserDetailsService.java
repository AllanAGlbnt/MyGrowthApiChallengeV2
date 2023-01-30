package com.allanAsc.MyGrowthApiChallengeV2.admin;

import com.allanAsc.MyGrowthApiChallengeV2.user.User;
import com.allanAsc.MyGrowthApiChallengeV2.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
	@Autowired private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("No user found with the given username");
		}
		
		return new CustomUserDetails(user);
	}

}
