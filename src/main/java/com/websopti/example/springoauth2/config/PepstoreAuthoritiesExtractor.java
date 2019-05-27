package com.websopti.example.springoauth2.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import com.websopti.example.springoauth2.model.UserLogin;
import com.websopti.example.springoauth2.model.UserRole;

@Component
public class PepstoreAuthoritiesExtractor implements AuthoritiesExtractor {

	@Override
	public List<GrantedAuthority> extractAuthorities(Map<String, Object> map) {
		String email = (String) map.get("email");
		System.out.println("Email ==> "+email);
		
		/*
		 * Here you can autorwire the UserService and call a method findByEmail to get User object from database and return it.
		*/
		
		UserLogin user = new UserLogin();
		user.setEmail(email);
		user.setRole(UserRole.ROLE_ADMIN);
		/*if (user == null) {
			return Collections.<GrantedAuthority>emptyList();
		}*/
		return AuthorityUtils.createAuthorityList(user.getRole().toString());
	}
}
