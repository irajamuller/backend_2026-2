package br.edu.unisinos.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unisinos.store.dto.LoginRequestDto;
import br.edu.unisinos.store.model.UserInfo;
import br.edu.unisinos.store.service.JwtService;
import br.edu.unisinos.store.service.UserInfoService;

@RestController
@RequestMapping("/usuario")
public class UserController {

	@Autowired
	private UserInfoService userInfoService;
	@Autowired
    private JwtService jwtService;
	@Autowired
    private AuthenticationManager authenticationManager;
    
	@PostMapping
	public UserInfo save(@RequestBody UserInfo userInfo) {
		return userInfoService.save(userInfo);
	}
	
	@PostMapping("/login")
	// DTO (Data Transfer Object)
    public String authenticateAndGetToken(@RequestBody LoginRequestDto loginRequestDto) {
		// Pode ser colocado na service
		try {
			Authentication authentication = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
	        );
            return jwtService.generateToken(loginRequestDto.getUsername());
        } catch (AuthenticationException e) {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }	
}
