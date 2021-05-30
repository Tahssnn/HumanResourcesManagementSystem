package kodlamaio.hrms.core.utilties.mail;

public class MailSenderManager implements MailSenderService {

	@Override
	public void sendMail(String email) {
		System.out.println("Mail gönderildi " + email);

	}

}
