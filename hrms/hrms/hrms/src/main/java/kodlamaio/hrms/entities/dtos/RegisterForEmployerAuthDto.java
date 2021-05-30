package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForEmployerAuthDto extends AuthDto {

    private String website;
    private String phoneNumber;
    private String companyName;
    private String repeatPassword;
}
