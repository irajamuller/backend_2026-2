package br.edu.unisinos.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.unisinos.store.core.UserInfoDetails;
import br.edu.unisinos.store.model.UserInfo;
import br.edu.unisinos.store.repository.UserInfoRepository;

@Service
public class UserInfoService implements UserDetailsService {
	@Autowired
	private UserInfoRepository repository;
	
	@Autowired
	@Lazy
    private PasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		    UserInfo user = repository.findByEmail(username)
		            .orElseThrow(() ->
		                    new UsernameNotFoundException(
		                            "User not found with email: " + username));

		    return new UserInfoDetails(user);
	}

    public UserInfo save(UserInfo userInfo) {
        // Encrypt senha antes de salvar
        userInfo.setPassword(encoder.encode(userInfo.getPassword())); 
        return repository.save(userInfo);
    }
}
