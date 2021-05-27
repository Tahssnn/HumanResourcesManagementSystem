package kodlamaio.hrms.entities.dtos;

import lombok.Data;

@Data
public class LoginUserAuthDto extends AuthDto {

	private String email;
	private String password;
}
