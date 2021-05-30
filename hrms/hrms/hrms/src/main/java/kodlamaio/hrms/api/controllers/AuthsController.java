package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilties.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.RegisterForEmployerAuthDto;
import kodlamaio.hrms.entities.dtos.RegisterForJobSeekerAuthDto;

@RestController
@RequestMapping("/api/auths")
public class AuthsController {

	private AuthService authService;

	@Autowired
	public AuthsController(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/registerJobseeker")
	public Result registerJobseeker(@RequestBody RegisterForJobSeekerAuthDto registerForJobSeekerAuthDto )
	{
		return this.authService.registerForJobSeeker(registerForJobSeekerAuthDto);
	}
	
	@PostMapping("/registerEmployer")
	public Result registerEmployer(@RequestBody RegisterForEmployerAuthDto registerForEmployerAuthDto )
	{
		return this.authService.registerForEmployer(registerForEmployerAuthDto);
	}
}
