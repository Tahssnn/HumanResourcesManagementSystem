package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.abstracts.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDto implements Dto {
	String email;
	String password;

}
