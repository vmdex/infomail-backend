package com.infopulse.infomail.controllers.rest;

import com.infopulse.infomail.dto.securityRequests.RegistrationRequest;
import com.infopulse.infomail.services.registration.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/registration")
public class RegistrationController {

	private final RegistrationService registrationService;

	@PostMapping
	public ResponseEntity<?> register(@Valid @RequestBody RegistrationRequest request) {
		try {
			registrationService.register(request);
			return ResponseEntity.ok().build();
		} catch (Exception ex) {
			log.error(ex.getMessage());
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	// security test controller
	@GetMapping(path = "sayHi")
	public String sayHi(Authentication authentication) {
		if (authentication != null)
			return "hi " + authentication.getPrincipal();
		else return "hi anonymous";
	}

	@GetMapping(path = "confirm")
	public ResponseEntity<?> confirm(@RequestParam("token") String token) {
		try {
			registrationService.confirmToken(token);
			return ResponseEntity.ok().build();
		} catch (Exception ex) {
			log.error(ex.getMessage());
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@GetMapping(path = "reject")
	public ResponseEntity<?> reject(@RequestParam("token") String token) {
		try {
			registrationService.rejectToken(token);
			return ResponseEntity.ok().build();
		} catch (Exception ex) {
			log.error(ex.getMessage());
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

}
