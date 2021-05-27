package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilties.results.DataResult;
import kodlamaio.hrms.core.utilties.results.Result;
import kodlamaio.hrms.entities.concretes.Admin;

public interface AdminService {

	DataResult<List<Admin>> getAll();
	Result add(Admin admin);
}
