package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilties.results.Result;
import kodlamaio.hrms.entities.dtos.RegisterForEmployerAuthDto;
import kodlamaio.hrms.entities.dtos.RegisterForJobSeekerAuthDto;

public interface AuthService {

	Result registerForJobSeeker(RegisterForJobSeekerAuthDto registerForJobSeekerAuthDto);

	Result registerForEmployer(RegisterForEmployerAuthDto registerForEmployerAuthDto);
}
