package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilties.results.Result;
import kodlamaio.hrms.entities.dtos.LoginUserAuthDto;
import kodlamaio.hrms.entities.dtos.RegisterForEmployerAuthDto;
import kodlamaio.hrms.entities.dtos.RegisterForJobSeekerAuthDto;

public interface AuthService {

    Result login(LoginUserAuthDto loginUserDto);
    Result registerForEmployer(RegisterForEmployerAuthDto registerForEmployerDto);
    Result registerForCandidate(RegisterForJobSeekerAuthDto registerForEmployerDto);
}
