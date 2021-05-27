package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilties.results.DataResult;
import kodlamaio.hrms.core.utilties.results.ErrorResult;
import kodlamaio.hrms.core.utilties.results.Result;
import kodlamaio.hrms.core.utilties.results.SuccessDataResult;
import kodlamaio.hrms.core.utilties.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;

import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(kodlamaio.hrms.dataAccess.abstracts.UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi.");
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Data listelendi.");
	}



	@Override
	public DataResult<User> getByEmail(String email) {
return new SuccessDataResult<User>(this.userDao.findByEmail(email));
	}

	@Override
	public Result checkUserExistsByEmail(String email) {
        var userEmail = getByEmail(email);
        if(userEmail.getData() !=null){
           return new ErrorResult("Bu mail kullanılıyor.");
        }

        return new SuccessResult();
    }
	

}
