package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilties.results.DataResult;
import kodlamaio.hrms.core.utilties.results.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface UserService {

	Result add(User user);
	
	DataResult<List<User>> getAll();
	
	DataResult<User> getByEmail(String email);
	
    Result checkUserExistsByEmail(String email);
}
