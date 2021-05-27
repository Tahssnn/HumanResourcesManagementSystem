package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AdminService;
import kodlamaio.hrms.core.utilties.results.DataResult;
import kodlamaio.hrms.core.utilties.results.Result;
import kodlamaio.hrms.core.utilties.results.SuccessDataResult;
import kodlamaio.hrms.core.utilties.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.AdminDao;
import kodlamaio.hrms.entities.concretes.Admin;

@Service
public class AdminManager implements AdminService{

	private AdminDao adminDao;
	
	
	@Autowired
	public AdminManager(AdminDao adminDao) {
		super();
		this.adminDao = adminDao;
	}

	@Override
	public DataResult<List<Admin>> getAll() {
		return new SuccessDataResult<List<Admin>>(this.adminDao.findAll(),"Sistem çalışanları listelendi.");
	}

	@Override
	public Result add(Admin admin) {
		this.adminDao.save(admin);
		return new SuccessResult("Sistem çalışanı eklendi.");
	}
	

}
