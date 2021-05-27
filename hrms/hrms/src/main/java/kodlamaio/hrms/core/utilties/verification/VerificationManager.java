  
package kodlamaio.hrms.core.utilties.verification;

//import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.UUID;

@Service
public class VerificationManager implements VerificationService {

	@Override
	public void verificateWithLink(String email) {
        UUID generatedString =UUID.randomUUID();
        String verificationLink = "https://www.humanverificationlink.com/" + generatedString;
        System.out.println("Doğrulama kodu gönderildi : " + email);
        System.out.println("Lütfen linke tıklayınız : " + verificationLink);
		
	}

	@Override
	public String verificateWithCode() {
        byte[] array = new byte[6]; // length is bounded by 6 - resource : https://www.baeldung.com/java-random-string
        new Random().nextBytes(array);
        String verificationCode = new String(array, Charset.forName("UTF-8"));
        System.out.println("Doğrulama kodunuz : " + verificationCode);
        return verificationCode;
	}

}
