package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.abstracts.Dto;
import lombok.Data;

@Data
public class AuthDto implements Dto {
	String email;
	String password;

}
