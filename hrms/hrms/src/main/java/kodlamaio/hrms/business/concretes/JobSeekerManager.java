package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilties.business.BusinessRules;
import kodlamaio.hrms.core.utilties.results.DataResult;
import kodlamaio.hrms.core.utilties.results.ErrorResult;
import kodlamaio.hrms.core.utilties.results.Result;
import kodlamaio.hrms.core.utilties.results.SuccessDataResult;
import kodlamaio.hrms.core.utilties.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;

import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Data listelendi.");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		var result = BusinessRules.run(checkUserExistsByNationalId(jobSeeker));
		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş arayan kişi eklendi.");
	}

	@Override
	public DataResult<JobSeeker> getByNationalId(String nationalId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByNationalId(nationalId));

	}

	private Result checkUserExistsByNationalId(JobSeeker jobSeeker) {

		var jobSeekerNationalId = getByNationalId(jobSeeker.getNationalId());
		if (jobSeekerNationalId.getData() != null) {
			new ErrorResult("Bu kimlik kullanılmış.");
		}

		return new SuccessResult();

	}

}
