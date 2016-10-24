package fr.wd.kata.rs.controller;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

	

	@SuppressWarnings("unused")
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		// on cherche l'utilisateur via son login
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ADMIN"));

		User user = new User("TATA", "TATA", authorities);
		// trouvé ?;
		//if (user == null) {
		if (!user.getUsername().equalsIgnoreCase(login)) {
			throw new UsernameNotFoundException(String.format("login [%s] inexistant", login));
		}
		// on rend les détails de l'utilsateur
		return new AppUserDetails(user);
	}
	
	
}
