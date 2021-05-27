package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;

import kodlamaio.hrms.core.utilties.results.Result;

import kodlamaio.hrms.entities.dtos.LoginUserAuthDto;
import kodlamaio.hrms.entities.dtos.RegisterForEmployerAuthDto;
import kodlamaio.hrms.entities.dtos.RegisterForJobSeekerAuthDto;

@Service
public class AuthManager implements AuthService {

	@Override
	public Result login(LoginUserAuthDto loginUserDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result registerForEmployer(RegisterForEmployerAuthDto registerForEmployerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result registerForCandidate(RegisterForJobSeekerAuthDto registerForEmployerDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
