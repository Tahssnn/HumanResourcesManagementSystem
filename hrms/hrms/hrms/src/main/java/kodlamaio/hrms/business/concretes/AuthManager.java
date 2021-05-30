package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilties.results.ErrorResult;
import kodlamaio.hrms.core.utilties.results.Result;
import kodlamaio.hrms.core.utilties.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.RegisterForEmployerAuthDto;
import kodlamaio.hrms.entities.dtos.RegisterForJobSeekerAuthDto;

@Service
public class AuthManager implements AuthService {

	private JobSeekerService jobSeekerService;
	private EmployerService employerService;
	private UserService userService;

	@Autowired
	public AuthManager(JobSeekerService jobSeekerService, EmployerService employerService, UserService userService) {
		super();
		this.jobSeekerService = jobSeekerService;
		this.employerService = employerService;
		this.userService = userService;
	}

	@Override
	public Result registerForJobSeeker(RegisterForJobSeekerAuthDto registerForJobSeekerAuthDto) {
		JobSeeker jobSeekerInfo = new JobSeeker();

		jobSeekerInfo.setFirstName(registerForJobSeekerAuthDto.getFirstName());
		jobSeekerInfo.setLastName(registerForJobSeekerAuthDto.getLastName());
		jobSeekerInfo.setNationalId(registerForJobSeekerAuthDto.getNationalId());
		jobSeekerInfo.setDate_of_birth(registerForJobSeekerAuthDto.getDateOfBirth());
		jobSeekerInfo.setEmail(registerForJobSeekerAuthDto.getEmail());
		jobSeekerInfo.setPassword(registerForJobSeekerAuthDto.getPassword());

		if (!checkIfEqualPasswordAndConfirmPassword(registerForJobSeekerAuthDto.getPassword(),
				registerForJobSeekerAuthDto.getRepeatPassword())) {

			return new ErrorResult("Şifreler eşleşmiyor.");
		}

		if (!checkIfNullInfoForJobseeker(registerForJobSeekerAuthDto)) {
			return new ErrorResult("Alanları eksiksiz doldurunuz.");
		}

		if (!checkIfExistsNationalId(registerForJobSeekerAuthDto.getNationalId())) {

			return new ErrorResult(registerForJobSeekerAuthDto.getNationalId() + " zaten var.");
		}

		if (!checkIfExistsEmail(registerForJobSeekerAuthDto.getEmail())) {
			return new ErrorResult(registerForJobSeekerAuthDto.getEmail() + " zaten var.");
		}

		this.jobSeekerService.add(jobSeekerInfo);

		return new SuccessResult("e-posta doğrulaması yaptığınızda kayıt tamamlanacak.");
	}

	@Override
	public Result registerForEmployer(RegisterForEmployerAuthDto registerForEmployerAuthDto) {
		Employer employerInfo = new Employer();

		employerInfo.setCompanyName(registerForEmployerAuthDto.getCompanyName());
		employerInfo.setWebSiteAddress(registerForEmployerAuthDto.getWebsite());
		employerInfo.setEmail(registerForEmployerAuthDto.getEmail());
		employerInfo.setPhoneNumber(registerForEmployerAuthDto.getPhoneNumber());
		employerInfo.setPassword(registerForEmployerAuthDto.getPassword());

		if (!checkIfEqualPasswordAndConfirmPassword(registerForEmployerAuthDto.getPassword(),
				registerForEmployerAuthDto.getRepeatPassword())) {

			return new ErrorResult("Şifreler eşleşmiyor.");
		}

		if (!checkIfNullInfoForEmployer(registerForEmployerAuthDto)) {
			return new ErrorResult("Alanları eksiksiz doldurunuz.");
		}

		if (!checkIfExistsEmail(registerForEmployerAuthDto.getEmail())) {
			return new ErrorResult(registerForEmployerAuthDto.getEmail() + " zaten var.");
		}

		if (!checkIfEqualEmailAndDomain(registerForEmployerAuthDto.getEmail(),
				registerForEmployerAuthDto.getWebsite())) {
			return new ErrorResult("web sitesi ile aynı domaine sahip e-posta değil.");
		}

		this.employerService.add(employerInfo);
		return new SuccessResult("e-posta doğrulaması yaptığınızda kayıt tamamlanacak.");

	}

	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

		if (!password.equals(confirmPassword)) {
			return false;
		}

		return true;
	}

	private boolean checkIfNullInfoForJobseeker(RegisterForJobSeekerAuthDto registerForJobSeekerAuthDto) {

		if (registerForJobSeekerAuthDto.getFirstName() != null && registerForJobSeekerAuthDto.getLastName() != null
				&& registerForJobSeekerAuthDto.getNationalId() != null
				&& registerForJobSeekerAuthDto.getDateOfBirth() != null
				&& registerForJobSeekerAuthDto.getPassword() != null && registerForJobSeekerAuthDto.getEmail() != null
				&& registerForJobSeekerAuthDto.getRepeatPassword() != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfNullInfoForEmployer(RegisterForEmployerAuthDto registerForEmployerAuthDto) {

		if (registerForEmployerAuthDto.getCompanyName() != null && registerForEmployerAuthDto.getEmail() != null
				&& registerForEmployerAuthDto.getPassword() != null
				&& registerForEmployerAuthDto.getPhoneNumber() != null
				&& registerForEmployerAuthDto.getRepeatPassword() != null
				&& registerForEmployerAuthDto.getWebsite() != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfExistsNationalId(String nationalId) {

		if (this.jobSeekerService.getByNationalId(nationalId).getData() == null) {
			return true;
		}
		return false;
	}

	private boolean checkIfExistsEmail(String email) {

		if (this.userService.getByEmail(email).getData() == null) {
			return true;
		}
		return false;
	}

	private boolean checkIfEqualEmailAndDomain(String email, String website) {
		String[] emailArr = email.split("@", 2);
		String domain = website.substring(4, website.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}

}
