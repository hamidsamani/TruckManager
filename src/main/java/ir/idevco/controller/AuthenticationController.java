package ir.idevco.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
	@RequestMapping(value = "/security/current", method = RequestMethod.GET)
	public ResponseEntity<User> currentUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
