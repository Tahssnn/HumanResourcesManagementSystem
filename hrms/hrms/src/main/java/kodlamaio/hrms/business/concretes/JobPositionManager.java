package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilties.results.DataResult;
import kodlamaio.hrms.core.utilties.results.ErrorResult;
import kodlamaio.hrms.core.utilties.results.Result;
import kodlamaio.hrms.core.utilties.results.SuccessDataResult;
import kodlamaio.hrms.core.utilties.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Data listelendi.");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		var result = getJobByTitle(jobPosition.getJobTitle()).getData();
		if (result !=null) {
			return new ErrorResult(jobPosition.getJobTitle()+" zaten var.");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu eklendi.");
	}

	@Override
	public DataResult<JobPosition> getJobByTitle(String title) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByJobTitle(title));
	}

}
