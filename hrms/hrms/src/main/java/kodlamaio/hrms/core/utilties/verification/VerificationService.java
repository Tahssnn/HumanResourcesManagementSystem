package kodlamaio.hrms.core.utilties.verification;

public interface VerificationService {

	void verificateWithLink(String email);
	String verificateWithCode();
}
