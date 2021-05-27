package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilties.results.DataResult;
import kodlamaio.hrms.core.utilties.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	
	DataResult<List<JobPosition>> getAll();

	Result add(JobPosition jobPosition);
	
	DataResult<JobPosition> getJobByTitle(String title); 
	

}
