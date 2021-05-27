package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilties.business.BusinessRules;
import kodlamaio.hrms.core.utilties.results.DataResult;
import kodlamaio.hrms.core.utilties.results.ErrorResult;
import kodlamaio.hrms.core.utilties.results.Result;
import kodlamaio.hrms.core.utilties.results.SuccessDataResult;
import kodlamaio.hrms.core.utilties.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}


	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Data listelendi.");
	}


	@Override
	public Result add(Employer employer) {
		var result = BusinessRules.run(checkNullFields(employer),checkMailIsCompatibleWithDomain(employer));
		if (!result.isSuccess()) {
	           return new ErrorResult(result.getMessage());
		}
				
		this.employerDao.save(employer);
		return new SuccessResult("İş veren eklendi.");
	}

    private Result checkMailIsCompatibleWithDomain(Employer employer){

        String[] isEmailCompatible = employer.getEmail().split("@", 2); // @ işaretinden iki ayrı parçaya böler
        String webSite = employer.getWebSiteAddress().substring(4); // www. kısmından sonrasını alır

        if (!isEmailCompatible[1].equals(webSite)){
            return new ErrorResult("Your Email adress is not compatible with your Web Site domain.");
        }

        return new SuccessResult();
    }

    private  Result checkNullFields(Employer employer){
        if(employer.getWebSiteAddress() == null){
            return new ErrorResult("Field Web Site cannot be blank.");
        }

        if(employer.getCompanyName() == null){
            return new ErrorResult("Field Company Name cannot be blank.");
        }

        if(employer.getEmail() == null){
            return new ErrorResult("Field Email cannot be blank.");
        }

        if(employer.getPhoneNumber() == null){
            return new ErrorResult("Field Phone Number cannot be blank.");
        }

        return new SuccessResult();
    }
}
